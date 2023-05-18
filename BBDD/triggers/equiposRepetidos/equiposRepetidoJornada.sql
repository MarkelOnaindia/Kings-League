/*Kings League equipo 2*/
/*Trigger verificar que cada equipo solo puede jugar una vez por jornada*/
CREATE OR REPLACE TRIGGER tr_partido_evitar_repetidos
BEFORE INSERT ON Partidos
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    IF :NEW.ID_JOR = 13 THEN
        RETURN; -- Si es la jornada número 13, se ignora la validación
    END IF;

    SELECT COUNT(*) INTO v_count
    FROM Partidos
    WHERE ID_JOR = :NEW.ID_JOR
        AND (ID_Ganador = :NEW.ID_Ganador OR ID_Perdedor = :NEW.ID_Ganador
             OR ID_Ganador = :NEW.ID_Perdedor OR ID_Perdedor = :NEW.ID_Perdedor);

    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'El mismo equipo no puede jugar dos veces en la misma jornada.');
    END IF;
END;
