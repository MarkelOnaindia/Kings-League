package Vista.Usuario;

import Controlador.Main;
import Vista.Admin.Cruds.Usuario.vInsertarUsuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vRegistarUsuario {
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel panelCentrado;
    private JButton volverButton;
    private JButton insertarButton;
    private JTextField tfNombre;
    private JTextField tfTelefono;
    private JTextField tfCorreo;
    private JTextField tfContrasena;
    private JPanel pPrincipal;
    String admin = "NO";

    //Getter
    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    //Main


    public static void main(String[] args) {
        JFrame frame = new JFrame("vRegistarUsuario");
        frame.setContentPane(new vRegistarUsuario().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //Todo
    public vRegistarUsuario() {
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vRegistrarse.setVisible(false);
                Main.vPrincipal.setVisible(true);
            }
        });
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.registrarUsuario(tfNombre.getText(),tfContrasena.getText(),tfCorreo.getText(),tfTelefono.getText(),admin);
                    JOptionPane.showMessageDialog(null,"Usuario registrado correctamente");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }
}

