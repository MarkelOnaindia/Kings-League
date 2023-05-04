-- Vista equipos
CREATE OR REPLACE VIEW view_equipos AS
SELECT e.id_equipo, e.Nombre, e.Presupuesto, COUNT(ContratoJugador.id_jug) AS cantidad_jugadores
FROM Equipo e
INNER JOIN ContratoJugador ON e.id_equipo = ContratoJugador.id_jug
GROUP BY e.id_equipo, e.Nombre, e.Presupuesto
Order by ID_EQUIPO;
