package Modelo.Entrenadores;

import Modelo.Equipos.Equipo;

public class ContratoEntrena {

    public int IdConen;
    public Entrenador ID_ENT;
    public Equipo ID_EQUIPO;
    public float Sueldo;
    public String FechaInicio;
    public String FechaFin;

    public ContratoEntrena(Entrenador ID_ENT, Equipo ID_EQUIPO, float sueldo, String fechaInicio, String fechaFin) {
        this.ID_ENT = ID_ENT;
        this.ID_EQUIPO = ID_EQUIPO;
        Sueldo = sueldo;
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
    }

    public ContratoEntrena() {
    }

    public ContratoEntrena(int idConen) {
    }

    public ContratoEntrena(Equipo eq, Entrenador e, float fsueldo, String fechaInicio, String fechaFin) {
    }


    public int getIdConen() {
        return IdConen;
    }

    public void setIdConen(int idConen) {
        IdConen = idConen;
    }

    public Entrenador getID_ENT() {
        return ID_ENT;
    }

    public void setID_ENT(Entrenador ID_ENT) {
        this.ID_ENT = ID_ENT;
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
}
