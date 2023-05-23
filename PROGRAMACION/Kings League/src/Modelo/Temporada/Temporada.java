package Modelo.Temporada;

public class Temporada {

    public int IdTemp;
    public String Tipo;
    public String Estado;

    public Temporada(int idTemp, String tipo, String estado) {
        IdTemp = idTemp;
        Tipo = tipo;
        Estado = estado;
    }

    public Temporada() {

    }

    public int getIdTemp() {
        return IdTemp;
    }

    public void setIdTemp(int idTemp) {
        IdTemp = idTemp;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
