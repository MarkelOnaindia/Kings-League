package Modelo.Equipos;

public class Equipo {

    public int IdEquipo;
    public String Nombre;
    public String ColorEscudo;
    public String ColorEquipacion;
    public int Presupuesto;

    public Equipo(int idEquipo, String nombre, String colorEscudo, String colorEquipacion, int presupuesto) {
        IdEquipo = idEquipo;
        Nombre = nombre;
        ColorEscudo = colorEscudo;
        ColorEquipacion = colorEquipacion;
        Presupuesto = presupuesto;
    }

    public Equipo() {

    }

    public Equipo(int idEquipo) {
        IdEquipo = idEquipo;
    }

    public int getIdEquipo() {
        return IdEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        IdEquipo = idEquipo;
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
