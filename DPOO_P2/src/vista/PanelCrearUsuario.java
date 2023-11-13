package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import modelo.ClienteRegistrado;
import modelo.MetodoPago;
import modelo.Licencia;

public class PanelCrearUsuario extends JPanel implements ActionListener{
	
	private Principal principal;
	private PanelPrincipal panelPrincipal;
	
	private JTextField cedula;
	private JTextField nombre;
	private JTextField celular;
	private JTextField email;
	private JTextField contrasenia;
	private JTextField fechaNacimiento;
	private JTextField nacionalidad;
	private JTextField lugarExpedicionCC;
	
	private JTextField numLicencia;
	private JTextField fechaVencimientoLicencia;

	private JTextField cvc;
	private JTextField numTarjeta;
	private JTextField fechaVencimientoTarjeta;
	private JTextField banco;
	
	private String seleccion;
	
	// ********************************
	// Constantes
	// ********************************
	
	public final static String CREAR_CUENTA = "Crear Cuenta";
	public final static String BORRAR = "Borrar";
	
	public PanelCrearUsuario(Principal principal) {
		
		TitledBorder border = new TitledBorder("Crear Cuenta");
		border.setTitleColor(Color.BLACK);
		setBorder(border);
		
		this.principal = principal;
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(1,0,1,0);
		JLabel lblCedula = new JLabel("Cedula:");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = 1;
		gbc.weighty = 0.5;
		this.add(lblCedula, gbc);
		
		cedula = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.fill = 1;
		this.add(cedula, gbc);
		
		JLabel lblNombre = new JLabel("Nombre y Apellido:");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.fill = 1;
		this.add(lblNombre, gbc);
		
		nombre = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.fill = 1;
		this.add(nombre, gbc);
		
		JLabel lblCelular = new JLabel("Celular:");
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.fill = 1;
		this.add(lblCelular, gbc);
		
		celular = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.fill = 1;
		this.add(celular, gbc);
		
		JLabel lblEmail = new JLabel("Email:");
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.fill = 1;
		this.add(lblEmail, gbc);
		
		email = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.fill = 1;
		this.add(email, gbc);
		
		JLabel lblContrasenia = new JLabel("Contraseña:");
		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.fill = 1;
		this.add(lblContrasenia, gbc);
		
		contrasenia = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 11;
		gbc.fill = 1;
		this.add(contrasenia, gbc);
		
		gbc.insets = new Insets(8,0,5,0);
		JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
		gbc.gridx = 0;
		gbc.gridy = 12;
		gbc.fill = 1;
		this.add(lblFechaNacimiento, gbc);
		
		fechaNacimiento = new JTextField(20);
		fechaNacimiento.setText("dd-mm-aa");
		fechaNacimiento.setForeground(Color.GRAY);
		fechaNacimiento.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (fechaNacimiento.getText().equals("dd-mm-aa")) {
					fechaNacimiento.setText("");
					fechaNacimiento.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (fechaNacimiento.getText().isEmpty()) {
					fechaNacimiento.setText("aa-mm-dd");
					fechaNacimiento.setForeground(Color.GRAY);
				}
			}
			
		});
		gbc.gridx = 0;
		gbc.gridy = 13;
		gbc.fill = 1;
		this.add(fechaNacimiento, gbc);
		
		gbc.insets = new Insets(1,0,1,0);
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		gbc.gridx = 0;
		gbc.gridy = 14;
		gbc.fill = 1;
		this.add(lblNacionalidad, gbc);
		
		nacionalidad = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 15;
		gbc.fill = 1;
		this.add(nacionalidad, gbc);
		
		JLabel lblLugarExpCC = new JLabel("País de Expedición de CC:");
		gbc.gridx = 0;
		gbc.gridy = 16;
		gbc.fill = 1;
		this.add(lblLugarExpCC, gbc);
		
		lugarExpedicionCC = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 17;
		gbc.fill = 1;
		this.add(lugarExpedicionCC, gbc);
		
		JLabel lblNumLicencia = new JLabel("Numero de Licencia:");
		gbc.gridx = 0;
		gbc.gridy = 18;
		gbc.fill = 1;
		this.add(lblNumLicencia, gbc);
		
		numLicencia = new JTextField(20);
		numLicencia.setText("Sólo los dígitos, no ingrese el 'LC'");
		numLicencia.setForeground(Color.GRAY);
		numLicencia.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (numLicencia.getText().equals("Sólo los dígitos, no ingrese el 'LC'")) {
					numLicencia.setText("");
					numLicencia.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (numLicencia.getText().isEmpty()) {
					numLicencia.setText("Sólo los dígitos, no ingrese el 'LC'");
					numLicencia.setForeground(Color.GRAY);
				}
				
			}
			
		});
		gbc.gridx = 0;
		gbc.gridy = 19;
		gbc.fill = 1;
		this.add(numLicencia, gbc);
		
		JLabel lblFechaVenLicencia = new JLabel("Fecha de Vencimiento Licencia:");
		gbc.gridx = 0;
		gbc.gridy = 20;
		gbc.fill = 1;
		this.add(lblFechaVenLicencia, gbc);
		
		fechaVencimientoLicencia = new JTextField(20);
		fechaVencimientoLicencia.setText("dd-mm-aa");
		fechaVencimientoLicencia.setForeground(Color.GRAY);
		fechaVencimientoLicencia.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (fechaVencimientoLicencia.getText().equals("dd-mm-aa")) {
					fechaVencimientoLicencia.setText("");
					fechaVencimientoLicencia.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (fechaVencimientoLicencia.getText().isEmpty()) {
					fechaVencimientoLicencia.setText("aa-mm-dd");
					fechaVencimientoLicencia.setForeground(Color.GRAY);
				}
			}
			
		});
		gbc.gridx = 0;
		gbc.gridy = 21;
		gbc.fill = 1;
		this.add(fechaVencimientoLicencia, gbc);
		
		gbc.insets = new Insets(0,10,0,0);
		JLabel lblMedioPago = new JLabel("Método de Pago:");
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = 1;
		this.add(lblMedioPago, gbc);
		
		String[] lstMetodosDePago = {"Tarjeta Crédito", "Tarjeta Debito"};
		JComboBox<String> medioPago = new JComboBox<>(lstMetodosDePago);
		medioPago.setSelectedIndex(0);
		seleccion = "Tarjeta Crédito";
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.fill = 1;
		this.add(medioPago, gbc);
		
		medioPago.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				seleccion = (String) medioPago.getSelectedItem();
			}
			
		});
		
		/**
		medioPago = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 23;
		gbc.fill = 1;
		this.add(medioPago, gbc);
		**/
		
		JLabel lblCVC = new JLabel("Código de seguridad CVC:");
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.fill = 1;
		this.add(lblCVC, gbc);
		
		cvc = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.fill = 1;
		this.add(cvc, gbc);
		
		JLabel lblNumTarjeta = new JLabel("Número de Tarjeta:");
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.fill = 1;
		this.add(lblNumTarjeta, gbc);
		
		numTarjeta = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.fill = 1;
		this.add(numTarjeta, gbc);
		
		JLabel lblFechaVenTarjeta = new JLabel("Fecha de Vencimiento Tarjeta:");
		
		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.fill = 1;
		this.add(lblFechaVenTarjeta, gbc);
		
		fechaVencimientoTarjeta = new JTextField(20);
		fechaVencimientoTarjeta.setText("MM/AA");
		fechaVencimientoTarjeta.setForeground(Color.GRAY);
		fechaVencimientoTarjeta.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (fechaVencimientoTarjeta.getText().equals("MM/AA")) {
					fechaVencimientoTarjeta.setText("");
					fechaVencimientoTarjeta.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (fechaVencimientoTarjeta.getText().isEmpty()) {
					fechaVencimientoTarjeta.setText("MM/AA");
					fechaVencimientoTarjeta.setForeground(Color.GRAY);
				}
			}
			
		});
		gbc.gridx = 1;
		gbc.gridy = 9;
		gbc.fill = 1;
		this.add(fechaVencimientoTarjeta, gbc);
		
		JLabel lblBanco = new JLabel("Banco:");
		gbc.gridx = 1;
		gbc.gridy = 10;
		gbc.fill = 1;
		this.add(lblBanco, gbc);
		
		banco = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 11;
		gbc.fill = 1;
		this.add(banco, gbc);
		
		gbc.insets = new Insets(15,10,0,0);
		JButton btnCrearCuenta = new JButton(CREAR_CUENTA);
		btnCrearCuenta.setActionCommand(CREAR_CUENTA);
		btnCrearCuenta.addActionListener(this);
		gbc.gridx = 1;
		gbc.gridy = 13;
		gbc.fill = 1;
		this.add(btnCrearCuenta, gbc);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		//medioPago = (String) comboBox.getSelectedItem();
		
		String strCedula = getCedula();
		String strNombre = getNombre();
		String strCelular = getCelular();
		String strEmail = getEmail();
		String strContrasenia = getContrasenia();
		String strFechaNacimiento = getFechaNacimiento();
		String strNacionalidad = getNacionalidad();
		String strLugarExpCC = getLugarExpedicionCC();
		String strNumLicencia = getNumLicencia();
		String strFechaVenLicencia = getFechaVencimientoLicencia();
		String strMedioPago = seleccion;
		String strCVC = getCvc();
		String strNumTarjeta = getNumTarjeta();
		String strFechaVenTarjeta = getFechaVencimientoTarjeta();
		String strBanco = getBanco();
		
		ArrayList<String> listaControl = new ArrayList<>();
		listaControl.add(strCedula);
		listaControl.add(strNombre);
		listaControl.add(strCelular);
		listaControl.add(strEmail);
		listaControl.add(strContrasenia);
		listaControl.add(strFechaNacimiento);
		listaControl.add(strNacionalidad);
		listaControl.add(strLugarExpCC);
		listaControl.add(strNumLicencia);
		listaControl.add(strFechaVenLicencia);
		listaControl.add(strMedioPago);
		listaControl.add(strCVC);
		listaControl.add(strNumTarjeta);
		listaControl.add(strFechaVenTarjeta);
		listaControl.add(strBanco);
		
		Boolean elementoMarcado = true;
		
		for (String elemento : listaControl) {
			if (elemento.equals("")) {
				elementoMarcado = false;
			}
		}
		if (comando.equals(CREAR_CUENTA) && elementoMarcado) {
			ClienteRegistrado nuevoCliente = new ClienteRegistrado(strNombre, strCedula, strCelular, strEmail, null, strContrasenia, strFechaNacimiento, strNacionalidad, strLugarExpCC);
			Licencia licencia = new Licencia(strNumLicencia, strFechaVenLicencia);
			MetodoPago metodo = new MetodoPago(strMedioPago, strCVC, strNumTarjeta, strFechaVenTarjeta, strBanco);
			
			try {
				this.principal.baseDatos.crearCuentaCliente(nuevoCliente, licencia, metodo);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			String primerNombre = getPrimerNombre(strNombre);
			JOptionPane.showMessageDialog(null, "Es hora de alquilar " + primerNombre + "! Por favor inicia sesión.");
			panelPrincipal = new PanelPrincipal(principal);
			this.principal.setContentPane(panelPrincipal);
			this.principal.revalidate();
			
		}
		else {
			JOptionPane.showMessageDialog(null, "Porfavor llene todos los campos.", "Información Incompleta", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	public String getPrimerNombre(String nombreCompleto) {
		String[] elementos = nombreCompleto.split(" ");
		String nombre = elementos[0];
		return nombre;
	}
	

	public String getCedula() {
		return cedula.getText();
	}

	public String getNombre() {
		return nombre.getText();
	}

	public String getCelular() {
		return celular.getText();
	}

	public String getEmail() {
		return email.getText();
	}

	public String getContrasenia() {
		return contrasenia.getText();
	}

	public String getFechaNacimiento() {
		return fechaNacimiento.getText();
	}

	public String getNacionalidad() {
		return nacionalidad.getText();
	}

	public String getLugarExpedicionCC() {
		return lugarExpedicionCC.getText();
	}

	public String getNumLicencia() {
		return numLicencia.getText();
	}

	public String getFechaVencimientoLicencia() {
		return fechaVencimientoLicencia.getText();
	}

	public String getCvc() {
		return cvc.getText();
	}

	public String getNumTarjeta() {
		return numTarjeta.getText();
	}

	public String getFechaVencimientoTarjeta() {
		return fechaVencimientoTarjeta.getText();
	}

	public String getBanco() {
		return banco.getText();
	}	
}
