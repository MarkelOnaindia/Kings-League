package Vista.Usuario;

import javax.swing.*;

public class vRegistrarse {
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel panelCentrado;
    private JFormattedTextField ftfUsuario;
    private JPasswordField pfContrasena;
    private JButton registrarButton;
    private JButton iniciarButton;
    private JLabel logo;
    private JPanel pPrincipal;
    private JPanel panelInicio;
    private JButton bRegistrar;
    private JButton bSalir;
    private JPasswordField pfContrasena2;
    private JTextField tfEmail;
    private JTextField tfTelefono;

    //Getter
    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    //Main
    public static void main(String[] args) {
        JFrame frame = new JFrame("vRegistrarse");
        frame.setContentPane(new vRegistrarse().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //Todo
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
