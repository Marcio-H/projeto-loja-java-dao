package utils;

import exception.MethodNotFoundException;
import exception.VoidConstructorNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class UMethod {
    
    private final static String METHOD_NOT_FOUND_EXCEPTION_MSG = "Não foi possível encontrar o metodo '%s' na classe '%s' com os parametros: %s";
    
    private static final String VOID_CONSTRUCTOR_NOT_FOUND_MSG = "Construtor vazio não encontrado na classe '%s'";
    
    public static Method getMethod(Class<?> classRoot, String name, Class<?>... args) {
        try {
            return classRoot.getMethod(name, args);
        } catch (NoSuchMethodException e) {
            throw new MethodNotFoundException(
                    String.format(METHOD_NOT_FOUND_EXCEPTION_MSG,
                            name,
                            classRoot.getName(),
                            Arrays.toString(args)
                    ),
                    e
            );
        } catch (SecurityException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Object callsMethod(Method calledMethod, Object obj, Object... args) {
        try {
            return calledMethod.invoke(obj, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Constructor getNoArgsConstructor(Class<?> classRoot) {
        try {
            return classRoot.getConstructor();
        } catch (NoSuchMethodException e) {
            throw new VoidConstructorNotFoundException(
                    String.format(VOID_CONSTRUCTOR_NOT_FOUND_MSG, classRoot.getName()),
                    e
            );
        } catch (SecurityException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Object callsConstructor(Constructor constructor, Object ... initArgs) {
        try {
            return constructor.newInstance(initArgs);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
