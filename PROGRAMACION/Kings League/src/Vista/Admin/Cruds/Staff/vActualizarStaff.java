package Vista.Admin.Cruds.Staff;

import Controlador.Main;
import Vista.Admin.Cruds.Propietario.vInsertarPropietario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vActualizarStaff {
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel panelCentrado;
    private JButton volverButton;
    private JButton actualizarButton;
    private JFormattedTextField ftfDNI;
    private JTextField tfNombre;
    private JTextField tfApellido1;
    private JTextField tfApellido2;
    private JTextField tfTelefono;
    private JTextField tfCorreo;
    private JTextField tfRol;
    private JComboBox cbIDStaff;
    private JPanel pPrincipal;

    public vActualizarStaff(){
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vActualizarStaff.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("vActualizarStaff");
        frame.setContentPane(new vActualizarStaff().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}
