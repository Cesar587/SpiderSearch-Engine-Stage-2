package Archivos;

import java.io.File;
/**
 * 
 * @author steven
 *
 */
public class Local {
	int cuentaPdf;
	int cuentaDoc;
	int cuentaDocx;
	int cuentaTxt;
	int cuentaOdt;
	int cuentaArchivos;
	
	
	
	/**
	 * 
	 */
	public Local(){
		
	}
	
	public void comprobarDir(String dir){
		comprobarDirAUX(new File(dir));
	}
	
	private void comprobarDirAUX(File dir){
		if (dir.getPath().startsWith("http")) {
			
			System.out.println("web");
		}
		else if (dir.getPath().startsWith("/")) {
			System.out.println("local");
		}
		else if (dir.getPath().startsWith("\\")) {
			System.out.println("compartido");
		}
		else {
			System.out.println(dir.getPath());
			System.out.println("error");
		}
	}
	/**
	 * 
	 * @param dir
	 */
	public void buscarCarpetas(String dir){
		 buscarCarpetasAux(new File(dir));
	}
	/**
	 * 
	 * @param dir
	 */
	private void buscarCarpetasAux(File dir){
		if (dir.exists()){
		 File listFile[] = dir.listFiles();
	        if (listFile.length != 0) {
	            for (int i = 0; i < listFile.length;) {
	            	if (listFile[i].getName().endsWith(".pdf")) {
	            		System.out.println(listFile[i].getName());
	            		cuentaPdf++;
	            		i++;
					}
	            	else if (listFile[i].getName().endsWith(".docx")) {
	            		System.out.println(listFile[i].getName());
	            		i++;
					}
	            	else if (listFile[i].getName().endsWith(".doc")) {
	            		System.out.println(listFile[i].getName());
	            		i++;
					}
	            	else if (listFile[i].getName().endsWith(".txt")) {
	            		System.out.println(listFile[i].getName());
	            		i++;
					}
	            	else if (listFile[i].getName().endsWith(".odt")) {
	            		System.out.println(listFile[i].getName());
	            		i++;
					}
	            	else {
						i++;
					}
	            }
	            System.out.println(cuentaPdf);
	            
	        }
	        else {
	        	 System.out.println("vacia");
			}
	        
		}
		else {
			
			 System.out.println( dir.exists());
		}
	}
	
	/**
	 * 
	 * @param dir
	 */
	public void buscarsubcarpeta(String dir){
		buscarCarpeta(new File(dir));
		
	}
	
	/**
	 * 
	 * @param dir
	 */
	private void buscarCarpeta(File dir){
		 File listFile[] = dir.listFiles();
	        if (listFile != null) {
	            for (int i = 0; i < listFile.length;) {
	                if (listFile[i].isDirectory()) {
	                    buscarCarpeta(listFile[i]);
	                    i++;
	                }
	                else if (listFile[i].getName().endsWith(".pdf")) {
	                	System.out.println(listFile[i].getPath());
	                	cuentaPdf++;
	                	cuentaArchivos++;
	            		i++;
					} 
	                else if (listFile[i].getName().endsWith(".docx")) {
	            		System.out.println(listFile[i].getName());
	            		cuentaDocx++;
	            		cuentaArchivos++;
	            		i++;
					}
	            	else if (listFile[i].getName().endsWith(".doc")) {
	            		System.out.println(listFile[i].getName());
	            		cuentaDoc++;
	            		cuentaArchivos++;
	            		i++;
					}
	            	else if (listFile[i].getName().endsWith(".txt")) {
	            		System.out.println(listFile[i].getName());
	            		cuentaTxt++;
	            		cuentaArchivos++;
	            		i++;
					}
	            	else if (listFile[i].getName().endsWith(".odt")) {
	            		System.out.println(listFile[i].getName());
	            		cuentaOdt++;
	            		cuentaArchivos++;
	            		i++;
					}
	                else {
	                	//System.out.println(listFile[i].getName());
	                	i++;
	                	}
	           }
	       
	        }
	       
    }
	
	public void cantidadPdf(){
		System.out.println("Pdf Cantidad: "+cuentaPdf);
	}
	public void cantidadDoc(){
		System.out.println("Doc Cantidad: "+cuentaDoc);
	}
	public void cantidadDocx(){
		System.out.println("Docx Cantidad: "+cuentaDocx);
	}
	public void cantidadTxt(){
		System.out.println("Txt Cantidad: "+cuentaTxt);
	}
	public void cantidadOdt(){
		System.out.println("Odt Cantidad: "+cuentaOdt);
	}
	public void cantidadArchivos(){
		System.out.println("Total Cantidad: "+cuentaArchivos);
	}

}
