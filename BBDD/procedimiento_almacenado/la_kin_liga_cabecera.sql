CREATE OR REPLACE PACKAGE relacion_equipo AS
    PROCEDURE info_equipos(informacion_equ OUT SYS_REFCURSOR);
    PROCEDURE info_jugadores(informacion_jug OUT SYS_REFCURSOR);
END relacion_equipo;