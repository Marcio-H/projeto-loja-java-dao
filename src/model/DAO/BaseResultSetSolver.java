package model.DAO;

import static utils.UStr.create;
import static utils.UMethod.getMethod;
import static utils.UAnnotation.hasAnnotationForeign;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;

public class BaseResultSetSolver {

    private final Field field;

    private final Method entitySetMethod;

    private final Method resultSetGetterMethod;
    
    private Long foreignValue;

    private static final String SET_PATTERN = "set%s";
    
    private static final String GET_RESULT_SET_PATTERN = "get%s";

    public BaseResultSetSolver(Field field, Method entitySetMethod, Method resultSetGetterMethod) {
        this.field = field;
        this.entitySetMethod = entitySetMethod;
        this.resultSetGetterMethod = resultSetGetterMethod;
    }

    public static BaseResultSetSolver[] solve(Field[] fields) {
        int fieldLenght = fields.length;
        BaseResultSetSolver[] arr = new BaseResultSetSolver[fieldLenght];

        for (int i = 0; i < fieldLenght; i++) {
            Method setEntityMethod = solveSetEntityMethod(fields[i]);
            Method resultGetterMethod = solveResultSetGetterMethod(fields[i]);
            
            arr[i] = new BaseResultSetSolver(fields[i], setEntityMethod, resultGetterMethod);
        }
        return arr;
    }

    private static Method solveSetEntityMethod(Field field) {
        Class<?> classe = field.getDeclaringClass();
        String fieldName = create(field.getName()).removePackageFromName().capitalize().get();
        String setEntityMethodName = String.format(SET_PATTERN, fieldName);
        Class<?> arg = field.getType();
        return getMethod(classe, setEntityMethodName, arg);
    }
    
    private static Method solveResultSetGetterMethod(Field field) {
        Class<?> classe = ResultSet.class;
        Class<?> arg = hasAnnotationForeign(field) ? Long.class : field.getType();
        String getType = create(arg.getName()).removePackageFromName().capitalize().get();
        String getResultMethodName = String.format(GET_RESULT_SET_PATTERN, getType);
        return getMethod(classe, getResultMethodName, String.class);
    }

    public Field getField() {
        return field;
    }

    public Method getEntitySetMethod() {
        return entitySetMethod;
    }

    public Method getResultSetGetterMethod() {
        return resultSetGetterMethod;
    }

    public Long getForeignValue() {
        return foreignValue;
    }

    public void setForeignValue(Long foreignValue) {
        this.foreignValue = foreignValue;
    }
}
