package vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import modelo.ClienteRegistrado;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;

public class PanelEmpleado extends JPanel implements ActionListener{
	
	private Principal principal;
	private PanelPrincipal panelPrincipal;
	private ClienteRegistrado cliente;
	
	private String categoriaSeleccionada = "lujo";
	private String sedeReservaSeleccionada = "sede3";
	private String sedeDevolucionSeleccionada = "sede3";
	
	JTextField fechaPickUp;
	JTextField fechaDevolucion;
	
	public static final String CONFIRMAR = "Confirmar";
	
	public PanelEmpleado(Principal principal) {
		
		this.principal = principal;
		
		cliente = new ClienteRegistrado(null, null, null, null, null, null, null, null,null);
		
		TitledBorder border = new TitledBorder("Reserva de Vehiculo");
		border.setTitleColor(Color.BLACK);
		setBorder(border);
		
		this.setLayout(new GridLayout(6, 1));
		
		this.add(panelCategoriaVehiculo());
		this.add(panelSede());
		this.add(panelFechaPickUp());
		this.add(panelSedeDevolucion());
		this.add(panelFechaDevolucion());
		
		JButton btnConfirmar = new JButton(CONFIRMAR);
		btnConfirmar.setActionCommand(CONFIRMAR);
		btnConfirmar.addActionListener(this);
		this.add(btnConfirmar);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if (comando.equals(CONFIRMAR) && !fechaPickUp.getText().equals("dd-mm-aa") && !fechaDevolucion.getText().equals("dd-mm-aa")) {
			cliente.guardarCarrosEnUso(categoriaSeleccionada, sedeReservaSeleccionada, fechaPickUp.getText(), fechaDevolucion.getText(), sedeDevolucionSeleccionada);
			
			Set<String> llave = cliente.carrosEnUso.keySet();
			String placa = llave.iterator().next();
			List<String> info = cliente.carrosEnUso.get(placa);
			String carro = info.get(0);
			
			JOptionPane.showMessageDialog(null, "Debido a las especificaciones que nos proporcionaste, te hemos asignado un " + carro + " de placa " + placa);
			
			panelPrincipal = new PanelPrincipal(principal);
			this.principal.setContentPane(panelPrincipal);
			this.principal.revalidate();
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Por favor llene todos los campos.", "Información Incompleta", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	
	
	private JPanel panelBotonesCategorias() {
		JPanel pnlCateVehiculo = new JPanel();
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		CheckboxGroup categorias = new CheckboxGroup();
		
		Checkbox pequenio = new Checkbox("Pequeño", categorias, true);
		gbc.gridx = 0;
		gbc.gridy = 1;
		pequenio.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					categoriaSeleccionada = "pequeño";
				}
			}
		});
		pnlCateVehiculo.add(pequenio, gbc);
		
		Checkbox vans = new Checkbox("Vans", categorias, true);
		gbc.gridx = 1;
		gbc.gridy = 1;
		vans.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					categoriaSeleccionada = "vans";
				}
			}
		});
		pnlCateVehiculo.add(vans, gbc);
		
		Checkbox suv = new Checkbox("SUV", categorias, true);
		gbc.gridx = 2;
		gbc.gridy = 1;
		suv.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					categoriaSeleccionada = "suv";
				}
			}
		});
		pnlCateVehiculo.add(suv, gbc);
		
		Checkbox deportivo = new Checkbox("Deportivo", categorias, true);
		gbc.gridx = 3;
		gbc.gridy = 1;
		deportivo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					categoriaSeleccionada = "deportivo";
				}
			}
		});
		pnlCateVehiculo.add(deportivo, gbc);
		
		Checkbox lujo = new Checkbox("Lujo", categorias, true);
		gbc.gridx = 4;
		gbc.gridy = 1;
		lujo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					categoriaSeleccionada = "lujo";
				}
			}
		});
		pnlCateVehiculo.add(lujo, gbc);
		
		return pnlCateVehiculo;
	}
	
	private JPanel panelCategoriaVehiculo() {
		
		JPanel pnlCateVehiculo = new JPanel();
		pnlCateVehiculo.setLayout(new GridBagLayout());
		pnlCateVehiculo.setVisible(true);
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		pnlCateVehiculo.add(panelBotonesCategorias(), gbc);

		JLabel categoria = new JLabel("¿Qué categoria de vehiculo le gustaría reservar?");
		gbc.gridx = 0;
		gbc.gridy = 0;
		pnlCateVehiculo.add(categoria, gbc);
		
		return pnlCateVehiculo;
	}
	
	private JPanel panelCheckboxReserva() {
		JPanel panel = new JPanel();
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		CheckboxGroup sedes = new CheckboxGroup();
		
		Checkbox sede1 = new Checkbox("Sede 1", sedes, true);
		gbc.gridx = 0;
		gbc.gridy = 1;
		sede1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					sedeReservaSeleccionada = "sede1";
				}
			}
		});
		panel.add(sede1, gbc);
		
		Checkbox sede2 = new Checkbox("Sede 2", sedes, true);
		gbc.gridx = 1;
		gbc.gridy = 1;
		sede2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					sedeReservaSeleccionada = "sede2";
				}
			}
		});
		panel.add(sede2, gbc);
		
		Checkbox sede3 = new Checkbox("Sede 3", sedes, true);
		gbc.gridx = 2;
		gbc.gridy = 1;
		sede3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					sedeReservaSeleccionada = "sede3";
				}
			}
		});
		panel.add(sede3, gbc);
		
		
		return panel;
	}
	
	private JPanel panelCheckboxDevolucion() {
		JPanel panel = new JPanel();
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		CheckboxGroup sedes = new CheckboxGroup();
		
		Checkbox sede1 = new Checkbox("Sede 1", sedes, true);
		gbc.gridx = 0;
		gbc.gridy = 1;
		sede1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					sedeDevolucionSeleccionada = "sede1";
				}
			}
		});
		panel.add(sede1, gbc);
		
		Checkbox sede2 = new Checkbox("Sede 2", sedes, true);
		gbc.gridx = 1;
		gbc.gridy = 1;
		sede2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					sedeDevolucionSeleccionada = "sede2";
				}
			}
		});
		panel.add(sede2, gbc);
		
		Checkbox sede3 = new Checkbox("Sede 3", sedes, true);
		gbc.gridx = 2;
		gbc.gridy = 1;
		sede3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					sedeDevolucionSeleccionada = "sede3";
				}
			}
		});
		panel.add(sede3, gbc);
		
		
		return panel;
	}
	
	private JPanel panelSede() {
		JPanel pnlSede = new JPanel();
		pnlSede.setVisible(true);
		pnlSede.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		pnlSede.add(panelCheckboxReserva(),gbc);
		
		JLabel sede = new JLabel("¿En qué sede desea realizar la reserva?");
		gbc.gridx = 0;
		gbc.gridy = 0;
		//gbc.gridwidth = 4;
		pnlSede.add(sede, gbc);
		
		return pnlSede;
	}
	
	private JPanel panelFechaPickUp() {
		JPanel pnlFechaPickUp = new JPanel();
		pnlFechaPickUp.setVisible(true);
		pnlFechaPickUp.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		fechaPickUp = new JTextField(10);
		gbc.gridx = 0;
		gbc.gridy = 1;
		fechaPickUp.setText("dd-mm-aa");
		fechaPickUp.setForeground(Color.GRAY);
		fechaPickUp.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (fechaPickUp.getText().equals("dd-mm-aa")) {
					fechaPickUp.setText("");
					fechaPickUp.setForeground(Color.BLACK);
				}
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (fechaPickUp.getText().isEmpty()) {
					fechaPickUp.setText("dd-mm-aa");
					fechaPickUp.setForeground(Color.GRAY);
				}
			}
			
		});
		pnlFechaPickUp.add(fechaPickUp, gbc);
		
		JLabel devolucion = new JLabel("¿En que fecha recogería el vehiculo?");
		gbc.gridx = 0;
		gbc.gridy = 0;
		pnlFechaPickUp.add(devolucion, gbc);
		
		
		return pnlFechaPickUp;
	}

	private JPanel panelSedeDevolucion() {
		JPanel pnlSede = new JPanel();
		pnlSede.setVisible(true);
		pnlSede.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		pnlSede.add(panelCheckboxDevolucion(),gbc);
		
		JLabel sede = new JLabel("¿En qué sede desea realizar la devolución del vehículo?");
		gbc.gridx = 0;
		gbc.gridy = 0;
		//gbc.gridwidth = 4;
		pnlSede.add(sede, gbc);
		
		return pnlSede;
	}
	
	private JPanel panelFechaDevolucion() {
		JPanel pnlFechaDevolucion = new JPanel();
		pnlFechaDevolucion.setVisible(true);
		pnlFechaDevolucion.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		fechaDevolucion = new JTextField(10);
		gbc.gridx = 0;
		gbc.gridy = 1;
		fechaDevolucion.setText("dd-mm-aa");
		fechaDevolucion.setForeground(Color.GRAY);
		fechaDevolucion.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (fechaDevolucion.getText().equals("dd-mm-aa")) {
					fechaDevolucion.setText("");
					fechaDevolucion.setForeground(Color.BLACK);
				}
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (fechaDevolucion.getText().isEmpty()) {
					fechaDevolucion.setText("dd-mm-aa");
					fechaDevolucion.setForeground(Color.GRAY);
				}
			}
			
		});
		pnlFechaDevolucion.add(fechaDevolucion, gbc);
		
		JLabel devolucion = new JLabel("¿En que fecha devolvería el vehiculo?");
		gbc.gridx = 0;
		gbc.gridy = 0;
		pnlFechaDevolucion.add(devolucion, gbc);
		
		
		return pnlFechaDevolucion;
	}	
}
