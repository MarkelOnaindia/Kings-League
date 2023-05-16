package Vista.Admin.Cruds.Temporada;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vTemporada {
    private JPanel pPrincipal;
    private JButton volverButton;

    //Getter
    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    //Main
    public static void main(String[] args) {
        JFrame frame = new JFrame("vTemporada");
        frame.setContentPane(new vTemporada().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //Todo
    public vTemporada() {
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vTemporada.setVisible(false);
                Main.vCRUD.setVisible(true);
            }
        });
    }
}
