package Controlador;

import Modelo.BaseDatos;
import Modelo.Duenos.*;
import Modelo.Entrenadores.*;
import Modelo.Equipos.*;
import Modelo.Jornada.*;
import Modelo.Jugadores.*;
import Modelo.Partido.*;
import Modelo.Propietario.*;
import Modelo.Staff.*;
import Modelo.Temporada.*;
import Modelo.Usuario.*;
import Vista.Admin.Cruds.ContratoDueno.*;
import Vista.Admin.Cruds.ContratoEntrenador.*;
import Vista.Admin.Cruds.ContratoJugador.*;
import Vista.Admin.Cruds.ContratoJugador.vConsultarContratoJugador;
import Vista.Admin.Cruds.ContratoStaff.*;
import Vista.Admin.Cruds.Entrenador.*;
import Vista.Admin.Cruds.Equipo.*;
import Vista.Admin.Cruds.Jornada.*;
import Vista.Admin.Cruds.Jugador.*;
import Vista.Admin.Cruds.Partido.*;
import Vista.Admin.Cruds.Propietario.*;
import Vista.Admin.Cruds.Staff.*;
import Vista.Admin.Cruds.Temporada.*;
import Vista.Admin.Cruds.Usuario.*;
import Vista.Admin.Cruds.vCRUD;
import Vista.Admin.vHomeAdmin;
import Vista.Admin.vJornadas;
import Vista.Usuario.*;
import Vista.vPrincipal;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    //JFrame Principal

    public static  JFrame vPrincipal;

    //JFrames ventana del Admin
    public static JFrame vAdmin;

    //JFrame del user
    public static JFrame vUser;

        //JFrame para ver los Equipos
        public static JFrame verEquipos;

        //JFrame para ver la Clasificacion
        public static JFrame verClasificacion;

        //JFrame para ver los Partidos
        public static JFrame verPartidos;

        //JFrame para ver jornadas
        public static JFrame verJornadas;

    //Registrarse
    public static JFrame vRegistrarse;

        //JFrames ventana del CRUD
        public static JFrame vCRUD;

                //JFrames del ContratoDueno
                public static JFrame vContratoDueno;
                    public static JFrame vInsertarContratoDueno;
                    public static JFrame vActualizarContratoDueno;
                    public static JDialog vBorrarContratoDueno;
                    public static JDialog vConsultarContratoDueno;

                //JFrames del ContratoEntrenador
                public static JFrame vContratoEntrena;

                    public static JFrame vInsertarContratoEntrenador;
                    public static JFrame vActualizarContratoEntrenador;
                    public static JDialog vConsultarContratoEntrenador;
                    public static JDialog vBorrarContratoEntrenador;




                //JFrames del ContratoJugador
                public static JFrame vContratoJugador;

                    public static JFrame vInsertarContratoJugador;
                    public static JFrame vActualizarContratoJugador;
                    public static JDialog vConsultarContratoJugador;
                    public static JDialog vBorrarContratoJugador;


                //JFrames del ContratoStaff
                public static JFrame vContratoStaff;

                    public static JFrame vInsertarContratoStaff;
                    public static JFrame vActualizarContratoStaff;
                    public static JDialog vConsultarContratoStaff;
                    public static JDialog vBorrarContratoStaff;


                //JFrames del Entrenador
                public static JFrame vEntrenador;

                    public static JFrame vInsertarEntrenador;
                    public static JFrame vActualizarEntrenador;
                    public static JDialog vConsultarEntrenador;
                    public static JDialog vBorrarEntrenador;


                //JFrames del Equipo
                public static JFrame vEquipo;

                    public static JFrame vInsertarEquipo;
                    public static JFrame vActualizarEquipo;
                    public static JDialog vConsultarEquipo;
                    public static JDialog vBorrarEquipo;


                //JFrames de la Jornada
                public static JFrame vJornada;
                    public static JFrame vInsertarJornada;
                    public static JFrame vActualizarJornada;
                    public static JDialog vConsultarJornada;
                    public static JDialog vBorrarJornada;


                //JFrames del Jugador
                public static JFrame vJugador;
                    public static JFrame vInsertarJugador;
                    public static JFrame vActualizarJugador;
                    public static JDialog vConsultarJugador;
                    public static JDialog vBorrarJugador;


                //JFrames del Partido
                public static JFrame vPartido;
                    public static JFrame vInsertarPartido;
                    public static JFrame vActualizarPartido;
                    public static JDialog vConsultarPartido;
                    public static JDialog vBorrarPartido;


                //JFrames del Propietario
                public static JFrame vPropietario;
                    public static JFrame vInsertarPropietario;
                    public static JFrame vActualizarPropietario;
                    public static JDialog vConsultarPropietario;
                    public static JDialog vBorrarPropietario;


                //JFrames del Staff
                public static JFrame vStaff;
                    public static JFrame vInsertarStaff;
                    public static JFrame vActualizarStaff;
                    public static JDialog vConsultarStaff;
                    public static JDialog vBorrarStaff;


                //JFrames de la Temporada
                public static JFrame vTemporada;
                    public static JFrame vInsertarTemporada;
                    public static JFrame vActualizarTemporada;
                    public static JDialog vConsultarTemporada;
                    public static JDialog vBorrarTemporada;


                //JFrames del Usuario
                public static JFrame vUsuario;

                    public static JFrame vInsertarUsuario;
                    public static JFrame vActualizarUsuario;
                    public static JDialog vConsultarUsuario;
                    public static JDialog vBorrarUsuario;

                public static JFrame vHomeUsuario;

    //JFrames ventana del Usuario

    //Declaracion de los objatos
    private static ContratoDueno cd;
    private static ContratoEntrena ce;
    private static ContratoJugador cj;
    private static ContratoStaff cs;
    private static Entrenador e;
    private static Equipo eq;
    private static Jornada jo;
    private static Jugador j;
    private static Partido p;
    private static Propietario pro;
    private static Staff stf;
    private static Temporada t;
    private static Usuario u;


    //Inicio del codigo
    public static void main(String[] args) {

        try
        {
            crearVentanaPrincipal();
        }
        catch (Exception e)
        {
            System.out.println("Problemas en el main "+ e.getClass());
        }
    }

    //***********************Vista*****************************************//

    //Creación de la Ventana Principal
    public static  void crearVentanaPrincipal(){
        //Variables globales
        vPrincipal = new JFrame("vPrincipal");
        vPrincipal.setContentPane(new vPrincipal().getpPrincipal());
        vPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vPrincipal.pack();
        vPrincipal.setExtendedState(Frame.MAXIMIZED_BOTH);
        vPrincipal.setVisible(true);
    }

    //Creacion ventana del Admin
    public static void crearVentanaAdmin(){
        vPrincipal.setVisible(false);
        vAdmin = new JFrame("vHomeAdmin");
        vAdmin.setContentPane(new vHomeAdmin().getpPrincipal());
        vAdmin.pack();
        vAdmin.setExtendedState(Frame.MAXIMIZED_BOTH);
        vAdmin.setVisible(true);
    }

        //Creacion ventanas referentes al admin
        public static void crearVentanaCRUD(){
            vAdmin.setVisible(false);
            vCRUD = new JFrame("vCRUD");
            vCRUD.setContentPane(new vCRUD().getpPrincipal());
            vCRUD.pack();
            vCRUD.setExtendedState(Frame.MAXIMIZED_BOTH);
            vCRUD.setVisible(true);
        }

        //Combo Boxes
        public static void llenarCBtablas(JComboBox CB){
            ArrayList<String> lTablas = BaseDatos.llenarCBTablas();

            CB.addItem("--Seleccione uno--");
            try {
                for (int x = 0; x < lTablas.size();x++){
                    CB.addItem(lTablas.get(x));
                }
            }catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        public static void llenarCBEquipo(JComboBox CB){
            ArrayList<Equipo> lEquipo = TEquipo.llenarCBEquipo();

            CB.addItem("--Seleccione uno--");
            try {
                for (int x = 0; x < lEquipo.size();x++){
                    CB.addItem(lEquipo.get(x).getIdEquipo());
                }
            }catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        public static String nombreEquipo(String ID_EQUIPO){
            int idEquipo = Integer.parseInt(ID_EQUIPO);
            eq = new Equipo(idEquipo);
            String e1 = TEquipo.nombreEquipo(eq);
            return e1;
        }

        public static void llenarCBPropietario(JComboBox CB){
            ArrayList<Propietario> lPropietario = TPropietario.llenarCBPropietario();

            CB.addItem("--Seleccione uno--");
            try {
                for (int x = 0; x < lPropietario.size();x++){
                    CB.addItem(lPropietario.get(x).getIdPro());
                }
            }catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        public static String nombrePropietario(String ID_PROPIETARIO){
        int idPro = Integer.parseInt(ID_PROPIETARIO);
        pro = new Propietario(idPro);
        String p1 = TPropietario.nombrePropietario(pro);
        return p1;
        }

        public static void llenarCBContratoDueno(JComboBox CB){
        ArrayList<ContratoDueno> lContratoDueno = TContratoDueno.llenarCBContratoDueno();

        CB.addItem("--Seleccione uno--");
        try {
            for (int x = 0; x < lContratoDueno.size();x++){
                CB.addItem(lContratoDueno.get(x).getIdCondu());
            }
        }catch (Exception ex) {
            throw new RuntimeException(ex);
        }


    }

        public static void llenarCBContratoJugador(JComboBox CB){
        ArrayList<Jugador> lJugador = TJugador.llenarCBJugador();

        CB.addItem("--Seleccione uno--");
        try {
            for (int x = 0; x < lJugador.size();x++){
                CB.addItem(lJugador.get(x).getIdJug());
            }
        }catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    public static String nombreEntrenador(String ID_ENTRENADOR){
        int iden = Main.stringAInt(ID_ENTRENADOR);
        e = new Entrenador(iden);
        String e1 = TEntrenador.nombreEntrenador(e);
        return e1;
    }


    public static void llenarCBContratoEntrenador(JComboBox CB){
        ArrayList<ContratoEntrena> lEntrenador = TContratoEntrena.llenarCBContratoEntrenador();

        CB.addItem("--Seleccione uno--");
        try {
            for (int x = 0; x < lEntrenador.size();x++){
                CB.addItem(lEntrenador.get(x).getIdConen());
            }
        }catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

        public static String npIDCondu(String ID_CONDU){
            int idCondu = Integer.parseInt(ID_CONDU);
            cd = new ContratoDueno(idCondu);
            String np = TContratoDueno.npIDCONDU(cd);
            return np;
        }

        public static String neIDCondu(String ID_CONDU){
            int idCondu = Integer.parseInt(ID_CONDU);
            cd = new ContratoDueno(idCondu);
            String ne = TContratoDueno.neIDCONDU(cd);
            return ne;
        }

    public static String nenIDConen(String ID_CONEN){ //nombre entrenador id entrenador
        int idConen = Integer.parseInt(ID_CONEN);
        ce = new ContratoEntrena(idConen);
        String np = TContratoEntrena.nenIDCONEN(ce);
        return np;
    }

    public static String neIDConen(String ID_CONEN){ //nombre equipo id entrenador
        int idConen = Integer.parseInt(ID_CONEN);
        ce = new ContratoEntrena(idConen);
        String ne = TContratoEntrena.neIDCONEN(ce);
        return ne;
    }

    public static void llenarCBTemporadas(JComboBox CB){
        ArrayList<Temporada> lTemporada = TTemporada.llenarCBTemporada();

        CB.addItem("--Seleccione uno--");
        try {
            for (int x = 0; x < lTemporada.size();x++){
                CB.addItem(lTemporada.get(x).getIdTemp());
            }
        }catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void llenarCbJornadas(JComboBox CB,int ID_TEMP){
        ArrayList<Jornada> lJornada = TJornada.llenarCBJornadas(ID_TEMP);

        CB.removeAllItems();
        CB.addItem("--Seleccione uno--");
        try {
            for (int x = 0; x < lJornada.size();x++){
                CB.addItem(lJornada.get(x).getNumero());
            }
        }catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


        //Creación de las Ventanas del ContratoDueno

            public static void crearVentanaInsertarContratoDueno(){
                //vContratoDueno.setVisible(false);
                vInsertarContratoDueno  = new JFrame("vInsertarContratoDueno");
                vInsertarContratoDueno.setContentPane(new vInsertarContratoDueno().getpPrincipal());
                vInsertarContratoDueno.pack();
                vInsertarContratoDueno.setExtendedState(Frame.MAXIMIZED_BOTH);
                vInsertarContratoDueno.setVisible(true);
            }

            public static void crearVentanaBorrarContratoDueno() {
                vBorrarContratoDueno = new vBorrarContratoDueno();
                vBorrarContratoDueno.setSize(1000, 600);
                vBorrarContratoDueno.setVisible(true);
            }

            public static void crearVentanaConsultarContratoDueno(){
                vConsultarContratoDueno = new vConsultarContratoDueno();
                vConsultarContratoDueno.setLocationRelativeTo(null);
                vConsultarContratoDueno.pack();
                vConsultarContratoDueno.setVisible(true);
            }

            public static void crearVentanaActualizarContratoDueno(){
                //vContratoDueno.setVisible(false);
                vActualizarContratoDueno  = new JFrame("vActualizarContratoDueno");
                vActualizarContratoDueno.setContentPane(new vActualizarContratoDueno().getpPrincipal());
                vActualizarContratoDueno.pack();
                vInsertarContratoDueno.setExtendedState(Frame.MAXIMIZED_BOTH);
                vActualizarContratoDueno.setVisible(true);
            }

        //Creación de las Ventanas del ContratoEntrenador

            public static void crearVentanaInsertarContratoEntrenador(){
                //vContratoEntrena.setVisible(false);
                vInsertarContratoEntrenador  = new JFrame("vInsertarContratoEntrenador");
                vInsertarContratoEntrenador.setContentPane(new vInsertarContratoEntrena().getpPrincipal());
                vInsertarContratoEntrenador.pack();
                vInsertarContratoEntrenador.setExtendedState(Frame.MAXIMIZED_BOTH);
                vInsertarContratoEntrenador.setVisible(true);
            }

            public static void crearVentanaConsultarContratoEntrenador(){
                vConsultarContratoEntrenador = new vConsultarContratoEntrena();
                vConsultarContratoEntrenador.setLocationRelativeTo(null);
                vConsultarContratoEntrenador.pack();
                vConsultarContratoEntrenador.setVisible(true);
            }

            public static void crearVentanaActualizarContratoEntrenador(){
                //vContratoEntrena.setVisible(false);
                vActualizarContratoEntrenador = new JFrame("vActualizarContratoEntrenador");
                vActualizarContratoEntrenador.setContentPane(new vActualizarContratoEntrena().getpPrincipal());
                vActualizarContratoEntrenador.pack();
                vActualizarContratoEntrenador.setExtendedState(Frame.MAXIMIZED_BOTH);
                vActualizarContratoEntrenador.setVisible(true);
            }

            public static void crearVentanaBorrarContratoEntrenador() {
                vBorrarContratoEntrenador = new vBorrarContratoEntrena();
                vBorrarContratoEntrenador.setLocationRelativeTo(null);
                vBorrarContratoEntrenador.setSize(1000, 600);
                vBorrarContratoEntrenador.setVisible(true);
            }

            //Creación de las Ventanas del ContratoJugador

            public static void crearVentanaInsertarContratoJugador(){
                vInsertarContratoJugador = new JFrame("vInsertarContratoJugador");
                vInsertarContratoJugador.setContentPane(new vInsertarContratoJugador().getpPrincipal());
                vInsertarContratoJugador.pack();
                vInsertarContratoJugador.setVisible(true);
            }

            public static void crearVentanaConsultarContratoJugador() {
                vConsultarContratoJugador = new vConsultarContratoJugador();
                vConsultarContratoJugador.setContentPane(new vConsultarContratoJugador().getpPrincipal());
                vConsultarContratoJugador.pack();
                vConsultarContratoJugador.setVisible(true);
            }

            public static void crearVentanaActualizarContratoJugador(){
                vActualizarContratoJugador = new JFrame("vActualizarContratoJugador");
                vActualizarContratoJugador.setContentPane(new vActualizarContratoJugador().getpPrincipal());
                vActualizarContratoJugador.pack();
                vActualizarContratoJugador.setVisible(true);
            }

            public static void crearVentanaBorrarContratoJugador(){
                vBorrarContratoJugador = new vBorrarContratoJugador();
                vBorrarContratoJugador.setContentPane(new vBorrarContratoJugador().getpPrincipal());
                vBorrarContratoJugador.pack();
                vBorrarContratoJugador.setVisible(true);
            }

            //Creación de las Ventanas del ContratoStaff

            public static void crearVentanaInsertarContratoStaff(){
                vInsertarContratoStaff = new JFrame("vInsertarContratoStaff");
                vInsertarContratoStaff.setContentPane(new vInsertarContratoStaff().getpPrincipal());
                vInsertarContratoStaff.pack();
                vInsertarContratoStaff.setVisible(true);
            }

            public static void crearVentanaConsultarContratoStaff(){
                vConsultarContratoStaff = new vConsultarContratoStaff();
                vConsultarContratoStaff.setContentPane(new vConsultarContratoStaff().getpPrincipal());
                vConsultarContratoStaff.pack();
                vConsultarContratoStaff.setVisible(true);
            }

            public static void crearVentanaActualizarContratoStaff(){
                vActualizarContratoStaff = new JFrame("vActualizarContratoStaff");
                vActualizarContratoStaff.setContentPane(new vActualizarContratoStaff().getpPrincipal());
                vActualizarContratoStaff.pack();
                vActualizarContratoStaff.setVisible(true);
            }

            public static void crearVentanaBorrarContratoStaff(){
                vBorrarContratoStaff = new vBorrarContratoStaff();
                vBorrarContratoStaff.setContentPane(new vBorrarContratoStaff().getpPrincipal());
                vBorrarContratoStaff.pack();
                vBorrarContratoStaff.setVisible(true);
            }

            //Creación de las Ventanas del Entrenador

            public static void crearVentanaInsertarEntrenador(){
                vInsertarEntrenador = new JFrame("vInsertarEntrenador");
                vInsertarEntrenador.setContentPane(new vInsertarEntrenador().getpPrincipal());
                vInsertarEntrenador.pack();
                vInsertarEntrenador.setVisible(true);
            }

            public static void crearVentanaConsultarEntrenador(){
                vConsultarEntrenador = new vConsultarEntrenador();
                vConsultarEntrenador.setContentPane(new vConsultarEntrenador().getpPrincipal());
                vConsultarEntrenador.pack();
                vConsultarEntrenador.setVisible(true);

            }

            public static void crearVentanaActualizarEntrenador(){
                vActualizarEntrenador = new JFrame("vActualizarEntrenador");
                vActualizarEntrenador.setContentPane(new vActualizarEntrenador().getpPrincipal());
                vActualizarEntrenador.pack();
                vActualizarEntrenador.setVisible(true);
            }

            public static void crearVentanaBorrarEntrenador(){
                vBorrarEntrenador = new vBorrarEntrenador();
                vBorrarEntrenador.setContentPane(new vBorrarEntrenador().getpPrincipal());
                vBorrarEntrenador.pack();
                vBorrarEntrenador.setVisible(true);
            }

            //Creación de las Ventanas del Equipo

            public static void crearVentanaInsertarEquipo(){
                vInsertarEquipo = new JFrame("vInsertarEquipo");
                vInsertarEquipo.setContentPane(new vInsertarEquipo().getpPrincipal());
                vInsertarEquipo.pack();
                vInsertarEquipo.setVisible(true);
            }

            public static void crearVentanaConsultarEquipo(){
                vConsultarEquipo = new vConsultarEquipo();
                vConsultarEquipo.setContentPane(new vConsultarEquipo().getpPrincipal());
                vConsultarEquipo.pack();
                vConsultarEquipo.setVisible(true);
            }

            public static void crearVentanaActualizarEquipo(){
                vActualizarEquipo = new JFrame("vActualizarEquipo");
                vActualizarEquipo.setContentPane(new vActualizarEquipo().getpPrincipal());
                vActualizarEquipo.pack();
                vActualizarEquipo.setVisible(true);
            }

            public static void crearVentanaBorrarEquipo(){
                vBorrarEquipo = new vBorrarEquipo();
                vBorrarEquipo.setContentPane(new vBorrarEquipo().getpPrincipal());
                vBorrarEquipo.pack();
                vBorrarEquipo.setVisible(true);
            }

            //Creación de las Ventanas de la Jornada

            public static void crearVentanaInsertarJornada(){
                vInsertarJornada = new JFrame("vInsertarJornada");
                vInsertarJornada.setContentPane(new vInsertarJornada().getpPrincipal());
                vInsertarJornada.pack();
                vInsertarJornada.setVisible(true);
            }

            public static void crearVentanaConsultarJornada(){
                vConsultarJornada = new vConsultarJornada();
                vConsultarJornada.setContentPane(new vConsultarJornada().getpPrincipal());
                vConsultarJornada.pack();
                vConsultarJornada.setVisible(true);
            }

            public static void crearVentanaActualizarJornada(){
                vActualizarJornada = new JFrame("vActualizarJornada");
                vActualizarJornada.setContentPane(new vActualizarJornada().getpPrincipal());
                vActualizarJornada.pack();
                vActualizarJornada.setVisible(true);
            }

            public static void crearVentanaBorrarJornada(){
                vBorrarJornada = new vBorrarJornada();
                vBorrarJornada.setContentPane(new vBorrarJornada().getpPrincipal());
                vBorrarJornada.pack();
                vBorrarJornada.setVisible(true);
            }

            //Creación de las Ventanas del Jugador

            public static void crearVentanaInsertarJugador(){
                vInsertarJugador = new JFrame("vInsertarJugador");
                vInsertarJugador.setContentPane(new vInsertarJugador().getpPrincipal());
                vInsertarJugador.pack();
                vInsertarJugador.setVisible(true);
            }

            public static void crearVentanaConsultarJugador(){
                vConsultarJugador = new vConsultarJugador();
                vConsultarJugador.setContentPane(new vConsultarJugador().getpPrincipal());
                vConsultarJugador.pack();
                vConsultarJugador.setVisible(true);
            }

            public static void crearVentanaActualizarJugador(){
                vActualizarJugador = new JFrame("vActualizarJugador");
                vActualizarJugador.setContentPane(new vActualizarJugador().getpPrincipal());
                vActualizarJugador.pack();
                vActualizarJugador.setVisible(true);
            }

            public static void crearVentanaBorrarJugador(){
                vBorrarJugador = new vBorrarJugador();
                vBorrarJugador.setContentPane(new vBorrarJugador().getpPrincipal());
                vBorrarJugador.pack();
                vBorrarJugador.setVisible(true);
            }

            //Creación de las Ventanas del Partido

            public static void crearVentanaInsertarPartido(){
                vInsertarPartido = new JFrame("vInsertarPartido");
                vInsertarPartido.setContentPane(new vInsertarPartido().getpPrincipal());
                vInsertarPartido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                vInsertarPartido.pack();
                vInsertarPartido.setVisible(true);
            }

            public static void crearVentanaConsultarPartido(){
                vConsultarPartido = new vConsultarPartido();
                vConsultarPartido.setContentPane(new vConsultarPartido().getpPrincipal());
                vConsultarPartido.pack();
                vConsultarPartido.setVisible(true);
            }

            public static void crearVentanaActualizarPartido(){
                vActualizarPartido = new JFrame("vActualizarPartido");
                vActualizarPartido.setContentPane(new vActualizarPartido().getpPrincipal());
                vActualizarPartido.pack();
                vActualizarPartido.setVisible(true);
            }

            public static void crearVentanaBorrarPartido(){
                vBorrarPartido = new vBorrarPartido();
                vBorrarPartido.setContentPane(new vBorrarPartido().getpPrincipal());
                vBorrarPartido.pack();
                vBorrarPartido.setVisible(true);
            }

            //Creación de las Ventanas del Propietario

            public static void crearVentanaInsertarPropietario(){
                vInsertarPropietario = new JFrame("vInsertarPropietario");
                vInsertarPropietario.setContentPane(new vInsertarPropietario().getpPrincipal());
                vInsertarPropietario.pack();
                vInsertarPropietario.setVisible(true);
            }

            public static void crearVentanaConsultarPropietario(){
                vConsultarPropietario = new vConsultarPropietario();
                vConsultarPropietario.setContentPane(new vConsultarPropietario().getpPrincipal());
                vConsultarPropietario.pack();
                vConsultarPropietario.setVisible(true);
            }

            public static void crearVentanaActualizarPropietario(){
                vActualizarPropietario = new JFrame("vActualizarPropietario");
                vActualizarPropietario.setContentPane(new vActualizarPropietario().getpPrincipal());
                vActualizarPropietario.pack();
                vActualizarPropietario.setVisible(true);
            }

            public static void crearVentanaBorrarPropietario(){
                vBorrarPropietario = new vBorrarPropietario();
                vBorrarPropietario.setContentPane(new vBorrarPropietario().getpPrincipal());
                vBorrarPropietario.pack();
                vBorrarPropietario.setVisible(true);
            }

            //Creación de las Ventanas del Staff

            public static void crearVentanaInsertarStaff(){
                vInsertarStaff = new JFrame("vInsertarStaff");
                vInsertarStaff.setContentPane(new vInsertarStaff().getpPrincipal());
                vInsertarStaff.pack();
                vInsertarStaff.setVisible(true);
            }

            public static void crearVentanaConsultarStaff(){
                vConsultarStaff = new vConsultarStaff();
                vConsultarStaff.setContentPane(new vConsultarStaff().getpPrincipal());
                vConsultarStaff.pack();
                vConsultarStaff.setVisible(true);
            }

            public static void crearVentanaActualizarStaff(){
                vActualizarStaff = new JFrame("vActualizarStaff");
                vActualizarStaff.setContentPane(new vActualizarStaff().getpPrincipal());
                vActualizarStaff.pack();
                vActualizarStaff.setVisible(true);
            }

            public static void crearVentanaBorrarStaff(){
                vBorrarStaff = new vBorrarStaff();
                vBorrarStaff.setContentPane(new vBorrarStaff().getpPrincipal());
                vBorrarStaff.pack();
                vBorrarStaff.setVisible(true);
            }

            //Creación de las Ventanas de la Temporada

            public static void crearVentanaInsertarTemporada(){
                vInsertarTemporada = new JFrame("vInsertarTemporada");
                vInsertarTemporada.setContentPane(new vInsertarTemporada().getpPrincipal());
                vInsertarTemporada.pack();
                vInsertarTemporada.setVisible(true);
            }

            public static void crearVentanaConsultarTemporada(){
                vConsultarTemporada = new vConsultarTemporada();
                vConsultarTemporada.setContentPane(new vConsultarTemporada().getpPrincipal());
                vConsultarTemporada.pack();
                vConsultarTemporada.setVisible(true);
            }

            public static void crearVentanaActualizarTemporada(){
                vActualizarTemporada = new JFrame("vActualizarTemporada");
                vActualizarTemporada.setContentPane(new vActualizarTemporada().getpPrincipal());
                vActualizarTemporada.pack();
                vActualizarTemporada.setVisible(true);
            }

            public static void crearVentanaBorrarTemporada(){
                vBorrarTemporada = new vBorrarTemporada();
                vBorrarTemporada.setContentPane(new vBorrarTemporada().getpPrincipal());
                vBorrarTemporada.pack();
                vBorrarTemporada.setVisible(true);
            }

            //Creación de las Ventanas del Usuario

            public static void crearVentanaInsertarUsuario(){
                vInsertarUsuario = new JFrame("vInsertarUsuario");
                vInsertarUsuario.setContentPane(new vInsertarUsuario().getpPrincipal());
                vInsertarUsuario.pack();
                vInsertarUsuario.setExtendedState(Frame.MAXIMIZED_BOTH);
                vInsertarUsuario.setVisible(true);
            }

            public static void crearVentanaConsultarUsuario(){
                vConsultarUsuario = new vConsultarUsuario();
                vConsultarUsuario.setContentPane(new vConsultarUsuario().getpPrincipal());
                vConsultarUsuario.pack();
                vConsultarUsuario.setVisible(true);
            }

            public static void crearVentanaActualizarUsuario(){
                vActualizarUsuario = new JFrame("vActualizarUsuario");
                vActualizarUsuario.setContentPane(new vActualizarUsuario().getpPrincipal());
                vActualizarUsuario.pack();
                vActualizarUsuario.setVisible(true);
            }

            public static void crearVentanaBorrarUsuario(){
                vBorrarUsuario = new vBorrarUsuario();
                vBorrarUsuario.setContentPane(new vBorrarUsuario().getpPrincipal());
                vBorrarUsuario.pack();
                vBorrarUsuario.setVisible(true);

            }

            //Ver Jornadas
            public static void crearVentanaVerJornadas(){
                vAdmin.setVisible(false);
                verJornadas = new JFrame("verJornadas");
                verJornadas.setContentPane(new vJornadas().getpPrincipal());
                verJornadas.pack();
                verJornadas.setExtendedState(Frame.MAXIMIZED_BOTH);
                verJornadas.setVisible(true);
            }


            //*******************Metodos *****************************************//


        //Creación de las Ventanas del ContratoEntrena
        public static void crearVentanaContratoDueno() {
            vCRUD.setVisible(false);
            vContratoDueno = new JFrame("vContratoDueno");
            vContratoDueno.setContentPane(new vContratoDueno().getpPrincipal());
            vContratoDueno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            vContratoDueno.pack();
            vContratoDueno.setExtendedState(Frame.MAXIMIZED_BOTH);
            vContratoDueno.setVisible(true);
        }

            //Crud del ContratoDueno
            public static void crearContratoDueno(String ID_PRO, String ID_EQUIPO, String sueldo, String FechaInicio, String FechaFin) throws Exception
            {

                int idEquipo = Integer.parseInt(ID_EQUIPO);
                eq = new Equipo(idEquipo);

                int idPro = Integer.parseInt(ID_PRO);
                pro = new Propietario(idPro);

                float fsueldo = Float.parseFloat(sueldo);

                //Inserción de datos
                pro = new Propietario(idPro);
                eq = new Equipo(idEquipo);
                cd = new ContratoDueno(eq,pro,fsueldo, FechaInicio,FechaFin);
                TContratoDueno.insertar(cd);
                vInsertarContratoDueno.dispose();
            }

            public static int borrarContratoDueno(int IdCondu) throws Exception
            {
                cd = new ContratoDueno(IdCondu);
                return TContratoDueno.borrar(cd);
            }

            public static StringBuilder consultarContratoDueno(int IdCondu) throws Exception
            {
                cd = new ContratoDueno(IdCondu);
                cd = TContratoDueno.consultarContratoDueno(cd);
                StringBuilder infoCD = new StringBuilder("La informacion del contrato del dueño referente al id " + cd.getIdCondu() + " es: \n");
                infoCD.append("Equipo: " + cd.getEquipo().getIdEquipo() + "\nPropietario: " + cd.getPropietario().getIdPro() + " \nFecha inicio: " + cd.getFechainicio() + "\nFecha fin: " + cd.getFechaFin() + "\nSueldo: " + cd.getSueldo());
                if (cd != null)
                    return infoCD;
                else
                    return null;
            }

            public static void actualizarContratoDueno(int ID_CONDU, int ID_PRO, int ID_EQUIPO, int sueldo, String FechaInicio, String FechaFin) throws Exception
            {
                eq = new Equipo(ID_EQUIPO);
                pro = new Propietario(ID_PRO);

                cd.setIdCondu(ID_CONDU);
                cd.setEquipo(eq);
                cd.setPropietario(pro);
                cd.setSueldo(sueldo);
                cd.setFechainicio(FechaInicio);
                cd.setFechaFin(FechaFin);

                TContratoDueno.actualizar(cd);
            }

            public static ContratoDueno consultarDatosContratoDueno(int IdCondu) throws Exception
            {
                cd = new ContratoDueno(IdCondu);
                ContratoDueno cd1 = TContratoDueno.consultarContratoDueno(cd);

                return cd1;
            }

        //Creación de las Ventanas del ContratoEntrena
        public static void crearVentanaContratoEntrena(){
                vCRUD.setVisible(false);
                vContratoEntrena = new JFrame("vContratoEntrena");
                vContratoEntrena.setContentPane(new vContratoEntrena().getpPrincipal());
                vContratoEntrena.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                vContratoEntrena.pack();
                vContratoEntrena.setExtendedState(Frame.MAXIMIZED_BOTH);
                vContratoEntrena.setVisible(true);
            }

            //Crud del ContratoEntrenador

            public static void crearContratoEntrenador(String ID_ENT, String ID_EQUIPO, String sueldo, String FechaInicio, String FechaFin) throws Exception
            {
                int idEquipo = Integer.parseInt(ID_EQUIPO);
                eq = new Equipo(idEquipo);

                int idEnt = Integer.parseInt(ID_ENT);
                e = new Entrenador(idEnt);

                float fsueldo = Float.parseFloat(sueldo);

                //Inserción de datos
                e = new Entrenador(idEnt);
                eq = new Equipo(idEquipo);
                ce = new ContratoEntrena(eq,e,fsueldo, FechaInicio,FechaFin);
                TContratoEntrena.insertar(ce);
                vInsertarContratoEntrenador.dispose();
            }


            public static int borrarContratoEntrena(int IdConen) throws Exception
            {
                ce = new ContratoEntrena();
                ce.setIdConen(IdConen);
                return TContratoEntrena.borrar(ce);
            }

            public static StringBuilder consultarContratoEntrenador(int IdConen) throws Exception
            {
                ce = new ContratoEntrena();
                ce.setIdConen(IdConen);
                ce = TContratoEntrena.consultarContratosEntrena(ce);
                StringBuilder infoCE = new StringBuilder("La informacion del contrato del entrenador referente al id " + ce.getIdConen() + " es: \n");
                infoCE.append("Fecha inicio: " + ce.getFechaInicio() + "\nFecha fin: " + ce.getFechaFin() + "\nSueldo: " + ce.getSueldo());
                if (ce != null)
                    return infoCE;
                else
                    return null;
            }

            public static ContratoEntrena consultarDatosContratoEntrenador(int IdConen) throws Exception
            {
                ce = new ContratoEntrena(IdConen);
                ContratoEntrena ce1 = TContratoEntrena.consultarContratosEntrena(ce);

                return ce1;
            }

            public static void actualizarContratoEntrena(int IdConen, int sueldo, String FechaInicio, String FechaFin) throws Exception
            {
                ce.setIdConen(IdConen);
                ce.setSueldo(sueldo);
                ce.setFechaInicio(FechaInicio);
                ce.setFechaFin(FechaFin);
                TContratoEntrena.actualizar(ce);
                vActualizarContratoEntrenador.dispose();
            }

        //Creación de las Ventanas del ContratoJugador
        public static void crearVentanaContratoJugador(){
            vCRUD.setVisible(false);
            vContratoJugador = new JFrame("vContratoJugador");
            vContratoJugador.setContentPane(new vContratoJugador().getpPrincipal());
            vContratoJugador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            vContratoJugador.pack();
            vContratoJugador.setExtendedState(Frame.MAXIMIZED_BOTH);
            vContratoJugador.setVisible(true);
        }

    //Crud del ContratoJugador

    public static void crearContratoJugador(String ID_JUG, String ID_EQUIPO, String sueldo, String FechaInicio, String FechaFin, String Clausula, String dorsal) throws Exception
    {
        //Inserción de datos
        int idJugador = Integer.parseInt(ID_JUG);
        j = new Jugador(idJugador);

        int idEquipo = Integer.parseInt(ID_EQUIPO);
        eq = new Equipo(idEquipo);

        float fsueldo = Float.parseFloat(sueldo);

        int fClausula = Integer.parseInt(Clausula);

        //Inserción de datos
        j = new Jugador(idJugador);
        eq = new Equipo(idEquipo);
        cj = new ContratoJugador(j,eq,fsueldo, FechaInicio,FechaFin, fClausula, dorsal);
        TContratoJugador.insertar(cj);
        vInsertarContratoJugador.dispose();
    }

    public static int borrarContratoJugador(int IdConju) throws Exception
    {
        cj = new ContratoJugador();
        cj.setIdConju(IdConju);
        return TContratoJugador.borrar(cj);
    }

    public static StringBuilder consultarContratoJugador(int IdConju) throws Exception
    {
        cj = new ContratoJugador();
        cj.setIdConju(IdConju);
        cj = TContratoJugador.consultarContratosJugadores(cj);
        StringBuilder infoCJ = new StringBuilder("La informacion del contrato del jugador referente al id " + cj.getIdConju() + " es: \n");
        infoCJ.append("ID Jugador: " + cj.getID_JUG().getIdJug() + "\nID Equipo: " + cj.getID_EQUIPO().getIdEquipo() + "\nFecha inicio: " + cj.getFechaInicio() + "\nFecha fin: "
                + cj.getFechaFin() + "\nSueldo: " + cj.getSueldo() + "\nClausula: " + cj.getClausula() + "\nDorsal: " + cj.getDorsal());
        if (cj != null)
            return infoCJ;
        else
            return null;
    }

    public static void actualizarContratoJugador(int ID_CONJU, int ID_JUG, int ID_EQUIPO, float sueldo, String FechaInicio, String FechaFin, int Clausula, String dorsal) throws Exception
    {
        j = new Jugador(ID_JUG);
        eq = new Equipo(ID_EQUIPO);

        cj.setIdConju(ID_CONJU);
        cj.setSueldo(sueldo);
        cj.setFechaInicio(FechaInicio);
        cj.setFechaFin(FechaFin);
        cj.setClausula(Clausula);
        cj.setDorsal(dorsal);
        TContratoJugador.actualizar(cj);
        vActualizarContratoJugador.dispose();
    }

        //Creación de las Ventanas del ContratoStaff
        public static void crearVentanaContratoStaff(){
            vCRUD.setVisible(false);
            vContratoStaff = new JFrame("vContratoStaff");
            vContratoStaff.setContentPane(new vContratoStaff().getpPrincipal());
            vContratoStaff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            vContratoStaff.pack();
            vContratoStaff.setExtendedState(Frame.MAXIMIZED_BOTH);
            vContratoStaff.setVisible(true);
    }

            //Crud del ContratoStaff

            public static void crearContratoStaff(String ID_STAFF, String ID_EQUIPO, String sueldo, String FechaInicio, String FechaFin) throws Exception
            {
                //Inserción de datos
                int idStaff = Integer.parseInt(ID_STAFF);
                stf = new Staff(idStaff);

                int idEquipo = Integer.parseInt(ID_EQUIPO);
                eq = new Equipo(idEquipo);

                float fsueldo = Float.parseFloat(sueldo);

                //Inserción de datos
                stf = new Staff(idStaff);
                eq = new Equipo(idEquipo);
                cs = new ContratoStaff(stf,eq,fsueldo, FechaInicio,FechaFin);
                TContratoStaff.insertar(cs);
                vInsertarContratoStaff.dispose();
            }

            public static int borrarContratoStaff(int IdConst) throws Exception
            {
                cs = new ContratoStaff();
                cs.setIdConst(IdConst);
                return TContratoStaff.borrar(cs);
            }

            public static StringBuilder consultarContratoStaff(int IdConst) throws Exception
            {
                cs = new ContratoStaff();
                cs.setIdConst(IdConst);
                cs = TContratoStaff.consultarContratoStaff(cs);
                StringBuilder infoCS = new StringBuilder("La informacion del contrato del staff referente al id " + cs.getIdConst() + " es: \n");
                infoCS.append("Fecha inicio: " + cj.getFechaInicio() + "\nFecha fin: " + cj.getFechaFin() + "\nSueldo: " + cj.getSueldo());
                if (cs != null)
                    return infoCS;
                else
                    return null;
            }

            public static void actualizarContratoStaff(int ID_CONST, int ID_STAFF, int ID_EQUIPO, float sueldo, String FechaInicio, String FechaFin) throws Exception
            {
                stf = new Staff(ID_STAFF);
                eq = new Equipo(ID_EQUIPO);

                cs.setIdConst(ID_CONST);
                cs.setID_STAFF(stf);
                cs.setID_EQUIPO(eq);
                cs.setSueldo(sueldo);
                cs.setFechaInicio(FechaInicio);
                cs.setFechaFin(FechaFin);
                TContratoStaff.actualizar(cs);
                vActualizarContratoStaff.dispose();
            }


        //Creación de las Ventanas del Entrenador
        public static void crearVentanaEntrenador(){
            vCRUD.setVisible(false);
            vEntrenador = new JFrame("vEntrenador");
            vEntrenador.setContentPane(new vEntrenador().getpPrincipal());
            vEntrenador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            vEntrenador.pack();
            vEntrenador.setExtendedState(Frame.MAXIMIZED_BOTH);
            vEntrenador.setVisible(true);
    }

            //Crud del Entrenador

            public static void crearEntrenador(int IdEnt, String DNI, String nombre, String apellido1, String apellido2, String telefono, String correo) throws Exception
            {
                //Inserción de datos
                e = new Entrenador(IdEnt, DNI, nombre, apellido1, apellido2, telefono, correo);
                TEntrenador.insertar(e);
                vInsertarEntrenador.dispose();
            }

            public static int borrarEntrenador(int IdEnt) throws Exception
            {
                e = new Entrenador();
                e.setIdEnt(IdEnt);
                return TEntrenador.borrar(e);
            }

            public static StringBuilder consultarEntrenador(int IdEnt) throws Exception
            {
                e = new Entrenador();
                e.setIdEnt(IdEnt);
                e = TEntrenador.consultarEntrenadores(e);
                StringBuilder infoE = new StringBuilder("La informacion del entrenador referente al id " + e.getIdEnt() + " es: \n");
                infoE.append("DNI: " + e.getDNI() + "\nNombre: " + e.getNombre() + "\nApellido1: " + e.getApellido1() + "\nApellido2: " + e.getApellido2() +
                        "\nTelefono: " + e.getTelefono() + "\nCorreo: " + e.getCorreo());
                if (e != null)
                    return infoE;
                else
                    return null;
            }

            public static void actualizarEntrenador(int IdEnt, String DNI, String nombre, String apellido1, String apellido2, String telefono, String correo) throws Exception
            {
                e.setIdEnt(IdEnt);
                e.setDNI(DNI);
                e.setNombre(nombre);
                e.setApellido1(apellido1);
                e.setApellido2(apellido2);
                e.setTelefono(telefono);
                e.setCorreo(correo);
                TEntrenador.actualizar(e);
                vActualizarEntrenador.dispose();
            }

        //Creación de las Ventanas del Equipo
        public static void crearVentanaEquipo(){
            vCRUD.setVisible(false);
            vEquipo = new JFrame("vEquipo");
            vEquipo.setContentPane(new vEquipo().getpPrincipal());
            vEquipo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            vEquipo.pack();
            vEquipo.setExtendedState(Frame.MAXIMIZED_BOTH);
            vEquipo.setVisible(true);
    }

            //Crud del Equipo

            public static void crearEquipo(int IdEquipo, String nombre, String colorEscudo, String colorEquipacion, int presupuesto) throws Exception
            {
                //Inserción de datos
                eq = new Equipo(IdEquipo, nombre, colorEscudo, colorEquipacion, presupuesto);
                TEquipo.insertar(eq);
                vInsertarEquipo.dispose();
            }

            public static int borrarEquipo(int IdEquipo) throws Exception
            {
                eq = new Equipo();
                eq.setIdEquipo(IdEquipo);
                return TEquipo.borrar(eq);
            }

            public static StringBuilder consultarEquipo(int IdEquipo) throws Exception
            {
                eq = new Equipo();
                eq.setIdEquipo(IdEquipo);
                eq = TEquipo.consultarEquipos(eq);
                StringBuilder infoEQ = new StringBuilder("La informacion del equipo referente al id " + eq.getIdEquipo() + " es: \n");
                infoEQ.append("Nombre: " + eq.getNombre() + "\nColor del Escudo: " + eq.getColorEscudo() + "\nColor de la Equipacion: " + eq.getColorEquipacion() +
                        "\nPresupuesto: " + eq.getPresupuesto());
                if (eq != null)
                    return infoEQ;
                else
                    return null;
            }

            public static void actualizarEquipo(int IdEquipo, String nombre, String colorEscudo, String colorEquipacion, int presupuesto) throws Exception
            {
                eq.setIdEquipo(IdEquipo);
                eq.setNombre(nombre);
                eq.setColorEscudo(colorEscudo);
                eq.setColorEquipacion(colorEquipacion);
                eq.setPresupuesto(presupuesto);
                TEquipo.actualizar(eq);
                vActualizarEquipo.dispose();
            }


        //Creación de las Ventanas del Jornada
        public static void crearVentanaJornada(){
            vCRUD.setVisible(false);
            vJornada = new JFrame("vJornada");
            vJornada.setContentPane(new vJornada().getpPrincipal());
            vJornada.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            vJornada.pack();
            vJornada.setExtendedState(Frame.MAXIMIZED_BOTH);
            vJornada.setVisible(true);
    }

            //Crud de la Jornada

            public static void crearJornada(int IdJor, String numero, LocalDate dia, String tipoJornada) throws Exception
            {
                //Inserción de datos
                jo = new Jornada(IdJor, numero, dia, tipoJornada);
                TJornada.insertar(jo);
                vInsertarJornada.dispose();
            }

            public static int borrarJornada(int IdJor) throws Exception
            {
                jo = new Jornada();
                jo.setIdJor(IdJor);
                return TJornada.borrar(jo);
            }

            public static StringBuilder consultarJornada(int IdJor) throws Exception
            {
                jo = new Jornada();
                jo.setIdJor(IdJor);
                jo = TJornada.consultarJornadas(jo);
                StringBuilder infoJO = new StringBuilder("La informacion de la jornada referente al id " + jo.getIdJor() + " es: \n");
                infoJO.append("Número: " + jo.getNumero() + "\nDía: " + jo.getDia() + "\nTipo de Jornada: " + jo.getTipoJornada());
                if (jo != null)
                    return infoJO;
                else
                    return null;
            }

            public static void actualizarJornada(int IdJor, String numero, LocalDate dia, String tipoJornada) throws Exception
            {
                jo.setIdJor(IdJor);
                jo.setNumero(numero);
                jo.setDia(dia);
                jo.setTipoJornada(tipoJornada);
                TJornada.actualizar(jo);
                vActualizarJornada.dispose();
            }


        //Creación de las Ventanas del Jugador
        public static void crearVentanaJugador(){
            vCRUD.setVisible(false);
            vJugador = new JFrame("vJugador");
            vJugador.setContentPane(new vJugador().getpPrincipal());
            vJugador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            vJugador.pack();
            vJugador.setExtendedState(Frame.MAXIMIZED_BOTH);
            vJugador.setVisible(true);
    }

            //Crud del Jugador

            public static void crearJugador(int IdJug, String pieManoDominante, String tamañoCalzado, String posicionDraft, String posicion, String tipoJugador,
                                            String DNI, String nombre, String apellido1, String apellido2, String telefono, String correo) throws Exception
            {
                //Inserción de datos
                j = new Jugador(IdJug, pieManoDominante, tamañoCalzado, posicionDraft, posicion, tipoJugador, DNI, nombre, apellido1, apellido2, telefono, correo);
                TJugador.insertar(j);
                vInsertarJugador.dispose();
            }

            public static int borrarJugador(int IdJug) throws Exception
            {
                j = new Jugador();
                j.setIdJug(IdJug);
                return TJugador.borrar(j);
            }

            public static StringBuilder consultarJugador(int IdJug) throws Exception
            {
                j = new Jugador();
                j.setIdJug(IdJug);
                j = TJugador.consultarJugadores(j);
                StringBuilder infoJ = new StringBuilder("La informacion del jugador referente al id " + j.getIdJug() + " es: \n");
                infoJ.append("DNI: " + j.getDNI() + "\nPie y Mano Dominantes: " + j.getPieManoDominante() + "\nTamaño del calzado: " + j.getTamañoCalzado() +
                        "\nPosicion en el Draft: " + j.getPosicionDraft() + "\nPosicion: " + j.getPosicion() + "\nTipo de Jugador: " + j.getTipoJugador() +
                        "\nNombre: " + j.getNombre() + "\nApellido1: " + j.getApellido1() + "\nApellido2: " + j.getApellido2() + "\nTelefono: " + j.getTelefono() +
                        "\nCorreo: " + j.getCorreo());
                if (j != null)
                    return infoJ;
                else
                    return null;
            }

            public static void actualizarJugador(int IdJug, String pieManoDominante, String tamañoCalzado, String posicionDraft, String posicion, String tipoJugador,
                                                 String DNI, String nombre, String apellido1, String apellido2, String telefono, String correo) throws Exception
            {
                j.setIdJug(IdJug);
                j.setPieManoDominante(pieManoDominante);
                j.setTamañoCalzado(tamañoCalzado);
                j.setPosicionDraft(posicionDraft);
                j.setPosicion(posicion);
                j.setTipoJugador(tipoJugador);
                j.setDNI(DNI);
                j.setNombre(nombre);
                j.setApellido1(apellido1);
                j.setApellido2(apellido2);
                j.setTelefono(telefono);
                j.setCorreo(correo);
                TJugador.actualizar(j);
                vActualizarJugador.dispose();
            }


        //Creación de las Ventanas del Partido
        public static void crearVentanaPartido(){
            vCRUD.setVisible(false);
            vPartido = new JFrame("vPartido");
            vPartido.setContentPane(new vPartido().getpPrincipal());
            vPartido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            vPartido.pack();
            vPartido.setExtendedState(Frame.MAXIMIZED_BOTH);
            vPartido.setVisible(true);
    }

            //Crud del Partido

            public static void crearPartido(int IdPartido, int IdJor, LocalDate Hora, int GolesEq1, int GolesEq2, int IdGanador, int IdPerdedor) throws Exception
            {
                //Inserción de datos
                p = new Partido (IdPartido, IdJor, Hora, GolesEq1, GolesEq2, IdGanador, IdPerdedor);
                TPartido.insertar(p);
                vInsertarPartido.dispose();
            }

            public static int borrarPartido(int IdPartido) throws Exception
            {
                p = new Partido();
                p.setIdPartido(IdPartido);
                return TPartido.borrar(p);
            }

            public static StringBuilder consultarPartido(int IdPartido) throws Exception
            {
                p = new Partido();
                p.setIdPartido(IdPartido);
                p = TPartido.consultarPartidos(p);
                StringBuilder infoP = new StringBuilder("La informacion del partido referente al id " + p.getIdPartido() + " es: \n");
                infoP.append("Id Jornada: " + p.getIdJor() + "\nHora: " + p.getHora() + "\nGoles Equipo 1: " + p.getGolesEq1() + "\nGoles Equipo 2: " + p.getGolesEq2() +
                        "\nId Ganador: " + p.getIdGanador() + "\nId Perdedor: " + p.getIdPerdedor());
                if (p != null)
                    return infoP;
                else
                    return null;
            }

            public static void actualizarPartido(int IdPartido, int IdJor, LocalDate Hora, int GolesEq1, int GolesEq2, int IdGanador, int IdPerdedor) throws Exception
            {
                p.setIdPartido(IdPartido);
                p.setIdJor(IdJor);
                p.setHora(Hora);
                p.setGolesEq1(GolesEq1);
                p.setGolesEq2(GolesEq2);
                p.setIdGanador(IdGanador);
                p.setIdPerdedor(IdPerdedor);
                TPartido.actualizar(p);
                vActualizarPartido.dispose();
            }

        //Creación de las Ventanas del Propietario
        public static void crearVentanaPropietario(){
            vCRUD.setVisible(false);
            vPropietario = new JFrame("vPropietario");
            vPropietario.setContentPane(new vPropietario().getpPrincipal());
            vPropietario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            vPropietario.pack();
            vPropietario.setExtendedState(Frame.MAXIMIZED_BOTH);
            vPropietario.setVisible(true);
    }

            //Crud del Propietario

            public static void crearPropietario(int IdPro, String DNI, String Nombre, String Apellido1, String Apellido2, String Telefono, String Correo) throws Exception
            {
                //Inserción de datos
                pro = new Propietario (IdPro, DNI, Nombre, Apellido1, Apellido2, Telefono, Correo);
                TPropietario.insertar(pro);
                vInsertarPropietario.dispose();
            }

            public static int borrarPropietario(int IdPro) throws Exception
            {
                pro = new Propietario();
                pro.setIdPro(IdPro);
                return TPropietario.borrar(pro);
            }

            public static StringBuilder consultarPropietario(int IdPro) throws Exception
            {
                pro = new Propietario();
                pro.setIdPro(IdPro);
                pro = TPropietario.consultarPropietarios(pro);
                StringBuilder infoPRO = new StringBuilder("La informacion del propietario referente al id " + pro.getIdPro() + " es: \n");
                infoPRO.append("DNI: " + pro.getDNI() + "\nNombre: " + pro.getNombre() + "\nApellido1: " + pro.getApellido1() + "\nApellido2: " + pro.getApellido2() +
                        "\nTelefono: " + pro.getTelefono() + "\nCorreo: " + pro.getCorreo());
                if (pro != null)
                    return infoPRO;
                else
                    return null;
            }

            public static void actualizarPropietario(int IdPro, String DNI, String Nombre, String Apellido1, String Apellido2, String Telefono, String Correo) throws Exception
            {
                pro.setIdPro(IdPro);
                pro.setDNI(DNI);
                pro.setNombre(Nombre);
                pro.setApellido1(Apellido1);
                pro.setApellido2(Apellido2);
                pro.setTelefono(Telefono);
                pro.setCorreo(Correo);
                TPropietario.actualizar(pro);
                vActualizarPropietario.dispose();
            }

        //Creación de las Ventanas del Staff
        public static void crearVentanaStaff(){
            vCRUD.setVisible(false);
            vStaff = new JFrame("vStaff");
            vStaff.setContentPane(new vStaff().getpPrincipal());
            vStaff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            vStaff.pack();
            vStaff.setExtendedState(Frame.MAXIMIZED_BOTH);
            vStaff.setVisible(true);
    }

            //Crud del Staff

            public static void crearStaff(int IdStaff, String DNI, String Nombre, String Apellido1, String Apellido2, String Telefono, String Correo, String Rol) throws Exception
            {
                //Inserción de datos
                stf = new Staff (IdStaff, DNI, Nombre, Apellido1, Apellido2, Telefono, Correo, Rol);
                TStaff.insertar(stf);
                vInsertarStaff.dispose();
            }

            public static int borrarStaff(int IdStaff) throws Exception
            {
                stf = new Staff();
                stf.setIdStaff(IdStaff);
                return TStaff.borrar(stf);
            }

            public static StringBuilder consultarStaff(int IdStaff) throws Exception
            {
                stf = new Staff();
                stf.setIdStaff(IdStaff);
                stf = TStaff.consultarStaff(stf);
                StringBuilder infoSTF = new StringBuilder("La informacion del staff referente al id " + stf.getIdStaff() + " es: \n");
                infoSTF.append("DNI: " + stf.getDNI() + "\nNombre: " + stf.getNombre() + "\nApellido1: " + stf.getApellido1() + "\nApellido2: " + stf.getApellido2() +
                        "\nTelefono: " + stf.getTelefono() + "\nCorreo: " + stf.getCorreo());
                if (stf != null)
                    return infoSTF;
                else
                    return null;
            }

            public static void actualizarStaff(int IdStaff, String DNI, String Nombre, String Apellido1, String Apellido2, String Telefono, String Correo, String Rol) throws Exception
            {
                stf.setIdStaff(IdStaff);
                stf.setDNI(DNI);
                stf.setNombre(Nombre);
                stf.setApellido1(Apellido1);
                stf.setApellido2(Apellido2);
                stf.setTelefono(Telefono);
                stf.setCorreo(Correo);
                stf.setRol(Rol);
                TStaff.actualizar(stf);
                vActualizarStaff.dispose();
            }


        //Creación de las Ventanas del Temporada
        public static void crearVentanaTemporada(){
            vCRUD.setVisible(false);
            vTemporada = new JFrame("vTemporada");
            vTemporada.setContentPane(new vTemporada().getpPrincipal());
            vTemporada.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            vTemporada.pack();
            vTemporada.setExtendedState(Frame.MAXIMIZED_BOTH);
            vTemporada.setVisible(true);
            }

            //Crud de las temporadas

            public static void crearTemporada(int IdTemp, String Tipo, String Estado) throws Exception
            {
                //Inserción de datos
                t = new Temporada (IdTemp, Tipo, Estado);
                TTemporada.insertar(t);
                vInsertarTemporada.dispose();
            }

            public static int borrarTemporada(int IdTemp) throws Exception
            {
                t = new Temporada();
                t.setIdTemp(IdTemp);
                return TTemporada.borrar(t);
            }

            public static StringBuilder consultarTemporada(int IdTemp) throws Exception
            {
                t = new Temporada();
                t.setIdTemp(IdTemp);
                t = TTemporada.consultarTemporada(t);
                StringBuilder infoT = new StringBuilder("La informacion de la temporada referente al id " + t.getIdTemp() + " es: \n");
                infoT.append("Tipo: " + t.getTipo() + "\nEstado: " + t.getEstado());
                if (t != null)
                    return infoT;
                else
                    return null;
            }

            public static void actualizarTemporada(int IdTemp, String Tipo, String Estado) throws Exception
            {
                t.setIdTemp(IdTemp);
                t.setTipo(Tipo);
                t.setEstado(Estado);
                TTemporada.actualizar(t);
                vActualizarTemporada.dispose();
            }


        //Creación de las Ventanas del Usuario
        public static void crearVentanaCRUDUsuario(){
            vCRUD.setVisible(false);
            vUsuario = new JFrame("vUsuario");
            vUsuario.setContentPane(new vUsuario().getpPrincipal());
            vUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            vUsuario.pack();
            vUsuario.setExtendedState(Frame.MAXIMIZED_BOTH);
            vUsuario.setVisible(true);
    }
    

            //Crud de los usuarios

            public static void crearUsuario( String Nombre, String Contraseña, String Email, String Telefono, String Admin) throws Exception
            {
                //Inserción de datos
                u = new Usuario (Nombre, Contraseña, Email, Telefono, Admin);
                TUsuario.insertar(u);
                vInsertarUsuario.dispose();
            }


            public static void registrarUsuario( String Nombre, String Contraseña, String Email, String Telefono, String Admin) throws Exception
            {
                //Inserción de datos
                u = new Usuario (Nombre, Contraseña, Email, Telefono, Admin);
                TUsuario.insertar(u);
            }


            public static int borrarUsuario(int IdUsuario) throws Exception
            {
                u = new Usuario();
                u.setIdUsuario(IdUsuario);
                return TUsuario.borrar(u);
            }

            public static StringBuilder consultarUsuario(int IdUsuario) throws Exception
            {
                u = new Usuario();
                u.setIdUsuario(IdUsuario);
                u = TUsuario.consultarUsuario(u);
                StringBuilder infoU = new StringBuilder("La informacion del usuario referente al id " + u.getIdUsuario() + " es: \n");
                infoU.append("Nombre: " + u.getNombre() + "\nContraseña: " + u.getContraseña() + "\nEmail: " + u.getEmail() + "\nTelefono: " + u.getTelefono() +
                        "\nAdmin: " + u.getAdmin());
                if (u != null)
                    return infoU;
                else
                    return null;
            }

            public static void actualizarUsuario(int IdUsuario, String Nombre, String Contraseña, String Email, String Telefono, String Admin) throws Exception
            {
                u.setIdUsuario(IdUsuario);
                u.setNombre(Nombre);
                u.setContraseña(Contraseña);
                u.setEmail(Email);
                u.setTelefono(Telefono);
                u.setAdmin(Admin);
                TUsuario.actualizar(u);
                vActualizarUsuario.dispose();
            }

     //Registro
     public static void crearVentanaRegistrarse(){
         vRegistrarse = new JFrame("vRegistarUsuario");
         vRegistrarse.setContentPane(new vRegistarUsuario().getpPrincipal());
         vRegistrarse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         vRegistrarse.pack();
         vRegistrarse.setExtendedState(Frame.MAXIMIZED_BOTH);
         vRegistrarse.setVisible(true);
     }

     //Crear ventana del User
     public static void crearVentanaUser(){
         vPrincipal.setVisible(false);
         Vista.Usuario.vHomeUsuario.main();
     }

        //Creacion de ventanas referentes al usuario NO admin
        public static void verEquipos(){
            verEquipos = new JFrame("vEquipos");
            verEquipos.setContentPane(new vEquipos().getpPrincipal());
            verEquipos.pack();
            verEquipos.setExtendedState(Frame.MAXIMIZED_BOTH);
            verEquipos.setVisible(true);
        }

        public static void verClasificacion(){
            verClasificacion = new JFrame("vClasificacion");
            verClasificacion.setContentPane(new vClasificacion().getpPrincipal());
            verClasificacion.pack();
            verClasificacion.setExtendedState(Frame.MAXIMIZED_BOTH);
            verClasificacion.setVisible(true);
        }

        public static void verPartidos(){

        }

    public static ArrayList<Object> generarClasificacion() throws Exception {
        TTemporada.crearView();
        ArrayList<Object> lArrays = TTemporada.buscarClasifi();
        return lArrays;
    }

     public static Usuario inicarSesion(String nombre, String contrasena) throws Exception {
                u = new Usuario(nombre,contrasena);
                Usuario user = TUsuario.inicioSesion(u);
                return user;
     }

     public static int stringAInt(String str){
            int num = Integer.parseInt(str);
            return num;
     }
}