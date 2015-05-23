//Nombre del Arhivo: ListaSimpleEnlazada.java
// Paquete Listas (contiene las clases nesesarias de las listas enlazadas)
package Listas;

/**
 * Clase ListaSimpleEnlazada: Crea una lista simple enlazada, ademas contiene metodos para insertar objetos,
 * eliminar objetos, buscar objetos,
 * @author Steven Ortiz
 * @version 1.0 (26/4/2015)
 * @category Estructuras de datos lineales
 */

//Inicio de la clase ListaSimpleEnlazada

//Clase ListaSimpleEnlazada contiene nombre, apuntadores (inicio y fin) y metodos para (inserccion,
// busquedad, borrado,lista vacia y tamaño de la lista)
public class ListaSimpleEnlazadaEspecial  {


	//Se crea un objeto de tipo NodoSimple llamado primero el cual sera el apuntador del inicio de la lista
	public NodoSimpleEspecial primero;
	//Se crea un objeto de tipo NodoSimple llamado ultimo el cual sera el apuntador del fin de la lista
	public NodoSimpleEspecial ultimo;
	//Se crea un objeto de tipo String llamado nomber el cual sera el nombre de la lista
	public String nombre;
	//Se crea una variable de tipo entero para tener la cuenta de los elementos de la lista
	public int largo;
	 
	/**
	 * Metodo para verificar que la lista no sea vacia y retorna un valor true/false
	 * Metodo tipo Boolean
	 * @return true (lista es vacia) False (lista no vacia)
	 */
	 public boolean vacia(){
		 //condicion: si el indice que apunta al primer nodo es nulo
		 if (primero ==null){
			 //si cumple la condicion anterior retorna true (Si)
			 return true;
		 }
		 //condicion: si no se cumple
		else {
			//si no se cumple la condicion anterior retorna false (No)
			return false;
		}
	 }
	 
	 /**
	  * Metodo que obtiene el tamano de la lista y lo retorna
	  * Metodo tipo Int(Entero)
	  * @return largo (la variable largo contiene el tamano de la lista)
	  */
	public int largo(){
		//devuelve el valor de la variable largo la cual contiene el tama�o de la lista
		return largo;
	}
	
	/**
	 * Metodo que obtiene el dato del ultimo nodo de la lista
	 * Metodo tipo Object
	 * @return ultimo.datos(contiene el dato de el ultimo nodo de la lista)
	 */
	public NodoSimpleEspecial fin(){
		//devuelve ultimo.datos(contiene el dato de el ultimo nodo de la lista)
		return ultimo;
	}
	
	/**
	 * Metodo que obtiene el dato del primer nodo de la lista
	 * Metodo tipo Object
	 * @return primero.datos(contiene el dato de el primer nodo de la lista)
	 */
	public NodoSimpleEspecial inico(){
		//devuele primero.datos(contiene el dato de el primer nodo de la lista)
		return primero;
	}
	
	/**
	 * Metodo que inserta un nodo al final de la lista
	 * Metodo tipo Void
	 * @param dato(dato del nodo a insertar)
	 */
	public void insertarFinal(String palabraN,int cantidadN){
		//Condicion: verifica si la lista esta vacia
		if (vacia()==true){
			//posiciona el apuntador de el primer nodo a el nuevo nodo
			primero=new NodoSimpleEspecial(palabraN,cantidadN);
			//iguala la posicion del ultimo nodo con la del primero
			ultimo= primero;
		}
		//Condicion: lista no vacia
		else{
			//Crea un nuevo nodo lo llama inicial el cual tendra el valor del primer nodo de la lista
			NodoSimpleEspecial inicial = ultimo;
			//Crea un nuevo nodo al cual le asigna el valor del dato ingresado
			NodoSimpleEspecial nuevo= new NodoSimpleEspecial(palabraN,cantidadN);
			//al nodo del inicio le asigna como siguiente nodo el nuevo nodo
			inicial.siguente=nuevo;
			//al nuevo nodo le asigna el apuntador del final
			ultimo=nuevo;
		}
		//aumenta en una unidad el tama�o de la lista
		largo++;
	}
	
