package utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class UType {

    private static final Map<Class<?>, Class<?>> OBJECT_PRIMITIVE_TYPES = getObjectPrimitiveTypes();

    private static final Class<?>[] STATEMENT_SUPPORTED_TYPES = getStatementSupportedTypes();

    /*
     * Retorna true se o campo passado for um objeto de um tipo
     * primitivo.
     * Exemplos: Boolean, Integer, Float, Long
     * @param Field field, campo de um objeto.
     * @return boolean, true quando e somente quando o campo for de um
     * dos objetos primitivos conhecidos.
     */
    public static boolean fieldIsObjectPrimitiveType(Field field) {
        return OBJECT_PRIMITIVE_TYPES.containsKey(field.getType());
    }

    public static boolean fieldIsPrimitiveType(Field field) {
        return field.getType().isPrimitive();
    }

    /*
     * Retorna true se o campo é suportado para Statement sql
     * WARNING: AINDA NÃO É CONHECIDO TODOS OS TIPOS DE OBJETOS
     * SUPORTADOS PARA STATEMENT SQL
     * @param Field field, campo de um objeto
     * @return boolean, true quando campo é suportado para statement sql
     */
    public static boolean fieldIsStatementSupported(Field field) {
        for (Class<?> statementSupportedType : STATEMENT_SUPPORTED_TYPES) {
            if (field.getType() == statementSupportedType) {
                return true;
            }
        }
        return false;
    }

    public static Class<?> toPrimitiveType(Class<?> objectPrimitiveType) {
        return OBJECT_PRIMITIVE_TYPES.get(objectPrimitiveType);
    }

    private static Map<Class<?>, Class<?>> getObjectPrimitiveTypes() {
        Map<Class<?>, Class<?>> listOfobjectPrimitiveTypes = new HashMap<>();

        listOfobjectPrimitiveTypes.put(Boolean.class, boolean.class);
        listOfobjectPrimitiveTypes.put(Character.class, char.class);
        listOfobjectPrimitiveTypes.put(Byte.class, byte.class);
        listOfobjectPrimitiveTypes.put(Short.class, short.class);
        listOfobjectPrimitiveTypes.put(Integer.class, int.class);
        listOfobjectPrimitiveTypes.put(Long.class, long.class);
        listOfobjectPrimitiveTypes.put(Float.class, float.class);
        listOfobjectPrimitiveTypes.put(Double.class, double.class);
        listOfobjectPrimitiveTypes.put(Void.class, void.class);
        return listOfobjectPrimitiveTypes;
    }

    /*
     * Retorna uma lista com todos os tipos de objetos suportados
     * para Statement sql
     * WARNING: NEM TODOS OS TIPOS FORAM ADICIONADOS NA LISTA
     * @return Class<?>[], lista com tipos de objetos suportados 
     * para Statement sql
     */
    private static Class<?>[] getStatementSupportedTypes() {
        Class<?>[] statementsSupported = new Class<?>[1];

        statementsSupported[0] = String.class;
        return statementsSupported;
    }
}
