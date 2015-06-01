//Nombre del Arhivo: AVL.java
//Paquete ArbolAVL (contiene las clases nesesarias de los ArbolAVL)
package ArbolAVL;

//Inicio de la clase AVL

/**
 * Clase AVL: Contiene los objetos (raiz y nombre)y los
 * metodos de (insertar, borrar, vacio, raiz, altura, cantidad de nodos) 
 * que se utilizaran para los arboles
 * @author Steven Ortiz
 * @version 1.0 (2/5/15)
 */
public class AVL {
	//Se crea un objeto de tipo NodoAVL con el nombre de raiz que apuntara ala raiz del arbol
	public NodoAVL raiz;
	//Se crea un objeto de tipo String con el nombre de nombre que contendra el nombre del arbol
	public String nombre;
	//Se crea un objeto de tipo Int(Entero)con el nombre de largo que contendra la cantidad de elementos del arbol
	public int largo;
	
	public int repeticiones;

	/**
	 * Consctructor de la clase que hace referencia al nodo raiz
	 * Metodo de tipo AVL
	 */
	public AVL(){
		//Al objeto raiz se le asigna el valor de nulo
		this.raiz = null;
		this.largo=0;
		this.repeticiones=0;
		
	}
	/**
	 * Metodo que busca un nodo en el arbol segun la llave
	 * Metodo de tipo NodoAVL
	 * @param pos(llave a buscar)
	 * @return buscarAux(pos,raiz) nodo buscado
	 */
	public NodoAVL buscar(int pos){
		//retorna metodo auxiliar para la busqueda
		return buscarAux(pos,raiz);
	}
	
	/**
	 * Metodo de busqueda auxiliar busca un nodo segun una llave y un inicio
	 * Metodo de tipo NodoAVL
	 * @param pos(llave a buscar)
	 * @param aux(inicio de la busqueda)
	 * @return aux(nodo buscado)
	 */
	private NodoAVL buscarAux(int pos, NodoAVL aux){
		//condicion: si la raiz es es nula
		if (raiz==null) {
			//retornar vacio
			return null;
		}
		//condicion: Si la llave del nodo es igual a la buscada
		else if (aux.llave==pos) {
			//retornar aux
			return aux;
		} 
		//codicion: si la llave del nodo es menor a la buscada
		else if (aux.llave<pos) {
			//retornar buscarAux(pos, aux.hijoDerecho)
			return buscarAux(pos, aux.hijoDerecho);
		}
		//si no
		else {
			//retornar return buscarAux(pos, aux.hijoIzquierdo)
			return buscarAux(pos, aux.hijoIzquierdo);
		}
	}
	
	/**
	 * Metodo que obtiene el factor de equilibrio de un nodo
	 * Metodo de tipo int
	 * @param aux(Nodo a buscar el factor de equilibrio)
	 * @return el factor de equilibrio (altura del nodo)
	 */
	public int obtenerFactorEquilibrio(NodoAVL aux){
		//condicion:si el nodo es nulo
		if (aux==null) {
			//retornar -1
			return -1;
		}
		//si no 
		else {
			//retornar altura del nodo
			return aux.nodoAltura;
		}
	}
	
	/**
	 * Metodo para la rotacion simple a la izquierda
	 * Metodo de tipo NodoAVL
	 * @param nodo(nodo a rotar)
	 * @return aux(nodo rotado)
	 */
	public NodoAVL rotacionSimpleIzquierda(NodoAVL nodo){
		//se crea un NodoAVL axuliar y se le asigna el valor del hijo izquierdo del nodo a rotar
		NodoAVL aux = nodo.hijoIzquierdo;
		//el hijo izquierdo de nodo a rotar se iguala al hijo derecho del nodo auxiliar
		nodo.hijoIzquierdo=aux.hijoDerecho;
		//el hijo derecho de nodo auxiliar se iguala a nodo a rotar
		aux.hijoDerecho=nodo;
		// se hace la altura del nodo a rotar segun la formula: max(hijo izquierdo, hijo derecho)+1
		nodo.nodoAltura=Math.max(obtenerFactorEquilibrio(nodo.hijoIzquierdo), obtenerFactorEquilibrio(nodo.hijoDerecho))+1;
		// se hace la altura del nodo auxiliar segun la formula: max(hijo izquierdo, hijo derecho)+1
		aux.nodoAltura=Math.max(obtenerFactorEquilibrio(aux.hijoIzquierdo), obtenerFactorEquilibrio(aux.hijoDerecho))+1;
		//retornar el nodo axiliar
		return aux;
	}
	
