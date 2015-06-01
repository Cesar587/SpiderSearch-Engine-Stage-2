//Nombre del Arhivo: NodoHeapSort.java
// Paquete ArbolBST(contiene las clases nesesarias de los Arboles HeapSort)
package ArbolHeapSort;

/**
 * Clase NodoHeapSort: Contiene los Objetos y apuntadores(hijos) que se utilizaran para los arboles
 * @author Steven Ortiz
 * @version 1.0 (26/5/15)
 * @category Estructuras de datos jerarquicas
 */

//Inicio de la clase HeapSort

//Clase HeapSort contiene url y peso
public class NodoHeapSort {
	//Se crea un objeto de tipo Int(Entero) con el nombre de padre que apuntara al padre del nodo
	public int padre;
	//Se crea un objeto de tipo Int(Entero)t con el nombre de hijoDerecho que apuntara al hijo derecho del nodo
	public int hijoDerecho;
	//Se crea un objeto de tipo Int(Entero) con el nombre de hijoIzquierdo que apuntara al hijo izquierdo del nodo
	public int hijoIzquierdo;
	//Se crea un objeto de tipo String con el nombre de url que contendra el url del nodo
	public String url;
	//Se crea un objeto de tipo Int(Entero) con el nombre de peso que contendra el peso de cada url(valor de comparacion) del nodo
	public int peso;	
	
	/**
	 * Constructor  de la clase que crea un objeto NodoeapSort que hace referencia al peso
	 * Metodo tipo NodoeapSort
	 * @param pesoN (peso de la URL)
	 * @param UrlN (direccion URL)
	 */
	public NodoHeapSort(int pesoN,String urlN) {
		// Al objeto padre se le asigan el valor de nulo
		this.padre = 0;
		// Al objeto hijoDerecho se le asigan el valor de nulo
		this.hijoDerecho = 0;
		// Al objeto hijoIzquierdo se le asigan el valor de nulo
		this.hijoIzquierdo = 0;
		// Al objeto peso se le asigan el valor del objeto pesoN
		this.peso=pesoN;
		// Al objeto url se le asigan el valor del objeto urlN
		this.url=urlN;
	}

	public synchronized int getPadre() {
		return padre;
	}

	public synchronized int getHijoDerecho() {
		return hijoDerecho;
	}

	public synchronized int getHijoIzquierdo() {
		return hijoIzquierdo;
	}

	public synchronized String getUrl() {
		return url;
	}

	public synchronized int getPeso() {
		return peso;
	}
	
	
}
//Fin de la clase HeapSort