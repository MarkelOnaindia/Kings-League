/*Kings League equipo 2*/
/*Procedimientos almacenados*/
    /*Informe de equipo*/
    
    -- Procedimiento info equipos
    CREATE OR REPLACE PROCEDURE info_equipos(
        informacion_equ OUT SYS_REFCURSOR) AS
    BEGIN
      OPEN informacion_equ FOR
      SELECT *
      FROM view_equipos;
    END info_equipos;
    /
    
    /*Informe jugador*/
    -- Procedimiento info jugadores
    CREATE OR REPLACE PROCEDURE info_jugadores(
        informacion_jug OUT SYS_REFCURSOR)
    IS
    BEGIN
      OPEN informacion_jug FOR
      SELECT j.id_jug, j.nombre, j.apellido1, j.apellido2, j.telefono, j.dni, e.Nombre, cj.sueldo, cj.clausula
      FROM Jugadores j, Equipos e, ContratosJugador cj
      WHERE j.id_jug = cj.id_jug AND e.id_equipo = cj.id_equipo;
    END info_jugadores;
    /