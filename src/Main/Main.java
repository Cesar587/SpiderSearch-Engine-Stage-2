package Main;

import ArbolAVL.*;
import ArbolBST.*;
import ArbolHeapSort.*;
import ArbolRojiNegro.*;
import ArbolSplay.*;
import Archivos.*;
import ColaTrabajo.*;
import Parser.*;
import Servidor.*;
import SpiderBot.*;
import Xml.*;
import Interfacez.*;
public class Main {

	public static void main(String[] args) {
		
		SpiderBot spi=new SpiderBot();
		spi.configurar();
		spi.URLdirecciones();
		spi.hilos();
		
		
	}

}
