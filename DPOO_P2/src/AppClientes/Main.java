package AppClientes;

import modelo.BaseDatos;  // Asegúrate de importar tu clase BaseDatos

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            BaseDatos baseDatos = new BaseDatos();  // Crea una instancia de BaseDatos
            ClientApp app = new ClientApp(baseDatos);  // Pasa la instancia de BaseDatos a ClientApp
            app.setVisible(true);
        });
    }
}


