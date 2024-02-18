package br.com.softblue.xml.exercicio.common;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

public class Response {
	
	private double resultado;
	
	private Response() {
	}
	
	public double getResultado() {
		return resultado;
	}
	
	public static Response fromData(double result) {
		Response resp = new Response();
		resp.resultado = result;
		return resp;
	}
	
	public static Response fromXML(String xmlResponse) throws CalcException {
		try {
			Response resp = new Response();
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			Document doc = db.parse(new InputSource(new StringReader(xmlResponse)));
			
			Element rootElement = doc.getDocumentElement();
			
			Element resultElement = (Element) rootElement.getElementsByTagName("result").item(0);
			resp.resultado = Double.parseDouble(resultElement.getTextContent());
			
			return resp;
			
		} catch (Exception e) {
			throw new CalcException(e);
		}
	}
	
	public String toXML() throws CalcException {
		try {
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			Document doc = db.newDocument();
			
			Element rootElement = doc.createElement("response");
			doc.appendChild(rootElement);
			
			Element resultElement = doc.createElement("result");
			resultElement.setTextContent(String.valueOf(resultado));
			rootElement.appendChild(resultElement);
			
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer trans = tf.newTransformer();
			
			StringWriter sw = new StringWriter();
			StreamResult sr = new StreamResult(sw);
			DOMSource source = new DOMSource(doc);
			
			trans.transform(source, sr);
			
			return sw.toString();
			
		} catch (Exception e) {
			throw new CalcException(e);
		}
	}
}
