package AppClientes;


import javax.swing.*;
import modelo.BaseDatos;
import java.util.List;
import java.util.Map;

public class LoginForm extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private BaseDatos baseDatos;

    public LoginForm(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;

        setTitle("Login de Usuario");
        setSize(300, 200);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        txtUsername = new JTextField(20);
        txtPassword = new JPasswordField(20);
        btnLogin = new JButton("Iniciar Sesión");

        btnLogin.addActionListener(e -> {
            authenticateUser();
        });

        add(new JLabel("Nombre de Usuario:"));
        add(txtUsername);
        add(new JLabel("Contraseña:"));
        add(txtPassword);
        add(btnLogin);
    }

    private void authenticateUser() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        if(username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, rellene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(verifyCredentials(username, password)) {
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
            // Lógica adicional para después del inicio de sesión
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean verifyCredentials(String username, String password) {
        Map<String, List<String>> clientesRegistrados = baseDatos.getClientesRegistrados();
        for (Map.Entry<String, List<String>> entry : clientesRegistrados.entrySet()) {
            if (entry.getKey().equals(username)) {
                // Suponiendo que la contraseña es uno de los elementos de la lista
                // Ajusta el índice según tu diseño
            	return entry.getValue().get(1).equals(password);

            }
        }
        return false;
    }
}



