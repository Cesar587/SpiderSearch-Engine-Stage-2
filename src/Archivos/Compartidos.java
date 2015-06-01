package Archivos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import jcifs.smb.SmbFileOutputStream;

public class Compartidos {
	public String destino = "/home/steven/Escritorio/Nuevo";
	public String usuario;
	
	public String local(){
		String dir=null;
		File miDir = new File (".");
		try {
			dir=miDir.getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dir; 
	}
	
	public void copiarArchivoProtegido(String nombreUsuarioN, String contrasenaN, String dominioN, String origenN){

		usuario = nombreUsuarioN + ":" + contrasenaN;
		
		NtlmPasswordAuthentication seguridad = new NtlmPasswordAuthentication(usuario);
		
		try {
			SmbFile x =new SmbFile(origenN, seguridad);
			SmbFileOutputStream z = new SmbFileOutputStream(x);
			FileInputStream b= new  FileInputStream(new File(destino));
			byte [] archivo=new byte[16*1024*1024];
			int len;
			while ((len=b.read(archivo))>0){
				z.write(archivo,0,len);
			}
			b.close();
			z.close();

			 
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (SmbException e1) {
			e1.printStackTrace();
		}
		catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	public void copiarArchivo(String origenN){
		try {
			SmbFile x =new SmbFile(origenN);
			SmbFileOutputStream z = new SmbFileOutputStream(x);
			FileInputStream b= new  FileInputStream(new File(destino));
			byte [] archivo=new byte[16*1024*1024];
			int len;
			while ((len=b.read(archivo))>0){
				z.write(archivo,0,len);
			}
			System.out.println("fin");
			b.close();
			z.close();
		} 
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (SmbException e1) {
			e1.printStackTrace();
		}
		catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void copiarFicheroDesdeUnidad (SmbFile in, File out) 
	{
		SmbFileInputStream fis = null;
		FileOutputStream fos = null;

		try
		{
			fis = new SmbFileInputStream(in);
			fos = new FileOutputStream(out);
			byte[] buf = new byte[1024];

			int i = 0;
			while ((i=fis.read(buf)) != -1)
			{
				fos.write(buf, 0, i);
			}
		}
		catch (Exception e) {}
		finally
		{
			try
			{
				System.out.println("fin");
				fis.close();
				fos.close();
			}
			catch (Exception e) {};
		}
	}

	public void copiarFicheroAUnidad (File in, SmbFile out) 
	{
		FileInputStream fis = null;
		SmbFileOutputStream fos = null;

		try
		{
			fis = new FileInputStream(in);
			fos = new SmbFileOutputStream(out);
			byte[] buf = new byte[1024];

			int i = 0;
			while ((i=fis.read(buf)) != -1)
			{
				fos.write(buf, 0, i);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fis.close();
				fos.close();
			}
			catch (Exception e) {};
		}
	}
	 public void copia(String origenN){
		 File in =new File(destino);
		 try {
			SmbFile out=new SmbFile(origenN);
			//copiarFicheroAUnidad(in, out);
			copiarFicheroDesdeUnidad(out, in);
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		 
		 
		 
	 }

}
