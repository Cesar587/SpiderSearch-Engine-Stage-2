package ColaTrabajo;

import java.util.zip.Inflater;

public class Cola {
	Object[] ArregloCola;
	int inicio=0,fin=0,elementos,cantidad=100;
	
	public Cola(){
		ArregloCola= new Object[cantidad];
		inicio=0;
		fin=-1;
		elementos=0;
	}
	
	public synchronized void Encolar(Object tarea){
		if (fin==-1) {
			fin++;
			ArregloCola[fin]=tarea;
		} else {
			fin++;
			if (fin==cantidad) {
				System.out.println("LLeno");
			} else {
				ArregloCola[fin]=tarea;
			}
		}
	}
	
	public synchronized void Desencolar(){
		if (ColaVacia()) {
			System.out.println("Vacio");
		} else {
			for(int i=inicio;i<fin; i++){
				ArregloCola[i]=ArregloCola[i+1];
			}
			ArregloCola[fin]=null;
			
			fin--;

		}
	}
	public synchronized boolean ColaVacia(){
		return(fin<inicio);
	}
	
	public synchronized void Imprimir(){
		if (fin==-1) {
			System.out.println("Vacia");
		} 
		else {
			for (int i=inicio ; i <= fin; i++) {
				System.out.println(ArregloCola[i]);
			}
		}
	}
	 public synchronized void VaciarCola(){
		 if (fin == -1) {
			 System.out.println("Vacia");
		 } else {
			 for (int i = inicio; i <= fin; i++) {
				 ArregloCola[i]=null;
			 }
			 inicio=0;
			 fin=-1;
		 }
	 }

}
