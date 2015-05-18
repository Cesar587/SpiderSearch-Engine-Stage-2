//Nombre del Arhivo= BST.java
//Paquete ArbolBST (contiene las clases nesesarias de los ArbolBST)
package ArbolBST;

/**
 * Clase BST: Contiene los objetos (raiz y nombre)y los
 * metodos de (insertar, borrar, vacio, raiz, altura, cantidad de nodos) 
 * que se utilizaran para los arboles
 * @author Steven Ortiz
 * @version 1.0 (1/5/15)
 */

//Inicio de la clase BST

//Clase BST contiene los objetos (raiz y nombre)y los 
//metodos de (insertar, borrar, vacio, raiz, altura, cantidad de nodos)  
//que se utilizaran para los arboles
public class BST{
	//Se crea un objeto de tipo NodoBST con el nombre de raiz que apuntara ala raiz del arbol
	public NodoBST raiz;
	//Se crea un objeto de tipo String con el nombre de nombre que contendra el nombre del arbol
	public String nombre;
	//Se crea un objeto de tipo Int(Entero)con el nombre de largo que contendra la cantidad de elementos del arbol
	public int largo;
	
	/**
	 * Consctructor de la clase que hace referencia al nodo raiz
	 * Metodo de tipo BST
	 */
	public BST(){
		//Al objeto raiz se le asigna el valor de nulo
		raiz = null;
	}
	
	/**
	 * Metodo que inserta un nodo al arbol resive dos parametros
	 * Metodo de tipo Void
	 * @param llave (llave del nodo a insertar)
	 * @param dato (dato del nodo a insertar)
	 */
	public void insertar(int llave , Object dato){
		//Se crea un objeto de tipo NodoBST y se le asigana el nombre de nuevo
		NodoBST nuevo= new NodoBST(llave);
		//al nodo nuevo se le agrega el dato el cual se toma de la entrada del usuario
		nuevo.dato=dato;
		// condicion ( si la raiz del arbol es nula)
		if (raiz == null) {
			//la raiz sera el nuevo nodo
			raiz = nuevo;
			//Aumenta el valor del objeto largo en una unidad
			largo++;
		} 
		// si no se cumple
		else {
			// se crea un nuevo objeto de tipo NodoBST llamado aux y se le asigna el valor de la raiz
			NodoBST aux = raiz;
			//Ciclo(mientras el nodo aux sea diferente de nulo
			while (aux != null) {
				//al nodo nuevo se le asigna como padre el nodo auxiliar
				nuevo.padre=aux;
				//condicion: si la llave del nuevo nodo sea mayor o igual a la del nodo auxiliar
				if (nuevo.llave >= aux.llave) {
					//el nodo auxiliar se posiciona como hijo derecho
					aux=aux.hijoDerecho;
				}
				//si no se cumple
				else {
					//el nodo auxiliar se posiciona como hijo izquierdo
					aux=aux.hijoIzquierdo;
				}
			}
			//condicion: si la llave del nuevo nodo es menor a la llave del  nodo padre
			if (nuevo.llave < nuevo.padre.llave) {
				//el nuevo nodo se ubica a la izquierda del nodo padre
				nuevo.padre.hijoIzquierdo=nuevo;
				//Aumenta el valor del objeto largo en una unidad
				largo++;
			}
			//si no se cumple
			else {
				//el nuevo nodo se ubica a la derecha del nodo padre
				nuevo.padre.hijoDerecho=nuevo;
				//Aumenta el valor del objeto largo en una unidad
				largo++;
			}
		}
	}
	
	/**
	 * Medoto que llama a una funcion para recorrer el arlbol en orden y le ingresa cono inicio la raiz
	 * Metodo de tipo Void 
	 */
	public void recorridoEnOrden(){
		//llamada al metodo recorridoEnOrdenAux(valor de inicio del recorrido)
		recorridoEnOrdenAux(raiz);
	}
	
	/**
	 * Metodo que recorre el arbol en orden
	 * Metodo de tipo Void
	 * @param aux (valor de inicio del recorrido)
	 */
	private void recorridoEnOrdenAux(NodoBST aux){
		//condicion: si el nodo auxilar es diferente de nulo
		if (aux!=null) {
			//llamada al metodo recorridoEnORdenAux(dnado como vaor de inicio el hijo izquierdo del nodo)
			recorridoEnOrdenAux(aux.hijoIzquierdo);
			//Imprime en pantalla la llave del nodo
			System.out.println(aux.llave);
			//llamada al metodo recorridoEnORdenAux(dnado como vaor de inicio el hijo derecho del nodo)
			recorridoEnOrdenAux(aux.hijoDerecho);
			
		}
	}
	
	/**
	 * Medoto que llama a una funcion para recorrer el arlbol en pre orden y le ingresa cono inicio la raiz
	 * Metodo de tipo Void 
	 */
	public void recorridoEnPreOrden(){
		recorridoEnPreOrdenAux(raiz);
	}
	
