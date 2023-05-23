package Modelo.Temporada;

import Modelo.BaseDatos;
import Modelo.Equipos.Equipo;
import Modelo.Staff.Staff;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TTemporada {


    //CRUD
    public static void insertar(Temporada t) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("insert into Temporadas (ID_TEMP,TIPO,ESTADO) values (?,?,?)");
        ps.setInt(1, t.getIdTemp());
        ps.setString(2, t.getTipo());
        ps.setString(3, t.getEstado());
        ps.executeUpdate();
        BaseDatos.cerrarConexion();
    }

    public static int borrar(Temporada t) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("delete from Temporadas where Id_Temp = ?");
        ps.setInt(1, t.getIdTemp());
        int n = ps.executeUpdate();
        BaseDatos.cerrarConexion();
        return n;
    }

    public static int actualizar(Temporada t) throws Exception
    {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("update Temporadas set Tipo = ?, Estado = ? where Id_Temp = ?");
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
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("select * from Temporadas where Id_Temp = ?");
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

    public static ArrayList<Temporada> llenarCBTemporada(){
        BaseDatos.abrirConexion();
        PreparedStatement ps = null;
        try {
            ps = BaseDatos.getCon().prepareStatement("SELECT Id_Temp FROM Temporadas");
            ResultSet rs = ps.executeQuery();
            ArrayList <Temporada> lTemporada  = new ArrayList();
            Temporada t1 = null;
            while (rs.next())
            {
                t1 = new Temporada();
                t1.setIdTemp(rs.getInt("Id_Temp"));
                lTemporada.add(t1);
            }
            BaseDatos.cerrarConexion();

            return lTemporada;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //Al no tener un TClasificacion coloco aqui la consulta referente a ella
    public static void crearView() throws SQLException {
        BaseDatos.abrirConexion();
        PreparedStatement ps = BaseDatos.getCon().prepareStatement("CREATE OR REPLACE VIEW clasificacion AS\n" +
                                                                        "    SELECT\n" +
                                                                        "           ROW_NUMBER() OVER (ORDER BY COUNT(CASE WHEN p.ID_Ganador = e.ID_EQUIPO THEN 1 END) DESC) AS Posicion,\n" +
                                                                        "           e.NOMBRE AS Nombre_Equipo,\n" +
                                                                        "           COUNT(CASE WHEN p.ID_Ganador = e.ID_EQUIPO THEN 1 END) AS Victorias,\n" +
                                                                        "           SUM(CASE WHEN p.ID_Ganador = e.ID_EQUIPO THEN p.GOLES_EQ1 ELSE p.GOLES_EQ2 END) AS Goles_a_favor,\n" +
                                                                        "           SUM(CASE WHEN p.ID_Ganador = e.ID_EQUIPO THEN p.GOLES_EQ2 ELSE p.GOLES_EQ1 END) AS Goles_en_contra,\n" +
                                                                        "           SUM(CASE WHEN p.ID_Ganador = e.ID_EQUIPO THEN p.GOLES_EQ1 ELSE p.GOLES_EQ2 END) - SUM(CASE WHEN p.ID_Ganador = e.ID_EQUIPO THEN p.GOLES_EQ2 ELSE p.GOLES_EQ1 END) AS Diferencia_goles\n" +
                                                                        "    FROM Equipos e\n" +
                                                                        "    JOIN Partidos p ON (e.ID_EQUIPO = p.ID_Ganador OR e.ID_EQUIPO = p.ID_Perdedor)\n" +
                                                                        "    JOIN Jornadas j ON j.id_jor = p.id_jor\n" +
                                                                        "    WHERE upper(j.tipo) = 'FASEREGULAR'\n" +
                                                                        "    GROUP BY e.ID_EQUIPO, e.NOMBRE\n" +
                                                                        "    ORDER BY\n" +
                                                                        "        Victorias DESC,\n" +
                                                                        "        Diferencia_goles DESC;");
    }
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