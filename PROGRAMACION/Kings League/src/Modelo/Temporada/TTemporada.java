package Modelo.Temporada;

import Modelo.BaseDatos;
import Modelo.Equipos.Equipo;
import Modelo.Staff.Staff;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TTemporada {


    //CRUD
    public static void insertar(Temporada t) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Temporadas values (?,?,?)");
        ps.setInt(1, t.getIdTemp());
        ps.setString(2, t.getTipo());
        ps.setString(3, t.getEstado());
        ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }

    public static int borrar(Temporada t) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from Temporadas where IdTemp = ?");
        ps.setInt(1, t.getIdTemp());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int actualizar(Temporada t) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("update Temporadas set Tipo = ?, Estado = ? where IdTemp = ?");
        ps.setString(1, t.getTipo());
        ps.setString(2, t.getEstado());
        ps.setInt(3, t.getIdTemp());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static Temporada consultarTemporada(Temporada t) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from Temporadas where IdTemp = ?");
        ps.setInt(1, t.getIdTemp());
        ResultSet resultado = ps.executeQuery();
        Temporada temp;
        if (resultado.next())
        {
            temp = new Temporada();
            temp.setIdTemp(resultado.getInt("IdTemporada"));
            temp.setTipo(resultado.getString("Tipo"));
            temp.setEstado(resultado.getString("Estado"));
        }
        else
            temp = null;
        BaseDatos.cerrarConexion();
        return temp;
    }

    //Al no tener un TClasificacion coloco aqui la consulta referente a ella
    public static ArrayList<Object> buscarClasifi() throws Exception {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select posicion, nombre_equipo, victorias, diferencia_goles from clasificacion");
        ResultSet resultado = ps.executeQuery();
        // Arrays coincidentes
        ArrayList<Equipo> lEquipos = new ArrayList<>();
        ArrayList<Integer> lVictorias = new ArrayList<>();
        ArrayList<Integer> lDiferenciaGoles = new ArrayList<>();
        ArrayList<Integer> lPosicion = new ArrayList<>();

        // Array contenedor de los anteriores
        ArrayList<Object> lArrays = new ArrayList<>();
        while (resultado.next()){
            Equipo equipo = new Equipo();
            equipo.setNombre(resultado.getString("nombre_equipo"));
            lEquipos.add(equipo);

            int victorias = resultado.getInt("victorias");
            lVictorias.add(victorias);

            int diferenciaGoles = resultado.getInt("diferencia_goles");
            lDiferenciaGoles.add(diferenciaGoles);

            int posicion = resultado.getInt("posicion");
            lPosicion.add(posicion);
        }
        BaseDatos.cerrarConexion();
        lArrays.add(lEquipos);
        lArrays.add(lVictorias);
        lArrays.add(lDiferenciaGoles);
        lArrays.add(lPosicion);
        return lArrays;
    }

}
