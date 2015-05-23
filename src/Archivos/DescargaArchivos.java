package Archivos;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DescargaArchivos {
	String dirString;
	
	
	 public void descargarAux(String direccion, String nombre){
		 try {
	            // Url con la foto
	            URL url = new URL(direccion);
	 
	            // establecemos conexion
	            URLConnection urlCon = url.openConnection();
	 
	            // Sacamos por pantalla el tipo de fichero
	            System.out.println(urlCon.getContentType());
	 
	            // Se obtiene el inputStream de la foto web y se abre el fichero
	            // local.
	            InputStream is = urlCon.getInputStream();
	            FileOutputStream fos = new FileOutputStream(nombre);
	 
	            // Lectura de la foto de la web y escritura en fichero local
	            byte[] array = new byte[1000]; // buffer temporal de lectura.
	            int leido = is.read(array);
	            while (leido > 0) {
	                fos.write(array, 0, leido);
	                leido = is.read(array);
	            }
	 
	            // cierre de conexion y fichero.
	            System.out.println("fin");
	            is.close();
	            fos.close();
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 }
	 public void descargar(String dir){
		 File direccion= new File(dir);
		 File miDir = new File (".");
		 try {
			dirString=miDir.getCanonicalPath()+"/"+direccion.getName();
			descargarAux(dir, dirString);
			System.out.println(dirString);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	 }
	 
	 
	 

}
