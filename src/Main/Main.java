package Main;

import Carpetas.*;
import Parser.*;
import Xml.*;
import ClientServer.*;
import Interfacez.InterfazCliente;
public class Main {

	public static void main(String[] args){
		//System.out.println("cas");
		
		//BuscaArchivos busqueda = new BuscaArchivos();
		//busqueda.buscarCarpetas("smb://STEVEN-AO722");
		//busqueda.buscarsubcarpeta("smb://STEVEN-AO722");
		//busqueda.cantidadPdf();
		//busqueda.cantidadDoc();
		//busqueda.cantidadDocx();
		//busqueda.cantidadOdt();
		//busqueda.cantidadTxt();
		//busqueda.cantidadArchivos();
		//busqueda.comprobarDir("http://cs.wellesley.edu/~cs231/fall01/red-black.pdf");
		//busqueda.comprobarDir("/home/steven");
		//busqueda.conectarweb();
		
		
		//PdfParse parseo=new PdfParse();
		//parseo.parserPdf("smb://steven-ao722/compartida/navegador.txt");
		//parseo.parserPdf("/home/steven/Escritorio/cas.txt");
		//System.out.println(parseo.parserPdf("/home/steven/Escritorio/Bitacora.pdf"));
		//parseo.testTika());
		//parseo.obtner();
		//System.out.println(parseo.parseToPlainText());
		//CrearXml config=new CrearXml();
		//config.crear();
		
		//parseo.Pdf("/home/steven/Escritorio/JavaEE.pdf");
		
		//System.out.print(parseo.parserPdf("http://www.dlsi.ua.es/asignaturas/sid/JSockets.pdf"));
	    /*String cadena = parseo.parserPdf("/home/steven/Escritorio/Manual Basico de Java.pdf");
	    String delimitadores= "[\n    .,;?!¡¿\'\"\\[\\]]+";
	    String[] palabrasSeparadas = cadena.split(delimitadores);
	    
	    for(int i = 0;i<palabrasSeparadas.length;i++){ 
	    	System.out.println(palabrasSeparadas[i]);
		
	    }*/

		//parseo.Pdf("/home/steven/Escritorio/Java.pdf");
	
		//Server servidor =new Server();
		//servidor.initServer();
		
		InterfazCliente venCliente =new InterfazCliente();
		//venCliente.crearVentana();
	
		
	}

}
