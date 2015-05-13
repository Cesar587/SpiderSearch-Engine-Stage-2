//Nombre del Arhivo: NodoBST.java
// Paquete ArbolBST(contiene las clases nesesarias de los ArbolBST)
package ArbolBST;

/**
 * Clase NodoBST: Contiene los Objetos y apuntadores(hijos) que se utilizaran para los arboles
 * @author Steven Ortiz
 * @version 1.0 (29/4/15)
 * @category Estructuras de datos jerarquicas
 */

//Inicio de la clase NodoBST

//Clase NodoBST contiene llave, datos, apuntador(hijos), metodos para los apuntadoes, datos y llave
public class NodoBST {
	//Se crea un objeto de tipo NodoBST con el nombre de padre que apuntara al padre del nodo
	public NodoBST padre;
	//Se crea un objeto de tipo NodoBST con el nombre de hijoDerecho que apuntara al hijo derecho del nodo
	public NodoBST hijoDerecho;
	//Se crea un objeto de tipo NodoBST con el nombre de hijoIzquierdo que apuntara al hijo izquierdo del nodo
	public NodoBST hijoIzquierdo;
	//Se crea un objeto de tipo Object con el nombre de dato que contendra el dato del nodo
	public Object dato;
	//Se crea un objeto de tipo Int(Entero) con el nombre de llave que contendra una llave(valor de comparacion) del nodo
	public int llave;	
	
	/**
	 * Constructor  de la clase que crea un objeto NodoBST que hace referencia ala llave
	 * Metodo tipo NodoSimple
	 * @param llave(llave del nodo)
	 */
	public NodoBST(int llave) {
		// Al objeto padre se le asigan el valor de nulo
		this.padre = null;
		// Al objeto hijoDerecho se le asigan el valor de nulo
		this.hijoDerecho = null;
		// Al objeto hijoIzquierdo se le asigan el valor de nulo
		this.hijoIzquierdo = null;
		// Al objeto llave se le asigan el valor del objeto llave
		this.llave=llave;
		// Al objeto dato se le asigan el valor de nulo
		this.dato=null;
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
	 * Metodo tipo NodoBST
	 * @return padre(apuntador al padre del nodo)
	 */
	public NodoBST obtenerPadre() {
		//devuelve padre (contiene el apundator del padre del nodo)
		return padre;
	}

	/**
	 * Metodo que obtiene el hijo derecho del nodo y lo retorna
	 * Metodo tipo NodoBST
	 * @return hijoDerecho (apuntador al hijo derecho del nodo)
	 */
	public NodoBST obtenerHijoDerecho() {
		//devuelve hijoDerecho (contiene el apundator al hijo derecho del nodo)
		return hijoDerecho;
	}
	
	/**
	 * Metodo que obtiene el hijo izquierdo del nodo y lo retorna
	 * Metodo tipo NodoBST
	 * @return hijoIzquierdo(apuntador al hijo izquierdo del nodo)
	 */
	public NodoBST obtenerHijoIzquierdo() {
		//devuelve hijoIzquierdo (contiene el apundator al hijo izquierdo del nodo)
		return hijoIzquierdo;
	}
	
	/**
	 * Metodo que obtiene la llave del nodo y lo retorna
	 * Metodo tipo Object
	 * @return dato(contienen el dato del nodo)
	 */
	public Object obtenerDato() {
		//devuelve dato (contiene el dato del nodo)
		return dato;
	}

}
//Fin clase NodoBST