package utils;

import annotations.Foreign;
import annotations.Id;
import java.lang.reflect.Field;

public class UAnnotation {
    
    public static boolean hasAnnotationId(Field field) {
        return field.isAnnotationPresent(Id.class);
    }
    
    public static boolean hasNotAnnotationId(Field field) {
        return !hasAnnotationId(field);
    }
    
    public static boolean hasAnnotationForeign(Field field) {
        return field.isAnnotationPresent(Foreign.class);
    }
    
    public static boolean hasNotAnnotationForeign(Field field) {
        return !hasAnnotationForeign(field);
    }
}
