package br.com.softblue.java.xml.exercicio;

import java.io.OutputStream;
import java.lang.reflect.Field;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class XMLWriter {
	
	public static void write(Object obj, OutputStream os) throws Exception {
		
		Class<?> clazz = obj.getClass();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		Document doc = db.newDocument();
		
		Element rootElement = doc.createElement(clazz.getName());
		doc.appendChild(rootElement);
		
		Field[] attributes = clazz.getDeclaredFields();
		for (Field attribute : attributes) {
			attribute.setAccessible(true);
			
			String name = attribute.getName();
			
			Object value = attribute.get(obj);
			
			Element nameElement = doc.createElement(name);
			rootElement.appendChild(nameElement);
			
			Text valueText = doc.createTextNode(value.toString());
			nameElement.appendChild(valueText);
		}
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans = tf.newTransformer();
		trans.setOutputProperty(OutputKeys.INDENT, "yes");
		
		trans.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		
		StreamResult sr = new StreamResult(os);
		DOMSource source = new DOMSource(doc);
		
		trans.transform(source, sr);
	}

}
