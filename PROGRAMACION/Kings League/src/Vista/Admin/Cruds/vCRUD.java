package Vista.Admin.Cruds;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class vCRUD {
    private JPanel pPrincipal;
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel panelCentrado;
    private JPanel panelInicio;
    private JButton bAtras;
    private JLabel logo;
    private JComboBox comboBox1;

    //Getter
    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    //Main
    public static void main(String[] args) {
        JFrame frame = new JFrame("vCRUD");
        frame.setContentPane(new vCRUD().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //Todo
    public vCRUD() {
        Main.llenarCBtablas(comboBox1);


        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int selectedIndex = comboBox1.getSelectedIndex();
                switch (selectedIndex) {
                    case 1:
                        Main.crearVentanaContratoDueno();
                        break;
                    case 2:
                        Main.crearVentanaContratoEntrena();
                        break;
                    case 3:
                        Main.crearVentanaContratoJugador();
                        break;
                    case 4:
                        Main.crearVentanaContratoStaff();
                        break;
                    case 5:
                        Main.crearVentanaEntrenador();
                        break;
                    case 6:
                        Main.crearVentanaEquipo();
                        break;
                    case 7:
                        Main.crearVentanaJornada();
                        break;
                    case 8:
                        Main.crearVentanaJugador();
                        break;
                    case 9:
                        Main.crearVentanaPartido();
                        break;
                    case 10:
                        Main.crearVentanaPropietario();
                        break;
                    case 11:
                        Main.crearVentanaStaff();
                        break;
                    case 12:
                        Main.crearVentanaTemporada();
                        break;
                    case 13:
                        Main.crearVentanaUsuario();
                        break;
                }
            }
        });
    }

}