	/**
	 * Metodo que recorre el arbol en pre orden
	 * Metodo de tipo Void
	 * @param aux (valor de inicio del recorrido)
	 */
	private void recorridoEnPreOrdenAux(NodoBST aux){
		if (aux!=null) {
			//Imprime en pantalla la llave del nodo
			System.out.println(aux.llave);
			//llamada al metodo recorridoEnPreORdenAux(dnado como vaor de inicio el hijo izquierdo del nodo)
			recorridoEnPreOrdenAux(aux.hijoIzquierdo);
			//llamada al metodo recorridoEnPreORdenAux(dnado como vaor de inicio el hijo derecho del nodo)
			recorridoEnPreOrdenAux(aux.hijoDerecho);
		}
	}
	
	/**
	 * Medoto que llama a una funcion para recorrer el arlbol en post orden y le ingresa cono inicio la raiz
	 * Metodo de tipo Void 
	 */
	public void recorridoEnPostOrden(){
		recorridoEnPostOrdenAux(raiz);
	}
	
	/**
	 * Metodo que recorre el arbol en post orden
	 * Metodo de tipo Void
	 * @param aux (valor de inicio del recorrido)
	 */
	private void recorridoEnPostOrdenAux(NodoBST aux){
		if (aux!=null) {
			//llamada al metodo recorridoEnPostORdenAux(dnado como vaor de inicio el hijo izquierdo del nodo)
			recorridoEnPostOrdenAux(aux.hijoIzquierdo);
			//llamada al metodo recorridoEnPostORdenAux(dnado como vaor de inicio el hijo derecho del nodo)
			recorridoEnPostOrdenAux(aux.hijoDerecho);
			//Imprime en pantalla la llave del nodo
			System.out.println(aux.llave);
		}
		
	}
	
	/**
	 * Metodo que verifica que el arbol no este vacio
	 * Metodo tipo Boolean
	 * @return true/false (si es o no vacia)
	 */
	public boolean vacio(){
		// retorna si es o no nula la raiz del arbol
		return raiz==null;
	}
	
	/**
	 * Metodo que busca una llave de un nodo en el arbol y la retorna
	 * Metodo tipo NodoBST
	 * @param llaveaux (llave a buscar en el arbol)
	 * @return aux (nodo que tiene esa llave)
	 */
	public NodoBST buscarLlave(int llaveaux){
		//Se crea un nuevo NodoBST llamado Aux y se le asigana el valor de raiz 
		NodoBST aux =raiz;
		//ciclo: mientras llaveaux sea diferente de aux.llave
		while (llaveaux!=aux.llave) {
			//condicon: si llaveaux es menor que aux.llave
			if (llaveaux<aux.llave) {
				//aux se igual a aux.hijoIzquierdo
				aux=aux.hijoIzquierdo;
			}
			//si no
			else {
				//aux se iguala a aux.hijoDerecho
				aux=aux.hijoDerecho;
			}
			//condicion: si aux es igual a nulo 
			if (aux==null){
				//retornar nulo
				return null;
			}
		}
		//retornar aux
		return aux;
	}
	
	
	/**
	 * Metodo para eliminar un nodo del arbol
	 * Metodo de tipo Bolean
	 * @param pos(llave del nodo a eliminar)
	 * @return true si lo elimina
	 */
	public boolean eliminar(int pos){
		//Se crea un nuevo NodoBST llamado auxilar y se le asigana el valor de raiz 
		NodoBST auxiliar =raiz;
		//Se crea un nuevo NodoBST llamado padre y se le asigana el valor de raiz 
		NodoBST padre=raiz;
		//Se cre una variable de tipo Boolean llamada esHijoIzquierdo y se se asigna el valor de true
		boolean esHijoIzquierdo=true;
		//ciclo: mientras auxiliar.llave sea diferente de pos
		while (auxiliar.llave!=pos) {
			//padre se iguala a axuliar
			padre=auxiliar;
			//condicion: si pos es menor a axiliar.llave
			if (pos<auxiliar.llave) {
				//la variable esHijoIzquierdo se la asigna el valor de true
				esHijoIzquierdo=true;
				//axuliar se iguala a auxiliar.hijoIzquierdo
				auxiliar=auxiliar.hijoIzquierdo;
			}
			//si no
			else {
				//la variable esHijoIzquierdo se la asigna el valor de false
				esHijoIzquierdo=false;
				//axuliar se iguala a auxiliar.hijoDerecho
				auxiliar=auxiliar.hijoDerecho;
			}
			//condion: si axular es igual a nulo
			if (auxiliar==null) {
				//retornar false
				return false;
				
			}
		}
		//condicion: si auxiliar.hijoIzquierdo es igual a nulo y auxiliar.hijoDerecho es igual a nuulo
		if (auxiliar.hijoIzquierdo==null && auxiliar.hijoDerecho==null) {
			//condicion: auxiliar es igual a raiz
			if (auxiliar==raiz){
				//raiz se iguala nulo
				raiz=null;
			}
			//condicion: si es hijoIzquerdo 
			else if (esHijoIzquierdo) {
				//padre.hijoIzquierdo se igual a nulo
				padre.hijoIzquierdo=null;
			}
			//si no
			else {
				//padre.hijoDerecho se iguala a nulo
				padre.hijoDerecho=null;
			}
		}
		//condicion: si auxiliar.hijoDerecho es igual a nulo
		else if (auxiliar.hijoDerecho==null) {
			//condicion: si auxiliar es igual a raiz
			if (auxiliar==raiz){
				//raiz se iguala a auxiliar.hijoIzquierdo
				raiz=auxiliar.hijoIzquierdo;
			}
			//condicion: si
			else if (esHijoIzquierdo) {
				//padre.hijoIzquierdo se iguala a auxiliar.hijoIzquierdo
				padre.hijoIzquierdo=auxiliar.hijoIzquierdo;
			}
			//si no
			else {
				// padre.hijoDerecho se iguala a auxiliar.hijoIzquierdo
				padre.hijoDerecho=auxiliar.hijoIzquierdo;
			}
		}
		//condicion: si
		else if (auxiliar.hijoIzquierdo==null) {
			//condicion: si
			if (auxiliar==raiz){
				//raiz se iguala a auxiliar.hijoDerecho
				raiz=auxiliar.hijoDerecho;
			}
			//condicion: si
			else if (esHijoIzquierdo) {
				//padre.hijoIzquierdo se iguala a auxiliar.hijoDerecho
				padre.hijoIzquierdo=auxiliar.hijoDerecho;
			}
			//si no
			else {
				//padre.hijoDerecho se iguala a auxiliar.hijoIzquierdo
				padre.hijoDerecho=auxiliar.hijoIzquierdo;
			}
		}
		//si no
		else {
			//se crea un NodoBST llamado reemplazo y se le asigna el valor de el metodo obtenerNodoReemplazo(auxiliar)
			NodoBST reemplazo =obtenerNodoReemplazo(auxiliar);
			//condicion: si
			if (auxiliar==raiz) {
				//raiz se iguala a reemplazo
				raiz=reemplazo;
			}
			//condicion: si
			else if (esHijoIzquierdo) {
				//padre.hijoIzquierdo se iguala a reemplazo
				padre.hijoIzquierdo=reemplazo;
			}
			//si no
			else {
				//padre.hijoIzquierdo se iguala a reemplazo
				padre.hijoDerecho=reemplazo;
			}
			//reemplazo.hijoIzquierdo se iguala a auxiliar.hijoIzquierdo
			reemplazo.hijoIzquierdo=auxiliar.hijoIzquierdo;
			
		}
		//retornar true
		return true;
	}
	
