package Vista.Admin;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vHomeAdmin {
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel panelCentrado;
    private JPanel panelInicio;
    private JButton bSalir;
    private JLabel logo;
    private JButton bCRUD;
    private JButton bintroducirResultados;
    private JButton bGenerarPlayOffs;
    private JButton bResultadosJornadas;
    private JPanel pPrincipal;

    //Getter
    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    //Main
    public static void main(String[] args) {
        JFrame frame = new JFrame("vHomeAdmin");
        frame.setContentPane(new vHomeAdmin().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //Todo
    public vHomeAdmin() {
        bCRUD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaCRUD();
            }
        });
        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        bResultadosJornadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaVerJornadas();
            }
        });
    }
}
