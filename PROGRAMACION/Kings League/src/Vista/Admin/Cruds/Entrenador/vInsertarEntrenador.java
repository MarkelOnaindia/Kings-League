package Vista.Admin.Cruds.Entrenador;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vInsertarEntrenador {
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel panelCentrado;
    private JButton volverButton;
    private JButton insertarButton;
    private JTextField tfNombre;
    private JFormattedTextField ftfDNI;
    private JTextField tfApellido1;
    private JTextField tfApellido2;
    private JTextField tfTelefono;
    private JTextField tfCorreo;
    private JPanel pPrincipal;

    public vInsertarEntrenador(){
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vInsertarEntrenador.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("vInsertarEntrenador");
        frame.setContentPane(new vInsertarEntrenador().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}
