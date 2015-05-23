//Nombre del Arhivo= NodoAVL.java
//Paquete ArbolAVL (contiene las clases nesesarias de los Arboles AVL)
package ArbolAVL;

//Inicio de la clase NodoAVL

//Clase NodoAVL contiene llave, datos, nodoAltura, apuntador(hijos), metodos para los apuntadoes, datos, llave y nodoALtura
public class NodoAVL {
	//Se crea un objeto de tipo NodoAVL con el nombre de padre que apuntara al padre del nodo
	public NodoAVL padre;
	//Se crea un objeto de tipo NodoAVL con el nombre de hijoDerecho que apuntara al hijo derecho del nodo
	public NodoAVL hijoDerecho;
	//Se crea un objeto de tipo NodoAVL con el nombre de hijoIzquierdo que apuntara al hijo izquierdo del nodo
	public NodoAVL hijoIzquierdo;
	//Se crea un objeto de tipo Object con el nombre de dato que contendra el dato del nodo
	public Object dato;
	//Se crea un objeto de tipo Int(Entero) con el nombre de llave que contendra una llave(valor de comparacion) del nodo
	public int llave;
	//Se crea un Objeto de tipo Int(Entero) con el nombre de nodoAltura que contendra la altura del nodo
	public int nodoAltura;
	
	/**
	 * Constructor  de la clase que crea un objeto NodoAVL que hace referencia ala llave
	 * Metodo tipo NodoAVL
	 * @param llave(llave del nodo)
	 * @param dato(dato del nodo)
	 */
	public NodoAVL(int llave ,String dato) {
		// Al objeto padre se le asigan el valor de nulo
		this.padre = null;
		// Al objeto hijoDerecho se le asigan el valor de nulo
		this.hijoDerecho = null;
		// Al objeto hijoIzquierdo se le asigan el valor de nulo
		this.hijoIzquierdo = null;
		// Al objeto llave se le asigan el valor del objeto llave
		this.llave=llave;
		// Al objeto dato se le asigan el valor del objeto dato
		this.dato=dato;
		// Al objeto nodoAltura se le asigan el valor de 0
		this.nodoAltura=0;
	}
	

	/**
	 * Metodo que obtiene la llave del nodo y la retorna
	 * Metodo tipo Int(Entero)
	 * @return llave (valor de comparacion)
	 */
	public int obtenerLlave() {
		//devuelve llave (contiene el valor de la llave del nodo)
		return llave;
	}

	/**
	 * Metodo que obtiene el padre del nodo y lo retorna
	  * Metodo tipo NodoAVL
	 * @return padre(apuntador al padre del nodo)
	 */
	public NodoAVL obtenerPadre() {
		//devuelve padre (contiene el apundator del padre del nodo)
		return padre;
	}

	/**
	 * Metodo que obtiene el hijo derecho del nodo y lo retorna
	  * Metodo tipo NodoAVL
	 * @return hijoDerecho (apuntador al hijo derecho del nodo)
	 */
	public NodoAVL obtenerHijoDerecho() {
		//devuelve hijoDerecho (contiene el apundator al hijo derecho del nodo)
		return hijoDerecho;
	}
	
	/**
	 * Metodo que obtiene el hijo izquierdo del nodo y lo retorna
	 * Metodo tipo NodoAVL
	 * @return hijoIzquierdo(apuntador al hijo izquierdo del nodo)
	 */
	public NodoAVL obtenerHijoIzquierdo() {
		//devuelve hijoIzquierdo (contiene el apundator al hijo izquierdo del nodo)
		return hijoIzquierdo;
	}
	
	/**
	 * Metodo que obtiene la llave del nodo y la retorna
	 * Metodo tipo Object
	 * @return dato(contiene el dato del nodo)
	 */
	public Object obtenerDato() {
		//devuelve dato (contiene el dato del nodo)
		return dato;
	}
	
	/**
	 * Metodo que obtiene la altura del nodo y la retorna
	 * Metodo tipo Int(Entero)
	 * @return nodoAltura(contiene la altura del nodo)
	 */
	public int obtenerNodoAltura() {
		//devuelve nodoAltura(contiene la altura del nodo)
		return nodoAltura;
	}
	
}
//Fin clase NodoAVL