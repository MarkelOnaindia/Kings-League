package Vista.Admin.Cruds.ContratoStaff;

import javax.swing.*;

public class vConsultarContratoStaff extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox cbIDStaff;
    private JPanel pPrincipal;

    //Getter
    public JPanel getpPrincipal() {
        return contentPane;
    }

    //Main
    public static void main(String[] args) {
        JFrame frame = new JFrame("vConsultarContratoStaff");
        frame.setContentPane(new vConsultarContratoStaff().getpPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
