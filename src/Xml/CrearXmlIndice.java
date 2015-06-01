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

public class CrearXmlIndice {

	public CrearXmlIndice(){
		
	}
    public synchronized void generate(ArrayList<String> direcciones,ArrayList<String> palabras, ArrayList<String> locales) throws Exception{
    	 
        if(direcciones.isEmpty() || palabras.isEmpty() || direcciones.size()!=palabras.size()){
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
            for(int i=0; i<direcciones.size();i++){
            	
                //Item Node
                Element nodoPadre = document.createElement("Url"); 
                
                //Nodo palabra
                Element palabra = document.createElement("Direccion"); 
                Text nodoPalabra = document.createTextNode(direcciones.get(i));
                palabra.appendChild(nodoPalabra);      
                
                //Nodo cantidad
                Element cantidad = document.createElement("Cantidad"); 
                Text nodeValueValue = document.createTextNode(palabras.get(i));                
                cantidad.appendChild(nodeValueValue);
                
                //Nodo local
                Element local = document.createElement("Referencia"); 
                Text nodoLocal = document.createTextNode(locales.get(i));                
                local.appendChild(nodoLocal);
                
                //append keyNode and valueNode to itemNode
                nodoPadre.appendChild(palabra);
                nodoPadre.appendChild(cantidad);
                nodoPadre.appendChild(local);
                
                //append itemNode to raiz
                raiz.appendChild(nodoPadre); //pegamos el elemento a la raiz "Documento"
            }                
            //Generate XML
            Source source = new DOMSource(document);
            //Indicamos donde lo queremos almacenar
            Result result = new StreamResult(new java.io.File("pelo.xml")); //nombre del archivo
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        }
    }

}
