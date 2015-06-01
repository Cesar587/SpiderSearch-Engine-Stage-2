package Xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;         
import org.jdom2.Element;          
import org.jdom2.JDOMException;    
import org.jdom2.input.SAXBuilder; 

import Archivos.Internet;

public class LeerXmlURL {
	
	Internet archi=new Internet();
	ArrayList<String> listaUrl=new ArrayList<String>(); 
	int pesoLocal=667;
	int pesoCompartido=1;
	int pesoWeb=334;
	int peso;
	String tipo;
	
	public synchronized ArrayList<String> leer(){
		//Se crea un SAXBuilder para poder parsear el archivo
		//System.out.println(archi.obtenerDirecctorioActual()+"/URL.xml" );
		SAXBuilder builder = new SAXBuilder();
		File xmlFile =new File(archi.obtenerDirecctorioActual()+"/URL.xml");
		//File xmlFile = new File("/home/steven/Escritorio/URL.xml");
		try
		{
			//Se crea el documento a traves del archivo
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			List list = rootNode.getChildren("URL");

			for (int i = 0; i < list.size(); i++) {
				 
				   Element node = (Element) list.get(i);
				  // System.out.println(node.getText());
				   listaUrl.add(node.getText());
				}
		}catch ( IOException io ) {
			System.out.println( io.getMessage() );
		}catch ( JDOMException jdomex ) {
			System.out.println( jdomex.getMessage() );
		}
		return listaUrl;
	}
	
	public String clasificar(String dir){
		File ulrFile =new File(dir);
		if (ulrFile.getPath().startsWith("http")) {
			tipo="web";
		}
		else if (ulrFile.getPath().startsWith("smb")) {
			tipo="compartido";
		}
		else if (ulrFile.getPath().startsWith("//")) {
			tipo="compartido";
		}
		else if (ulrFile.getPath().startsWith("/")) {
			tipo="local";
		}
		else {
			tipo="Error";
		}
		return tipo;
		
	}
	public int obtenerPeso(String tipo){
		if (tipo.equalsIgnoreCase("web")) {
			if (334 <= pesoWeb && pesoWeb <= 666) {
				peso=pesoWeb;
				pesoWeb++;
			}
			else{
				peso=pesoWeb;
				pesoWeb=334;
			}
		}
		else if (tipo.equalsIgnoreCase("local")) {
			if (667 <= pesoLocal && pesoLocal <= 999) {
				peso=pesoLocal;
				pesoLocal++;
			}
			else{
				peso=pesoWeb;
				pesoLocal=667;
			}
		}
		else if (tipo.equalsIgnoreCase("compartido")) {
			if (1 <= pesoCompartido && pesoCompartido <= 333) {
				peso=pesoCompartido;
				pesoCompartido++;
			}
			else{
				peso=pesoCompartido;
				pesoCompartido=1;
			}
		}
		else {
			System.out.println("Error");
		}
		return peso;
	}
}
