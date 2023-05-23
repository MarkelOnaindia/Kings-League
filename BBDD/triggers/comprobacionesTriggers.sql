/*Kings League equipo 2*/
/*Creacion de triggers*/

/*Comprobaciones para el trigger de maximo de jugadores*/

/*COMPROBACIONES*/

/*
SELECT * FROM ContratosJugador;
SELECT * FROM JUGADORES;
SELECT * FROM EQUIPOS;
*/
    /*Comprobacion de habituales*/

    INSERT INTO ContratosJugador VALUES (DEFAULT,10,1,10000000,TO_DATE('12/09/2022', 'DD/MM/YYYY'),TO_DATE('10/10/2022', 'DD/MM/YYYY'),1000000,12); --A la hora de insertar el noveno jugadro habitual salta el trigger

    /*Respuesta a la hora de la ultima insercion:
    Error que empieza en la línea: 73 del comando :
    INSERT INTO ContratosJugador VALUES (DEFAULT,10,1,10000000,TO_DATE('12/09/2022', 'DD/MM/YYYY'),TO_DATE('10/10/2022', 'DD/MM/YYYY'),1000000,12)
    Informe de error -
    ORA-20000: NO SE PUEDEN TENER MAS DE 8 JUGADORES DE TIPO HABITUAL
    ORA-06512: en "EQDAW02.MAX_JUGADORES", línea 28
    ORA-04088: error durante la ejecución del disparador 'EQDAW02.MAX_JUGADORES'
    */

    /*Comprobacion de wild cards*/

    INSERT INTO ContratosJugador VALUES (DEFAULT,133,1,10000000,TO_DATE('12/09/2022', 'DD/MM/YYYY'),TO_DATE('10/10/2022', 'DD/MM/YYYY'),1000000,12);--A la hora de insertar el tercer jugadro wildcard salta el trigger
   
    /*Respuesta a la hora de la ultima insercion:
    Error que empieza en la línea: 77 del comando :
    INSERT INTO ContratosJugador VALUES (DEFAULT,133,1,10000000,TO_DATE('12/09/2022', 'DD/MM/YYYY'),TO_DATE('10/10/2022', 'DD/MM/YYYY'),1000000,12)
    Informe de error -
    ORA-20001: NO SE PUEDEN TENER MAS DE 2 JUGADORES DE TIPO WILDCARD
    ORA-06512: en "EQDAW02.MAX_JUGADORES", línea 33
    ORA-04088: error durante la ejecución del disparador 'EQDAW02.MAX_JUGADORES'
    */  
   
    UPDATE ContratosJugador
    SET ID_EQUIPO = 1
    WHERE ID_CONJU = 14;
   
    /*
    Informe de error -
    ORA-04091: la tabla EQDAW02.CONTRATOSJUGADOR está mutando, puede que el disparador/la función no puedan verla
    ORA-06512: en "EQDAW02.TRG_CONTRATOSJUGADOR", línea 5
    ORA-04088: error durante la ejecución del disparador 'EQDAW02.TRG_CONTRATOSJUGADOR'
    */

    /*Comprobacion trigger que evita los empates*/
    
    /*select * from partido;*/
    
    INSERT INTO Partidos VALUES (DEFAULT,1, '16:00', 3, 3,5,6);
    
    /*Al intentar insertar un partido acabado en empate salta el error
    Error que empieza en la línea: 13 del comando :
    INSERT INTO Partidos VALUES (DEFAULT,1, '16:00', 3, 3,5,6)
    Informe de error -
    ORA-20001: No se permiten empates en los partidos.
    */
    
    /*Comprobacion equipos repetidos*/
    
    /*select * from partidos;*/
    
    INSERT INTO Partidos VALUES (DEFAULT,4, '16:00', 3, 1,1,5);
    
    /*Al insertar un partido que ya ha jugado su partido en una jornada salta el error
    Error que empieza en la línea: 20 del comando :
    INSERT INTO Partidos VALUES (DEFAULT,4, '16:00', 3, 1,1,5)
    Informe de error -
    ORA-20001: El mismo equipo no puede jugar dos veces en la misma jornada.
    */
    
    /*Dos triggers del calendario*/
    
    /*Modificar jugadores*/
    
        UPDATE Jugadores SET TELEFONO = '123456789' WHERE ID_JUG = 1;
        /*Al hacer el update de equipo podemos ver como salta el error*/
       
       
        /*Error que empieza en la línea: 59 del comando :
        UPDATE Jugadores SET TELEFONO = '123456789' WHERE ID_JUG = 1
        Informe de error -
        ORA-20001: No se pueden actualizar jugadores durante una temporada cerrada.
        ORA-06512: en "EQDAW02.TR_CERRAR_TEMPORADA_JUGADOR", línea 6
        ORA-04088: error durante la ejecución del disparador 'EQDAW02.TR_CERRAR_TEMPORADA_JUGADOR'*/
    
     /*Modificar equipo*/
    
        UPDATE Temporadas SET ESTADO = 'Cerrado' WHERE ID_TEMP = 1;
        /*Cerramos la temporada*/
        UPDATE Equipos SET PRESUPUESTO = 3000000 WHERE ID_EQUIPO = 1;
        /*Al hacer el update de equipo podemos ver como salta el error*/
       
        /*
        UPDATE Equipos SET PRESUPUESTO = 3000000 WHERE ID_EQUIPO = 1
        Informe de error -
        ORA-20001: No se pueden actualizar equipos durante una temporada cerrada.
        ORA-06512: en "EQDAW02.TR_CERRAR_TEMPORADA", línea 6
        ORA-04088: error durante la ejecución del disparador 'EQDAW02.TR_CERRAR_TEMPORADA'
        */
    
    /*Comprobacion trigger maximo de presupuesto*/
    
    INSERT INTO ContratosJugador VALUES (DEFAULT,4,3,10000000,TO_DATE('12/09/2022', 'DD/MM/YYYY'),TO_DATE('10/10/2022', 'DD/MM/YYYY'),200000000,1);
    /*Probamos a meter un jugador que supere los 200.0000.000€*/
    
    /* y nos salta el error
    
    INSERT INTO ContratosJugador VALUES (DEFAULT,4,3,10000000,TO_DATE('12/09/2022', 'DD/MM/YYYY'),TO_DATE('10/10/2022', 'DD/MM/YYYY'),200000000,1)
    Informe de error -
    ORA-20001: La suma del sueldo y clausula de los jugadores supera los 200000000
    ORA-06512: en "EQDAW02.TRG_CONTRATOJUGADOR", línea 9
    ORA-04088: error durante la ejecución del disparador 'EQDAW02.TRG_CONTRATOJUGADOR' */