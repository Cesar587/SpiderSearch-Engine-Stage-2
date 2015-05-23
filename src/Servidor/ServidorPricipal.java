package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServidorPricipal extends Thread{

	final int PUERTO=5000;
	ServerSocket servidor;
	Socket cliente;
	DataOutputStream salida;
	String mensajeRecibido;
	DataInputStream entrada;
	Boolean encendido=true;
	
	public ServidorPricipal(String msg){
		super(msg);
		
	}
	
	public void detener(){
		encendido= false;
	}
	
	public void run(){
		try{
			servidor=new ServerSocket(PUERTO);
			cliente=new Socket();
			System.out.println("Esperando una conexión:");
			while (encendido) {
				
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
			System.out.println("Servidor apagado");
			servidor.close();
		}
		catch(Exception e ){
			System.out.println("Error: "+e.getMessage());
		}

	}
}
