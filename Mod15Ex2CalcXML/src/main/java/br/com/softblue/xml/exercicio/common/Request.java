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

public class Request {
	
	public enum Op {
		
		SOMAR,
		SUBTRAIR,
		MULTIPLICAR,
		DIVIDIR
	}
	
	private Op operacao;
	
	private double n1;
	private double n2;
	
	private Request() {
	}
	
	public static Request fromData(Op op, double n1, double n2) {
		Request req = new Request();
		req.operacao = op;
		req.n1 = n1;
		req.n2 = n2;
		return req;
	}
	
	public static Request fromXML(String xmlRequest) throws CalcException {
		try {
			Request req = new Request();
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			Document doc = db.parse(new InputSource(new StringReader(xmlRequest)));
			
			Element rootElement = doc.getDocumentElement();
			
			Element opElement = (Element) rootElement.getElementsByTagName("op").item(0);
			req.operacao = Op.valueOf(opElement.getTextContent());
			
			Element n1Element = (Element) rootElement.getElementsByTagName("valor1").item(0);
			req.n1 = Double.parseDouble(n1Element.getTextContent());
			
			Element n2Element = (Element) rootElement.getElementsByTagName("valor2").item(0);
			req.n2 = Double.parseDouble(n2Element.getTextContent());
			
			return req;
			
		} catch (Exception e) {
			
			throw new CalcException();
		}
	}
	
	public String toXML() throws CalcException {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			Document doc = db.newDocument();
			
			Element rootElement = doc.createElement("request");
			doc.appendChild(rootElement);
			
			Element opElement = doc.createElement("op");
			opElement.setTextContent(operacao.toString());
			rootElement.appendChild(opElement);
			
			Element n1Element = doc.createElement("valor1");
			n1Element.setTextContent(String.valueOf(n1));
			rootElement.appendChild(n1Element);
			
			Element n2Element = doc.createElement("valor2");
			n2Element.setTextContent(String.valueOf(n2));
			rootElement.appendChild(n2Element);
			
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
	
	public Op getOperacao() {
		return operacao;
	}

	public double getN1() {
		return n1;
	}
	
	public double getN2() {
		return n2;
	}
}
