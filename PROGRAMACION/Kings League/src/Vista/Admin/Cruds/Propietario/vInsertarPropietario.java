package Vista.Admin.Cruds.Propietario;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vInsertarPropietario {
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel pPrincipal;
    private JPanel panelCentrado;
    private JButton volverButton;
    private JButton insertarButton;
    private JFormattedTextField ftfDNI;
    private JTextField tfNombre;
    private JTextField tfApellido1;
    private JTextField tfApellido2;
    private JTextField tfTelefono;
    private JTextField tfCorreo;

    public vInsertarPropietario(){
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vInsertarPropietario.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("vInsertarPropietario");
        frame.setContentPane(new vInsertarPropietario().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}
