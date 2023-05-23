package Vista.Admin.Cruds.ContratoJugador;

import Controlador.Main;
import Vista.Admin.Cruds.ContratoEntrenador.vContratoEntrena;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vContratoJugador {
    private JPanel pPrincipal;
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JButton volverButton;
    private JPanel panelCentrado;
    private JPanel panelInicio;
    private JButton insertarButton;
    private JButton borrarButton;
    private JButton consultarButton;
    private JButton actualizarButton;

    //Getter
    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    //Main
    public static void main(String[] args) {
        JFrame frame = new JFrame("vContratoJugador");
        frame.setContentPane(new vContratoJugador().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //Todo
    public vContratoJugador() {
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vContratoEntrena.setVisible(false);
                Main.vCRUD.setVisible(true);
            }
        });
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaInsertarContratoJugador();
            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBorrarContratoJugador();
            }
        });
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaConsultarContratoJugador();
            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaActualizarContratoJugador();
            }
        });
    }
}