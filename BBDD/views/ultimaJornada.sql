/*Kings League equipo 2*/
/*View para visualizar toda la informacion de la ultima jornadas*/

CREATE OR REPLACE VIEW vista_ultima_jornada AS
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
    INNER JOIN Partidos p ON j.ID_JOR = p.ID_JOR
WHERE
    j.ID_JOR = (SELECT MAX(ID_JOR)
                FROM Jornadas);
