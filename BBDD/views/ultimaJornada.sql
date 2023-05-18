/*Kings League equipo 2*/
/*View para visualizar toda la informacion de la ultima jornadas*/

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
    INNER JOIN Jornada j ON t.ID_TEMP = j.ID_TEMP
    INNER JOIN Partido p ON j.ID_JOR = p.ID_JOR
WHERE
    j.ID_JOR = (SELECT MAX(ID_JOR)
                FROM Jornadas);
                
