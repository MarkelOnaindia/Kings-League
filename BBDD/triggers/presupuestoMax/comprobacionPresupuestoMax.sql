/*Kings League equipo 2*/
/*Comprobacion trigger maximo de presupuesto*/

INSERT INTO ContratosJugador VALUES (DEFAULT,4,3,10000000,TO_DATE('12/09/2022', 'DD/MM/YYYY'),TO_DATE('10/10/2022', 'DD/MM/YYYY'),200000000,1);
/*Probamos a meter un jugador que supere los 200.0000.000€*/

/* y nos salta el error

INSERT INTO ContratosJugador VALUES (DEFAULT,4,3,10000000,TO_DATE('12/09/2022', 'DD/MM/YYYY'),TO_DATE('10/10/2022', 'DD/MM/YYYY'),200000000,1)
Informe de error -
ORA-20001: La suma del sueldo y clausula de los jugadores supera los 200000000
ORA-06512: en "EQDAW02.TRG_CONTRATOJUGADOR", línea 9
ORA-04088: error durante la ejecución del disparador 'EQDAW02.TRG_CONTRATOJUGADOR' */
