package Xml;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;         
import org.jdom2.Element;          
import org.jdom2.JDOMException;    
import org.jdom2.input.SAXBuilder; 

import Archivos.Internet;

public class LeerXmlconfiguracion {
	Internet archi=new Internet();
	Configuracion configuracionSpiderBot=new Configuracion(0, 0, 0);
	
	public synchronized Configuracion leer(){
		//Se crea un SAXBuilder para poder parsear el archivo
		//System.out.println(archi.obtenerDirecctorioActual()+"/URL.xml" );
		SAXBuilder builder = new SAXBuilder();
		File xmlFile =new File(archi.obtenerDirecctorioActual()+"/config.xml");
		//File xmlFile = new File("/home/steven/Escritorio/URL.xml");
		try
		{
			//Se crea el documento a traves del archivo
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			List list = rootNode.getChildren("maxthereads");

			for (int i = 0; i < list.size(); i++) {
				   Element node = (Element) list.get(i);
				   configuracionSpiderBot.definirMaxthereads(Integer.parseInt(node.getText()));
				}
			List list2 = rootNode.getChildren("recursivity");

			for (int i = 0; i < list2.size(); i++) {
				   Element node = (Element) list2.get(i);
				   configuracionSpiderBot.definirRecursivity(Integer.parseInt(node.getText()));
				}
			
			List list3 = rootNode.getChildren("reindex");

			for (int i = 0; i < list3.size(); i++) {
				   Element node = (Element) list3.get(i);
				   configuracionSpiderBot.definirReindex(Integer.parseInt(node.getText()));
				}
			
			
		}catch ( IOException io ) {
			System.out.println( io.getMessage() );
		}catch ( JDOMException jdomex ) {
			System.out.println( jdomex.getMessage() );
		}
		return configuracionSpiderBot;
	}
	
}
