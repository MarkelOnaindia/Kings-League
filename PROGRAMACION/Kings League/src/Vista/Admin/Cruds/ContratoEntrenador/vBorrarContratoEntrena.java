package Vista.Admin.Cruds.ContratoEntrenador;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;

public class vBorrarContratoEntrena extends JDialog {
    private JComboBox<String> cbIDEntrena;
    private JTextField tfEntrenador;
    private JTextField tfEquipo;
    private JButton buttonCancel;
    private JButton buttonOK;
    private JPanel contentPane;

    public vBorrarContratoEntrena() {
        Main.llenarCBContratoEntrenador(cbIDEntrena);
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

        cbIDEntrena.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String nen = Main.nenIDConen(cbIDEntrena.getSelectedItem().toString());
                String ne = Main.neIDConen(cbIDEntrena.getSelectedItem().toString());
                tfEntrenador.setText(nen);
                tfEquipo.setText(ne);
            }
        });
    }

    private void onOK() {
        // add your code here
        int idEntrena = Main.stringAInt(cbIDEntrena.getSelectedItem().toString());
        try {
            Main.borrarContratoEntrena(idEntrena);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    // Main
    public static void main(String[] args) {
        vBorrarContratoEntrena dialog = new vBorrarContratoEntrena();
        dialog.pack();
        dialog.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
