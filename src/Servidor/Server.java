package Servidor;

import java.net.*;
import java.io.*;
/**
 * 
 * @author steven
 *
 */
public class Server implements Runnable {

	final int PUERTO=5000;
	ServerSocket servidor;
	Socket cliente;
	DataOutputStream salida;
	String mensajeRecibido;
	DataInputStream entrada;
	Boolean encendido=true;
	

	//SERVIDOR
	
	public void run() {
		try{
			servidor=new ServerSocket(PUERTO);
			cliente=new Socket();
			System.out.println("Esperando una conexión:");
			while (true) {
				if (encendido==true) {
					cliente = servidor.accept();

					//Inicia el socket, ahora esta esperando una conexión por parte del cliente

					System.out.println("Un cliente se ha conectado.");

					//Canales de entrada y salida de datos

					entrada = new DataInputStream(cliente.getInputStream());

					mensajeRecibido = entrada.readUTF();
					System.out.println(mensajeRecibido);
					cliente.close();
					if (mensajeRecibido.equalsIgnoreCase("FinServidor")) {
						System.out.println("Servidor apagado");
						servidor.close();
						break;
					}
				}
				else {
					System.out.println("Servidor apagado");
					servidor.close();
					break;
				}
				
			}
			//System.out.println("Servidor apagado");

			
	
			
		}
		
		catch(Exception e ){
			System.out.println("Error: "+e.getMessage());
			}
		
	}
	public Server() {
		
	}
	public void iniciar(){
		Thread hiloservidorThread=new Thread();
		hiloservidorThread.start();
	}

	public void apagar(){
		encendido=false;
	}
	
	
	
	
	
	
}
