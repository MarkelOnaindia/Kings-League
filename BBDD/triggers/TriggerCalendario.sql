CREATE OR REPLACE TRIGGER tr_cerrar_temporada

/* Indica que el trigger se activará antes de que se realice una actualización en la tabla "Equipo". */
BEFORE UPDATE ON Equipo

/* Indica que el trigger se ejecutará por cada fila afectada por la actualización. */
FOR EACH ROW

/* Declara una variable llamada "estado_temporada" con el mismo tipo de datos que el campo "ESTADO" de la tabla "Temporada". */
DECLARE
    estado_temporada Temporada.ESTADO%TYPE;
BEGIN

    /* Asigna el valor del campo "ESTADO" de la fila con ID_TEMP=1 en la tabla "Temporada" a la variable "estado_temporada". */
    SELECT ESTADO INTO estado_temporada FROM Temporada WHERE ID_TEMP = 1;

    /* Comprueba si la variable "estado_temporada" es igual a 'Cerrado'. */
    IF estado_temporada = 'Cerrado' THEN

        /* Si la temporada está cerrada, se generará un error de aplicación con el mensaje 'No se pueden actualizar equipos durante una temporada cerrada.'. */
        RAISE_APPLICATION_ERROR(-20001, 'No se pueden actualizar equipos durante una temporada cerrada.');

    END IF;

/* Cierra la estructura de control IF. */
END;

/* Cierra el bloque de código del trigger. */


UPDATE Temporada SET ESTADO = 'Cerrado' WHERE ID_TEMP = 1;
/*Cerramos la temporada*/
UPDATE Equipo SET PRESUPUESTO = 3000000 WHERE ID_EQUIPO = 1;
/*Al hacer el update de equipo podemos ver como salta el error*/

/*
UPDATE Equipo SET PRESUPUESTO = 3000000 WHERE ID_EQUIPO = 1
Informe de error -
ORA-20001: No se pueden actualizar equipos durante una temporada cerrada.
ORA-06512: en "EQDAW02.TR_CERRAR_TEMPORADA", línea 6
ORA-04088: error durante la ejecución del disparador 'EQDAW02.TR_CERRAR_TEMPORADA'
*/




CREATE OR REPLACE TRIGGER tr_cerrar_temporada_jugador

/* Se indica que el trigger se ejecutará antes de una operación de actualización en la tabla Jugador. */

BEFORE UPDATE ON Jugador

/* Se especifica que el trigger se ejecutará una vez por cada fila actualizada. */

FOR EACH ROW

/* Se declara una variable que almacenará el estado de la temporada. */

DECLARE
estado_temporada Temporada.ESTADO%TYPE;
BEGIN
/* Se selecciona el estado de la temporada almacenada en la tabla Temporada. */

SELECT ESTADO INTO estado_temporada FROM Temporada WHERE ID_TEMP = 1;

/* Se comprueba si el estado de la temporada es "Cerrado". Si es así, se lanza un error que indica que no se pueden actualizar jugadores. */

IF estado_temporada = 'Cerrado' THEN
    RAISE_APPLICATION_ERROR(-20001, 'No se pueden actualizar jugadores durante una temporada cerrada.');
END IF;
/* Este es el final del código para crear el trigger. */

END;

UPDATE Jugador SET TELEFONO = '123456789' WHERE ID_JUG = 1;
/*Al hacer el update de equipo podemos ver como salta el error*/


/*Error que empieza en la línea: 59 del comando :
UPDATE Jugador SET TELEFONO = '123456789' WHERE ID_JUG = 1
Informe de error -
ORA-20001: No se pueden actualizar jugadores durante una temporada cerrada.
ORA-06512: en "EQDAW02.TR_CERRAR_TEMPORADA_JUGADOR", línea 6
ORA-04088: error durante la ejecución del disparador 'EQDAW02.TR_CERRAR_TEMPORADA_JUGADOR'*/

