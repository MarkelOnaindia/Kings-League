package Vista.Admin.Cruds.Equipo;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vActualizarEquipo {
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel panelCentrado;
    private JTextField tfEscudo;
    private JTextField tfEquipacion;
    private JButton volverButton;
    private JButton insertarButton;
    private JFormattedTextField ftfPresupuesto;
    private JComboBox cbNombre;
    private JPanel pPrincipal;

    public vActualizarEquipo(){
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vActualizarEquipo.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("vActualizarEquipo");
        frame.setContentPane(new vActualizarEquipo().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}
