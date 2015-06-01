package Interfacez;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Servidor.*;

public class InterfazServidor implements ActionListener{
	JFrame ventana;
	JLabel textoVentana;
	JButton botonVentana, boton2Ventana;
	ServidorPricipal servidor=new ServidorPricipal("hilo Servidor");
	boolean encendido= false;
	
	public void crearVentana(){
		ventana=new JFrame();
		ventana.setTitle("Servidor de busquedas");
		ventana.setLayout(new FlowLayout(FlowLayout.CENTER));
		ventana.setSize(300,90);
		ventana.setLocation(400, 300);
		
		textoVentana=new JLabel();
		textoVentana.setText("Precione iniciar para iniciar el servidor");
		
		botonVentana=new JButton();
		botonVentana.setText("Iniciar");
		botonVentana.addActionListener(this);
		
		boton2Ventana=new JButton();
		boton2Ventana.setText("Detener");
		boton2Ventana.addActionListener(this);
		
		ventana.add(textoVentana);
		ventana.add(botonVentana);
		ventana.add(boton2Ventana);
		
		ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}
	
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource()==botonVentana && encendido!=true) {
				//servidor.iniciar();
				servidor.start();
				encendido=true;
			}
			else if (e.getSource()==botonVentana && encendido==true) {
				servidor.resume();
			}
			else if (e.getSource()==boton2Ventana) {
				//servidor.interrupt();
				servidor.suspend();
				//servidor.stop();
			}
		} catch (Exception e2) {
			servidor.interrupt();
		}
		
	}
	
	public InterfazServidor(){
		crearVentana();
	}
	
	

}
