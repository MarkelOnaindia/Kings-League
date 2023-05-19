package Vista.Admin.Cruds.Jugador;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vActualizarJugador {
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel panelCentrado;
    private JTextField tfPosicionDraft;
    private JButton volverButton;
    private JButton actualizarButton;
    private JTextField tfpie;
    private JComboBox comboBox1;
    private JTextField tfDNI;
    private JTextField tfNombre;
    private JTextField tfApellido1;
    private JTextField tfApellido2;
    private JTextField tfTelefono;
    private JTextField tfCorreo;
    private JTextField tfIDJugador;
    private JPanel pPrincipal;

    public vActualizarJugador(){
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vActualizarJugador.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("vActualizarJugador");
        frame.setContentPane(new vActualizarJugador().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}
