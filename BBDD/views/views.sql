   /*Kings League equipo 2*/
/*Creacion de views*/

    /*View clasificacion*/
    CREATE OR REPLACE VIEW clasificacion AS
    SELECT
           ROW_NUMBER() OVER (ORDER BY COUNT(CASE WHEN p.ID_Ganador = e.ID_EQUIPO THEN 1 END) DESC) AS Posicion,
           e.NOMBRE AS Nombre_Equipo,
           COUNT(CASE WHEN p.ID_Ganador = e.ID_EQUIPO THEN 1 END) AS Victorias,
           SUM(CASE WHEN p.ID_Ganador = e.ID_EQUIPO THEN p.GOLES_EQ1 ELSE p.GOLES_EQ2 END) AS Goles_a_favor,
           SUM(CASE WHEN p.ID_Ganador = e.ID_EQUIPO THEN p.GOLES_EQ2 ELSE p.GOLES_EQ1 END) AS Goles_en_contra,
           SUM(CASE WHEN p.ID_Ganador = e.ID_EQUIPO THEN p.GOLES_EQ1 ELSE p.GOLES_EQ2 END) - SUM(CASE WHEN p.ID_Ganador = e.ID_EQUIPO THEN p.GOLES_EQ2 ELSE p.GOLES_EQ1 END) AS Diferencia_goles
    FROM Equipos e
    JOIN Partidos p ON (e.ID_EQUIPO = p.ID_Ganador OR e.ID_EQUIPO = p.ID_Perdedor)
    JOIN Jornadas j ON j.id_jor = p.id_jor
    WHERE upper(j.tipo) = 'FASEREGULAR'
    GROUP BY e.ID_EQUIPO, e.NOMBRE
    ORDER BY
        Victorias DESC,
        Diferencia_goles DESC;
    
    /*View equipos*/
    CREATE OR REPLACE VIEW view_equipos AS
    SELECT DISTINCT e.id_equipo, e.Nombre, e.Color_Escudo, e.Equipacion, e.Presupuesto,
            COUNT(ContratosJugador.id_jug) AS cantidad_jugadores
    FROM Equipos e
    INNER JOIN ContratosJugador ON e.id_equipo = ContratosJugador.id_equipo
    GROUP BY e.id_equipo, e.Nombre, e.Color_Escudo, e.Equipacion, e.Presupuesto
    Order by ID_EQUIPO;
    
    /*View ultima jornadas*/
    CREATE OR REPLACE VIEW vista_ultima_jornada AS
    SELECT
        t.ID_TEMP,
        t.TIPO AS Temporadas,
        j.ID_JOR,
        j.NUMERO AS Numero_Jornada,
        j.Dia,
        j.TIPO AS Tipo_Jornada,
        p.ID_PARTIDO,
        p.HORA,
        p.GOLES_EQ1,
        p.GOLES_EQ2,
        p.ID_Ganador,
        p.ID_Perdedor
    FROM
        Temporadas t
        INNER JOIN Jornadas j ON t.ID_TEMP = j.ID_TEMP
        INNER JOIN Partidos p ON j.ID_JOR = p.ID_JOR
    WHERE
        j.ID_JOR = (SELECT MAX(ID_JOR)
                    FROM Jornadas);
    
    /*View para visualizar toda la informacion de todas las jornadas*/
    CREATE OR REPLACE VIEW vista_todas_jornadas AS
    SELECT
    t.ID_TEMP,
    j.TIPO AS Tipo_Jornada,
    p.ID_PARTIDO,
    j.Dia as Fecha_Partido,
    p.HORA,
    p.ID_Ganador as Equipo1,
    p.GOLES_EQ1,
    p.ID_Perdedor as Equipo2,
    p.GOLES_EQ2
    FROM
    Temporadas t
    INNER JOIN Jornadas j ON t.ID_TEMP = j.ID_TEMP
    INNER JOIN Partidos p ON j.ID_JOR = p.ID_JOR;