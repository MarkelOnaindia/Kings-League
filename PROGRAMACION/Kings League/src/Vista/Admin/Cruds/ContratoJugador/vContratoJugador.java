package Vista.Admin.Cruds.ContratoJugador;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vContratoJugador {
    private JPanel pPrincipal;
    private JButton volverButton;

    //Getter
    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    //Main
    public static void main(String[] args) {
        JFrame frame = new JFrame("vContratoJugador");
        frame.setContentPane(new vContratoJugador().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //Todo
    public vContratoJugador() {
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vContratoJugador.setVisible(false);
                Main.vCRUD.setVisible(true);
            }
        });
    }
}
