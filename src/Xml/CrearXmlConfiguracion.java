package Xml;

import org.w3c.dom.*;



import javax.xml.transform.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
/**
 * 
 * @author steven
 *
 */
public class CrearXmlConfiguracion {
	Element elemento;
	Text valor;
	/**
	 * 
	 */
	public CrearXmlConfiguracion(){
		
	}
	/**
	 * 
	 */
	public synchronized void crear() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		}
		catch(ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		DOMImplementation implementation = builder.getDOMImplementation();
		
		Document document = implementation.createDocument(null, "spider", null);
		document.setXmlVersion("1.0");
		
		Element raiz = document.getDocumentElement();
		
		elemento= document.createElement("maxthereads"); //creamos un nuevo elemento
		valor = document.createTextNode("20"); //Ingresamos la info
		elemento.appendChild(valor);
		raiz.appendChild(elemento); //pegamos el elemento a la raiz "Documento"
		
		elemento = document.createElement("recursivity"); //creamos un nuevo elemento
		valor = document.createTextNode("10"); //Ingresamos la info
		elemento.appendChild(valor);
		raiz.appendChild(elemento); //pegamos el elemento a la raiz "Documento
		
		Element compartido = document.createElement("reindex"); //creamos un nuevo elemento
		valor = document.createTextNode("56000"); //Ingresamos la info
		compartido.appendChild(valor);
		raiz.appendChild(compartido); //pegamos el elemento a la raiz "Documento"
		
		Source source = new DOMSource(document);
		Result result = new StreamResult(new java.io.File("config.xml"));//nombre del archivo
		Transformer transformer = null;
		
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
		}
		catch (TransformerConfigurationException|TransformerFactoryConfigurationError eThrowable) {
			eThrowable.printStackTrace();
		}
		try {
			transformer.transform(source, result);
		} 
		catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
