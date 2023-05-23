package Vista.Admin.Cruds.ContratoJugador;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vBorrarContratoJugador extends JDialog {
    private JPanel contentPane;
    private JButton buttonCancel;
    private JComboBox cbIDJugador;
    private JTextField tfEquipo;
    private JTextField tfEntrenador;
    private JButton buttonOK;
    private JPanel pPrincipal;

    public vBorrarContratoJugador() {
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
