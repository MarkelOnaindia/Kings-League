package Vista.Admin.Cruds.Jornada;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vBorrarJornada extends JDialog {
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel panelCentrado;
    private JTextField tfNumero;
    private JButton volverButton;
    private JButton borrarButton;
    private JComboBox cbIDJornada;
    private JTextField tfIdTemp;
    private JPanel pPrincipal;

    public vBorrarJornada(){
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vBorrarJornada.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("vBorrarJornada");
        frame.setContentPane(new vBorrarJornada().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}
