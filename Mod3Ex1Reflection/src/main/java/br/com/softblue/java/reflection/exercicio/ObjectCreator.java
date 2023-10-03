package br.com.softblue.java.reflection.exercicio;

import java.lang.reflect.Method;

public class ObjectCreator {
	
	public static <T> T create(Class<T> clazz) {
		
		try {
			T obj = (T)clazz.getDeclaredConstructor().newInstance();
			
			Method[] methods = clazz.getMethods();
			
			for (Method method : methods) {
				
				Init init = method.getAnnotation(Init.class);
				
				if(init != null && init.runOnInstantiation()) {
					method.invoke(obj, (Object[])null);
				}
			}
			return obj;
		} catch (Exception e) {
			return null;
		}
	}
}
