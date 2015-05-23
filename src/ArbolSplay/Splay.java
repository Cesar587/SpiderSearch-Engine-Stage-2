package ArbolSplay;

public class Splay {
	
	public int cont;
	public String codigot;
	public NodoSplay raiz;
	public NodoSplay auxiliarPadre;
	public NodoSplay auxiliarHijo;
	public boolean bandera = true;
	public int largo; {
		
	}
	
	public Splay(){
		raiz=null;

	}

	/**
	 * 
	 * @param llaveN
	 * @param datoN
	 * @return
	 */
	public void insertar(int llaveN , String datoN){
		NodoSplay nuevo = new NodoSplay (llaveN,datoN);
		if (raiz == null){
			raiz = nuevo;
		}
		else{
			auxiliarPadre = null;
			auxiliarHijo = raiz;
			while (auxiliarHijo != null){
				if (nuevo.llave <= auxiliarHijo.llave){
					auxiliarPadre = auxiliarHijo;
					auxiliarHijo = auxiliarHijo.hijoIzquiero;
				}
				else{
					auxiliarPadre = auxiliarHijo;
					auxiliarHijo = auxiliarHijo.hijoDerecho;
				}
			}
			
			if (auxiliarPadre.llave < nuevo.llave){
				auxiliarPadre.hijoDerecho = nuevo;
				largo++;
				Subir (auxiliarPadre, nuevo);
			}
			else{
				auxiliarPadre.hijoIzquiero = nuevo;
				largo++;
				Subir (auxiliarPadre, nuevo);
			}
		}
	}
	
	
	//rotacion zag zig
	/**
	 * 
	 * @param abuelo
	 */
	public void zagzig(NodoSplay abuelo){
		if(cont==1 || cont ==2){
			cont=0;
			NodoSplay nuevo = new NodoSplay (abuelo.llave, abuelo.dato);
			nuevo.hijoIzquiero = abuelo.hijoIzquiero;
			nuevo.hijoDerecho = abuelo.hijoDerecho;
			abuelo.llave = auxiliarHijo.llave;
			abuelo.dato=auxiliarHijo.dato;
			nuevo.hijoDerecho = auxiliarHijo.hijoIzquiero;
			abuelo.hijoIzquiero = nuevo;
			auxiliarPadre.hijoIzquiero = auxiliarHijo.hijoDerecho;
			abuelo.hijoDerecho = auxiliarPadre;
		}
		if (abuelo == raiz){
			raiz = abuelo;
			bandera = false;
		}
		auxiliarHijo = abuelo;
		auxiliarPadre = TieneAbuelo (auxiliarHijo);
	}
	
	//rotacion zig zag
	public void zigzag(NodoSplay abuelo){
		if(cont==1 || cont ==2){
			cont=0;
			NodoSplay nuevo = new NodoSplay (abuelo.llave, abuelo.dato);
			nuevo.hijoIzquiero = abuelo.hijoIzquiero;
			nuevo.hijoDerecho = abuelo.hijoDerecho;
			abuelo.llave = auxiliarHijo.llave;
			abuelo.dato=auxiliarHijo.dato;
			nuevo.hijoIzquiero = auxiliarHijo.hijoDerecho;
			abuelo.hijoDerecho = nuevo;
			auxiliarPadre.hijoDerecho = auxiliarHijo.hijoIzquiero;
			abuelo.hijoIzquiero = auxiliarPadre;
		}
		if (abuelo == raiz){
			raiz = abuelo;
			bandera = false;
		}
		auxiliarHijo = abuelo;
		auxiliarPadre = TieneAbuelo (auxiliarHijo);

	}

