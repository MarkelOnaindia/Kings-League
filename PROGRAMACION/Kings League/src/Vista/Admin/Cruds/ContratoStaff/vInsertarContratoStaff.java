package Vista.Admin.Cruds.ContratoStaff;

import Controlador.Main;
import Vista.Admin.Cruds.ContratoJugador.vInsertarContratoJugador;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;

public class vInsertarContratoStaff {
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel panelInicio;
    private JComboBox cbStaff;
    private JTextField tfNombreEntrenador;
    private JComboBox cbEquipo;
    private JTextField tfNombreEquipo;
    private JFormattedTextField ftSueldo;
    private JFormattedTextField ftFechaInicio;
    private JFormattedTextField ftFechaFin;
    private JButton volverButton;
    private JButton insertarButton;
    private JPanel pPrincipal;

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    //Main
    public static void main(String[] args) {
        JFrame frame = new JFrame("vInsertarContratoDueno");
        frame.setContentPane(new vInsertarContratoStaff().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //Todo
    public vInsertarContratoStaff() {
        Main.llenarCBEquipo(cbEquipo);
        Main.llenarCBContratoEntrenador(cbEquipo);
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vInsertarContratoEntrenador.setVisible(false);
                Main.vContratoEntrena.setVisible(true);
            }
        });
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.crearContratoEntrenador(cbEquipo.getSelectedItem().toString(),cbEquipo.getSelectedItem().toString(),ftSueldo.getText(),ftFechaInicio.getText(),ftFechaFin.getText());
                    JOptionPane.showMessageDialog(null,"Insercion Exitosa");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        cbEquipo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String ne = Main.nombreEntrenador(cbEquipo.getSelectedItem().toString());
                tfNombreEntrenador.setText(ne);
            }
        });
        cbEquipo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String ne = Main.nombreEquipo(cbEquipo.getSelectedItem().toString());
                tfNombreEquipo.setText(ne);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        try {
            ftSueldo = new JFormattedTextField(new MaskFormatter("###########"));
            ftFechaInicio = new JFormattedTextField(new MaskFormatter("##/##/####"));
            ftFechaFin = new JFormattedTextField(new MaskFormatter("##/##/####"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

