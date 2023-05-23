package Vista.Admin.Cruds.ContratoEntrenador;

import Controlador.Main;


import javax.swing.*;
import java.awt.event.*;

public class vConsultarContratoEntrena extends JDialog {
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox cbIDEntrena;
    private JPanel contentPane;


    //Todo
    public vConsultarContratoEntrena() {
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
                int idEntrena = Main.stringAInt(cbIDEntrena.getSelectedItem().toString());
                try {
                    StringBuilder infoCE = Main.consultarContratoEntrenador(idEntrena);
                    JOptionPane.showMessageDialog(null,infoCE);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    //Main
    public static void main(String[] args) {
        vConsultarContratoEntrena dialog = new vConsultarContratoEntrena();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
