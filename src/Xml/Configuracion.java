//Nombre del Arhivo: Configuracion.java
// Paquete Xml (contiene las clases nesesarias para el manejo de XML)
package Xml;

/**
 * Clase Configuracion: Contiene los Objetos de configuracion del spiderbot
 * @author Steven Ortiz
 * @version 1.0 (24/5/2015)
 * @category Estructuras de datos lineales
 */

//Inicio de la clase Configuracion

// Clase Configuracion contiene datos, apuntador, metodos para los apuntadoes y datos
public class Configuracion {
	//maxthereads: cantidad de hilos del spiderbot
	public int maxthereads;
	// recursivity: profundidad del spiderbot
	public int recursivity;
	//reindex: tiempo de actualizacion del spiderbot
	public int reindex;
	
	/**
	 * Constructor que crea un objeto Nodosimple que hace referencia al objeto
	 * Metodo tipo NodoSimple
	 * @param valor es un objeto de tipo Objetc
	 */
	public Configuracion(int maxthereadsN,int recursivityN, int reindexN){
		// Al objeto maxthereads se le asigan el valor de maxthereadsN
		this.maxthereads=maxthereadsN;
		// Al objeto recursivity se le asigan el valor de recursivityN
		this.recursivity= recursivityN;
		// Al objeto reindex se le asigan el valor de reindex
		this.reindex=reindexN;
	}

	public synchronized int obtnerMaxthereads() {
		return maxthereads;
	}

	public synchronized void definirMaxthereads(int maxthereads) {
		this.maxthereads = maxthereads;
	}

	public synchronized int obtenerRecursivity() {
		return recursivity;
	}

	public synchronized void definirRecursivity(int recursivity) {
		this.recursivity = recursivity;
	}

	public synchronized int obtenerReindex() {
		return reindex;
	}

	public synchronized void definirReindex(int reindex) {
		this.reindex = reindex;
	}
	
	
	
}
//Fin de la clase Configuracion
