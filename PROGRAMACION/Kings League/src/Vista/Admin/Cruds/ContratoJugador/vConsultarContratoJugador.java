package Vista.Admin.Cruds.ContratoJugador;

import javax.swing.*;

public class vConsultarContratoJugador extends JDialog{
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox cbIDJugador;

    //Getter
    public JPanel getpPrincipal() {
        return contentPane;
    }

    //Main
    public static void main(String[] args) {
        JFrame frame = new JFrame("vConsultarContratoJugador");
        frame.setContentPane(new vConsultarContratoJugador().contentPane);
        frame.pack();
        frame.setVisible(true);
    }
}
