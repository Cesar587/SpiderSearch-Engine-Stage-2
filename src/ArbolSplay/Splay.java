package ArbolSplay;

public class Splay {
	public int cont;
	public String codigot;
	public NodoSplay raiz;
	public NodoSplay auxp;
	public NodoSplay auxh;
	public boolean bandera = true;

	public NodoSplay Insertar (int llaveN,String datoN){
		if (raiz == null)
			raiz = new NodoSplay (llaveN, datoN);
		else{
			auxp = null;
			auxh = raiz;
			while (auxh != null){
				if (llaveN <= auxh.llave){
					auxp = auxh;
					auxh = auxh.hijoIzquiero;
				}
				else{
					auxp = auxh;
					auxh = auxh.hijoDerecho;
				}
			}
			NodoSplay nuevo = new NodoSplay (llaveN, datoN);
			if (auxp.llave < llaveN){
				auxp.hijoDerecho = nuevo;
				Subir (auxp, nuevo);
			}
			else{
				auxp.hijoIzquiero = nuevo;
				Subir (auxp, nuevo);
			}
		}
		return raiz;
	}

	//Contructor
	public Splay(){
		raiz = null;
	}

	//rotacion zag zag
	public void zagzag(NodoSplay abuelo){
		if(cont<2){
			cont++;
			NodoSplay nuevo = new NodoSplay(abuelo.llave,abuelo.dato);
			nuevo.hijoIzquiero = abuelo.hijoIzquiero;
			nuevo.hijoDerecho = abuelo.hijoDerecho;
			nuevo.hijoDerecho = auxp.hijoIzquiero;
			abuelo.hijoIzquiero = nuevo;
			abuelo.hijoDerecho = auxp.hijoDerecho;
			abuelo.llave = auxp.llave;
			abuelo.dato=auxp.dato;
			if (abuelo == raiz)
				bandera = false;
			auxp = abuelo;
		}
		else{
			cont=0;
		}	
	}

	//rotacion zag zig
	public void zagzig(NodoSplay abuelo){
		cont=0;
		NodoSplay nuevo = new NodoSplay (abuelo.llave, abuelo.dato);
		nuevo.hijoIzquiero = abuelo.hijoIzquiero;
		nuevo.hijoDerecho = abuelo.hijoDerecho;
		abuelo.llave = auxh.llave;
		abuelo.dato=auxh.dato;
		nuevo.hijoDerecho = auxh.hijoIzquiero;
		abuelo.hijoIzquiero= nuevo;
		auxp.hijoIzquiero = auxh.hijoDerecho;
		abuelo.hijoDerecho = auxp;
		if (abuelo == raiz){
			raiz = abuelo;
			bandera = false;
		}
		auxh = abuelo;
		auxp = TieneAbuelo (auxh);
	}

	//rotacion zig zig
	public void zigzig(NodoSplay abuelo){
		if(cont<2){
			cont++;
			NodoSplay nuevo = new NodoSplay (abuelo.llave, abuelo.dato);
			nuevo.hijoIzquiero = abuelo.hijoDerecho;
			nuevo.hijoDerecho = abuelo.hijoDerecho;
			nuevo.hijoIzquiero = auxp.hijoDerecho;
			abuelo.hijoDerecho = nuevo;
			abuelo.hijoIzquiero = auxp.hijoIzquiero;
			abuelo.llave = auxp.llave;
			abuelo.dato=auxp.dato;
			if (abuelo == raiz)
				bandera = false;
			auxp = abuelo;
		}
		else{
			cont=0;
		}	
	}

	//rotacion zig zag
	public void zigzag(NodoSplay abuelo){
		cont=0;
		NodoSplay nuevo = new NodoSplay (abuelo.llave, abuelo.dato);
		nuevo.hijoIzquiero = abuelo.hijoIzquiero;
		nuevo.hijoDerecho = abuelo.hijoDerecho;
		abuelo.llave = auxh.llave;
		abuelo.dato=auxh.dato;
		nuevo.hijoIzquiero = auxh.hijoDerecho;
		abuelo.hijoDerecho = nuevo;
		auxp.hijoDerecho = auxh.hijoIzquiero;
		abuelo.hijoIzquiero = auxp;
		if (abuelo == raiz){
			raiz = abuelo;
			bandera = false;
		}
		auxh = abuelo;
		auxp = TieneAbuelo (auxh);
	}

	//rotacion zig
	public void zig(){
		raiz.hijoIzquiero = auxh.hijoDerecho;
		auxh.hijoDerecho = raiz;
		raiz = auxh;
		cont=0;
	}

	//rotacion zag
	public void zag(){
		raiz.hijoDerecho = auxh.hijoIzquiero;
		auxh.hijoIzquiero = raiz;
		raiz = auxh;
		cont=0;
	}

