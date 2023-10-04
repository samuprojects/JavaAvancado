package br.com.softblue.java.reflection.exercicio;

import java.lang.reflect.Method;

public class Property {
	
	public static <T> void set(Object obj, String property, T value) throws Exception {
		set(obj, property, value, null);
	}
	
	public static <T> void set(Object obj, String property, T value, Class<?> paramType) throws Exception {
		Class<?> clazz = obj.getClass();
		char c = Character.toUpperCase(property.charAt(0));
		String setMethod = "set" + c + property.substring(1);
		if (paramType == null) {
			paramType = value.getClass();
		}
		
		Method method = clazz.getMethod(setMethod, paramType);
		
		method.invoke(obj, value);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T get(Object obj, String property, Class<T> returnType) throws Exception {
		Class<?> clazz = obj.getClass();
		
		char c = Character.toUpperCase(property.charAt(0));
		
		String getMethod = "get" + c + property.substring(1);
		
		Method method = clazz.getMethod(getMethod);
		
		Object ret = method.invoke(obj);
		
		return (T) ret;
	}

}
