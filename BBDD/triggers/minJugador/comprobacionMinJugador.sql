/*Kings League equipo 2*/
/*Comprobacion trigger de minimo de jugadores*/
/*Comprobaciones*/

/*select * from Temporadas;*/
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
/*select * from ContratosJugador;*/

UPDATE Temporadas SET ESTADO = 'Cerrado' WHERE ID_TEMP = 1;

/*Probamos a poner el estado en cerrado sin tener todos los equipos con 8 jugadores

Error que empieza en la línea: 64 del comando :
UPDATE Temporadas SET ESTADO = 'Cerrado' WHERE ID_TEMP = 1
Informe de error -
ORA-20001: El equipo 2 no tiene al menos 8 jugadores
ORA-06512: en "EQDAW02.TRG_VERIF_JUGADORES", línea 12
ORA-04088: error durante la ejecución del disparador 'EQDAW02.TRG_VERIF_JUGADORES'
*/ 

/*Ponemos 8 jugadores a cada equipo y lo volvemos a intentar*/

/*1 fila actualizadas*/
