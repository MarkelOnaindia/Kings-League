package Vista.Usuario;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vEquipos {
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JMenu equiposMenu;
    private JMenu clasificacionMenu;
    private JMenu partidosMenu;
    private JPanel panelCentrado;
    private JLabel ImagenTroncos;
    private JLabel ImagenPio;
    private JLabel ImagenPorcinos;
    private JLabel ImagenRayo;
    private JLabel ImagenSaiyans;
    private JLabel imagenMostoles;
    private JLabel ImagenXbuyer;
    private JPanel pPrincipal;
    private JMenuItem verEquipos;
    private JMenuItem verClasificacion;
    private JMenuItem verPartidos;
    private JMenu mhome;
    private JMenuItem verhome;

    public vEquipos(){
        verhome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaUser();
                Main.verEquipos.setVisible(false);
            }
        });
        verClasificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.verClasificacion();
                Main.verEquipos.setVisible(false);
            }
        });

        verPartidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.verPartidos();
                Main.verEquipos.setVisible(false);
            }
        });
    }

    //Getter
    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    //Main
    public static void main(String[] args) {
        JFrame frame = new JFrame("vEquipos");
        frame.setContentPane(new vEquipos().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
