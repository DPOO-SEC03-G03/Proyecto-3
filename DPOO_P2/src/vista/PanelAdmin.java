package vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.AdminLocal;
import modelo.Empleado;

public class PanelAdmin extends JPanel implements ActionListener{
	
	private Principal principal;
	private PanelPrincipal panelPrincipal;
	private PanelCrearUsuario panelCrearUsuario;
	private AdminLocal adminLocal;
	
	private JTextField cedula;
	private JTextField contrasenia;
	private JTextField nombre;
	private JTextField celular;
	private JTextField email;
	private JTextField aniosEmpresa;
	private JTextField sede;
	
	public final static String CONFIRMAR = "Confirmar";
	public final static String CERRAR = "Cerrar";
	public final static String REGISTRAR_CLIENTE = "Reg. Cliente";
	
	public PanelAdmin(Principal principal) {
		this.principal = principal;
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel regEmp = new JLabel("Registrar Empleado");
		gbc.insets = new Insets(0,0,15,0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(regEmp, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(panelInfoRequerida(), gbc);
		
		gbc.insets = new Insets(10,0,0,0);
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(panelBotones(), gbc);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		String[] listaComprob = {cedula.getText(), contrasenia.getText(), nombre.getText(), celular.getText(), email.getText(), aniosEmpresa.getText(), sede.getText()};
		
		Boolean todosLlenos = true;
		for (String atrib : listaComprob) {
			if (atrib.equals("")) {
				todosLlenos = false;
			}
		}
		
		if (comando.equals(CONFIRMAR) && todosLlenos) {
			Empleado empleado = new Empleado(nombre.getText(), cedula.getText()+"2", celular.getText(), email.getText(), aniosEmpresa.getText(), contrasenia.getText(), sede.getText());
			try {
				this.principal.adminLocal.crearNuevoEmpleado(empleado);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, nombre.getText() + " ha sido registrado como empleado.");
		}
		
		else if (comando.equals(CERRAR)) {
			panelPrincipal = new PanelPrincipal(principal);
			this.principal.setContentPane(panelPrincipal);
			this.principal.revalidate();
			
		}
		
		else if (comando.equals(REGISTRAR_CLIENTE)) {
			panelCrearUsuario = new PanelCrearUsuario(principal);
			this.principal.setContentPane(panelCrearUsuario);
			this.principal.revalidate();
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Por favor llene todos los campos solicitados.", "Información Incompleta", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	public JPanel panelBotones() {
		JPanel pnlBotones = new JPanel();
		pnlBotones.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JButton btnConfirmar = new JButton(CONFIRMAR);
		btnConfirmar.setActionCommand(CONFIRMAR);
		btnConfirmar.addActionListener(this);
		gbc.gridx = 0;
		gbc.gridy = 0;
		pnlBotones.add(btnConfirmar, gbc);
		
		JButton btnCerrar = new JButton(CERRAR);
		btnCerrar.setActionCommand(CERRAR);
		btnCerrar.addActionListener(this);
		gbc.gridx = 1;
		gbc.gridy = 0;
		pnlBotones.add(btnCerrar, gbc);
		
		JButton btnRegCliente = new JButton(REGISTRAR_CLIENTE);
		btnRegCliente.setActionCommand(REGISTRAR_CLIENTE);
		btnRegCliente.addActionListener(this);
		gbc.gridx = 2;
		gbc.gridy = 0;
		pnlBotones.add(btnRegCliente, gbc);
		
		return pnlBotones;
	}
	
	public JPanel panelInfoRequerida() {
		JPanel pnlInfoRequerida = new JPanel();
		pnlInfoRequerida.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel txtCedula = new JLabel("Cedula");
		gbc.gridx = 0;
		gbc.gridy = 0;
		pnlInfoRequerida.add(txtCedula, gbc);
		
		cedula = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 1;
		pnlInfoRequerida.add(cedula, gbc);
		
		JLabel txtContrasenia = new JLabel("Contraseña");
		gbc.gridx = 0;
		gbc.gridy = 2;
		pnlInfoRequerida.add(txtContrasenia, gbc);
		
		contrasenia = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 3;
		pnlInfoRequerida.add(contrasenia, gbc);
		
		JLabel txtNombre = new JLabel("Nombre");
		gbc.gridx = 0;
		gbc.gridy = 4;
		pnlInfoRequerida.add(txtNombre, gbc);
		
		nombre = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 5;
		pnlInfoRequerida.add(nombre, gbc);
		
		JLabel txtCelular = new JLabel("Celular");
		gbc.gridx = 0;
		gbc.gridy = 6;
		pnlInfoRequerida.add(txtCelular, gbc);
		
		celular = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 7;
		pnlInfoRequerida.add(celular, gbc);
		
		JLabel txtEmail = new JLabel("Email");
		gbc.gridx = 0;
		gbc.gridy = 8;
		pnlInfoRequerida.add(txtEmail, gbc);
		
		email = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 9;
		pnlInfoRequerida.add(email, gbc);
		
		JLabel txtAniosEmpresa = new JLabel("Años en la Empresa");
		gbc.gridx = 0;
		gbc.gridy = 10;
		pnlInfoRequerida.add(txtAniosEmpresa, gbc);
		
		aniosEmpresa = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 11;
		pnlInfoRequerida.add(aniosEmpresa, gbc);
		
		JLabel txtSede = new JLabel("Sede");
		gbc.gridx = 0;
		gbc.gridy = 12;
		pnlInfoRequerida.add(txtSede, gbc);
		
		sede = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 13;
		pnlInfoRequerida.add(sede, gbc);
		
		return pnlInfoRequerida;
	}
}
