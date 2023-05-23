package Vista.Admin.Cruds.Usuario;

import Controlador.Main;
import Vista.Admin.Cruds.ContratoEntrenador.vInsertarContratoEntrena;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;

public class vInsertarUsuario {
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel panelCentrado;
    private JButton volverButton;
    private JButton insertarButton;
    private JTextField tfNombre;
    private JTextField tfTelefono;
    private JTextField tfCorreo;
    private JTextField tfContrasena;
    private JRadioButton siRadioButton;
    private JRadioButton noRadioButton;
    private JPanel pPrincipal;
    String admin = "";

    //Getter
    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    //Main


    public static void main(String[] args) {
        JFrame frame = new JFrame("vInsertarUsuario");
        frame.setContentPane(new vInsertarUsuario().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //Todo
    public vInsertarUsuario() {
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vInsertarUsuario.setVisible(false);
                Main.vUsuario.setVisible(true);
            }
        });
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (siRadioButton.isSelected()){
                        admin = "SI";

                    }
                    else{
                        admin = "NO";

                    }
                    Main.crearUsuario(tfNombre.getText(),tfContrasena.getText(),tfCorreo.getText(),tfTelefono.getText(),admin);
                    JOptionPane.showMessageDialog(null,"Insercion Exitosa");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }
}
