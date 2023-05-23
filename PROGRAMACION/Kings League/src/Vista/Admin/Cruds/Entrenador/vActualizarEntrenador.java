package Vista.Admin.Cruds.Entrenador;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vActualizarEntrenador {
    private JPanel panelArriba;
    private JPanel panelAbajo;
    private JPanel panelCentrado;
    private JTextField tfNombre;
    private JTextField tfApellido1;
    private JTextField tfApellido2;
    private JTextField tfTelefono;
    private JTextField tfCorreo;
    private JButton volverButton;
    private JButton actualizarButton;
    private JComboBox cbDNI;
    private JPanel pPrincipal;

    public vActualizarEntrenador(){
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vActualizarEntrenador.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("vActualizarEntrenador");
        frame.setContentPane(new vActualizarEntrenador().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}
