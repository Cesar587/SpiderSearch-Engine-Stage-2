package SpiderBot;


import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import ArbolAVL.AVL;
import ArbolHeapSort.HeapSortMax;
import ArbolRojiNegro.RojiNegro;
import Parser.*;
import Xml.*;

public class SpiderBot {
	/*Estructuras jerarquicas: Arboles*/
	//Arbol Heap Sort Mayores
	HeapSortMax arbolheHeapSortMax=new HeapSortMax();
	//Arbol AVL
	AVL arbolAvl=new AVL();
	//Arbol Roji-Negro
	RojiNegro arbolRojiNegro=new RojiNegro();
	
	/*Configuracion del SpiderBot*/
	// maxthereads: cantidad de hilos
	int maxthereads;
	//recursivity: recursividad en la busqueda de carpetas
	int recursivity;
	//reindex: tiempo de chequeo de los hilos
	int reindex;
	
	/*Classes adicionales para las busquedas */
	//clase que parsea los documentos
	ParsearDocumento parsearURL=new ParsearDocumento();
	
	//crea xml
	CrearXmlURL urlconfig= new CrearXmlURL();
	CrearXmlConfiguracion xmlConfig =new CrearXmlConfiguracion();
	CrearXmlIndice indiceXML= new CrearXmlIndice();
	
	//lee xml
	LeerXmlconfiguracion config= new LeerXmlconfiguracion();
	LeerXmlURL dirUrl= new LeerXmlURL();
	
	
	ArrayList<String> direcciones=new ArrayList<String>();
	ArrayList<String> palabras=new ArrayList<String>();
	ArrayList<String> locales=new ArrayList<String>();
	
	
	public SpiderBot() {
		
	}
	/**
	 * 
	 */
	public synchronized void configurar(){
		xmlConfig.crear();
		maxthereads=config.leer().maxthereads;
		recursivity=config.leer().recursivity;
		reindex=config.leer().reindex;
		System.out.println("max: "+ maxthereads+" /rec: "+recursivity+" /rei: "+reindex);
	}
	
	/**
	 * 
	 */
	public synchronized void URLdirecciones(){
		urlconfig.crear();
		ArrayList<String> lista=dirUrl.leer();
		for (int i = 0; i < lista.size(); i++) {
			arbolheHeapSortMax.insertar(dirUrl.obtenerPeso(dirUrl.clasificar(lista.get(i))), lista.get(i));
		}
		direcciones=arbolheHeapSortMax.obtener();
		arbolheHeapSortMax.imprimir();
	}
	public synchronized void hilos(){
		ExecutorService workersHilos = Executors.newFixedThreadPool(maxthereads);
		buscar tarea;
		for (int i = 0; i < direcciones.size(); i++) {
			tarea=new buscar(direcciones.get(i));
			workersHilos.execute(tarea);
		}
		workersHilos.shutdown();
	}
	
	
	/**
	 * 
	 */
	public synchronized void generarIndice(){
		try {
			indiceXML.generate(direcciones, palabras, locales);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public synchronized void rojo(){
		
	}
	
	
	
	
	
	
	
	

}
