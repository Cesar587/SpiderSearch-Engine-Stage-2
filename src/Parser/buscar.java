package Parser;

import java.util.ArrayList;

import Xml.CrearXmlSubIndice;

public class buscar implements Runnable{
	
	ParsearDocumento parsearURL=new ParsearDocumento();
	String doc;
	ArrayList<String> busqueda=new ArrayList<String>();
	ArrayList<String> repetidas=new ArrayList<String>();
	CrearXmlSubIndice subIndiceXML=new CrearXmlSubIndice();
	
	public buscar(String documento){
		this.doc=documento;
	}
	public synchronized void buscar(){
		parsearURL.parsear(doc);
		int repeticiones=0;
		busqueda=parsearURL.obtenerParseado();
		ArrayList<String> resultados= parsearURL.obtenerTodo();
		for (int i = 0; i < busqueda.size(); i++) {
			
			for (int j = 0; j < resultados.size(); j++) {
				
				if (busqueda.get(i).equalsIgnoreCase(resultados.get(j))) {
					repeticiones++;
				}
			}
			if (repeticiones!=0) {
				repetidas.add(Integer.toString(repeticiones));
				//System.out.println(repeticiones);
				//arbolAvl.Insertar(repeticiones, busqueda.get(i));
			}
			repeticiones=0;
			
			
		}
		//arbolAvl.recorridoEnOrdenAVL();
	}
	public synchronized void generarSubIndice(){
		try {
			subIndiceXML.generate(doc,busqueda, repetidas);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clasificar(){
		
	}

	
	public void run() {
		buscar();
		generarSubIndice();
	}
	
}
