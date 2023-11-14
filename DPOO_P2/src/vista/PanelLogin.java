package vista;

import javax.imageio.ImageIO;
import javax.swing.*;

import modelo.AdminGeneral;
import modelo.AdminLocal;
import modelo.Categoria;
import modelo.ClienteRegistrado;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import java.lang.NullPointerException;

public class PanelLogin extends JFrame implements ActionListener{

    private JTextField usernameField;
    private JPasswordField passwordField;
    
    private Principal principal;
	private PanelCliente panelCliente;
	private PanelAGeneral panelAGeneral;
	private PanelAdmin panelAdmin;
	private PanelEmpleado panelEmpleado;
    
	private Categoria categoria;
	private AdminGeneral adminGeneral;
	private AdminLocal adminLocal;
	
	private HashMap<String, List<String>> clientes;
	private HashMap<String, List<String>> empleados;
	
    
	// ********************************
	// Constantes
	// ********************************
    
    public final static String OK = "Ok";

    public PanelLogin(Principal principal) {
    	
 
    	
    	categoria = new Categoria ();
		adminLocal = new AdminLocal(null, null, null, null, null, null, null);
		adminGeneral = new AdminGeneral(null, null, null, null, null, null);
		
		System.out.println("\n");
		
		categoria.cargarFlotilla("vehiculos.txt");
		
		
		clientes = principal.baseDatos.getClientesRegistrados();
		empleados = principal.baseDatos.getEmpleados();
    	
    	this.principal = principal;
    	
    	this.setTitle("Login");
    	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	this.setVisible(true);
    	this.setSize(350,150);
    	
        setLayout(new GridLayout(3, 2, 10, 10)); // GridLayout con 3 filas y 2 columnas

        JLabel usernameLabel = new JLabel("Nombre de Usuario:");
        usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField(20); 

        this.add(usernameLabel);
        this.add(usernameField);
        this.add(passwordLabel);
        this.add(passwordField);
        
        JButton btnAceptar = new JButton(OK);
        btnAceptar.setActionCommand(OK);
        btnAceptar.addActionListener(this);
        
        this.add(btnAceptar);
    }
    

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return String.valueOf(passwordField.getPassword());
    }
    
    public Boolean validUserAndPassword(String usuario, String contrasenia) {

    	List<String> infoUsuario = clientes.get(usuario);
    	
    	if (infoUsuario != null) {
    		
    	}
    	
    	int tamanio = infoUsuario.size();
 
		//int tamanio = infoUsuario.size();
		String actual = null;
		Boolean encontro = false;
		
		if(clientes.containsKey(usuario))
		{
			for(int i = 0; i < tamanio && encontro == false; i++)
			{
				actual = infoUsuario.get(i); 
				if(actual.equals(contrasenia)) {
					encontro = true;
				}
			}
		}
		
		else {
			encontro = false;
		}
		return encontro;
    }
    
    public Boolean validWorkerAndPassword(String usuario, String contrasenia) {
		List<String> infoEmpleados = empleados.get(usuario);
		int tamanio = infoEmpleados.size();
		String actual = null;
		Boolean encontro = false;
		if(empleados.containsKey(usuario)) {
			for(int i = 0; i < tamanio && encontro == false; i++) {
				actual = infoEmpleados.get(i); 
				if(actual.equals(contrasenia)) {
					encontro = true;
				}
			}
		}
		else {
			encontro = false;
		}
		return encontro;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		String usuario = getUsername();
		String contrasenia = getPassword();
		
		try {
			
			char id = usuario.charAt(usuario.length()-1);
			int longitud = usuario.length();
			
			if (longitud == 10) {
				if ((comando.equals(OK)) && validUserAndPassword(usuario, contrasenia)) {
					panelCliente = new PanelCliente(principal);
		            this.principal.setContentPane(panelCliente);
		            this.principal.revalidate();
					dispose();
				}
			}
			
			else if (longitud == 11) {
				if ((comando.equals(OK)) && validWorkerAndPassword(usuario, contrasenia)) {
					if (String.valueOf(id).equals("1")) {
						panelAGeneral = new PanelAGeneral(principal);
						this.principal.setContentPane(panelAGeneral);
						this.principal.revalidate();
						dispose();
					}
					else if (String.valueOf(id).equals("2")) {
						panelAdmin = new PanelAdmin(principal);
						this.principal.setContentPane(panelAdmin);
						this.principal.revalidate();
						dispose();
					}
					else if (String.valueOf(id).equals("3")) {
						panelEmpleado = new PanelEmpleado(principal);
						this.principal.setContentPane(panelEmpleado);
						this.principal.revalidate();
						dispose();
					}
				}
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Tu nombre de usuario o contraseña son incorrectos.", "Error: No Pudimos Inciar tu Sesión :(", JOptionPane.ERROR_MESSAGE);
			}
			
		} catch(NullPointerException ex) {
			JOptionPane.showMessageDialog(null, "Tu nombre de usuario o contraseña son incorrectos.", "Error: No Pudimos Inciar tu Sesión :(", JOptionPane.ERROR_MESSAGE);
		} catch(StringIndexOutOfBoundsException ex) {
			JOptionPane.showMessageDialog(null, "No se ingresó información, porfavor inténtelo de nuevo.", "Información Incompleta", JOptionPane.WARNING_MESSAGE);
		}
	}
	
 
}
