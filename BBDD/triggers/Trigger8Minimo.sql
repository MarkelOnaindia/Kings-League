select * from ContratoJugador;

-- Creación del trigger trg_verif_jugadores
CREATE OR REPLACE TRIGGER trg_verif_jugadores
BEFORE UPDATE OF ESTADO ON Temporada -- Se dispara antes de que se actualice la columna ESTADO en la tabla Temporada
FOR EACH ROW -- Se ejecuta por cada fila afectada

DECLARE
    num_jugadores INTEGER; -- Variable para almacenar el número de jugadores de cada equipo

BEGIN

    -- Verificar que todos los equipos tienen al menos 8 jugadores
    FOR equipo IN (SELECT ID_EQUIPO FROM Equipo) -- Por cada equipo en la tabla Equipo
    LOOP
        -- Contar el número de jugadores que tiene el equipo actual
        SELECT COUNT(*) INTO num_jugadores
        FROM ContratoJugador
        WHERE ID_EQUIPO = equipo.ID_EQUIPO;

        -- Si el equipo actual tiene menos de 8 jugadores, lanzar un error
        IF num_jugadores < 8 THEN
            RAISE_APPLICATION_ERROR(-20001, 'El equipo ' || equipo.ID_EQUIPO || ' no tiene al menos 8 jugadores');
        END IF;
    END LOOP;
    
    -- Verificar que el estado de la temporada no se actualice a "Cerrado" si hay equipos con menos de 8 jugadores
    IF :NEW.ESTADO = 'Cerrado' THEN -- Si se intenta actualizar el estado a 'Cerrado'
        FOR equipo IN (SELECT ID_EQUIPO FROM Equipo) -- Por cada equipo en la tabla Equipo
        LOOP
            -- Contar el número de jugadores que tiene el equipo actual
            SELECT COUNT(*) INTO num_jugadores
            FROM ContratoJugador
            WHERE ID_EQUIPO = equipo.ID_EQUIPO;

            -- Si el equipo actual tiene menos de 8 jugadores, lanzar un error
            IF num_jugadores < 8 THEN
                RAISE_APPLICATION_ERROR(-20002, 'No se puede cerrar la temporada porque el equipo ' || equipo.ID_EQUIPO || ' no tiene al menos 8 jugadores');
            END IF;
        END LOOP;
    END IF;

END;


/*Comprobaciones*/

select * from Temporada;

/*
   ID_TEMP TIPO       ESTADO    
---------- ---------- ----------
         1 Invierno   Abierto   
         2 Verano     Abierto   
         3 Invierno   Abierto   
         4 Verano     Abierto   
         5 Invierno   Abierto   
         6 Verano     Abierto   
         7 Invierno   Abierto   
         8 Verano     Abierto   
         9 Invierno   Abierto   
        10 Verano     Abierto

*/




select * from ContratoJugador;




UPDATE Temporada SET ESTADO = 'Cerrado' WHERE ID_TEMP = 1;

/*Probamos a poner el estado en cerrado sin tener todos los equipos con 8 jugadores

Error que empieza en la línea: 64 del comando :
UPDATE Temporada SET ESTADO = 'Cerrado' WHERE ID_TEMP = 1
Informe de error -
ORA-20001: El equipo 2 no tiene al menos 8 jugadores
ORA-06512: en "EQDAW02.TRG_VERIF_JUGADORES", línea 12
ORA-04088: error durante la ejecución del disparador 'EQDAW02.TRG_VERIF_JUGADORES'
*/ 

/*Ponemos 8 jugadores a cada equipo y lo volvemos a intentar*/

/*1 fila actualizadas*/
