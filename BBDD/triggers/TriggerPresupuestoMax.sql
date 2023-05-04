CREATE OR REPLACE TRIGGER TRG_CONTRATOJUGADOR
BEFORE INSERT OR UPDATE ON ContratoJugador
FOR EACH ROW
DECLARE
    v_total NUMBER;
BEGIN
    /* Selecciona la suma de sueldo y cláusula de todos los jugadores de un equipo */
    SELECT SUM(Sueldo + Clausula) INTO v_total
    FROM ContratoJugador
    WHERE ID_EQUIPO = :NEW.ID_EQUIPO;
    
    /* Si la suma total más el nuevo sueldo y cláusula del jugador supera los 200000000 */
    IF v_total + NVL(:NEW.Sueldo,0) + NVL(:NEW.Clausula,0) > 200000000 THEN
        /* Se lanza un error personalizado */
        RAISE_APPLICATION_ERROR(-20001, 'La suma del sueldo y clausula de los jugadores supera los 200000000');
    END IF;
END;



INSERT INTO ContratoJugador VALUES (DEFAULT,4,3,10000000,TO_DATE('12/09/2022', 'DD/MM/YYYY'),TO_DATE('10/10/2022', 'DD/MM/YYYY'),200000000,1);
/*Probamos a meter un jugador que supere los 200.0000.000€*/

/* y nos salta el error

INSERT INTO ContratoJugador VALUES (DEFAULT,4,3,10000000,TO_DATE('12/09/2022', 'DD/MM/YYYY'),TO_DATE('10/10/2022', 'DD/MM/YYYY'),200000000,1)
Informe de error -
ORA-20001: La suma del sueldo y clausula de los jugadores supera los 200000000
ORA-06512: en "EQDAW02.TRG_CONTRATOJUGADOR", línea 9
ORA-04088: error durante la ejecución del disparador 'EQDAW02.TRG_CONTRATOJUGADOR' */