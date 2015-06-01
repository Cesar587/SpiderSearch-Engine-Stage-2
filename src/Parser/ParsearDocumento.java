package Parser;



import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class ParsearDocumento {
	Parser parseo = new AutoDetectParser();

	Metadata metadata = new Metadata();

	BodyContentHandler handler = new BodyContentHandler();

	InputStream texto = null;
	
	ArrayList<String> entrada=new ArrayList<String>();
	ArrayList<String> busqueda= new ArrayList<String>();
	

	/**
	 * Constructor que extrae el texto
	 * 
	 * @param Nombre
	 *            del archivo
	 * @return 
	 */
	public  synchronized void parsear(String archivo) {
		// this.archivo = archivo;

		try {
			/**Lee un nuevo archivo*/
			texto = new BufferedInputStream(new FileInputStream(new File(archivo)));
			
			/**Realiza el parseo*/
			parseo.parse(texto, handler, metadata, new ParseContext());

			for (String name : metadata.names()) {
				String value = metadata.get(name);

			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TikaException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} finally {
			if (texto != null) {
				try {
					texto.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		obtener();

	}

	/**
	 * Método para retornar el texto
	 * 
	 * @return handler
	 */
	
	private synchronized void obtener(){
		String cadena = handler.toString();
	    String delimitadores= "[\n \t \\-     : @ ( ) / * - { } + ₡ = # . , % _ ; ? ! ¡ ¿ \'\"\\[\\]]+";
	    String[] palabrasSeparadas = cadena.split(delimitadores);
	    
	    for(int i = 0;i<palabrasSeparadas.length;i++){
	    	entrada.add(palabrasSeparadas[i]);
	    }
	   obtenerSin();
	}
	private synchronized void obtenerSin(){
		for (int i = 0; i < entrada.size(); i++) {
			if (buscar(entrada.get(i))==false) {
				busqueda.add(entrada.get(i));
			}
		}
		
	}
	
	private synchronized boolean buscar(String texto){
		boolean encontado=false;
		for (int i = 0; i < busqueda.size(); i++) {
			if (busqueda.get(i).equalsIgnoreCase(texto)) {
				encontado=true;
				break;
			}
		}
		return encontado;
	}
	
	public synchronized void imprimir(){
		for (int i = 0; i < busqueda.size(); i++) {
			System.out.println(busqueda.get(i));
		}
		System.out.println(entrada.size());
		System.out.println(busqueda.size());
	}
	public synchronized ArrayList<String> obtenerTodo(){
		return entrada;
	}
	public synchronized ArrayList<String> obtenerParseado(){
		return busqueda;
	}


}
