package model.DAO;

import static model.DAO.ConnectionFactory.closeConnection;
import static model.DAO.BasePreparedStatementSetMethod.resolvePreparedStatementSetMethods;
import static model.DAO.BaseResultSetSolver.solve;
import static utils.UStr.create;
import static utils.UField.filterForFieldsWithoutIdAnnotation;
import static utils.UField.concatFieldsToSQL;
import static utils.UAnnotation.hasAnnotationForeign;
import static utils.UField.getFieldNameFormmated;
import static utils.UField.fieldsToInsertStringValues;
import static utils.UMethod.callsMethod;
import static utils.UMethod.getNoArgsConstructor;
import static utils.UMethod.callsConstructor;
import static utils.UMethod.getMethod;
import static utils.UField.fieldWithAnnotationId;

import exception.FrameworkSolutionException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseDAO<T> {

    private static final String INSERT_SQL = "INSERT INTO %s (%s) VALUES (%s);";

    private static final String READ_BY_ID_SQL = "SELECT %s from %s where %s.id = ?;";
    
    private static final String READ_ALL_SQL = "SELECT %s from %s ORDER BY 1;";
    
    private static final String DELETE_BY_ID_SQL = "DELETE FROM %s WHERE id = ?;";
    
    private static final String UPDATE_BY_ID_SQL = "UPDATE %s set %s where id = ?;";
    
    private static final String SET_ID_METHOD = "setId";

    protected Connection connection;

    protected PreparedStatement preparedStatement;

    protected ResultSet resultSet;

    protected T abstractCreate(T object) {
        Field[] fieldsToInsert = filterForFieldsWithoutIdAnnotation(object.getClass().getDeclaredFields());
        String sql = insertSQL(object.getClass(), fieldsToInsert);
        BasePreparedStatementSetMethod[] resolvedSetMethods = resolvePreparedStatementSetMethods(object, fieldsToInsert);
        Method setId = getMethod(object.getClass(), SET_ID_METHOD, Long.class);

        openConnection();
        try {
            prepareStatement(sql);
            invokeSetMethods(resolvedSetMethods);
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                callsMethod(setId, object, generatedKeys.getLong(1));
            }
        } catch (SQLException e) {
            throw new FrameworkSolutionException(e.getMessage(), e);
        }
        close();
        return object;
    }

    protected Object abstractReadById(Long codigo, Class<?> classe) {
        String sqlFields = concatFieldsToSQL(classe.getDeclaredFields());
        String tableName = create(classe.getName())
                .removePackageFromName()
                .convertCameoCaseToSnakeCase()
                .get();
        String sql = String.format(
                READ_BY_ID_SQL,
                sqlFields,
                tableName,
                tableName
        );

        Object instaciedObject = getInstance(classe);
        Field[] fields = classe.getDeclaredFields();
        BaseResultSetSolver[] resultSetSolvers = solve(fields);

        openConnection();
        try {
            prepareStatement(sql);
            preparedStatement.setLong(1, codigo);
            resultSet();
            resultSet.next();
            invokeResultSetSolve(resultSetSolvers, instaciedObject);
        } catch (SQLException e) {
            throw new FrameworkSolutionException(e.getMessage(), e);
        }
        close();
        resolveDependecies(resultSetSolvers, instaciedObject);
        return instaciedObject;
    }

    protected List<T> abstractRead(Class<T> classe) {
        List<T> arr = new ArrayList<>();
        String sqlFields = concatFieldsToSQL(classe.getDeclaredFields());
        String tableName = create(classe.getName()).removePackageFromName().convertCameoCaseToSnakeCase().get();
        String sql = String.format(
                READ_ALL_SQL,
                sqlFields,
                tableName
        );
        Field[] fields = classe.getDeclaredFields();
        BaseResultSetSolver[] resultSetSolvers = solve(fields);
        
        openConnection();
        try {
            prepareStatement(sql);
            resultSet();
            while (resultSet.next()) {
                Object instaciedObject = getInstance(classe);

                invokeResultSetSolve(resultSetSolvers, instaciedObject);
                arr.add((T) instaciedObject);
            }
        } catch (SQLException e) {
            throw new FrameworkSolutionException(e.getMessage(), e);
        }
        close();
        arr.stream().forEach(instance -> resolveDependecies(resultSetSolvers, instance));
        return arr;
    }
    
    protected void abstractDelete(Class<T> classe, Long id) {
        String className = create(classe.getName()).removePackageFromName().convertCameoCaseToSnakeCase().get();
        String sql = String.format(
                DELETE_BY_ID_SQL,
                className
        );
        
        openConnection();
        try {
            prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new FrameworkSolutionException(e.getMessage(), e);
        }
        close();
    }
    
    protected T abstractUpdate(final T objeto) {
        Method getId = getMethod(objeto.getClass(), "getId");
        Object id = callsMethod(getId, objeto);
        String table = create(objeto.getClass()
                .getName())
                .removePackageFromName()
                .convertCameoCaseToSnakeCase()
                .get();
        Field[] fieldsWithoutId = filterForFieldsWithoutIdAnnotation(objeto.getClass().getDeclaredFields());
        String fieldToUpdate = updateSql(fieldsWithoutId);
        String sql = String.format(
                UPDATE_BY_ID_SQL,
                table,
                fieldToUpdate
        );
        Field[] f = Arrays.copyOf(fieldsWithoutId, fieldsWithoutId.length + 1);
        
        f[fieldsWithoutId.length] = fieldWithAnnotationId(objeto.getClass());
        BasePreparedStatementSetMethod[] resolvedSetMethods = resolvePreparedStatementSetMethods(objeto, f);

        openConnection();
        try {
            prepareStatement(sql);
            invokeSetMethods(resolvedSetMethods);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new FrameworkSolutionException(e.getMessage(), e);
        }
        close();
        return objeto;
    }

    protected void openConnection() {
        connection = ConnectionFactory.getConnection();
    }

    protected void prepareStatement(String query) throws SQLException {
        preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
    }

    protected void resultSet() throws SQLException {
        resultSet = preparedStatement.executeQuery();
    }

    protected void close() {
        closeConnection(connection, preparedStatement, resultSet);
    }

    private void invokeSetMethods(BasePreparedStatementSetMethod[] methodsToInvoke) {
        int parameterIndex = 1;

        for (BasePreparedStatementSetMethod setMethod : methodsToInvoke) {
            callsMethod(setMethod.getSetMethod(), preparedStatement, parameterIndex, setMethod.getValue());
            parameterIndex++;
        }
    }
    
    private String insertSQL(Class<?> objectClass, Field[] fields) {
        String tableName = create(objectClass.getName()).removePackageFromName().convertCameoCaseToSnakeCase().get();
        String sqlFields = concatFieldsToSQL(fields);
        String sqlValues = fieldsToInsertStringValues(fields);
        return String.format(
                INSERT_SQL,
                tableName,
                sqlFields,
                sqlValues
        );
    }

    private Object getInstance(Class<?> classe) {
        Constructor noArgsConstructor = getNoArgsConstructor(classe);
        return callsConstructor(noArgsConstructor);
    }

    private void invokeResultSetSolve(BaseResultSetSolver[] resultSetSolvers, Object obj) {
        for (BaseResultSetSolver solver : resultSetSolvers) {
            String formattedFieldName = getFieldNameFormmated(solver.getField()).toString();
            Object result = callsMethod(solver.getResultSetGetterMethod(), this.resultSet, formattedFieldName);

            if (hasAnnotationForeign(solver.getField())) {
                solver.setForeignValue((Long) result);
                continue;
            }
            callsMethod(solver.getEntitySetMethod(), obj, result);
        }
    }

    private void resolveDependecies(BaseResultSetSolver[] resultSetSolvers, Object obj) {
        for (BaseResultSetSolver solver : resultSetSolvers) {
            if (hasAnnotationForeign(solver.getField()) && !solver.getForeignValue().equals(0L)) {
                Object value = abstractReadById(solver.getForeignValue(), solver.getField().getType());
                callsMethod(solver.getEntitySetMethod(), obj, value);
            }
        }
    }
    
    private static String updateSql(Field[] fields) {
        StringBuilder resultStr = new StringBuilder();
        
        for (Field field : fields) {
            String fieldName = getFieldNameFormmated(field).toString();
            resultStr.append(fieldName);
            resultStr.append(" = ?, ");
        }
        resultStr.delete(resultStr.length() - 2, resultStr.length());
        return resultStr.toString();
    }
}
