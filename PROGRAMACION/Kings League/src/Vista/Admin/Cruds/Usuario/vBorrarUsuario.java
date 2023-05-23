package Vista.Admin.Cruds.Usuario;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vBorrarUsuario extends JDialog {
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel panelCentrado;
    private JButton volverButton;
    private JButton borrarButton;
    private JComboBox cbIDUsuario;
    private JTextField tfNombre;
    private JPanel pPrincipal;

    public vBorrarUsuario(){
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vBorrarUsuario.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("vBorrarUsuario");
        frame.setContentPane(new vBorrarUsuario().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}
