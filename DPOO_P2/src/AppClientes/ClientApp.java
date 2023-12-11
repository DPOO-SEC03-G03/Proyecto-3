package AppClientes;

import javax.swing.*;
import modelo.BaseDatos;  // Asegúrate de importar tu clase BaseDatos

public class ClientApp extends JFrame {
    private BaseDatos baseDatos;

    public ClientApp(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;  // Inyecta la dependencia de la base de datos

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setTitle("Aplicación para Clientes");

        JButton btnRegister = new JButton("Registrar Nuevo Usuario");
        JButton btnLogin = new JButton("Autenticar Usuario");

        btnRegister.addActionListener(e -> showRegistrationForm());
        btnLogin.addActionListener(e -> showLoginForm());

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(btnRegister);
        add(btnLogin);
    }

    private void showRegistrationForm() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.setVisible(true);
    }

    private void showLoginForm() {
        LoginForm loginForm = new LoginForm(baseDatos);
        loginForm.setVisible(true);
    }
}


