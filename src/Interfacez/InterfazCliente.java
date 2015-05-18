package Interfacez;

import java.awt.*;

import javax.swing.*;

public class InterfazCliente{
	JFrame ventana;
	JPanel panelArriba,panelAbajo;
	JLabel texto;
	JButton boton;
	JScrollBar casBar;
	JMenu menu;
	
	
	
	public void crearPanelArriba(){
		panelArriba=new JPanel();
		texto=new JLabel();
		texto.setText("Para iniciar conectese al servidor");
		panelArriba.setLayout(new BoxLayout(panelArriba, BoxLayout.X_AXIS));
		panelArriba.add(texto);
		
	}
	
	public void crearPanelAbajo(){
		panelAbajo=new JPanel();
		boton=new JButton();
		boton.setText("Conectar");
		panelAbajo.setLayout(new BoxLayout(panelAbajo, BoxLayout.X_AXIS));
		panelAbajo.add(boton);
		
	}
	public void crearVentana(){
		ventana=new JFrame();
		ventana.setTitle("Cliente");
		ventana.setSize(400,200);
		ventana.setLocation(400, 300);
		ventana.setLayout(new BoxLayout(ventana.getContentPane(), BoxLayout.Y_AXIS));
		ventana.add(panelArriba);
		ventana.add(panelAbajo);
		ventana.setVisible(true);
		
		
		
	}
	public InterfazCliente(){
		crearPanelArriba();
		crearPanelAbajo();
		crearVentana();
	}

}
