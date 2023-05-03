DROP TRIGGER MAX_JUGADORES;

CREATE OR REPLACE TRIGGER MAX_JUGADORES
FOR INSERT OR UPDATE ON ContratoJugador 
COMPOUND TRIGGER

    /*Variables*/
    num_habituales NUMBER(2);
    num_wildcards NUMBER;
    new_tipo_jug VARCHAR(20);

 BEFORE EACH ROW IS
 BEGIN
    /*Select para sacar recuento de jugadores habituales de un equipo*/
    SELECT COUNT(*) INTO num_habituales
    FROM ContratoJugador
    WHERE ID_EQUIPO = :NEW.ID_EQUIPO
    AND ID_JUG IN (SELECT ID_JUG 
                   FROM JUGADOR WHERE UPPER(TIPO) = 'HABITUAL');

    /*Select para sacar recuento de jugadores wildcard de un equipo*/
    SELECT COUNT(*) INTO num_wildcards
    FROM ContratoJugador
    WHERE ID_EQUIPO = :NEW.ID_EQUIPO
    AND ID_JUG IN (SELECT ID_JUG 
                   FROM JUGADOR WHERE UPPER(TIPO) = 'WILDCARD');
        
    SELECT TIPO INTO NEW_TIPO_JUG FROM JUGADOR WHERE ID_JUG = :NEW.ID_JUG;     
    
 END BEFORE EACH ROW;
 AFTER EACH ROW IS
 BEGIN

    /*Condicion si los jugadores wildcard superan 2*/
    IF UPPER(NEW_TIPO_JUG) = 'WILDCARD' THEN
        IF num_wildcards = 2 THEN
            RAISE_APPLICATION_ERROR(-20001, 'NO SE PUEDEN TENER MAS DE 2 JUGADORES DE TIPO WILDCARD');
        END IF;
    ELSE

    /*Condicion si los jugadores habituales superan 8*/
        IF num_habituales = 8 THEN
            RAISE_APPLICATION_ERROR(-20001, 'NO SE PUEDEN TENER MAS DE 8 JUGADORES DE TIPO HABITUAL');
        END IF;
    END IF;
END AFTER EACH ROW;  
END MAX_JUGADORES;

/*COMPROBACIONES*/
SELECT * FROM ContratoJugador;
SELECT * FROM JUGADOR;
SELECT * FROM EQUIPO;

    /*Comprobacion de habituales*/
    INSERT INTO ContratoJugador VALUES (DEFAULT,1,1,10000000,TO_DATE('12/09/2022', 'DD/MM/YYYY'),TO_DATE('10/10/2022', 'DD/MM/YYYY'),1000000,12);
    INSERT INTO ContratoJugador VALUES (DEFAULT,2,1,10000000,TO_DATE('12/09/2022', 'DD/MM/YYYY'),TO_DATE('10/10/2022', 'DD/MM/YYYY'),1000000,12);
    INSERT INTO ContratoJugador VALUES (DEFAULT,3,1,10000000,TO_DATE('12/09/2022', 'DD/MM/YYYY'),TO_DATE('10/10/2022', 'DD/MM/YYYY'),1000000,12);
    INSERT INTO ContratoJugador VALUES (DEFAULT,4,1,10000000,TO_DATE('12/09/2022', 'DD/MM/YYYY'),TO_DATE('10/10/2022', 'DD/MM/YYYY'),1000000,12);
    INSERT INTO ContratoJugador VALUES (DEFAULT,5,1,10000000,TO_DATE('12/09/2022', 'DD/MM/YYYY'),TO_DATE('10/10/2022', 'DD/MM/YYYY'),1000000,12);
    INSERT INTO ContratoJugador VALUES (DEFAULT,6,1,10000000,TO_DATE('12/09/2022', 'DD/MM/YYYY'),TO_DATE('10/10/2022', 'DD/MM/YYYY'),1000000,12);
    INSERT INTO ContratoJugador VALUES (DEFAULT,7,1,10000000,TO_DATE('12/09/2022', 'DD/MM/YYYY'),TO_DATE('10/10/2022', 'DD/MM/YYYY'),1000000,12);
    INSERT INTO ContratoJugador VALUES (DEFAULT,9,1,10000000,TO_DATE('12/09/2022', 'DD/MM/YYYY'),TO_DATE('10/10/2022', 'DD/MM/YYYY'),1000000,12); --Hasta aqui se insertan 8 jugadores habituales
    INSERT INTO ContratoJugador VALUES (DEFAULT,10,1,10000000,TO_DATE('12/09/2022', 'DD/MM/YYYY'),TO_DATE('10/10/2022', 'DD/MM/YYYY'),1000000,12); --A la hora de insertar el noveno jugadro habitual salta el trigger

    /*Respuesta a la hora de la ultima insercion:
    Error que empieza en la línea: 73 del comando :
    INSERT INTO ContratoJugador VALUES (DEFAULT,10,1,10000000,TO_DATE('12/09/2022', 'DD/MM/YYYY'),TO_DATE('10/10/2022', 'DD/MM/YYYY'),1000000,12)
    Informe de error -
    ORA-20000: NO SE PUEDEN TENER MAS DE 8 JUGADORES DE TIPO HABITUAL
    ORA-06512: en "EQDAW02.MAX_JUGADORES", línea 28
    ORA-04088: error durante la ejecución del disparador 'EQDAW02.MAX_JUGADORES'
    */

    /*Comprobacion de wild cards*/
    INSERT INTO ContratoJugador VALUES (DEFAULT,127,1,10000000,TO_DATE('12/09/2022', 'DD/MM/YYYY'),TO_DATE('10/10/2022', 'DD/MM/YYYY'),1000000,12);
    INSERT INTO ContratoJugador VALUES (DEFAULT,128,1,10000000,TO_DATE('12/09/2022', 'DD/MM/YYYY'),TO_DATE('10/10/2022', 'DD/MM/YYYY'),1000000,12);--Hasta aqui se insertan 2 jugadores wildcard
    INSERT INTO ContratoJugador VALUES (DEFAULT,133,1,10000000,TO_DATE('12/09/2022', 'DD/MM/YYYY'),TO_DATE('10/10/2022', 'DD/MM/YYYY'),1000000,12);--A la hora de insertar el tercer jugadro wildcard salta el trigger

    
    /*Respuesta a la hora de la ultima insercion:
    Error que empieza en la línea: 77 del comando :
    INSERT INTO ContratoJugador VALUES (DEFAULT,133,1,10000000,TO_DATE('12/09/2022', 'DD/MM/YYYY'),TO_DATE('10/10/2022', 'DD/MM/YYYY'),1000000,12)
    Informe de error -
    ORA-20001: NO SE PUEDEN TENER MAS DE 2 JUGADORES DE TIPO WILDCARD
    ORA-06512: en "EQDAW02.MAX_JUGADORES", línea 33
    ORA-04088: error durante la ejecución del disparador 'EQDAW02.MAX_JUGADORES'
    */  