	/**
	 * Metodo que obtiene el remplazo para cuando se elimina un nodo
	 * Metodo e tipo NodoSBT
	 * @param aux (Nodo a reemplazar)
	 * @return reemplazo(nodo de reemplazo)
	 */
	private NodoBST obtenerNodoReemplazo(NodoBST aux) {
		//Se crea un NodoBST llamado reemplazoPadre y se le asigna un valor de nulo
		NodoBST reemplazoPadre= aux;
		//Se crea un NodoBST llamado reemplazo y se le asigna un valor de aux
		NodoBST reemplazo=aux;
		//Se crea un NodoBST llamado temporal y se le asigna un valor de aux.hijoDerecho
		NodoBST temporal=aux.hijoDerecho;
		//ciclo: mientras temporal sea diferente de nulo
		while (temporal!=null) {
			// reemplazoPadre se iguala a reemplazo
			reemplazoPadre=reemplazo;
			//reemplazo se iguala a temporal
			reemplazo=temporal;
			//temporal se iguala a temporal.hijoIzquierdo
			temporal=temporal.hijoIzquierdo;
		}
		//condicion: si reemplazo es diferente de aux.hijoDerecho
		if (reemplazo!=aux.hijoDerecho) {
			//reemplazoPadre.hijoIzquierdo se iguala a reemplazo.hijoDerecho
			reemplazoPadre.hijoIzquierdo=reemplazo.hijoDerecho;
			//reemplazo.hijoDerecho se iguala a aux.hijoDerecho
			reemplazo.hijoDerecho=aux.hijoDerecho;
		}
		//retorna reemplazo
		return reemplazo;
	}
	
	
	/**
	 * Metodo para obtener el nombre del arbol
	 * Metodo de tipo String
	 * @return nombre(nombre del arbol
	 */
	public String obtenerNombre() {
		//retorna el nombre del arbol
		return nombre;
	}

	/**
	 * Metodo para insertar un nombre al albol
	 * Metodo tipo Void
	 * @param nombre(nombre a insertar)
	 */
	public void insertarNombre(String nombre) {
		//asigna el nombre al arbol
		this.nombre = nombre;
	}

	/**
	 * Metodo para obtener la raiz del arbol
	 * Metodo tipo NodoBST
	 * @return raiz(raiz del arbol)
	 */
	public NodoBST obtenerRaiz() {
		//retorna la raiz
		return raiz;
	}

}
//Fin clase BST