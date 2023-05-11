/*Kings League equipo 2*/
/*Comprobacion equipos repetidos*/

/*select * from partido;*/
INSERT INTO Partido VALUES (DEFAULT,4, '16:00', 3, 1,1,5);

/*Al insertar un partdio que ya ha jugado su partido en una jornada salta el error
Error que empieza en la línea: 20 del comando :
INSERT INTO Partido VALUES (DEFAULT,4, '16:00', 3, 1,1,5)
Informe de error -
ORA-20001: El mismo equipo no puede jugar dos veces en la misma jornada.
*/