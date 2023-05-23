package Vista.Admin.Cruds.ContratoStaff;

import javax.swing.*;

public class vBorrarContratoStaff extends JDialog {
    private JPanel contentPane;
    private JButton buttonCancel;
    private JComboBox cbIDStaff;
    private JTextField tfEquipo;
    private JTextField tfEntrenador;
    private JButton buttonOK;
    private JPanel pPrincipal;

    //Getter
    public JPanel getpPrincipal() {
        return contentPane;
    }

    //Main
    public static void main(String[] args) {
        JFrame frame = new JFrame("vBorrarContratoStaff");
        frame.setContentPane(new vBorrarContratoStaff().getpPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
