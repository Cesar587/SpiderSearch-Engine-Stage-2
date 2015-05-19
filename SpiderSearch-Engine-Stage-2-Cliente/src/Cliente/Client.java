package Cliente;

import java.net.*;
import java.io.*;

public class Client {
	
	final String HOST = "localhost";
	final int PUERTO=5000;
	Socket miCliente= new Socket();
	DataOutputStream mensaje;
	DataInputStream entrada;

	//Cliente


	public void intClient(){ /*ejecuta este metodo para correr el cliente */

		try{

			miCliente. = new Socket( HOST , PUERTO );/*conectar a un servidor en localhost con puerto 5000*/
			

			//cerramos la conexión
			miCliente.close();
			
			
		}
		catch(Exception e ){
			System.out.println("Error: "+e.getMessage());
		}

	}
	public void enviarMensaje(String dato){
		//creamos el flujo de datos por el que se enviara un mensaje
		try {
			mensaje= new DataOutputStream(miCliente.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//enviamos el mensaje
		try {
			mensaje.writeUTF(dato);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