	//rotacion zig zig
	/**
	 * 
	 * @param abuelo
	 */
	public void zigzig(NodoSplay abuelo){

		if(cont<2){
			cont++;
			NodoSplay nuevo = new NodoSplay (abuelo.llave, abuelo.dato);
			nuevo.hijoIzquiero = abuelo.hijoIzquiero;
			nuevo.hijoDerecho = abuelo.hijoDerecho;
			nuevo.hijoIzquiero = auxiliarPadre.hijoDerecho;
			abuelo.hijoDerecho = nuevo;
			abuelo.hijoIzquiero = auxiliarPadre.hijoIzquiero;
			abuelo.llave = auxiliarPadre.llave;
			abuelo.dato=auxiliarPadre.dato;
			if (abuelo == raiz){
				bandera = false;
				auxiliarPadre = abuelo;
			}
		}
		else{

			cont=0;
		}	
			
	}
	//rotacion zag zag
	/**
	 * 
	 * @param abuelo
	 */
	public void rotacionZagZag(NodoSplay abuelo){
		if(cont<2){
			cont++;
			NodoSplay nuevo = new NodoSplay (abuelo.llave, abuelo.dato);
			nuevo.hijoIzquiero = abuelo.hijoIzquiero;
			nuevo.hijoDerecho = abuelo.hijoDerecho;
			nuevo.hijoDerecho = auxiliarPadre.hijoIzquiero;
			abuelo.hijoIzquiero = nuevo;
			abuelo.hijoDerecho = auxiliarPadre.hijoDerecho;
			abuelo.llave = auxiliarPadre.llave;
			abuelo.dato=auxiliarPadre.dato;
			if (abuelo == raiz){
				bandera = false;
				auxiliarPadre = abuelo;
			}
		}
		else{
			cont=0;
		}	
	}
	//rotacion zig
	public void zig(){
		if(cont==2){
			raiz.hijoIzquiero = auxiliarHijo;
			auxiliarHijo.hijoDerecho = raiz;
			raiz = auxiliarHijo;
			cont=0;
		}
	}
	//rotacion zag
	public void zag(){
		if(cont==2){
			raiz.hijoDerecho = auxiliarHijo;
			auxiliarHijo.hijoIzquiero = raiz;
			raiz = auxiliarHijo;
			cont=0;
		}
	}

	//sube el recien insertado a la raiz
	public void Subir (NodoSplay padre, NodoSplay hijo){
		bandera=true;
		auxiliarPadre=padre;
		auxiliarHijo=hijo;
		while ((bandera == true) && (TieneAbuelo (auxiliarPadre) != null)){
			NodoSplay abuelo = TieneAbuelo (auxiliarPadre);
			//zag zag
			if ((abuelo.hijoDerecho == auxiliarPadre) && (auxiliarPadre.hijoDerecho == auxiliarHijo)){
				rotacionZagZag(abuelo);
			}
			else{
				//zag zig
				if ((abuelo.hijoDerecho == auxiliarPadre) && (auxiliarPadre.hijoIzquiero == auxiliarHijo)){
					zagzig(abuelo);
				}
				else{
					//zig zig
					if ((abuelo.hijoIzquiero == auxiliarPadre) && (auxiliarPadre.hijoIzquiero == auxiliarHijo)){
						zigzig(abuelo);
					}
					//zig zag
					else{
						zigzag(abuelo);
					}
				}
			}
		}
		if (auxiliarHijo != raiz){
			//zag
			if (raiz.hijoDerecho == auxiliarHijo){
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
			NodoSplay abuelo = null;
			NodoSplay padre = null;
			NodoSplay hijo = raiz;
			while (hijo != nodo){
				if (nodo.llave <= hijo.llave){
					abuelo=padre;
					padre = hijo;
					hijo = hijo.hijoIzquiero;
				}
				else{
					abuelo=padre;
					padre = hijo;
					hijo = hijo.hijoDerecho;
				}
			}
			return abuelo;
		}
	}

	//imprime en inorden el arbol splay
	public void Inorden (NodoSplay root){
		if(root==null)
			return;
		else{
			Inorden (root.hijoIzquiero);
			System.out.println (root.llave + " "+root.dato);
			Inorden (root.hijoDerecho);
		}
	}

	public void Preorden (NodoSplay root){
		if(root==null)
			return;
		else{
			System.out.println (root.llave + " "+root.dato);
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
			}
			else{
				Subir (padre, hijo);
			}
		}
		return raiz;
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
	
	
	



