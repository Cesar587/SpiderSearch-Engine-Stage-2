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
public class NodoSimpleEspecial {
	// datos: variable de tipo String que contendra la informacion a almacenar
	public String palabra;
	// siguiente: variable de tipo NodoSimple la cual nos servira de apuntador al siguente nodo
	public NodoSimpleEspecial siguente;
	public int cantidad;
	
	/**
	 * Constructor que crea un objeto Nodosimple que hace referencia al objeto
	 * Metodo tipo NodoSimple
	 * @param valor es un objeto de tipo Objetc
	 */
	public NodoSimpleEspecial(String palabraN,int cantidadN){
		// Al objeto datos se le asigan el valor del objeto valor
		this.palabra=palabraN;
		// Al objeto siguiente se le asigan el valor de nulo
		this.siguente= null;
		this.cantidad=cantidadN;
	}
	
	/**
	 * Metodo para enlazar el nodo actual con el siguiente nodo
	 * Metodo tipo Void
	 * @param NodoSiguiente es el nodo siguiente a enlazar
	 */
	public void enlazarSiguiente(NodoSimpleEspecial NodoSiguiente){
		// Al objeto siguiente se le asigna el valor del objeto NodoSiguiente
		siguente=NodoSiguiente;
	}
	 
	 /**
	  * Metodo que obtiene el valor del objeto y lo retorna
	  * Metodo tipo Object
	  * @return devuelve el dato de este nodo
	  */
	 public String obtenerPalabra(){
		 // devuelve datos(contiene el dato del nodo)
		 return palabra;
	 }
	 
	 /**
	  *Metodo que devuelve la referencia al siguiente nodo en la lista
	  *Metodo tipo NodoSimple
	  * @return devuelve el valor del siguiente nodo
	  */
	 public NodoSimpleEspecial obtenerSiguiente(){
		 //devuelve siguiente (contiene el siguiente nodo)
		 return siguente;
	 }

	public int obtenerCantidad() {
		return cantidad;
	}

	public void cambiarCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
	
}
//Fin de la clase NodoSimple