	/**
	 * Metodo para la rotacion simple a la derecha
	 * Metodo de tipo NodoAVL
	 * @param nodo(nodo a rotar)
	 * @return aux(nodo rotado)
	 */
	public NodoAVL rotacionSimpleDerecha(NodoAVL nodo){
		//se crea un NodoAVL axuliar y se le asigna el valor del hijo derecho del nodo a rotar
		NodoAVL aux = nodo.hijoDerecho;
		//el hijo derecho de nodo a rotar se iguala al hijo izquierdo del nodo auxiliar
		nodo.hijoDerecho=aux.hijoIzquierdo;
		//el hijo izquierdo de nodo auxiliar se iguala a nodo a rotar
		aux.hijoIzquierdo=nodo;
		// se hace la altura del nodo a rotar segun la formula: max(hijo izquierdo, hijo derecho)+1
		nodo.nodoAltura=Math.max(obtenerFactorEquilibrio(nodo.hijoIzquierdo), obtenerFactorEquilibrio(nodo.hijoDerecho))+1;
		// se hace la altura del nodo auxiliar segun la formula: max(hijo izquierdo, hijo derecho)+1
		aux.nodoAltura=Math.max(obtenerFactorEquilibrio(aux.hijoIzquierdo), obtenerFactorEquilibrio(aux.hijoDerecho))+1;
		//retornar el nodo axiliar
		return aux;
	}
	
	/**
	 * Metodo para la rotacion doble a la izquierda
	 * Metodo de tipo NodoAVL
	 * @param nodo (nodo a rotar)
	 * @return aux(nodo rotado)
	 */
	public NodoAVL rotacionDobleIzquierda(NodoAVL nodo){
		//se crea un NodoAVL axuliar
		NodoAVL aux;
		// el hijo izquierdo de nodo a rotar se iguala a rotacion simple derecha del hijo izquierdo del nodo a rotar
		nodo.hijoIzquierdo=rotacionSimpleDerecha(nodo.hijoIzquierdo);
		// el nodo a rotar se iguala a rotacion simple a la izquierda del nodo a rotar
		aux=rotacionSimpleIzquierda(nodo);
		//retornar el nodo axuliar
		return aux;
	}
	
	/** 
	 * Metodo para la rotacion doble a la derecha
	 * Metodo de tipo NodoAVL
	 * @param nodo (nodo a rotar)
	 * @return aux(nodo rotado)
	 */
	public NodoAVL rotacionDobleDerecha(NodoAVL nodo){
		//se crea un NodoAVL axuliar
		NodoAVL aux;
		// el hijo derecho de nodo a rotar se iguala a rotacion simple izquierda del hijo derecho del nodo a rotar
		nodo.hijoDerecho=rotacionSimpleIzquierda(nodo.hijoDerecho);
		// el nodo a rotar se iguala a rotacion simple a la derecha del nodo a rotar
		aux=rotacionSimpleDerecha(nodo);
		//retornar el nodo axuliar
		return aux;
	}
	
	/**
	 * Metodo para insertar un nodo en forma AVL
	 * Metodo de tipo NodoAVL
	 * @param nuevo
	 * @param subArb
	 * @return
	 */
	private NodoAVL insertarAVL (NodoAVL nuevo, NodoAVL subArb){
		NodoAVL nuevoPadre=subArb;
		if (nuevo.llave<=subArb.llave) {
			if (subArb.hijoIzquierdo==null) {
				subArb.hijoIzquierdo=nuevo;
			}
			else {
				subArb.hijoIzquierdo=insertarAVL(nuevo, subArb.hijoIzquierdo);
				if (obtenerFactorEquilibrio(subArb.hijoIzquierdo)-obtenerFactorEquilibrio(subArb.hijoDerecho)==2) {
					if (nuevo.llave<subArb.hijoIzquierdo.llave) {
						nuevoPadre=rotacionSimpleIzquierda(subArb);
					}
					else {
						nuevoPadre=rotacionDobleIzquierda(subArb);
					}
				}
			}
			
		}
		else{
			if (subArb.hijoDerecho==null) {
				subArb.hijoDerecho=nuevo;
			}
			else {
				subArb.hijoDerecho=insertarAVL(nuevo, subArb.hijoDerecho);
				if (obtenerFactorEquilibrio(subArb.hijoDerecho)-obtenerFactorEquilibrio(subArb.hijoIzquierdo)==2) {
					if (nuevo.llave>subArb.hijoDerecho.llave) {
						nuevoPadre=rotacionSimpleDerecha(subArb);
					}
					else {
						nuevoPadre=rotacionDobleDerecha(subArb);
					}
				}
			}
		}
		
		
		if ((subArb.hijoIzquierdo==null)&&(subArb.hijoDerecho!=null)) {
			subArb.nodoAltura=subArb.hijoDerecho.nodoAltura+1;
		}
		else if ((subArb.hijoDerecho==null)&&(subArb.hijoIzquierdo!=null)){
			subArb.nodoAltura=subArb.hijoIzquierdo.nodoAltura+1;
		}
		else {
			subArb.nodoAltura=Math.max(obtenerFactorEquilibrio(subArb.hijoDerecho), obtenerFactorEquilibrio(subArb.hijoIzquierdo))+1;
		}
		return nuevoPadre;
	}

