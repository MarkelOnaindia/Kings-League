package Vista.Admin.Cruds.ContratoDueno;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;

public class vBorrarContratoDueno extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox cbIDDueno;
    private JTextField tfPropietario;
    private JTextField tfEquipo;


    //Todo
    public vBorrarContratoDueno() {
        Main.llenarCBContratoDueno(cbIDDueno);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        cbIDDueno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String np = Main.npIDCondu(cbIDDueno.getSelectedItem().toString());
                String ne = Main.neIDCondu(cbIDDueno.getSelectedItem().toString());
                tfPropietario.setText(np);
                tfEquipo.setText(ne);
            }
        });
    }

    private void onOK() {
        // add your code here
        int idDueno = Main.stringAInt(cbIDDueno.getSelectedItem().toString());
        try {
            Main.borrarContratoDueno(idDueno);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


    //Main
    public static void main(String[] args) {
        vBorrarContratoDueno dialog = new vBorrarContratoDueno();
        dialog.pack();
        dialog.setVisible(true);
    }
}
