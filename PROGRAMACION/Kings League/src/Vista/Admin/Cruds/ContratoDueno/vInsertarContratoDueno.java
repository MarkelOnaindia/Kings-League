package Vista.Admin.Cruds.ContratoDueno;

import Controlador.Main;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;

public class vInsertarContratoDueno {
    private JPanel pPrincipal;
    private JComboBox cbPropietario;
    private JComboBox cbEquipo;
    private JFormattedTextField ftSueldo;
    private JFormattedTextField ftFechaInicio;
    private JFormattedTextField ftFechaFin;
    private JButton insertarButton;
    private JButton volverButton;
    private JTextField tfNombrePropietario;
    private JTextField tfNombreEquipo;
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel panelCentrado;
    private JPanel panelInicio;
    private JLabel logo;


    //Getter
    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    //Main
    public static void main(String[] args) {
        JFrame frame = new JFrame("vInsertarContratoDueno");
        frame.setContentPane(new vInsertarContratoDueno().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //Todo
    public vInsertarContratoDueno() {
        Main.llenarCBEquipo(cbEquipo);
        Main.llenarCBPropietario(cbPropietario);
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vInsertarContratoDueno.setVisible(false);
                Main.vContratoDueno.setVisible(true);
            }
        });
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.crearContratoDueno(cbPropietario.getSelectedItem().toString(),cbEquipo.getSelectedItem().toString(),ftSueldo.getText(),ftFechaInicio.getText(),ftFechaFin.getText());
                    JOptionPane.showMessageDialog(null,"Insercion Exitosa");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        cbPropietario.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String np = Main.nombrePropietario(cbPropietario.getSelectedItem().toString());
                tfNombrePropietario.setText(np);
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
