package Vista.Admin;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class vJornadas {
    private JPanel Jpanel;
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel panelCentrado;
    private JPanel panelInicio;
    private JLabel logo;
    private JComboBox cbJornada;
    private JComboBox cbTemporada;
    private JPanel pPrincipal;



    //Getter
    public JPanel getpPrincipal() {
        return Jpanel;
    }

    //Main
    public static void main(String[] args) {
        JFrame frame = new JFrame("vJornadas");
        frame.setContentPane(new vJornadas().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //Todo
    public vJornadas() {
        Main.llenarCBTemporadas(cbTemporada);
        cbTemporada.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int idTemp = Main.stringAInt(cbTemporada.getSelectedItem().toString());
                Main.llenarCbJornadas(cbJornada,idTemp);
            }
        });
        cbJornada.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int idJor = Main.stringAInt(cbJornada.getSelectedItem().toString());
                /*Main.mostrarJornada(idJor);*/
            }
        });
    }
}
