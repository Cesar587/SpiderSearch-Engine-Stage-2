package ArbolRojiNegro;

//version del compilador java 1.6.0_13

public class RojiNegro {

	public NodoRojiNegro primerNodo; // nodo raiz del arbol
	public NodoRojiNegro nodEncontrado; // para busquedas guarda la referencia del nodo encontrado para resaltarlo

	// constructor de la clase crea la ventana y sus controles
	public RojiNegro(){
		
		primerNodo=null;
		nodEncontrado=null;
	}

	// metodo que inserta el nodo en el arbol recibe el numero y texto del nuevo nodo
	public void Insertar(int numero, String texto){
		NodoRojiNegro nuevoNodo;
		boolean esHijoDer;
		if(primerNodo==null) // ve si el arbol esta vacio y crea el nodo como raiz
			primerNodo=new NodoRojiNegro(numero,texto,false);
		else{
			nuevoNodo=new NodoRojiNegro(numero,texto,true);
			nuevoNodo.padre=primerNodo;
			while(true){ 
				// recorre los nodos que existan para buscar el lugar del nuevo nodo en base a su numero
				if(numero<nuevoNodo.padre.numero){
					if(nuevoNodo.padre.izquierdo!=null) nuevoNodo.padre=nuevoNodo.padre.izquierdo;
					else{
						nuevoNodo.padre.izquierdo=nuevoNodo;
						esHijoDer=false;
						break;
					}
				}
				else{
					if(nuevoNodo.padre.derecho!=null) nuevoNodo.padre=nuevoNodo.padre.derecho;
					else{
						nuevoNodo.padre.derecho=nuevoNodo;
						esHijoDer=true;
						break;
					}
				}
			};
			// en caso de que se presente que el padre del nuevo nodo es rojo envia al metodo que soluciona esto
			if(nuevoNodo.padre.rojo) casoRojoRojo(nuevoNodo.padre,esHijoDer);
		}
	}

	// soluciona si al insertar se presenta un caso donde el nodo padre del nuevo nodo es rojo
	private void casoRojoRojo(NodoRojiNegro n, boolean hijoDer){
		NodoRojiNegro padreDePadre=n.padre;
		NodoRojiNegro hermanoDePadre;
		NodoRojiNegro temporal;
		if(padreDePadre.izquierdo!=null && padreDePadre.derecho!=null){
			// caso uno y dos: volver a colorear
			if(n==padreDePadre.izquierdo) hermanoDePadre=padreDePadre.derecho;
			else hermanoDePadre=padreDePadre.izquierdo;
			if(hermanoDePadre.rojo){
				hermanoDePadre.rojo=false; n.rojo=false;
				if(padreDePadre!=primerNodo) padreDePadre.rojo=true;
				if(padreDePadre.padre!=null){
					if(padreDePadre.padre.rojo) // revisar que no se haya creado un caso rojo-rojo hacia arriba
						casoRojoRojo(padreDePadre.padre,padreDePadre.padre.izquierdo!=padreDePadre);
				}
				return;
			}
		}
		if(!hijoDer && padreDePadre.izquierdo==n){
			// caso tres: reestructurar
			n.rojo=false; padreDePadre.rojo=true;
			temporal=n.derecho; n.derecho=padreDePadre; n.padre=padreDePadre.padre;
			padreDePadre.padre=n; padreDePadre.izquierdo=temporal;
			if(temporal!=null) temporal.padre=padreDePadre;
			if(n.padre!=null){
				temporal=n.padre;
				if(temporal.izquierdo==n.derecho) temporal.izquierdo=n;
				else temporal.derecho=n;
			}
			else primerNodo=n;
		}
		else if(hijoDer && padreDePadre.derecho==n){
			// caso cuatro: reestructurar
			n.rojo=false; padreDePadre.rojo=true;
			temporal=n.izquierdo; n.izquierdo=padreDePadre; n.padre=padreDePadre.padre;
			padreDePadre.padre=n; padreDePadre.derecho=temporal;
			if(temporal!=null) temporal.padre=padreDePadre;
			if(n.padre!=null){
				temporal=n.padre;
				if(temporal.izquierdo==n.izquierdo) temporal.izquierdo=n;
				else temporal.derecho=n;
			}
			else primerNodo=n;
		}
		else if(hijoDer && padreDePadre.izquierdo==n){
			// caso cinco: reestructurar
			hermanoDePadre=n.derecho; temporal=hermanoDePadre.izquierdo; padreDePadre.izquierdo=hermanoDePadre;
			hermanoDePadre.padre=padreDePadre; hermanoDePadre.izquierdo=n; n.padre=hermanoDePadre;
			n.derecho=temporal;
			if(temporal!=null) temporal.padre=n;
			// lleva al caso tres
			casoRojoRojo(hermanoDePadre,false);
		}
		else if(!hijoDer && padreDePadre.derecho==n){
			// caso seis: reestructurar
			hermanoDePadre=n.izquierdo; temporal=hermanoDePadre.derecho; padreDePadre.derecho=hermanoDePadre;
			hermanoDePadre.padre=padreDePadre; hermanoDePadre.derecho=n; n.padre=hermanoDePadre;
			n.izquierdo=temporal;
			if(temporal!=null) temporal.padre=n;
			// lleva al caso cuatro
			casoRojoRojo(hermanoDePadre,true);
		}
	}

	// metodo para buscar un nodo si no lo encuentra regresa null
	public NodoRojiNegro Buscar(int numero){
		NodoRojiNegro temporal=primerNodo;
		if(temporal==null) return null;
		do{
			if(numero==temporal.numero) return temporal;
			else if(numero<temporal.numero) temporal=temporal.izquierdo;
			else if(numero>temporal.numero) temporal=temporal.derecho;
		}while(temporal!=null);
		return null;
	}

	// calcula la el numero de nodos de profundidad del arbol para calcular el arrea que ocupara el grafico
	// segun el numero de nodos
	public int calculaProfundidad(NodoRojiNegro inicial){
		int profIzq=0;
		int profDer=0;
		if(inicial==null) return 0;
		if(inicial.izquierdo!=null)
			profIzq=calculaProfundidad(inicial.izquierdo);
		if(inicial.derecho!=null)
			profDer=calculaProfundidad(inicial.derecho);
		return (profIzq>profDer?profIzq:profDer)+1;
	}

	public void PreOrden() {
		PreOrdenAux(primerNodo);
	}
	private void PreOrdenAux(NodoRojiNegro nodo) {
		if (nodo!=null) {
			System.out.println(nodo.numero+ " color:" +nodo.rojo);
			PreOrdenAux(nodo.izquierdo);
			PreOrdenAux(nodo.derecho);
		}
	}


}
