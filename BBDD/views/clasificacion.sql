/*Kings League equipo 2*/
/*View clasificacion*/
CREATE OR REPLACE VIEW clasificaciones AS
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
    
