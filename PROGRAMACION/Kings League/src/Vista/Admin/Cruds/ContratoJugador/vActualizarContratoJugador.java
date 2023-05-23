package Vista.Admin.Cruds.ContratoJugador;

import Controlador.Main;
import Modelo.Duenos.ContratoDueno;
import Vista.Admin.Cruds.ContratoEntrenador.vActualizarContratoEntrena;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;

public class vActualizarContratoJugador {
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel panelCentrado;
    private JTextField tfNombrePropietario;
    private JTextField tfNombreEquipo;
    private JFormattedTextField ftSueldo;
    private JFormattedTextField ftFechaInicio;
    private JFormattedTextField ftFechaFin;
    private JButton volverButton;
    private JButton insertarButton;
    private JTextField tfIDJug;
    private JTextField tfIDEquipo;
    private JComboBox cbIDDueno;
    private JPanel pPrincipal;

    //Getter
    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    //Main
    public static void main(String[] args) {
        JFrame frame = new JFrame("vActualizarContratoDueno");
        frame.setContentPane(new vActualizarContratoJugador().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //Todo
    public vActualizarContratoJugador() {
        Main.llenarCBContratoDueno(cbIDDueno);
        cbIDDueno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                valores();
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vActualizarContratoDueno.setVisible(false);
                Main.vContratoDueno.setVisible(true);
            }
        });
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idCondu = Main.stringAInt(cbIDDueno.getSelectedItem().toString());
                int idPro = Main.stringAInt(tfIDJug.getText());
                int idEquipo = Main.stringAInt(tfIDEquipo.getText());
                int sueldo = Main.stringAInt(ftSueldo.getText());
                try {
                    Main.actualizarContratoDueno(idCondu,idPro,idEquipo,sueldo,ftFechaInicio.getText(),ftFechaFin.getText());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public void valores(){
        int idDueno = Main.stringAInt(cbIDDueno.getSelectedItem().toString());
        try {
            ContratoDueno cd1 = Main.consultarDatosContratoDueno(idDueno);
            String np = Main.nombrePropietario(tfIDJug.getText());
            String ne = Main.nombreEquipo(tfIDEquipo.getText());

            tfIDEquipo.setText(String.valueOf(cd1.getEquipo().getIdEquipo()));
            tfIDJug.setText(String.valueOf(cd1.getPropietario().getIdPro()));
            tfNombrePropietario.setText(np);
            tfNombreEquipo.setText(ne);
            ftSueldo.setText(String.valueOf(cd1.getSueldo()));
            ftFechaInicio.setText(String.valueOf(cd1.getFechainicio()));
            ftFechaFin.setText(String.valueOf(cd1.getFechaFin()));

            cbIDDueno.setEditable(false);
            tfIDEquipo.setEditable(true);
            tfIDJug.setEditable(true);
            tfNombrePropietario.setEditable(true);
            tfNombreEquipo.setEditable(true);
            ftSueldo.setEditable(true);
            ftFechaInicio.setEditable(true);
            ftFechaFin.setEditable(true);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
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

