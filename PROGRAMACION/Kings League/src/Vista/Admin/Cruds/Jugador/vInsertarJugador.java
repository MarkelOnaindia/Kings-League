package Vista.Admin.Cruds.Jugador;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vInsertarJugador {
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel panelCentrado;
    private JTextField tfPosicionDraft;
    private JButton volverButton;
    private JButton insertarButton;
    private JTextField tfpie;
    private JComboBox comboBox1;
    private JTextField tfDNI;
    private JTextField tfNombre;
    private JTextField tfTelefono;
    private JTextField tfCorreo;
    private JTextField tfApellido2;
    private JTextField tfApellido1;
    private JPanel pPrincipal;

    public vInsertarJugador(){
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vInsertarJugador.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("vInsertarJugador");
        frame.setContentPane(new vInsertarJugador().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}
