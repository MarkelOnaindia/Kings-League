package Vista.Admin.Cruds.Partido;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vActualizarPartido {
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel panelCentrado;
    private JButton volverButton;
    private JButton actualizarButton;
    private JComboBox cbIDJornada;
    private JFormattedTextField ftfHora;
    private JFormattedTextField ftfgoles1;
    private JFormattedTextField ftfgoles2;
    private JComboBox cbEquipog;
    private JComboBox cbEquipop;
    private JTextField tfGanador;
    private JTextField tfPerdedor;
    private JPanel pPrincipal;
    private JComboBox ftfIDPartido;

    public vActualizarPartido(){
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vActualizarPartido.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("vActualizarPartido");
        frame.setContentPane(new vActualizarPartido().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}
