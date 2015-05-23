//Nombre del Arhivo: NodoSplay.java
// Paquete ArbolSplay(contiene las clases nesesarias de los Arboles Splay)
package ArbolSplay;

/**
 * Clase NodoSplay: Contiene los Objetos y apuntadores(hijos) que se utilizaran para los arboles
 * @author Steven Ortiz
 * @version 1.0 (19/5/15)
 * @category Estructuras de datos jerarquicas
 */

//Inicio de la clase NodoSplay

//Clase NodoSplay contiene llave, datos, apuntador(hijos), metodos para los apuntadoes, datos y llave
public class NodoSplay {
	//Se crea un objeto de tipo Int(Entero) con el nombre de llave que contendra una llave(valor de comparacion) del nodo
	public int llave;
	//Se crea un objeto de tipo Object con el nombre de dato que contendra el dato del nodo
	public String dato;
	//Se crea un objeto de tipo NodoSplay con el nombre de hijoIzquierdo que apuntara al hijo izquierdo del nodo
	public NodoSplay hijoIzquiero;
	//Se crea un objeto de tipo NodoSplay con el nombre de hijoDerecho que apuntara al hijo derecho del nodo
	public NodoSplay hijoDerecho;
	//Se crea un objeto de tipo NodoSplay con el nombre de padre que apuntara al padre del nodo
	public NodoSplay padre;
	
	/**
	 * Constructor  de la clase que crea un objeto NodoSplay que hace referencia ala llave
	 * Metodo tipo NodoSplay
	 * @param llaveN (llave del nodo)
	 * @param datoN (dato del nodo)
	 */
	public NodoSplay (int llaveN,String datoN){
		// Al objeto llave se le asigan el valor del objeto llaveN
		this.llave=llaveN;
		// Al objeto padre se le asigan el valor de nulo
		this.padre=null;
		// Al objeto hijoIzquierdo se le asigan el valor de nulo
		this.hijoIzquiero = null;
		// Al objeto hijoDerecho se le asigan el valor de nulo
		this.hijoDerecho = null;
		// Al objeto dato se le asigan el valor de datoN
		this.dato=datoN;
	}

	public int getLlave() {
		return llave;
	}

	public String getDato() {
		return dato;
	}

	public NodoSplay getHijoIzquiero() {
		return hijoIzquiero;
	}

	public NodoSplay getHijoDerecho() {
		return hijoDerecho;
	}

	public NodoSplay getPadre() {
		return padre;
	}
	
	
}
