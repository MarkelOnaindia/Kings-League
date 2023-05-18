-- Vista equipos
CREATE OR REPLACE VIEW view_equipos AS
SELECT DISTINCT e.id_equipo, e.Nombre, e.Color_Escudo, e.Equipacion, e.Presupuesto,
        COUNT(ContratoJugador.id_jug) AS cantidad_jugadores
FROM Equipos e
INNER JOIN ContratoJugadores ON e.id_equipo = ContratoJugadores.id_equipo
GROUP BY e.id_equipo, e.Nombre, e.Color_Escudo, e.Equipacion, e.Presupuesto
Order by ID_EQUIPO;
