package Modelo.Equipos;

public class Equipo {

    public String Nombre;
    public String ColorEscudo;
    public String ColorEquipacion;
    public int Presupuesto;

    public Equipo(String nombre, String colorEscudo, String colorEquipacion, int presupuesto) {
        Nombre = nombre;
        ColorEscudo = colorEscudo;
        ColorEquipacion = colorEquipacion;
        Presupuesto = presupuesto;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getColorEscudo() {
        return ColorEscudo;
    }

    public void setColorEscudo(String colorEscudo) {
        ColorEscudo = colorEscudo;
    }

    public String getColorEquipacion() {
        return ColorEquipacion;
    }

    public void setColorEquipacion(String colorEquipacion) {
        ColorEquipacion = colorEquipacion;
    }

    public int getPresupuesto() {
        return Presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        Presupuesto = presupuesto;
    }
}
