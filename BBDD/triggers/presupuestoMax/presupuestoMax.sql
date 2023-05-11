/*Kings League equipo 2*/
/*Trigger que comprueba que el presupuesto maximo del equipo*/

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