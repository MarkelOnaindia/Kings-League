package Vista.Admin.Cruds.Equipo;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vBorrarEquipo extends JDialog{
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel panelCentrado;
    private JButton volverButton;
    private JButton borrarButton;
    private JComboBox cbNombre;
    private JPanel pPrincipal;

    public vBorrarEquipo(){
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vBorrarEquipo.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("vBorrarEquipo");
        frame.setContentPane(new vBorrarEquipo().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}
