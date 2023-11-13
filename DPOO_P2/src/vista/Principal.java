package vista;

import javax.imageio.ImageIO;
import javax.swing.*;

import modelo.AdminLocal;
import modelo.BaseDatos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Principal extends JFrame {
	
	JPanel p1;

	// ********************************
	// Variables Globales
	// ********************************
	public BaseDatos baseDatos = new BaseDatos();
	public AdminLocal adminLocal = new AdminLocal(null, null, null, null, null, null, null);
	
	public Principal() {
		
		this.setTitle("Carros Chimbas Para Alquilar");
		this.setSize(800,600);
		this.setResizable(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		this.add(new PanelPrincipal(this));
	}
	
	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.setVisible(true);
	}
	
    
    
}
