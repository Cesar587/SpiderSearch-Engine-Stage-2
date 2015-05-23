package Parser;

import Listas.ListaSimpleEnlazada;
import Listas.ListaSimpleEnlazadaEspecial;
import Listas.NodoSimple;
import Listas.NodoSimpleEspecial;

public class ParsearBusqueda {
	
	ListaSimpleEnlazada palabrasBuscadas=new ListaSimpleEnlazada();
	ListaSimpleEnlazadaEspecial pb=new ListaSimpleEnlazadaEspecial();
	
	
	public ParsearBusqueda(){
		
	}
	public void obtenerParseo(String busqueda){
	    String delimitadores= "[\n \t    : ( ) / * - { } + = # . , % _ ; ? ! ¡ ¿ \'\"\\[\\]]+";
	    String[] palabras = busqueda.split(delimitadores);
	    
	    for(int i = 0;i<palabras.length;i++){ 
	    	//System.out.println(palabras[i]);
	    	palabrasBuscadas.insertarFinal(palabras[i]);
		}
	}
	public void imprimir(){
		palabrasBuscadas.imprimir();
	}
	public void contarPalabras(){
		NodoSimple aux=palabrasBuscadas.inicio();
		while (aux!=null) {
			if (pb.buscarPalabra(aux.datos)) {
				
			}
			//System.out.println(aux.obtenerDato());
			aux=aux.siguente;
		}
	}
}
