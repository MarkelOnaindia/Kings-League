package Vista.Usuario;

import Controlador.Main;
import Modelo.Equipos.Equipo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class vClasificacion {
    private JPanel panelAbajo;
    private JPanel panelArriba;
    private JPanel panelCentrado;
    private JPanel panelClasificacion;
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
    private JPanel pPrincipal;
    private JMenu equiposMenu;
    private JMenu clasificacionMenu;
    private JMenu partidosMenu;
    private JMenuItem verEquipos;
    private JMenuItem verClasificacion;
    private JMenuItem verPartidos;
    private JMenu mhome;
    private JMenuItem verhome;

    public vClasificacion(){
        verhome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaUser();
                Main.verClasificacion.setVisible(false);
            }
        });
        verEquipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.verEquipos();
                Main.verClasificacion.setVisible(false);
            }
        });

        verPartidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.verPartidos();
                Main.verClasificacion.setVisible(false);
            }
        });

        //Generar la clasificacion
    try {
       //Sacar datos
       ArrayList<Object> clasificacion = Main.generarClasificacion();
       ArrayList<Equipo> equipo = (ArrayList<Equipo>) clasificacion.get(0);
       ArrayList<Integer> victorias = (ArrayList<Integer>) clasificacion.get(1);
       ArrayList<Integer> diferenciaGoles = (ArrayList<Integer>) clasificacion.get(2);
       ArrayList<Integer> posicion = (ArrayList<Integer>) clasificacion.get(3);

       //Colocar datos
       //Nombres
       nombreEquipo1.setText(equipo.get(0).getNombre());
       nombreEquipo2.setText(equipo.get(1).getNombre());
       nombreEquipo3.setText(equipo.get(2).getNombre());
       nombreEquipo4.setText(equipo.get(3).getNombre());
       nombreEquipo5.setText(equipo.get(4).getNombre());
       nombreEquipo6.setText(equipo.get(5).getNombre());
       nombreEquipo7.setText(equipo.get(6).getNombre());
       nombreEquipo8.setText(equipo.get(7).getNombre());
       nombreEquipo9.setText(equipo.get(8).getNombre());
       nombreEquipo10.setText(equipo.get(9).getNombre());
       nombreEquipo11.setText(equipo.get(10).getNombre());
       nombreEquipo12.setText(equipo.get(11).getNombre());

       //Victorias
       puntosEquipo1.setText(victorias.get(0).toString());
       puntosEquipo2.setText(victorias.get(1).toString());
       puntosEquipo3.setText(victorias.get(2).toString());
       puntosEquipo4.setText(victorias.get(3).toString());
       puntosEquipo5.setText(victorias.get(4).toString());
       puntosEquipo6.setText(victorias.get(5).toString());
       puntosEquipo7.setText(victorias.get(6).toString());
       puntosEquipo8.setText(victorias.get(7).toString());
       puntosEquipo9.setText(victorias.get(8).toString());
       puntosEquipo10.setText(victorias.get(9).toString());
       puntosEquipo11.setText(victorias.get(10).toString());
       puntosEquipo12.setText(victorias.get(11).toString());

       //Diferencia goles
       diferenciaEquipo1.setText(diferenciaGoles.get(0).toString());
       diferenciaEquipo2.setText(diferenciaGoles.get(1).toString());
       diferenciaEquipo3.setText(diferenciaGoles.get(2).toString());
       diferenciaEquipo4.setText(diferenciaGoles.get(3).toString());
       diferenciaEquipo5.setText(diferenciaGoles.get(4).toString());
       diferenciaEquipo6.setText(diferenciaGoles.get(5).toString());
       diferenciaEquipo7.setText(diferenciaGoles.get(6).toString());
       diferenciaEquipo8.setText(diferenciaGoles.get(7).toString());
       diferenciaEquipo9.setText(diferenciaGoles.get(8).toString());
       diferenciaEquipo10.setText(diferenciaGoles.get(9).toString());
       diferenciaEquipo11.setText(diferenciaGoles.get(10).toString());
       diferenciaEquipo12.setText(diferenciaGoles.get(11).toString());
    } catch (Exception e) {
       throw new RuntimeException(e);
    }

    }

    //Getter
    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    //Main
    public static void main(String[] args) {
        JFrame frame = new JFrame("vClasificacion");
        frame.setContentPane(new vClasificacion().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
