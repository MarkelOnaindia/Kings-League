/*Kings League equipo 2*/
/*Comprobacion trigger que evita los empates*/

/*select * from partido;*/
INSERT INTO Partidos VALUES (DEFAULT,1, '16:00', 3, 3,5,6);

/*Al intentar insertar un partido acabado en empate salta el error
Error que empieza en la línea: 13 del comando :
INSERT INTO Partidos VALUES (DEFAULT,1, '16:00', 3, 3,5,6)
Informe de error -
ORA-20001: No se permiten empates en los partidos.
*/
