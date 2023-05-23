package Vista.Admin.Cruds.Equipo;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vConsultarEquipo extends JDialog{
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel panelCentrado;
    private JButton volverButton;
    private JButton consultarButton;
    private JComboBox cbNombre;
    private JPanel pPrincipal;

    public vConsultarEquipo(){
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vConsultarEquipo.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("vConsultarEquipo");
        frame.setContentPane(new vConsultarEquipo().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}
