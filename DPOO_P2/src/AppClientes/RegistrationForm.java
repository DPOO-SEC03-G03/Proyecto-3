package AppClientes;

import modelo.BaseDatos;
import modelo.ClienteRegistrado;
import modelo.Licencia;
import modelo.MetodoPago;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegistrationForm extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnRegister;
    private BaseDatos baseDatos;

    public RegistrationForm() {
        this.baseDatos = baseDatos;

        setTitle("Registro de Usuario");
        setSize(300, 200);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        txtUsername = new JTextField(20);
        txtPassword = new JPasswordField(20);
        btnRegister = new JButton("Registrar");

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    registerUser();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        add(new JLabel("Nombre de Usuario:"));
        add(txtUsername);
        add(new JLabel("Contraseña:"));
        add(txtPassword);
        add(btnRegister);
    }

    private void registerUser() throws IOException {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        if(username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, rellene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Crear objetos Licencia y MetodoPago con valores de ejemplo
            Licencia licencia = new Licencia("123456789", "2025-12-31");
            MetodoPago metodoPago = new MetodoPago("Visa", "123", "1111222233334444", "Banco Ejemplo", "2024-08-01");

            // Crear un nuevo cliente. Los valores de ejemplo se utilizan para parámetros no proporcionados por el formulario.
            ClienteRegistrado nuevoCliente = new ClienteRegistrado(username, "123456789", "3001234567", "email@example.com", "0", password, "01-01-1990", "Colombiano", "Colombia");

            baseDatos.crearCuentaCliente(nuevoCliente, licencia, metodoPago);

            JOptionPane.showMessageDialog(this, "Usuario registrado con éxito!", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
            txtUsername.setText("");
            txtPassword.setText("");
        }
    }


        
    }


