SET SERVEROUTPUT ON;

DECLARE
  cur_equipos SYS_REFCURSOR;
  id_equipo equipo.id_equipo%TYPE;
  nombre_equipo equipo.nombre%TYPE;
  color_escudo equipo.color_escudo%TYPE;
  equipacion equipo.equipacion%TYPE;
  presupuesto_equipo equipo.presupuesto%TYPE;
  cantidad_jug NUMBER;
BEGIN
  info_equipos(cur_equipos);
  LOOP
    FETCH cur_equipos INTO id_equipo, nombre_equipo, color_escudo, equipacion, presupuesto_equipo, cantidad_jug;
    EXIT WHEN cur_equipos%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('Id Equipo: ' || id_equipo );
    DBMS_OUTPUT.PUT_LINE('Nombre: ' || nombre_equipo );
    DBMS_OUTPUT.PUT_LINE('Color Escudo: ' || color_escudo );
    DBMS_OUTPUT.PUT_LINE('Equipacion: ' || equipacion );
    DBMS_OUTPUT.PUT_LINE('Presupuesto Equipo: ' || presupuesto_equipo );
    DBMS_OUTPUT.PUT_LINE('Cantidad Jugadores: ' || cantidad_jug );
    DBMS_OUTPUT.PUT_LINE(' ');
  END LOOP;
  CLOSE cur_equipos;
END;