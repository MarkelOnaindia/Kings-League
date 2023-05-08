package Modelo.Temporada;

public class Temporada {
    public String Tipo;
    public String Estado;

    public Temporada(String tipo, String estado) {
        Tipo = tipo;
        Estado = estado;
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
