package ClientServer;

import java.net.*;
import java.io.*;
/**
 * 
 * @author steven
 *
 */
public class Server {

	final int PUERTO=5000;
	ServerSocket miServico;
	Socket socketServico;
	//DataInputStream entrada;
	//PrintStream mensaje;
	DataOutputStream salida;
	String mensajeRecibido;
	BufferedReader entrada;

	//SERVIDOR
	/**
	 * 
	 */
	public void initServer(){
		
		try{
			miServico=new ServerSocket(PUERTO);//crea socket servidor que escuchara en puerto 5000*/
			socketServico=new Socket();
			System.out.println("Esperando una conexión:");
			socketServico = miServico.accept();
			
			
			
			//entrada=new DataInputStream(socketServico.getInputStream());
			//mensaje=new PrintStream(socketServico.getOutputStream());
			
			
			//Inicia el socket, ahora esta esperando una conexión por parte del cliente
			
			System.out.println("Un cliente se ha conectado.");
			
			//Canales de entrada y salida de datos
			
			entrada = new BufferedReader(new InputStreamReader(socketServico.getInputStream()));
			salida= new DataOutputStream(socketServico.getOutputStream());
			System.out.println("Confirmando conexion al cliente....");
			salida.writeUTF("Conexión exitosa...n envia un mensaje :D");
			
			//Recepcion de mensaje
			
			mensajeRecibido = entrada.readLine();
			System.out.println(mensajeRecibido);
			salida.writeUTF("Se recibio tu mensaje.n Terminando conexion...");
			salida.writeUTF("Gracias por conectarte, adios!");
			System.out.println("Cerrando conexión...");
			miServico.close();//Aqui se cierra la conexión con el cliente
			
			//entrada.close();
			//salida.close();
			//mensaje.close();
			
			//socketServico.close();
			
			}
		
		catch(Exception e ){
			System.out.println("Error: "+e.getMessage());
			}
	}
}
