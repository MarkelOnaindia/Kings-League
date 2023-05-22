/*Kings League equipo 2*/
/*Trigger que comprueba que al cerrar la temporada cada equipo deba tener
un minimo de  8 jugadores*/

-- Creación del trigger trg_verif_jugadores
CREATE OR REPLACE TRIGGER trg_verif_jugadores
BEFORE UPDATE OF ESTADO ON Temporadas -- Se dispara antes de que se actualice la columna ESTADO en la tabla Temporadas
FOR EACH ROW -- Se ejecuta por cada fila afectada

DECLARE
    num_jugadores INTEGER; -- Variable para almacenar el número de jugadores de cada equipo

BEGIN

    -- Verificar que todos los equipos tienen al menos 8 jugadores
    FOR equipo IN (SELECT ID_EQUIPO FROM Equipos) -- Por cada equipo en la tabla Equipo
    LOOP
        -- Contar el número de jugadores que tiene el equipo actual
        SELECT COUNT(*) INTO num_jugadores
        FROM ContratosJugador
        WHERE ID_EQUIPO = equipo.ID_EQUIPO;

        -- Si el equipo actual tiene menos de 8 jugadores, lanzar un error
        IF num_jugadores < 8 THEN
            RAISE_APPLICATION_ERROR(-20001, 'El equipo ' || equipo.ID_EQUIPO || ' no tiene al menos 8 jugadores');
        END IF;
    END LOOP;
    
    -- Verificar que el estado de la temporada no se actualice a "Cerrado" si hay equipos con menos de 8 jugadores
    IF :NEW.ESTADO = 'Cerrado' THEN -- Si se intenta actualizar el estado a 'Cerrado'
        FOR equipos IN (SELECT ID_EQUIPO FROM Equipos) -- Por cada equipo en la tabla Equipos
        LOOP
            -- Contar el número de jugadores que tiene el equipo actual
            SELECT COUNT(*) INTO num_jugadores
            FROM ContratosJugador
            WHERE ID_EQUIPO = equipo.ID_EQUIPO;

            -- Si el equipo actual tiene menos de 8 jugadores, lanzar un error
            IF num_jugadores < 8 THEN
                RAISE_APPLICATION_ERROR(-20002, 'No se puede cerrar la temporada porque el equipo ' || equipo.ID_EQUIPO || ' no tiene al menos 8 jugadores');
            END IF;
        END LOOP;
    END IF;

END;
