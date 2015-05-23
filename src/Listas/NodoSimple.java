//Nombre del Arhivo: NodoSimple.java
// Paquete Listas (contiene las clases nesesarias de las listas enlazadas)
package Listas;

/**
 * Clase NodoSimple: Contiene los Objetos y apuntadores que se utilizaran para las listas enlazadas
 * @author Steven Ortiz
 * @version 1.0 (24/4/2015)
 * @category Estructuras de datos lineales
 */

//Inicio de la clase NodoSimple

// Clase NodoSimple contiene datos, apuntador, metodos para los apuntadoes y datos
public class NodoSimple {
	// datos: variable de tipo Objeto que contendra la informacion a almacenar
	public String datos;
	// siguiente: variable de tipo NodoSimple la cual nos servira de apuntador al siguente nodo
	public NodoSimple siguente;
	
	/**
	 * Constructor que crea un objeto Nodosimple que hace referencia al objeto
	 * Metodo tipo NodoSimple
	 * @param valor es un objeto de tipo Objetc
	 */
	public NodoSimple(String valor){
		// Al objeto datos se le asigan el valor del objeto valor
		this.datos=valor;
		// Al objeto siguiente se le asigan el valor de nulo
		this.siguente= null;
	}
	
	/**
	 * Metodo para enlazar el nodo actual con el siguiente nodo
	 * Metodo tipo Void
	 * @param NodoSiguiente es el nodo siguiente a enlazar
	 */
	public void enlazarSiguiente(NodoSimple NodoSiguiente){
		// Al objeto siguiente se le asigna el valor del objeto NodoSiguiente
		siguente=NodoSiguiente;
	}
	 
	 /**
	  * Metodo que obtiene el valor del objeto y lo retorna
	  * Metodo tipo Object
	  * @return devuelve el dato de este nodo
	  */
	 public Object obtenerDato(){
		 // devuelve datos(contiene el dato del nodo)
		 return datos;
	 }
	 
	 /**
	  *Metodo que devuelve la referencia al siguiente nodo en la lista
	  *Metodo tipo NodoSimple
	  * @return devuelve el valor del siguiente nodo
	  */
	 public NodoSimple obtenerSiguiente(){
		 //devuelve siguiente (contiene el siguiente nodo)
		 return siguente;
	 }

	 /**
	  * Metodo que cambia el valor del objeto datos por otro nuevo
	  * Metodo tipo Void
	  * @param datos nuevo valor a cambiar
	  */
	public void cambioDatos(String datos) {
		//Se le asigana el nuevo valor
		this.datos = datos;
	}
	
	/**
	 * Metodo que cambia el valor del objeto siguiente por otro nuevo
	 * Metodo tipo Void
	 * @param siguente uevo valor a cambiar
	 */
	public void cambioSiguente(NodoSimple siguente) {
		//Se le asigana el nuevo valor
		this.siguente = siguente;
	}
	
}
//Fin de la clase NodoSimple
