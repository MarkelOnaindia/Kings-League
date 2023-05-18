-- Vista equipos
CREATE OR REPLACE VIEW view_equipos AS
SELECT DISTINCT e.id_equipo, e.Nombre, e.Color_Escudo, e.Equipacion, e.Presupuesto,
        COUNT(ContratosJugador.id_jug) AS cantidad_jugadores
FROM Equipos e
INNER JOIN ContratosJugador ON e.id_equipo = ContratosJugador.id_equipo
GROUP BY e.id_equipo, e.Nombre, e.Color_Escudo, e.Equipacion, e.Presupuesto
Order by ID_EQUIPO;
