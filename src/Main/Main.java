package Main;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.zip.Inflater;

import ArbolAVL.AVL;
import ArbolBST.BST;
import ArbolSplay.Splay;
import Archivos.*;
import Parser.*;
import Servidor.*;
import Xml.*;
import Interfacez.InterfazServidor;
public class Main {

	public static void main(String[] args) {
		
		/*Splay arbol =new Splay();
		arbol.insertar(6, "casa");
		arbol.insertar(9, "casa");
		arbol.insertar(8, "casa");
		arbol.insertar(14, "casa");
		arbol.insertar(3, "casa");
		arbol.insertar(4, "casa");
		arbol.insertar(1, "casa");
		arbol.insertar(15, "casa");
		
		System.out.println("raiz: "+arbol.raiz.hijoDerecho.llave+" "+arbol.raiz.hijoDerecho.dato);*/
		//arbol.Preorden(arbol.raiz);
		//arbol.Inorden(arbol.raiz);
		
		//BST arbol=new BST();
		AVL arbol =new AVL();
		arbol.insertar(6, "casa");
		arbol.insertar(9, "casa");
		arbol.insertar(8, "casa");
		arbol.insertar(14, "casa");
		arbol.insertar(3, "casa");
		arbol.insertar(4, "casa");
		arbol.insertar(1, "casa");
		arbol.insertar(15, "casa");
		//arbol.recorridoEnOrden();//Inorden(arbol.raiz);
		//arbol.recorridoEnOrdenAVL();
		arbol.recorridoEnPreOrdenAVL();
		
		
		//http://cvb.ehu.es/open_course_ware/castellano/tecnicas/fundamen_mate/contenidos/teoria/documentos-pdf/
		
		
		
		/*
		InterfazServidor servidor=new InterfazServidor();
		ParsearDocumento doc=new ParsearDocumento();
		doc.TikaParser("/home/steven/Escritorio/Bitacora.pdf");
		doc.obtenerParseo();
		ParsearBusqueda buscar= new ParsearBusqueda();
		buscar.obtenerParseo(doc.obtenerParseo().toString());
		buscar.imprimir();*/
		
		/*int cantidad=0;
		String busca;
		String busca2;
		String sTexto = "En,un*lugar/de_la-mancha+po//lop:lui,un,en,de,la";*/
		//StringTokenizer palabras = new StringTokenizer(sTexto,",*/_-+//:");
		//StringTokenizer bpalabras;
		//bpalabras=palabras;
		//System.out.println ( st );
		//System.out.println ( st.countTokens() );
		/*try {
			while (palabras.hasMoreTokens()){
		    	cantidad=0;
		    	busca=palabras.nextToken();
		    	while (bpalabras.hasMoreTokens()) {
		    		busca2=bpalabras.nextToken();
					if(busca.equalsIgnoreCase(busca2)){
						cantidad++;
					}
				}
		        System.out.println (palabras.nextToken()+" : "+cantidad);
		    }
		} catch (Exception e) {
			System.out.println(e);
		}*/
	    
		
	   /* String[] palabras = sTexto.split( "[- + _ , * // :]");
	    String[] otro= palabras;
	    for(int i = 0;i<palabras.length;i++){ 
	    	cantidad=0;
	    	for(int f = 0;f<otro.length;){ 
	    		if (palabras[i].equalsIgnoreCase(otro[f])) {
	    			cantidad++;
	    			f++;
	    		}
	    		else {
	    			f++;
	    		}
	    	}
	    	System.out.println(palabras[i]+" : "+ cantidad);
	    }*/
		
		
		
		//DescargaArchivos docArchivos=new DescargaArchivos();
		//docArchivos.descargar("https://aulapt.files.wordpress.com/2008/02/lecturas-animales.pdf");
		//docArchivos.tipo("http://www.ceiploreto.es/sugerencias/Comprension_lectora/mis_lecturas_ciclo2.pdf");
		//docArchivos.descargarAux("http://www.ceiploreto.es/sugerencias/Comprension_lectora/mis_lecturas_ciclo2.pdf","/home/steven/Escritorio/mis_lecturas_ciclo2.pdf" );
		
		//http://www.adaptacionescurriculares.com/matlecto2.pdf
		//https://aulapt.files.wordpress.com/2008/02/lecturas-animales.pdf
		//http://spanish4teachers.org/files/Spanish_Reading_Comprehension___lectura_comprensiva.pdf
		
		
		/*ParsearDocumento documento=new ParsearDocumento();
		documento.TikaParser("/home/steven/Escritorio/Documentacion.docx");
		//System.out.print(documento.GetHandler());
	
		String cadena = documento.GetHandler().toString();
	    String delimitadores= "[\n \t    : ( ) / * - { } + = # . , % _ ; ? ! ¡ ¿ \'\"\\[\\]]+";
	    String[] palabrasSeparadas = cadena.split(delimitadores);
	    
	    for(int i = 0;i<palabrasSeparadas.length;i++){ 
	    	System.out.println(palabrasSeparadas[i]);
		
	    }*/
	}

}
