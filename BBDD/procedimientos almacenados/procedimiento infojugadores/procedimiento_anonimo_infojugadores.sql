SET SERVEROUTPUT ON;

DECLARE
  cur_jugadores SYS_REFCURSOR;
  id_jugador jugador.id_jug%TYPE;
  nombre_jugador jugador.nombre%TYPE;
  apellido1_jugador jugador.apellido1%TYPE;
  apellido2_jugador jugador.apellido2%TYPE;
  telefono_jugador jugador.telefono%TYPE;
  dni_jugador jugador.dni%TYPE;
  posicion_jugador jugador.posicion%TYPE;
  nombre_equipo equipo.nombre%TYPE;
  sueldo_jugador contratojugador.sueldo%TYPE;
  clausula_jugador contratojugador.clausula%TYPE;
BEGIN
  info_jugadores(cur_jugadores);
  LOOP
    FETCH cur_jugadores INTO id_jugador, nombre_jugador, apellido1_jugador,apellido2_jugador,telefono_jugador, dni_jugador, posicion_jugador, nombre_equipo, sueldo_jugador, clausula_jugador;
    EXIT WHEN cur_jugadores%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('Id Jugador: ' || id_jugador );
    DBMS_OUTPUT.PUT_LINE('Nombre: ' || nombre_jugador );
    DBMS_OUTPUT.PUT_LINE('Apellido1: ' || apellido1_jugador );
    DBMS_OUTPUT.PUT_LINE('Apellido2: ' || apellido2_jugador );
    DBMS_OUTPUT.PUT_LINE('Telefono: ' || telefono_jugador );
    DBMS_OUTPUT.PUT_LINE('DNI: ' || dni_jugador );
    DBMS_OUTPUT.PUT_LINE('Posición: ' || posicion_jugador );
    DBMS_OUTPUT.PUT_LINE('Equipo: ' || nombre_equipo);
    DBMS_OUTPUT.PUT_LINE('Sueldo: ' || sueldo_jugador);
    DBMS_OUTPUT.PUT_LINE('Clausula: ' || clausula_jugador );
    DBMS_OUTPUT.PUT_LINE(' ');
  END LOOP;
  CLOSE cur_jugadores;
END;
