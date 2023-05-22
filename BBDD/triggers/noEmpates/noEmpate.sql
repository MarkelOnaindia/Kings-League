/*Kings League equipo 2*/
/*Trigger para evitar empates en los partidos*/
CREATE OR REPLACE TRIGGER no_empates
BEFORE INSERT OR UPDATE ON Partidos
FOR EACH ROW
DECLARE
BEGIN
    IF :NEW.GOLES_EQ1 = :NEW.GOLES_EQ2 THEN
        RAISE_APPLICATION_ERROR(-20001, 'No se permiten empates en los partidos.');
    END IF;
END;
