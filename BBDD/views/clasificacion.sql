/*Kings League equipo 2*/
/*View clasificacion*/
CREATE OR REPLACE VIEW clasificacion AS
SELECT 
       ROW_NUMBER() OVER (ORDER BY COUNT(CASE WHEN p.ID_Ganador = e.ID_EQUIPO THEN 1 END) DESC) AS Posicion,
       e.NOMBRE AS Nombre_Equipo, 
       COUNT(CASE WHEN p.ID_Ganador = e.ID_EQUIPO THEN 1 END) AS Victorias, 
       SUM(CASE WHEN p.ID_Ganador = e.ID_EQUIPO THEN p.GOLES_EQ1 ELSE p.GOLES_EQ2 END) AS Goles_a_favor,
       SUM(CASE WHEN p.ID_Ganador = e.ID_EQUIPO THEN p.GOLES_EQ2 ELSE p.GOLES_EQ1 END) AS Goles_en_contra,
       SUM(CASE WHEN p.ID_Ganador = e.ID_EQUIPO THEN p.GOLES_EQ1 ELSE p.GOLES_EQ2 END) - SUM(CASE WHEN p.ID_Ganador = e.ID_EQUIPO THEN p.GOLES_EQ2 ELSE p.GOLES_EQ1 END) AS Diferencia_goles
FROM Equipo e
JOIN Partido p ON (e.ID_EQUIPO = p.ID_Ganador OR e.ID_EQUIPO = p.ID_Perdedor)
GROUP BY e.ID_EQUIPO, e.NOMBRE
ORDER BY
    Victorias DESC, 
    Diferencia_goles DESC;
    