	/**
	 * Metodo que inserta un nodo al final de la lista
	 * Metodo tipo Void
	 * @param dato (dato del nodo a insertar)
	 */
	public void insertarInicio(String palabraN,int cantidadN){
		//Condicion: verifica si la lista esta vacia
		if (vacia()==true){
			//posiciona el apuntador de el primer nodo a el nuevo nodo
			primero=new NodoSimpleEspecial(palabraN,cantidadN);
			//iguala la posicion del ultimo nodo con la del primero
			ultimo= primero;
		}
		else{
			//Crea un nuevo nodo lo llama anterios el cual tendra el valor del primer nodo de la lista
			NodoSimpleEspecial anterior = primero;
			//Crea un nuevo nodo al cual le asigna el valor del dato ingresado
			NodoSimpleEspecial nuevo= new NodoSimpleEspecial(palabraN,cantidadN);
			//al nodo nuevo le asigna como siguiente nodo el anterior
			nuevo.siguente=anterior;
			//al apuntador del primer nodo le asigna el valor del nuevo nodo
			primero=nuevo;
		}
		//aumenta en una unidad el tama�o de la lista
		largo++;
	}
	
	/**
	 * Metodo que busca un nodo segun la posicion y retorna el dato del nodo
	 * Metodo tipo Object
	 * @param posicion (valor de la posicon a buscar)
	 * @return el dato del nodo o mesaje de error si la posicion no existe
	 */
	public Object buscarPosicion(int posicion){
		//condicion: posicion a buscar menor igual a tamano de la lista y mayor a cero
		if (0<posicion && posicion<=largo){
			//se crea una variable de tipo Int(entero) la cual se llama contador y servira para llevar la cuenta en el recorrido de la lista
			int contador=1;
			//Se cre un nodo auxiliar y le asigna el apuntodor al primer nodo de la lista
			NodoSimpleEspecial aux = primero;
			//se crea un ciclo para recorrer la lista
			//condicion: mientras el contador del recoorido sea menor a la posicion buscada
			while(contador<posicion){
				//el nodo auxiliar  se iguala al nodo siguiente
				aux=aux.siguente;
				//se aumenta contador en una variable
				contador++;
			}
			//cuando se termina el ciclo se retorna el dato del nodo auxiliar
			return aux.obtenerPalabra();
		}
		// si no se cumple
		else{
			// retorna un mensaje de error
			return "Error indice fuera de rango";
		}
	}
	
	/**
	 * Metodo que elimina el primer nodo de la lista
	 * Metodo tipo void
	 */
	public void eliminarPrimero(){
		//Al apuntador del primer nodo se le asigna el nodo siguiente
		primero=primero.siguente;
		//se reduce en una unidad el tama�o de la lista
		largo--;
	}
	
	/**
	 * 
	 * @param posicion
	 */
	public void eliminarPosicion(int posicion){
		if(posicion==1){
			eliminarPrimero();
		}
		else if(1<posicion && posicion<=largo){
			int contador=1;
			NodoSimpleEspecial aux=primero;
			while (contador+1<posicion) {
				aux=aux.siguente;
				contador++;
			}
			aux.siguente=aux.siguente.siguente;
		}
		largo--;
	
		//else if (posicion==largo) {
			
		//}
	}
	
	/**
	 * 
	 * @param posicion
	 */
	public void cortarPosicion(int posicion){
		int contador=1;
		NodoSimpleEspecial aux=primero;
		while (contador<posicion) {
			aux=aux.siguente;
			contador++;
		}
		aux.siguente=null;
		largo=cuenta();
		
	}
	
	/**
	 * 
	 */
	public void eliminarUltimo(){
		eliminarPosicion(largo);
	}
	
	/**
	 * 
	 * @return
	 */
	public String nombreLista() {
		return nombre;
	}
	
	/**
	 * 
	 * @param nombre
	 */
	public void insertarNombe(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * 
	 * @return
	 */
	public int cuenta(){
		int contador=0;
		if(vacia()==false){
			NodoSimpleEspecial aux=primero;
			while (aux.siguente!=null) {
				aux=aux.siguente;
				contador++;	
			}
			return contador+1;
		}
		else {
			return contador;
		}
		
	}
	
	/**
	 * 
	 */
	public void imprimir(){
		NodoSimpleEspecial aux=primero;
		while (aux!=null) {
			System.out.println(aux.obtenerPalabra());
			aux=aux.siguente;
		}
		
	}
	public boolean buscarPalabra(String palabraN){
		//Se cre un nodo auxiliar y le asigna el apuntodor al primer nodo de la lista
		NodoSimpleEspecial aux = primero;
		//se crea un ciclo para recorrer la lista
		//condicion: mientras el contador del recoorido sea menor a la posicion buscada
		while(aux.siguente!=null){
			if (aux.obtenerPalabra().equalsIgnoreCase(palabraN)!=true) {
				//el nodo auxiliar  se iguala al nodo siguiente
				aux=aux.siguente;
			}
			else {
				return true;
			}
			
		}
		//cuando se termina el ciclo se retorna el dato del nodo auxiliar
		return false;
		
	}
	
	

	

}
//Fin clase ListaSimpleEnlazada