	//sube el recien insertado a la raiz
	public void Subir (NodoSplay padre, NodoSplay hijo){
		bandera=true;
		auxp=padre;
		auxh=hijo;
		while ((bandera == true) && (TieneAbuelo (auxp) != null)){
			NodoSplay abuelo = TieneAbuelo (auxp);
			//zag zag
			if ((abuelo.hijoDerecho == auxp) && (auxp.hijoDerecho == auxh)){
				zagzag(abuelo);
			}
			else{
				//zag zig
				if ((abuelo.hijoDerecho == auxp) && (auxp.hijoIzquiero == auxh)){
					zagzig(abuelo);
				}
				else{
					//zig zig
					if ((abuelo.hijoIzquiero == auxp) && (auxp.hijoIzquiero == auxh)){
						zigzig(abuelo);
					}
					//zig zag
					else{
						zigzag(abuelo);
					}
				}
			}
		}
		if (auxh != raiz){
			//zag
			if (raiz.hijoDerecho == auxh){
				zag();
			}
			//zig
			else{
				zig();
			}
		}
	}

	//retorna el abuelo de un nieto  
	public NodoSplay TieneAbuelo (NodoSplay nodo){
		if (nodo == raiz)
			return null;
		else{
			NodoSplay padre=null;
			NodoSplay hijo = raiz;
			while (hijo != nodo){
				if (nodo.llave <= hijo.llave){
					padre = hijo;
					hijo = hijo.hijoIzquiero;
				}
				else{
					padre = hijo;
					hijo = hijo.hijoDerecho;
				}
			}
			return padre;
		}
	}

	//imprime en inorden el arbol splay
	public void Inorden (NodoSplay root){
		if(root==null)
			return;
		else{
			Inorden (root.hijoIzquiero);
			System.out.println (root.llave + " ");
			Inorden (root.hijoDerecho);
		}
	}
	
	public void Preorden (NodoSplay root){
		if(root==null)
			return;
		else{
			System.out.println (root.llave + " ");
			Preorden (root.hijoIzquiero);
			Preorden (root.hijoDerecho);
		}
	}

	//elimina un elemento de un arbol splay y coloca su antecesor
	//en la raiz	
	public NodoSplay Eliminar (int llaveN){
		if (llaveN == raiz.llave){
			NodoSplay borrado = raiz;
			if ((raiz.hijoIzquiero == null) && (raiz.hijoDerecho == null)){
				raiz = null;
				return borrado;
			}
			else{
				if ((raiz.hijoIzquiero != null) && (raiz.hijoDerecho != null)){
					NodoSplay aux = raiz;
					raiz = MayordeMenores (raiz);
					raiz.hijoIzquiero = aux.hijoIzquiero;
					raiz.hijoDerecho = aux.hijoDerecho;
					return borrado;
				}
				else{
					if (raiz.hijoDerecho != null){
						raiz = raiz.hijoDerecho;
						return borrado;
					}
					else{
						raiz = raiz.hijoIzquiero;
						return borrado;
					}
				}
			}
		}
		else{
			NodoSplay padre = null;
			NodoSplay hijo = raiz;
			while (hijo.llave != llaveN){
				if (llaveN <= hijo.llave){
					padre = hijo;
					hijo = hijo.hijoIzquiero;
				}
				else{
					padre = hijo;
					hijo = hijo.hijoDerecho;
				}
			}
			Subir (padre, hijo);
			NodoSplay rai = raiz;
			Eliminar (raiz.llave);
			return rai;
		}
	}

	//buscar el mayor de los menores
	public NodoSplay MayordeMenores (NodoSplay nodo){
		NodoSplay padre = nodo;
		NodoSplay aux = nodo.hijoIzquiero;
		while (aux.hijoDerecho != null){
			padre = aux;
			aux = aux.hijoDerecho;
		}
		padre.hijoDerecho = aux.hijoIzquiero;
		return aux;
	}

	//buscar un elemento y lo sube a la raiz
	public NodoSplay Buscar (int llaveN){
		if (llaveN == raiz.llave){
			return raiz;
		}
		else{
			NodoSplay padre = null;
			NodoSplay hijo = raiz;
			while ((hijo != null) && (hijo.llave != llaveN)){
				if (llaveN <= hijo.llave){
					padre = hijo;
					hijo = hijo.hijoIzquiero;
				}
				else{
					padre = hijo;
					hijo = hijo.hijoDerecho;
				}
			}
			if (hijo == null){
				NodoSplay aux = TieneAbuelo (padre);
				if (padre != raiz)
					Subir (aux, padre);
				return null;
			}
			else{
				Subir (padre, hijo);
				return raiz;
			}
		}
	}

	//retorna si es miembro un elemento
	public boolean Miembro (int llaveN){
		NodoSplay hijo = raiz;
		while ((hijo != null) && (hijo.llave != llaveN)){
			if (llaveN <= hijo.llave){
				hijo = hijo.hijoIzquiero;
			}
			else{
				hijo = hijo.hijoDerecho;
			}
		}
		if (hijo == null)
			return false;
		else
			return true;
	}
}

