package Xml;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class CrearXmlSubIndice {

	public CrearXmlSubIndice(){
		
	}
    public synchronized void generate(String nombre,ArrayList<String> palabras,ArrayList<String> repeticiones) throws Exception{
    	 
        if(palabras.isEmpty() || repeticiones.isEmpty() || palabras.size()!=repeticiones.size()){
            System.out.println("ERROR empty ArrayList");
            return;
        }else{
 
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "indice", null);
            document.setXmlVersion("1.0");
 
            //Main Node
            Element raiz = document.getDocumentElement();
            //Por cada key creamos un item que contendrá la key y el value
            for(int i=0; i<palabras.size();i++){
                //Item Node
                Element itemNode = document.createElement("Url"); 
                //Key Node
                Element keyNode = document.createElement("Palabra"); 
                Text nodeKeyValue = document.createTextNode(palabras.get(i));
                keyNode.appendChild(nodeKeyValue);      
                //Value Node
                Element valueNode = document.createElement("Repeticiones"); 
                Text nodeValueValue = document.createTextNode(repeticiones.get(i));                
                valueNode.appendChild(nodeValueValue);
                //append keyNode and valueNode to itemNode
                itemNode.appendChild(keyNode);
                itemNode.appendChild(valueNode);
                //append itemNode to raiz
                raiz.appendChild(itemNode); //pegamos el elemento a la raiz "Documento"
            }                
            //Generate XML
            Source source = new DOMSource(document);
            //Indicamos donde lo queremos almacenar
            Result result = new StreamResult(new java.io.File(nombre+".xml")); //nombre del archivo
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        }
    }

}
