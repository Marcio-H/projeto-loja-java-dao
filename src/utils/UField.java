package utils;

import static utils.UAnnotation.hasAnnotationForeign;

import annotations.Foreign;
import annotations.Id;
import java.lang.reflect.Field;

public class UField {

    private static final String FOREIGN_PATTERN = "_id";

    private static final String CONCAT_OPERATOR = ", ";

    private static final String INSERT_SYMBOL = "?";

    /*
     * Retorna o nome de um campo seguindo o padrão adotado
     * para os nomes dos entidade e propriedades.
     * se campo é foreign key o nome do campo deve ser "nomeCampo" + FOREIGN_PATTERN
     * @param Field field, campo do objeto que será criado
     * @return String, nome do campo 
     */
    public static String getFieldNameFormmated(Field field) {
        if (field.isAnnotationPresent(Foreign.class)) {
            return field.getName() + FOREIGN_PATTERN;
        }
        return field.getName();
    }

    /*
     * Retorna um array de campos com todos os campos
     * passados menos o de Id.
     * @param Field[] field, campos de um objeto.
     * @return Field[] fieldWithoutIdAnnotation, todos os campos sem annotation id
     */
    public static Field[] filterForFieldsWithoutIdAnnotation(Field[] fields) {
        int lenght = fields.length;
        int iterator = 0;
        Field[] fieldWithoutIdAnnotation = new Field[lenght - 1];

        for (Field field : fields) {
            if (UAnnotation.hasNotAnnotationId(field)) {
                fieldWithoutIdAnnotation[iterator] = field;
                iterator++;
            }
        }
        return fieldWithoutIdAnnotation;
    }

    /*
     * Retorna os campos informado concatenados pela constante
     * "CONCAT_OPERATOR" aplicando as regras definidos neste framework.
     * exemplo:
     * campos: [Id, Nome, Uf]
     * retorno: Id, Nome, Uf
     * @param Field[] fields, campos de um objeto
     * @return Campos concatenados
     */
    public static String concatFieldsToSQL(Field[] fields) {
        StringBuilder resultStr = new StringBuilder();
        int lenght = fields.length;

        for (int i = 0; i < lenght - 1; i++) {
            appendApplyRules(resultStr, fields[i]);
            resultStr.append(CONCAT_OPERATOR);
        }
        appendApplyRules(resultStr, fields[lenght - 1]);
        return resultStr.toString();
    }

    private static void appendApplyRules(StringBuilder resultStr, Field field) {
        if (hasAnnotationForeign(field)) {
            resultStr.append(getFieldNameFormmated(field));
        } else {
            resultStr.append(field.getName());
        }
    }

    /*
     * Retorna string com a quantidade de simbolos igual
     * a quantidade de campos concatenados pela constante "CONCAT_OPERATOR".
     * @param Field[] field, campos de um objeto
     * @return String com os simbolos concatenados.
     */
    public static String fieldsToInsertStringValues(Field[] fields) {
        StringBuilder resultStr = new StringBuilder();
        int lenght = fields.length;

        for (int i = 0; i < lenght - 1; i++) {
            resultStr.append(INSERT_SYMBOL);
            resultStr.append(CONCAT_OPERATOR);
        }
        resultStr.append(INSERT_SYMBOL);
        return resultStr.toString();
    }

    /*
     * Retorna o campo que possui a annotation id de uma classe.
     * @param Class<?> classe, classe qualquer um de objeto.
     * @return Field, campo com annotation id
     */
    public static Field fieldWithAnnotationId(Class<?> classe) {
        for (Field field : classe.getDeclaredFields()) {
            if (field.isAnnotationPresent(Id.class)) {
                return field;
            }
        }
        return null;
    }
}
