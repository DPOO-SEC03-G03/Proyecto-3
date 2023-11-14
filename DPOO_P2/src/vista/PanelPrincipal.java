package vista;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PanelPrincipal extends JPanel implements ActionListener {
    private Principal principal;
    private PanelLogin panelLogin;
    private PanelCrearUsuario panelCrearUsuario;

    public final static String INICIAR_SESION = "Iniciar Sesión";
    public final static String CREAR_CUENTA = "Crear Cuenta";

    public PanelPrincipal(Principal principal) {
    	
        this.principal = principal;

        this.principal.baseDatos.cargarBaseDatos("empleados.txt",
                "ClientesRegistrados.txt",
                "sede1.txt",
                "sede2.txt",
                "sede3.txt");

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Crear un JLabel para el título
        JLabel tituloLabel = new JLabel("Bienvenido a Carros Chimbas");
        tituloLabel.setFont(new Font("SansSerif", Font.BOLD, 24));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15, 0, 30, 0); 
        this.add(tituloLabel, gbc);

        JButton btnInicSes = new JButton(INICIAR_SESION);
        btnInicSes.setActionCommand(INICIAR_SESION);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(15, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        btnInicSes.addActionListener(this);
        this.add(btnInicSes, gbc);

        JButton btnCrearCuenta = new JButton(CREAR_CUENTA);
        btnCrearCuenta.setActionCommand(CREAR_CUENTA);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        btnCrearCuenta.addActionListener(this);
        this.add(btnCrearCuenta, gbc);
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals(INICIAR_SESION)) {
            panelLogin = new PanelLogin(this.principal);
        } else if (comando.equals(CREAR_CUENTA)) {
            panelCrearUsuario = new PanelCrearUsuario(this.principal);
            this.principal.setContentPane(panelCrearUsuario);
            this.principal.revalidate();
        }
    }
}
