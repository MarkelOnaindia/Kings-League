-- Procedimiento info jugadores
CREATE OR REPLACE PROCEDURE info_jugadores(
    informacion_jug OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN informacion_jug FOR
  SELECT j.id_jug, j.nombre, j.apellido1, j.apellido2, j.telefono, j.dni, e.Nombre, cj.sueldo, cj.clausula
  FROM Jugador j, Equipo e, ContratoJugador cj
  WHERE j.id_jug = cj.id_jug AND e.id_equipo = cj.id_equipo;
END;
