package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.AdminGeneral;
import modelo.ClienteRegistrado;

public class PanelAGeneral extends JPanel implements ActionListener{
	
	private Principal principal;
	private PanelPrincipal panelPrincipal;
	private AdminGeneral adminGeneral;
	
	JButton btnSede1;
    JButton btnSede2;
    JButton btnSede3;
    JButton btnReservas;
	
	JTextField txtPlaca;
	JTextField txtMarca;
	JTextField txtModelo;
	JTextField txtAnio;
	JTextField txtColor;
	JTextField txtTransmision;
	JTextField txtUbicacion;
	JTextField txtCategoria;
	JTextField txtInfo;

	private JPanel pnlInfoDesplegada;
	
	private static final String CONFIRMAR = "Confirmar";
	private static final String SEDE1 = "Sede 1";
	private static final String SEDE2 = "Sede 2";
	private static final String SEDE3 = "Sede 3";
	private static final String RESERVAS_ACTUALES = "Reservas Actuales";
	
	public PanelAGeneral(Principal principal) {
		
		this.principal = principal;
		
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(panelInfoDesplegada(), gbc);
		
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(panelCentralCompra(), gbc);
		
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(15,0,0,0);
		this.add(panelInferiorCompra(), gbc);
		
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0,0,15,0);
		this.add(panelInfo("Registrar Compra de Vehiculo"), gbc);
		
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.insets = new Insets(0,0,0,0);
		this.add(panelBotones(), gbc);
		
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(15,0,0,0);
		this.add(panelInfo("Información Disponible en Tiempo Real:"), gbc);
	}
	
	public JPanel panelInfo(String label) {
		JPanel pnlSuperior = new JPanel();
		JLabel lblRegistro = new JLabel(label);
		pnlSuperior.add(lblRegistro);
		return pnlSuperior;
	}
	
	public JPanel panelCentralCompra() {
		JPanel pnlCentral = new JPanel();
		pnlCentral.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.anchor = GridBagConstraints.WEST;
		
		JLabel lblPlaca = new JLabel("Placa");
		gbc.gridx = 0;
		gbc.gridy = 0;
		pnlCentral.add(lblPlaca, gbc);
		
		txtPlaca = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 1;
		pnlCentral.add(txtPlaca, gbc);
		
		JLabel lblMarca = new JLabel("Marca");
		gbc.gridx = 0;
		gbc.gridy = 2;
		pnlCentral.add(lblMarca, gbc);
		
		txtMarca = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 3;
		pnlCentral.add(txtMarca, gbc);
		
		JLabel lblModelo = new JLabel("Modelo");
		gbc.gridx = 0;
		gbc.gridy = 4;
		pnlCentral.add(lblModelo, gbc);
		
		txtModelo = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 5;
		pnlCentral.add(txtModelo, gbc);
		
		JLabel lblAnio = new JLabel("Año");
		gbc.gridx = 0;
		gbc.gridy = 6;
		pnlCentral.add(lblAnio, gbc);
		
		txtAnio = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 7;
		pnlCentral.add(txtAnio, gbc);
		
		JLabel lblColor = new JLabel("Color");
		gbc.gridx = 1;
		gbc.gridy = 0;
		pnlCentral.add(lblColor, gbc);
		
		txtColor = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 1;
		pnlCentral.add(txtColor, gbc);
		
		JLabel lblTransmision = new JLabel("Transmision");
		gbc.gridx = 1;
		gbc.gridy = 2;
		pnlCentral.add(lblTransmision, gbc);
		
		txtTransmision = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 3;
		pnlCentral.add(txtTransmision, gbc);
		
		JLabel lblUbicacion = new JLabel("Sede a la que llega");
		gbc.gridx = 1;
		gbc.gridy = 4;
		pnlCentral.add(lblUbicacion, gbc);
		
		txtUbicacion = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 5;
		pnlCentral.add(txtUbicacion, gbc);
		
		JLabel lblCategoria = new JLabel("Categoria");
		gbc.gridx = 1;
		gbc.gridy = 6;
		pnlCentral.add(lblCategoria, gbc);
		
		txtCategoria = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 7;
		pnlCentral.add(txtCategoria, gbc);
		
		return pnlCentral;
	}
	
	public JPanel panelInferiorCompra() {
		JPanel pnlInferior = new JPanel();
		
		JButton btnConfirmar = new JButton(CONFIRMAR);
		btnConfirmar.setActionCommand(CONFIRMAR);
		btnConfirmar.addActionListener(this);
		
		pnlInferior.add(btnConfirmar);
		
		return pnlInferior;
	}
	
	public JPanel panelInfoDesplegada() {
		
		JPanel pnlInfoDesplegada = new JPanel();

		pnlInfoDesplegada.setLayout(new CardLayout());
		
		DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("C0");
        tableModel.addColumn("C1");
        tableModel.addColumn("C2");
        tableModel.addColumn("C3");
        tableModel.addColumn("C4");
        tableModel.addColumn("C5");
        tableModel.addColumn("C6");
        tableModel.addColumn("C7");
        tableModel.addColumn("C8");
        tableModel.addColumn("C9");
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("sede1.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] rowData = line.split(";"); // Suponiendo que las columnas están separadas por tabulaciones
                tableModel.addRow(rowData);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        JTable sede1 = new JTable(tableModel);
        
        DefaultTableModel tableModel1 = new DefaultTableModel();
        tableModel1.addColumn("C0");
        tableModel1.addColumn("C1");
        tableModel1.addColumn("C2");
        tableModel1.addColumn("C3");
        tableModel1.addColumn("C4");
        tableModel1.addColumn("C5");
        tableModel1.addColumn("C6");
        tableModel1.addColumn("C7");
        tableModel1.addColumn("C8");
        tableModel1.addColumn("C9");
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("sede2.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] rowData = line.split(";"); 
                tableModel1.addRow(rowData);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        JTable sede2 = new JTable(tableModel1);
        
        DefaultTableModel tableModel2 = new DefaultTableModel();
        tableModel2.addColumn("C0");
        tableModel2.addColumn("C1");
        tableModel2.addColumn("C2");
        tableModel2.addColumn("C3");
        tableModel2.addColumn("C4");
        tableModel2.addColumn("C5");
        tableModel2.addColumn("C6");
        tableModel2.addColumn("C7");
        tableModel2.addColumn("C8");
        tableModel2.addColumn("C9");
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("sede3.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] rowData = line.split(";"); 
                tableModel2.addRow(rowData);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        JTable sede3 = new JTable(tableModel2);
        
        DefaultTableModel tableModel3 = new DefaultTableModel();
        tableModel3.addColumn("C0");
        tableModel3.addColumn("C1");
        tableModel3.addColumn("C2");
        tableModel3.addColumn("C3");
        tableModel3.addColumn("C4");
        tableModel3.addColumn("C5");
        tableModel3.addColumn("C6");
        tableModel3.addColumn("C7");
        tableModel3.addColumn("C8");
        tableModel3.addColumn("C9");
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("reservas.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] rowData = line.split(";"); 
                tableModel2.addRow(rowData);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        JTable reservas = new JTable(tableModel3);
       
        
        pnlInfoDesplegada.add(sede1, "sede1");
        pnlInfoDesplegada.add(sede2, "sede2");
        pnlInfoDesplegada.add(sede3, "sede3");
        pnlInfoDesplegada.add(reservas, "reservas");
        
        btnSede1 = new JButton(SEDE1);
        btnSede2 = new JButton(SEDE2);
        btnSede3 = new JButton(SEDE3);
        btnReservas = new JButton(RESERVAS_ACTUALES);
        
        btnSede1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) pnlInfoDesplegada.getLayout();
				cardLayout.show(pnlInfoDesplegada, "sede1");
				
			}
        	
        });
        
        btnSede2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) pnlInfoDesplegada.getLayout();
				cardLayout.show(pnlInfoDesplegada, "sede2");
				
			}
        	
        });
        
        btnSede3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) pnlInfoDesplegada.getLayout();
				cardLayout.show(pnlInfoDesplegada, "sede3");
				
			}
        	
        });
        
        btnReservas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) pnlInfoDesplegada.getLayout();
				cardLayout.show(pnlInfoDesplegada, "reservas");
				
			}
        	
        });
        
        return pnlInfoDesplegada;
	}
	
	//HashMap<String,List<String>> sede
	
	
	public JPanel panelBotones() {
		JPanel pnlDisplaySede = new JPanel();
		pnlDisplaySede.setLayout(new FlowLayout());
		pnlDisplaySede.add(btnSede1);
		pnlDisplaySede.add(btnSede2);
		pnlDisplaySede.add(btnSede3);
		pnlDisplaySede.add(btnReservas);
		return pnlDisplaySede;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		ArrayList<String> lstCampos = new ArrayList<String>();
		lstCampos.add(txtPlaca.getText());
		lstCampos.add(txtMarca.getText());
		lstCampos.add(txtModelo.getText());
		lstCampos.add(txtAnio.getText());
		lstCampos.add(txtColor.getText());
		lstCampos.add(txtTransmision.getText());
		lstCampos.add(txtUbicacion.getText());
		lstCampos.add(txtCategoria.getText());
		
		Boolean infoRecibida = true;
		for (String campo : lstCampos) {
			if (campo.equals("")) {
				infoRecibida = false;
			}
		}
		
		
		if (comando.equals(CONFIRMAR) && infoRecibida) {
			adminGeneral.registrarCompraNuevoVehiculo(txtPlaca.getText(), txtMarca.getText(), txtModelo.getText(), txtAnio.getText(), txtColor.getText(), txtTransmision.getText(), txtUbicacion.getText(), "False", "Listo", txtCategoria.getText());
			JOptionPane.showMessageDialog(null, "Se ha registrado un nuevo vehículo en la " + txtUbicacion.getText());
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Por favor llene todos los campos solicitados.", "Información Incompleta", JOptionPane.WARNING_MESSAGE);
		}
		
	}

}


//adminGeneral.registrarCompraNuevoVehiculo(placa, marca, modelo, ano, color, transmision, ubicacion, false, "Listo", tipo);

