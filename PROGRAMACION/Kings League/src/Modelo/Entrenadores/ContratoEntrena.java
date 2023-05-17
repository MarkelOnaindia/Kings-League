package Modelo.Entrenadores;

import Modelo.Equipos.Equipo;

import java.time.LocalDate;

public class ContratoEntrena {

    public int IdConen;
    public  int Sueldo;
    public LocalDate FechaInicio;
    public  LocalDate FechaFin;

    public ContratoEntrena(int idConen, int sueldo, LocalDate fechaInicio, LocalDate fechaFin) {
        IdConen = idConen;
        Sueldo = sueldo;
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
    }

    public ContratoEntrena() {

    }

    public ContratoEntrena(Equipo eq, Entrenador e, float fsueldo, String fechaInicio, String fechaFin) {
    }

    public int getIdConen() {
        return IdConen;
    }

    public void setIdConen(int idConen) {
        IdConen = idConen;
    }

    public int getSueldo() {
        return Sueldo;
    }

    public void setSueldo(int sueldo) {
        Sueldo = sueldo;
    }

    public LocalDate getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        FechaFin = fechaFin;
    }
}
