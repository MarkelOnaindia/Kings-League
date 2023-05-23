package Vista.Admin.Cruds.ContratoJugador;

import Controlador.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class vConsultarContratoJugador extends JDialog{
    private JPanel contentPane;
    private JButton buttonCancel;
    private JComboBox cbIDJugador;



    //Getter
    public JPanel getpPrincipal() {
        return contentPane;
    }

    //Main
    public static void main(String[] args) {
        JFrame frame = new JFrame("vConsultarContratoJugador");
        frame.setContentPane(new vConsultarContratoJugador().contentPane);
        frame.pack();
        frame.setVisible(true);
    }

    //Todo
    public vConsultarContratoJugador() {
        Main.llenarCBContratoJugador(cbIDJugador);
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vCRUD.setVisible(true);
                Main.vConsultarContratoJugador.setVisible(false);
            }
        });
        cbIDJugador.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int idJug = Main.stringAInt(cbIDJugador.getSelectedItem().toString());
                try {
                    StringBuilder infoCJ = Main.consultarContratoJugador(idJug);
                    JOptionPane.showMessageDialog(null,infoCJ);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
