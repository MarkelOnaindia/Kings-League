package Vista.Admin.Cruds.Usuario;

import Controlador.Main;
import Vista.Admin.Cruds.Staff.vInsertarStaff;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vActualizarUsuario {
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel panelCentrado;
    private JButton volverButton;
    private JButton actualizarButton;
    private JTextField tfNombre;
    private JTextField tfTelefono;
    private JTextField tfCorreo;
    private JTextField tfContrasena;
    private JRadioButton siRadioButton;
    private JRadioButton noRadioButton;
    private JPanel pPrincipal;

    public vActualizarUsuario(){
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vActualizarUsuario.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("vActualizarUsuario");
        frame.setContentPane(new vActualizarUsuario().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}
