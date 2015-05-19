package Interfacez;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InterfazCliente implements ActionListener{
	JFrame ventana,ventana2,ventana3;
	JLabel textoVentana,textoVentana2,textoVentana3;
	JButton botonVentana,botonVentana2;
	JTextField entradaTextoVentana2;
	JList<String> lista; 
	String[] resultados = {"jahbd","sjdhb","hjdbvg"};
	
	public void crearVentana(){
		ventana=new JFrame();
		ventana.setTitle("Conexion Cliente");
		ventana.setLayout(new FlowLayout(FlowLayout.CENTER));
		ventana.setSize(300,90);
		ventana.setLocation(400, 300);
		textoVentana=new JLabel();
		textoVentana.setText("Para iniciar conectese al servidor");
		botonVentana=new JButton();
		botonVentana.setText("Conectar");
		botonVentana.addActionListener(this);
		ventana.add(textoVentana);
		ventana.add(botonVentana);
		ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}
	
	public void crearVentana2(){
		ventana2=new JFrame();
		ventana2.setTitle("Busqueda Cliente");
		ventana2.setLayout(new FlowLayout(FlowLayout.CENTER));
		ventana2.setSize(600,120);
		ventana2.setLocation(400, 300);
		textoVentana2=new JLabel();
		textoVentana2.setText("Ingrese lo que desea buscar");
		entradaTextoVentana2=new JTextField(50);
		botonVentana2=new JButton();
		botonVentana2.setText("Buscar");
		botonVentana2.addActionListener(this);
		ventana2.add(textoVentana2);
		ventana2.add(entradaTextoVentana2);
		ventana2.add(botonVentana2);
		ventana2.setDefaultCloseOperation(ventana2.EXIT_ON_CLOSE);
		
	}
	public void crearVentana3(){
		ventana3=new JFrame();
		ventana3.setTitle("Resultados Cliente");
		ventana3.setLayout(new FlowLayout(FlowLayout.CENTER));
		ventana3.setSize(600,400);
		ventana3.setLocation(400, 300);
		textoVentana3=new JLabel();
		textoVentana3.setText("Los resultados de la busqueda son:");
		lista=new JList<String>(resultados);
		ventana3.add(textoVentana3);
		ventana3.add(lista);
		ventana3.setDefaultCloseOperation(ventana3.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botonVentana) {
			ventana.setVisible(false);
			crearVentana2();
			ventana2.setVisible(true);
			
		}
		if (e.getSource()==botonVentana2) {
			ventana2.setVisible(false);
			crearVentana3();
			ventana3.setVisible(true);
		}
		
	}
	
	public InterfazCliente(){
		crearVentana();
	}
	
	

}
