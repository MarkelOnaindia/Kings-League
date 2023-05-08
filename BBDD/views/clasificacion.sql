/*Kings League equipo 2*/
/*View clasificacion*/
CREATE OR REPLACE VIEW clasificacion AS
SELECT
    ROW_NUMBER() OVER (ORDER BY COUNT(*) DESC) AS Posicion,
    e.NOMBRE,
    COUNT(*) AS Numero_Victorias,
    SUM(CASE WHEN p.GOLES_EQ1 > p.GOLES_EQ2 AND p.ID_GANADOR = e.ID_EQUIPO THEN p.GOLES_EQ1
             WHEN p.GOLES_EQ2 > p.GOLES_EQ1 AND p.ID_GANADOR = e.ID_EQUIPO THEN p.GOLES_EQ2
             ELSE 0 END) AS Goles_Anotados
FROM
    Equipo e
    JOIN Partido p ON e.ID_EQUIPO = p.ID_GANADOR
GROUP BY
    e.NOMBRE
ORDER BY
    Numero_Victorias DESC, 
    Goles_Anotados DESC;