	/**
	 * 
	 * @param llave
	 * @param dato
	 */
	public void Insertar(int llave, String dato){
		NodoAVL nuevo= new NodoAVL(llave,dato);
		if (raiz==null) {
			raiz = nuevo;
		}
		else {
			raiz=insertarAVL(nuevo, raiz);
		}
		largo++;
		repeticiones+=llave;
		
		
	}
	/**
	 * Medoto que llama a una funcion para recorrer el arlbol en orden y le ingresa cono inicio la raiz
	 * Metodo de tipo Void 
	 */
	public void recorridoEnOrdenAVL(){
		//llamada al metodo recorridoEnOrdenAux(valor de inicio del recorrido)
		recorridoEnOrdenAuxAVL(raiz);
	}
	
	/**
	 * Metodo que recorre el arbol en orden
	 * Metodo de tipo Void
	 * @param aux (valor de inicio del recorrido)
	 */
	private void recorridoEnOrdenAuxAVL(NodoAVL aux){
		//condicion: si el nodo auxilar es diferente de nulo
		if (aux!=null) {
			//llamada al metodo recorridoEnORdenAux(dnado como vaor de inicio el hijo izquierdo del nodo)
			recorridoEnOrdenAuxAVL(aux.hijoIzquierdo);
			//Imprime en pantalla la llave del nodo
			System.out.println(aux.llave);
			//llamada al metodo recorridoEnORdenAux(dnado como vaor de inicio el hijo derecho del nodo)
			recorridoEnOrdenAuxAVL(aux.hijoDerecho);
			
		}
	}
	
	/**
	 * Medoto que llama a una funcion para recorrer el arlbol en pre orden y le ingresa cono inicio la raiz
	 * Metodo de tipo Void 
	 */
	public void recorridoEnPreOrdenAVL(){
		recorridoEnPreOrdenAuxAVL(raiz);
	}
	
	/**
	 * Metodo que recorre el arbol en pre orden
	 * Metodo de tipo Void
	 * @param aux (valor de inicio del recorrido)
	 */
	private void recorridoEnPreOrdenAuxAVL(NodoAVL aux){
		if (aux!=null) {
			//Imprime en pantalla la llave del nodo
			System.out.println(aux.llave);
			//llamada al metodo recorridoEnPreORdenAux(dnado como vaor de inicio el hijo izquierdo del nodo)
			recorridoEnPreOrdenAuxAVL(aux.hijoIzquierdo);
			//llamada al metodo recorridoEnPreORdenAux(dnado como vaor de inicio el hijo derecho del nodo)
			recorridoEnPreOrdenAuxAVL(aux.hijoDerecho);
		}
	}
	
	/**
	 * Medoto que llama a una funcion para recorrer el arlbol en post orden y le ingresa cono inicio la raiz
	 * Metodo de tipo Void 
	 */
	public void recorridoEnPostOrdenAVL(){
		recorridoEnPostOrdenAuxAVL(raiz);
	}
	
	/**
	 * Metodo que recorre el arbol en post orden
	 * Metodo de tipo Void
	 * @param aux (valor de inicio del recorrido)
	 */
	private void recorridoEnPostOrdenAuxAVL(NodoAVL aux){
		if (aux!=null) {
			//llamada al metodo recorridoEnPostORdenAux(dnado como vaor de inicio el hijo izquierdo del nodo)
			recorridoEnPostOrdenAuxAVL(aux.hijoIzquierdo);
			//llamada al metodo recorridoEnPostORdenAux(dnado como vaor de inicio el hijo derecho del nodo)
			recorridoEnPostOrdenAuxAVL(aux.hijoDerecho);
			//Imprime en pantalla la llave del nodo
			System.out.println(aux.llave);
		}
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public NodoAVL getRaiz() {
		return raiz;
	}
	public int getLargo() {
		return largo;
	}
	
}
//Fin clase AVL