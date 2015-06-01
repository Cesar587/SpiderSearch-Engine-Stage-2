package Parser;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class parserTextInput {
	
	ArrayList<String> entrada= new ArrayList<String>();
	ArrayList<String> busqueda= new ArrayList<String>();
	boolean result=false;
	int largo;
	public parserTextInput() {
		
	}
	public synchronized void parsear(String texto){
		String cadena = texto;
	    String delimitadores= "[\n \t \\-     : @ ( ) / * - { } + ₡ = # . , % _ ; ? ! ¡ ¿ \'\"\\[\\]]+";
	    String[] palabrasSeparadas = cadena.split(delimitadores);
	    
	    for(int i = 0;i<palabrasSeparadas.length;i++){
	    	entrada.add(palabrasSeparadas[i]);
	    }
	    insertar();
	}
	
	private synchronized void insertar() {
		for (int i = 0; i < entrada.size(); i++) {
			if (buscar(entrada.get(i))) {
				
			}
			else {
				busqueda.add(entrada.get(i));
			}
		}
	}
	private synchronized boolean buscar(String texto){
		largo=busqueda.size()-1;
		while (largo!=(-1)) {
			if (busqueda.get(largo).equalsIgnoreCase(texto)) {
				result=true;
				break;
			} else {
				result=false;
				largo--;
			}
		}
		return result;
	}
	
	public synchronized void imprimir(){
		System.out.println("largo entrada: "+entrada.size());
		System.out.println("largo busqueda: "+busqueda.size());
		for (int i = 0; i < busqueda.size(); i++) {
			System.out.println(busqueda.get(i));
		}
	}
	public synchronized ArrayList<String> obtenerParseo() {
		return busqueda;
	}
}
