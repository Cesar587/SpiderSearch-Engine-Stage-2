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
public class CrearXmlURL{
	Element elemento;
	Text valor;
	/**
	 * 
	 */
	public CrearXmlURL(){
		
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
		
		Document document = implementation.createDocument(null, "targets", null);
		document.setXmlVersion("1.0");
		
		Element raiz = document.getDocumentElement();
		
		elemento= document.createElement("URL"); //creamos un nuevo elemento
		valor = document.createTextNode("/home/steven/Escritorio/Proyecto_Programado_2_-_Taller_de_Programacion.pdf"); //Ingresamos la info
		elemento.appendChild(valor);
		raiz.appendChild(elemento); //pegamos el elemento a la raiz "Documento"
		
		elemento = document.createElement("URL"); //creamos un nuevo elemento
		valor = document.createTextNode("/home/steven/Escritorio/compartida/Documentacion.docx"); //Ingresamos la info
		elemento.appendChild(valor);
		raiz.appendChild(elemento); //pegamos el elemento a la raiz "Documento
		
		elemento = document.createElement("URL"); //creamos un nuevo elemento
		valor = document.createTextNode("smb://192.168.43.81/compartida/navegador.txt"); //Ingresamos la info
		elemento.appendChild(valor);
		raiz.appendChild(elemento); //pegamos el elemento a la raiz "Documento
		
		elemento = document.createElement("URL"); //creamos un nuevo elemento
		valor = document.createTextNode("http://www.royaltalens.com/media/1411989/88800156_Kleur_ESP.pdf"); //Ingresamos la info
		elemento.appendChild(valor);
		raiz.appendChild(elemento); //pegamos el elemento a la raiz "Documento
		
		elemento = document.createElement("URL"); //creamos un nuevo elemento
		valor = document.createTextNode("http://www.ceiploreto.es/sugerencias/Comprension_lectora/mis_lecturas_ciclo2.pdf"); //Ingresamos la info
		elemento.appendChild(valor);
		raiz.appendChild(elemento); //pegamos el elemento a la raiz "Documento

		elemento = document.createElement("URL"); //creamos un nuevo elemento
		valor = document.createTextNode("smb://192.168.43.81/compartida/navegador.txt"); //Ingresamos la info
		elemento.appendChild(valor);
		raiz.appendChild(elemento); //pegamos el elemento a la raiz "Documento
		
		Source source = new DOMSource(document);
		Result result = new StreamResult(new java.io.File("URL.xml"));//nombre del archivo
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
