package Vista;

import Controlador.Main;
import Modelo.BaseDatos;
import Modelo.Usuario.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;


public class vPrincipal {
    private JPanel pPrincipal;
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel panelCentrado;
    private JPanel panelInicio;
    private JFormattedTextField ftfUsuario;
    private JPasswordField pfContrasena;
    private JButton bRegistrar;
    private JButton bIniciar;
    private JLabel logo;



    //Getter
    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    //Main
    public static void main(String[] args) {
        JFrame frame = new JFrame("vPrincipal");
        frame.setContentPane(new vPrincipal().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //Todo
    public vPrincipal() {

        bRegistrar.addActionListener(e -> {
            Main.crearVentanaRegistrarse();
        });

        bIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Usuario user = Main.inicarSesion(ftfUsuario.getText(),pfContrasena.getText());
                    if (user.getAdmin().equalsIgnoreCase("SI")){
                        Main.crearVentanaAdmin();
                    }else {
                        if (user.getAdmin().equalsIgnoreCase("NO")){
                            Main.crearVentanaUser();
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Usuario o clave incorrecto");               }
            }
        });
        bRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {Main.crearVentanaRegistrarse();

            }
        });
    }




}



