package Vista.Admin.Cruds.Jornada;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vActualizarJornada {
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel panelCentrado;
    private JTextField tfNumero;
    private JButton volverButton;
    private JButton actualizarButton;
    private JComboBox cbIDTemp;
    private JTextField tfDia;
    private JRadioButton faseRegularRadioButton;
    private JRadioButton playOffsRadioButton;
    private JPanel pPrincipal;

    public vActualizarJornada(){
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vActualizarJornada.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("vActualizarJornada");
        frame.setContentPane(new vActualizarJornada().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}
