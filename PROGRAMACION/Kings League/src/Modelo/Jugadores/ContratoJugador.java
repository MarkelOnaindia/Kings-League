package Modelo.Jugadores;

import Modelo.Equipos.Equipo;

import java.time.LocalDate;

public class ContratoJugador {

    public int IdConju;
    public Jugador ID_JUG;
    public Equipo ID_EQUIPO;
    public float Sueldo;
    public String FechaInicio;
    public String FechaFin;
    public int Clausula;
    public String Dorsal;

    public ContratoJugador(Jugador ID_JUG, Equipo ID_EQUIPO, float sueldo, String fechaInicio, String fechaFin, int clausula, String dorsal) {
        this.ID_JUG = ID_JUG;
        this.ID_EQUIPO = ID_EQUIPO;
        Sueldo = sueldo;
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
        Clausula = clausula;
        Dorsal = dorsal;
    }

    public ContratoJugador(){
    }



    public int getIdConju() {
        return IdConju;
    }

    public void setIdConju(int idConju) {
        IdConju = idConju;
    }

    public Jugador getID_JUG() {
        return ID_JUG;
    }

    public void setID_JUG(Jugador ID_JUG) {
        this.ID_JUG = ID_JUG;
    }

    public Equipo getID_EQUIPO() {
        return ID_EQUIPO;
    }

    public void setID_EQUIPO(Equipo ID_EQUIPO) {
        this.ID_EQUIPO = ID_EQUIPO;
    }

    public float getSueldo() {
        return Sueldo;
    }

    public void setSueldo(float sueldo) {
        Sueldo = sueldo;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(String fechaFin) {
        FechaFin = fechaFin;
    }

    public int getClausula() {
        return Clausula;
    }

    public void setClausula(int clausula) {
        Clausula = clausula;
    }

    public String getDorsal() {
        return Dorsal;
    }

    public void setDorsal(String dorsal) {
        Dorsal = dorsal;
    }
}