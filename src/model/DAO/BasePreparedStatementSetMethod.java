package model.dao;

import static utils.UAnnotation.hasAnnotationForeign;
import static utils.UField.fieldWithAnnotationId;
import static utils.UType.fieldIsStatementSupported;
import static utils.UType.fieldIsPrimitiveType;
import static utils.UType.fieldIsObjectPrimitiveType;
import static utils.UStr.create;
import static utils.UMethod.getMethod;
import static utils.UMethod.callsMethod;

import exception.UnmappedObjectException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import utils.UStr;
import utils.UType;

/*
 * Este objeto é usado para guardar um o valor e um dos set's do
 * PreparedStatement, para que quando seja necessário é possível chamar
 * o metodo a qualquer momento.
 */
public class BasePreparedStatementSetMethod {

    /*
     * metodo set do PreparedStatement
     */
    private final Method setMethod;

    /*
     * valor que será passado no metodo set
     */
    private final Object value;

    private static final String GET_METHOD_NAME = "get%s";

    private static final String OBJETO_NAO_MAPEADO_MSG = "Objeto '%s' não mapeado";

    private static final String PREPAREDSTATEMENT_SET_METHOD = "set%s";

    public BasePreparedStatementSetMethod(Method setMethod, Object value) {
        this.setMethod = setMethod;
        this.value = value;
    }

    public Method getSetMethod() {
        return setMethod;
    }

    public Object getValue() {
        return value;
    }

    //esta função pode ter um comportamento inesperado
    //fazer testes
    public static Object resolveValue(Field field, Object object) {
        String nameField = UStr.create(field.getName())
                .removePackageFromName()
                .capitalize()
                .get();
        String getFieldMethodName = String.format(GET_METHOD_NAME, nameField);
        Method getFieldMethod = getMethod(object.getClass(), getFieldMethodName);
        Object value = callsMethod(getFieldMethod, object);

        if (fieldIsPrimitiveType(field) || fieldIsObjectPrimitiveType(field) || fieldIsStatementSupported(field)) {
            return value;
        }

        if (hasAnnotationForeign(field)) {
            Field idField = fieldWithAnnotationId(field.getType());

            if (idField == null) {
                throw new UnmappedObjectException(String.format(OBJETO_NAO_MAPEADO_MSG, field.getType().getClass()));
            }
            return resolveValue(idField, value);
        }
        throw new UnmappedObjectException(String.format(OBJETO_NAO_MAPEADO_MSG, field.getDeclaringClass().getName()));
    }

    /*
     * Retorna o tipo suportado para Statement sql de um campo.
     * dado um campo qualquer de um objeto este metodo retorna o tipo que é
     * suportado para statement sql desse campo com base no tipo do campo.
     * se tipo do campo for primitivo = retorna primitivo
     * "          "     for um objeto primitivo = retorna o o tipo primitivo 
     * desse objeto.
     * "          "     for suportado para statement sql = retorna o tipo do
     * campo sem alteração.
     * "          "     for um campo que possui a annotation foreign nele
     * o metodo deve procurar na classe foreign o campo que possui a annotation
     * id e fazer as verificações listadas acima novamente e retornar esse tipo.
     * @param Field field, campo de um objeto.
     * @return class<?>, tipo que é suportador para Statemente sql.
     */
    public static Class<?> resolveParameterType(Field field) {
        if (UType.fieldIsPrimitiveType(field)) {
            return field.getType();
        }
        if (UType.fieldIsObjectPrimitiveType(field)) {
            return UType.toPrimitiveType(field.getType());
        }
        if (UType.fieldIsStatementSupported(field)) {
            return field.getType();
        }

        if (hasAnnotationForeign(field)) {
            Field idField = fieldWithAnnotationId(field.getType());

            if (idField == null) {
                throw new UnmappedObjectException(String.format(OBJETO_NAO_MAPEADO_MSG, field.getType().getName()));
            }
            return resolveParameterType(idField);
        }
        throw new UnmappedObjectException(String.format(OBJETO_NAO_MAPEADO_MSG, field.getDeclaringClass().getName()));
    }

    public static Method findPreparedStatementSetMethod(Field field) {
        Class<?> resolvedParameterType = resolveParameterType(field);
        String sanitizedParameterType = create(resolvedParameterType.getName()).removePackageFromName().capitalize().get();
        String setMethodName = String.format(PREPAREDSTATEMENT_SET_METHOD, sanitizedParameterType);

        return getMethod(PreparedStatement.class, setMethodName, int.class, resolvedParameterType);
    }

    /*
     * Retorna um array de BasePreparedStatementSetMethod ** DOC DO OBJETO
     * NO OBJETO **
     * @param Object object, objeto instanciado.
     * @param Field[] fields, campos do objeto instanciado no parametro
     * anterior. Não precisa ser todos os campos **.
     */
    public static BasePreparedStatementSetMethod[] resolvePreparedStatementSetMethods(Object object, Field[] fields) {
        int fieldsLenght = fields.length;
        BasePreparedStatementSetMethod[] resolvedSetMethods = new BasePreparedStatementSetMethod[fieldsLenght];

        for (int i = 0; i < fieldsLenght; i++) {
            Method resolvedSetMethod = findPreparedStatementSetMethod(fields[i]);
            Object value = resolveValue(fields[i], object);

            resolvedSetMethods[i] = new BasePreparedStatementSetMethod(resolvedSetMethod, value);
        }
        return resolvedSetMethods;
    }
}
