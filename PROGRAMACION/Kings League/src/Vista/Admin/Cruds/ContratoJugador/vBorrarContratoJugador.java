package Vista.Admin.Cruds.ContratoJugador;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class vBorrarContratoJugador extends JDialog {
    private JPanel contentPane;
    private JButton buttonCancel;
    private JComboBox cbIDContratoJugador;
    private JTextField tfEquipo;
    private JTextField tfJugador;
    private JButton buttonOK;
    private JPanel pPrincipal;

    public vBorrarContratoJugador() {
        Main.llenarCBContratoJugador(cbIDContratoJugador);
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vBorrarContratoJugador.setVisible(false);
            }
        });
    }

    //Getter
    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    //Main
    public static void main(String[] args) {
        JFrame frame = new JFrame("vBorrarContratoJugador");
        frame.setContentPane(new vBorrarContratoJugador().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
