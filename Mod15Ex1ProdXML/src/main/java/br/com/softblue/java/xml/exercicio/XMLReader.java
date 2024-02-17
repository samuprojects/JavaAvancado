package br.com.softblue.java.xml.exercicio;

import java.io.InputStream;
import java.lang.reflect.Field;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLReader {
	
	public static Object read(InputStream is) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		Document doc = db.parse(is);
		
		Element rootElement = doc.getDocumentElement();
		
		String className = rootElement.getNodeName();
		
		Class<?> clazz = Class.forName(className);
		Object obj = clazz.getDeclaredConstructor().newInstance();
		
		Field[] attributes = clazz.getDeclaredFields();
		
		for (Field attribute : attributes) {
			
			String name = attribute.getName();
			Element nameElement = (Element) rootElement.getElementsByTagName(name).item(0);
			
			Class<?> type = attribute.getType();
			
			attribute.setAccessible(true);
			
			Object value;
			
			if (type == String.class) {
				value = nameElement.getTextContent();
			} else if (type == int.class) {
				value = Integer.parseInt(nameElement.getTextContent());
			} else if (type == double.class) {
				value = Double.parseDouble(nameElement.getTextContent());
			} else if (type == boolean.class) {
				value = Boolean.parseBoolean(nameElement.getTextContent());
			} else {
				value = null;
			}
			
			attribute.set(obj, value);			
		}
		
		return obj;
		}
}
