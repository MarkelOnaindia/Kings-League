/*Kings League equipo 2*/

    /*Trigger verificar que cada equipo solo puede jugar una vez por jornada*/
    CREATE OR REPLACE TRIGGER tr_partido_evitar_repetidos
    BEFORE INSERT ON Partidos
    FOR EACH ROW
    DECLARE
        v_count NUMBER;
    BEGIN
        IF :NEW.ID_JOR = 13 THEN
            RETURN; -- Si es la jornada número 13, se ignora la validación
        END IF;
    
        SELECT COUNT(*) INTO v_count
        FROM Partidos
        WHERE ID_JOR = :NEW.ID_JOR
            AND (ID_Ganador = :NEW.ID_Ganador OR ID_Perdedor = :NEW.ID_Ganador
                 OR ID_Ganador = :NEW.ID_Perdedor OR ID_Perdedor = :NEW.ID_Perdedor);
    
        IF v_count > 0 THEN
            RAISE_APPLICATION_ERROR(-20001, 'El mismo equipo no puede jugar dos veces en la misma jornada.');
        END IF;
    END tr_partido_evitar_repetidos;
    /
    /*Trigger que controla el maximo de jugadores*/
    CREATE OR REPLACE TRIGGER MAX_JUGADORES
    FOR INSERT OR UPDATE ON ContratosJugador 
    COMPOUND TRIGGER
    
        /*Variables*/
        num_habituales NUMBER(2);
        num_wildcards NUMBER;
        new_tipo_jug VARCHAR(20);
    
     BEFORE EACH ROW IS
     BEGIN
        /*Select para sacar recuento de jugadores habituales de un equipo*/
        SELECT COUNT(*) INTO num_habituales
        FROM ContratosJugador
        WHERE ID_EQUIPO = :NEW.ID_EQUIPO
        AND ID_JUG IN (SELECT ID_JUG 
                       FROM JUGADORES WHERE UPPER(TIPO) = 'HABITUAL');
    
        /*Select para sacar recuento de jugadores wildcard de un equipo*/
        SELECT COUNT(*) INTO num_wildcards
        FROM ContratosJugador
        WHERE ID_EQUIPO = :NEW.ID_EQUIPO
        AND ID_JUG IN (SELECT ID_JUG 
                       FROM JUGADORES WHERE UPPER(TIPO) = 'WILDCARD');
            
        SELECT TIPO INTO NEW_TIPO_JUG FROM JUGADORES WHERE ID_JUG = :NEW.ID_JUG;     
        
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
    /
    /*Trigger para evitar empates en los partidos*/
    CREATE OR REPLACE TRIGGER no_empates
    BEFORE INSERT OR UPDATE ON Partidos
    FOR EACH ROW
    DECLARE
    BEGIN
        IF :NEW.GOLES_EQ1 = :NEW.GOLES_EQ2 THEN
            RAISE_APPLICATION_ERROR(-20001, 'No se permiten empates en los partidos.');
        END IF;
    END no_empates;
    /
    /*Kings League equipo 2*/
    
    CREATE OR REPLACE TRIGGER TRG_CONTRATOJUGADOR
    BEFORE INSERT OR UPDATE ON ContratosJugador
    FOR EACH ROW
    DECLARE
        v_total NUMBER;
    BEGIN
        /* Selecciona la suma de sueldo y cláusula de todos los jugadores de un equipo */
        SELECT SUM(Sueldo + Clausula) INTO v_total
        FROM ContratosJugador
        WHERE ID_EQUIPO = :NEW.ID_EQUIPO;
        
        /* Si la suma total más el nuevo sueldo y cláusula del jugador supera los 200000000 */
        IF v_total + NVL(:NEW.Sueldo,0) + NVL(:NEW.Clausula,0) > 200000000 THEN
            /* Se lanza un error personalizado */
            RAISE_APPLICATION_ERROR(-20001, 'La suma del sueldo y clausula de los jugadores supera los 200000000');
        END IF;
    END TRG_CONTRATOJUGADOR;
    /
    /*Calendario*/
        /*Trigger para el calendario sobre el jugadores*/
        
            /*Trigger modificar jugadores*/
            CREATE OR REPLACE TRIGGER tr_cerrar_temporada_jugador
            
            /* Se indica que el trigger se ejecutará antes de una operación de actualización en la tabla Jugadores. */
            
            BEFORE UPDATE ON Jugadores
            
            /* Se especifica que el trigger se ejecutará una vez por cada fila actualizada. */
            
            FOR EACH ROW
            
            /* Se declara una variable que almacenará el estado de la temporada. */
            
            DECLARE
            estado_temporada Temporadas.ESTADO%TYPE;
            BEGIN
            /* Se selecciona el estado de la temporada almacenada en la tabla Temporadas. */
            
            SELECT ESTADO INTO estado_temporada FROM Temporadas WHERE ID_TEMP = 1;
            
            /* Se comprueba si el estado de la temporada es "Cerrado". Si es así, se lanza un error que indica que no se pueden actualizar jugadores. */
            
            IF estado_temporada = 'Cerrado' THEN
                RAISE_APPLICATION_ERROR(-20001, 'No se pueden actualizar jugadores durante una temporada cerrada.');
            END IF;
            /* Este es el final del código para crear el trigger. */
            
            END tr_cerrar_temporada_jugador;
            /
            /*Trigger para el calendario sobre el equipo*/
            
                /*Trigger modificar equipo*/
                CREATE OR REPLACE TRIGGER tr_cerrar_temporada_equipo
                
                /* Indica que el trigger se activará antes de que se realice una actualización en la tabla "Equipo". */
                BEFORE UPDATE ON Equipos
                
                /* Indica que el trigger se ejecutará por cada fila afectada por la actualización. */
                FOR EACH ROW
                
                /* Declara una variable llamada "estado_temporada" con el mismo tipo de datos que el campo "ESTADO" de la tabla "Temporada". */
                DECLARE
                    estado_temporada Temporadas.ESTADO%TYPE;
                BEGIN
                
                    /* Asigna el valor del campo "ESTADO" de la fila con ID_TEMP=1 en la tabla "Temporada" a la variable "estado_temporada". */
                    SELECT ESTADO INTO estado_temporada FROM Temporadas WHERE ID_TEMP = 1;
                
                    /* Comprueba si la variable "estado_temporada" es igual a 'Cerrado'. */
                    IF estado_temporada = 'Cerrado' THEN
                
                        /* Si la temporada está cerrada, se generará un error de aplicación con el mensaje 'No se pueden actualizar equipos durante una temporada cerrada.'. */
                        RAISE_APPLICATION_ERROR(-20001, 'No se pueden actualizar equipos durante una temporada cerrada.');
                
                    END IF;
                
                /* Cierra la estructura de control IF. */
                END tr_cerrar_temporada_equipo;
                /
                /* Cierra el bloque de código del trigger. */
                
    
