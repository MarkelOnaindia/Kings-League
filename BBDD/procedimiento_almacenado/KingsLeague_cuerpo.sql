CREATE OR REPLACE PACKAGE BODY relacion_equipo IS

-- Procedimiento info equipos
PROCEDURE info_equipos(
    informacion_equ OUT SYS_REFCURSOR) AS
BEGIN
  OPEN informacion_equ FOR
  SELECT *
  FROM view_equipos;
END info_equipos;

-- Procedimiento info jugadores
PROCEDURE info_jugadores(
    informacion_jug OUT SYS_REFCURSOR) AS
BEGIN
  OPEN informacion_jug FOR
  SELECT j.nombre, j.apellido1, j.apellido2, j.telefono, j.dni, e.Nombre
  FROM Jugador j
  INNER JOIN Equipo e ON j.id_jug = e.id_equipo;
END info_jugadores;

END relacion_equipo;
