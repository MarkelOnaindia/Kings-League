package Vista.Admin.Cruds.ContratoDueno;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vContratoDueno {
    private JPanel pPrincipal;
    private JButton volverButton;
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
        JFrame frame = new JFrame("vContratoDueno");
        frame.setContentPane(new vContratoDueno().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //Todo
    public vContratoDueno() {
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vContratoDueno.setVisible(false);
                Main.vCRUD.setVisible(true);
            }
        });
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaInsertarContratoDueno();
            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBorrarContratoDueno();
            }
        });
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaConsultarContratoDueno();
            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaActualizarContratoDueno();
            }
        });
    }
}
