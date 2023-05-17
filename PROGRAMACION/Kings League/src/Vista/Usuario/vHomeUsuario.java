package Vista.Usuario;

import javax.swing.*;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.Icon;

public class vHomeUsuario {
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel panelCentrado;
    private JLabel jlNoticias;
    private JPanel pPrinciapl;
    private JPanel panelClasificacion;
    private JLabel jlequipo1;
    private JLabel jlequipo2;
    private JLabel jlequipo3;
    private JLabel jlequipo4;
    private JLabel jlequipo5;
    private JLabel jlequipo6;
    private JLabel jlequipo7;
    private JLabel jlequipo8;
    private JLabel jlequipo9;
    private JLabel jlequipo10;
    private JLabel jlequipo11;
    private JLabel jlequipo12;
    private JLabel a1Label;
    private JLabel a2Label;
    private JLabel a3Label;
    private JLabel a4Label;
    private JLabel a5Label;
    private JLabel a6Label;
    private JLabel a7Label;
    private JLabel a8Label;
    private JLabel a9Label;
    private JLabel a10Label;
    private JLabel a11Label;
    private JLabel a12Label;
    private JLabel nombreEquipo1;
    private JLabel nombreEquipo2;
    private JLabel nombreEquipo3;
    private JLabel nombreEquipo4;
    private JLabel nombreEquipo5;
    private JLabel nombreEquipo6;
    private JLabel nombreEquipo7;
    private JLabel nombreEquipo8;
    private JLabel nombreEquipo9;
    private JLabel nombreEquipo10;
    private JLabel nombreEquipo11;
    private JLabel nombreEquipo12;
    private JLabel puntosEquipo1;
    private JLabel puntosEquipo2;
    private JLabel puntosEquipo3;
    private JLabel puntosEquipo4;
    private JLabel puntosEquipo5;
    private JLabel puntosEquipo6;
    private JLabel puntosEquipo7;
    private JLabel puntosEquipo8;
    private JLabel puntosEquipo9;
    private JLabel puntosEquipo10;
    private JLabel puntosEquipo11;
    private JLabel puntosEquipo12;
    private JLabel partidosequipo1;
    private JLabel partidosequipo2;
    private JLabel partidosequipo3;
    private JLabel partidosequipo4;
    private JLabel partidosequipo5;
    private JLabel partidosequipo6;
    private JLabel partidosequipo7;
    private JLabel partidosequipo8;
    private JLabel partidosequipo9;
    private JLabel partidosequipo10;
    private JLabel partidosequipo11;
    private JLabel partidosequipo12;
    private JLabel diferenciaEquipo1;
    private JLabel diferenciaEquipo2;
    private JLabel diferenciaEquipo3;
    private JLabel diferenciaEquipo4;
    private JLabel diferenciaEquipo5;
    private JLabel diferenciaEquipo6;
    private JLabel diferenciaEquipo7;
    private JLabel diferenciaEquipo8;
    private JLabel diferenciaEquipo9;
    private JLabel diferenciaEquipo10;
    private JLabel diferenciaEquipo11;
    private JLabel diferenciaEquipo12;
    private JMenu equiposMenu;
    private JMenu clasificacionMenu;
    private JMenu partidosMenu;

    static int contador = 0;

    public vHomeUsuario() {

    }

    public static void main(String[] args) {
        int velocidad = 2; // segundos

        Timer timer;
        TimerTask tarea;
        int velmil = velocidad * 2500;

        JFrame frame = new JFrame("vHomeUsuario");
        vHomeUsuario homeUsuario = new vHomeUsuario(); // Crear una instancia de vHomeUsuario
        frame.setContentPane(homeUsuario.pPrinciapl);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        tarea = new TimerTask() {
            @Override
            public void run() {
                Icon icono;

                switch (contador) {
                    case 0:
                        contador = 1;
                        icono = new ImageIcon(getClass().getResource("/Imagenes/Noticias/piquex400x333.jpg"));
                        homeUsuario.jlNoticias.setIcon(icono);
                        break;
                    case 1:
                        contador = 2;
                        icono = new ImageIcon(getClass().getResource("/Imagenes/Noticias/1kx500x300.jpg"));
                        homeUsuario.jlNoticias.setIcon(icono);
                        break;
                    case 2:
                        contador = 3;
                        icono = new ImageIcon(getClass().getResource("/Imagenes/Noticias/accionJuegox500x300.jpeg"));
                        homeUsuario.jlNoticias.setIcon(icono);
                        break;
                    case 3:
                        contador = 4;
                        icono = new ImageIcon(getClass().getResource("/Imagenes/Noticias/balonx500x300.jpg"));
                        homeUsuario.jlNoticias.setIcon(icono);
                        break;
                    case 4:
                        contador = 0;
                        icono = new ImageIcon(getClass().getResource("/Imagenes/Noticias/troncosdosx500x333.jpg"));
                        homeUsuario.jlNoticias.setIcon(icono);
                        break;
                }
            }
        };

        timer = new Timer();
        timer.scheduleAtFixedRate(tarea, velmil, velmil);
    }
}
