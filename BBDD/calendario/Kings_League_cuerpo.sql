CREATE OR REPLACE PACKAGE BODY calendario AS
  PROCEDURE generar_calendario AS
  
  C_ID_GANADOR PARTIDO.ID_GANADOR%TYPE;
  C_ID_PERDEDOR PARTIDO.ID_PERDEDOR%TYPE;
  C_ID_PARTIDO PARTIDO.ID_PARTIDO%TYPE; 
  C_HORA_PARTIDO VARCHAR2(5):= '16:00';
  C_DIA_JORNADA DATE:= TO_DATE('01/01/2024','DD/MM/YYYY');
  C_ID_JORNADA JORNADA.ID_JOR%TYPE;
  C_ID_TEMPORADA NUMBER;
  C_ENFRENTAMIENTO NUMBER;
  C_PARTIDOS_CREADOS NUMBER;
  C_ID_EQUIPO EQUIPO.ID_EQUIPO%TYPE;
  
  BEGIN
  
  --GENERAR TEMPORADAS
  INSERT INTO TEMPORADAS(TIPO,ESTADO)
  VALUES('VERANO','ABIERTO');
  
  SELECT ID_TEMP INTO C_ID_TEMPORADA
  FROM TEMPORADAS
  WHERE ROWNUM = 1
  ORDER BY ID_TEMP DESC;
  
  --GENERAR JORNADAS
  FOR NUM_JOR IN 1..11 LOOP
  
  
  INSERT INTO  JORNADAS(ID_TEMP,DIA,TIPO)
  VALUES(C_ID_TEMPORADA,C_DIA_JORNADA,'FaseRegular');
  C_DIA_JORNADA:= C_DIA_JORNADA +7;
  END LOOP;
  
  --CREACION DE LOS PARTIDOS  PARA LAS JORNADAS
  
  SELECT MIN(ID_JOR) INTO C_ID_JORNADA
  FROM JORNADAS
  WHERE ID_TEMP = C_ID_TEMPORADA;
  C_ENFRENTAMIENTO:=1;
  FOR 
   ID_GANADOR IN(SELECT * FROM PARTIDO) 
   LOOP
   SELECT MIN(ID_JOR) INTO C_ID_JORNADA
   FROM JORNADAS
   WHERE ID_TEMP= C_ID_TEMPORADA;
   
   FOR ID_PERDEDOR IN (SELECT * FROM PARTIDO) 
   LOOP
 /*IF C_ID_GANADOR != C_ID_PERDEDOR THEN*/
   SELECT COUNT(ID_PARTIDO) INTO C_PARTIDOS_CREADOS
   FROM PARTIDOS
   WHERE(ID_PARTIDO IN (SELECT ID_PARTIDO
                    FROM PARTIDO 
                    WHERE  ID_EQUIPO= PARTIDO.ID_GANADOR
                    AND ID_PARTIDO IN (SELECT ID_PARTIDO
                                       FROM PARTIDOS
                                       WHERE ID_JOR=C_ID_JORNADA)))
                                       
    OR(ID_PARTIDO IN(SELECT ID_PARTIDO
                     FROM PARTIDOS
                     WHERE ID_EQUIPO=PARTIDO.ID_PERDEDOR
                     AND ID_PARTIDO IN(SELECT ID_PARTIDO
                                       FROM PARTIDOS
                                       WHERE ID_JOR=C_ID_JORNADA)));
   
   
   
   IF C_PARTIDOS_CREADOS != 0 THEN
            
            IF C_ID_GANADOR  <> C_ID_PERDEDOR THEN
                
                SELECT COUNT(ID_PARTIDO) INTO C_PARTIDOS_CREADOS
                FROM PARTIDOS
   WHERE(ID_PARTIDO IN(SELECT ID_GANADOR
                       FROM PARTIDOS
                       WHERE ID_EQUIPO=PARTIDO.ID_GANADOR
                       AND ID_PARTIDO IN(SELECT ID_PARTIDO
                                         FROM PARTIDOS
                                         WHERE ID_EQUIPO=PARTIDO.ID_GANADOR)))
                                         
    OR (ID_PARTIDO IN (SELECT ID_PERDEDOR
                       FROM PARTIDOS
                       WHERE ID_EQUIPO=PARTIDO.ID_PERDEDOR
                       AND ID_PARTIDO IN (SELECT ID_PARTIDO
                                          FROM PARTIDOS
                                          WHERE ID_EQUIPO=PARTIDO.ID_PERDEDOR)))
                                          
    OR (ID_PARTIDO IN (SELECT ID_PARTIDO
                             FROM PARTIDOS
                             WHERE ID_EQUIPO = PARTIDO.ID_GANADOR
                             AND ID_PARTIDO IN (SELECT ID_PARTIDO
                                               FROM PARTIDOS
                                               WHERE ID_JOR = C_ID_JORNADA)));
   
   
   IF C_PARTIDOS_CREADOS = 0 THEN
   C_ID_GANADOR := ID_EQUIPO1;
   C_ID_PERDEDOR := ID_EQUIPO2;
   
   INSERT INTO PARTIDOS(HORA, ID_JOR) VALUES
   (C_HORA_PARTIDO,C_ID_JORNADA);
   
    SELECT ID_PARTIDO INTO C_ID_PARTIDO
   FROM PARTIDOS
   WHERE ROWNUM=1
   ORDER BY ID_PARTIDO DESC;
   
   INSERT INTO PARTIDOS (ID_GANADOR,ID_PARTIDO)
   VALUES (C_ID_GANADOR,C_ID_PARTIDO);
   
   INSERT INTO PARTIDOS(ID_PERDEDOR,ID_PARTIDO)
   VALUES (C_ID_PERDEDOR,C_ID_PARTIDO);
   
   C_ENFRENTAMIENTO :=0;
   IF C_ENFRENTAMIENTO =0 THEN
   C_ID_JORNADA := C_ID_JORNADA +1;
   C_ENFRENTAMIENTO:= 1;
   
   
   END IF;
   END IF;  
   END IF;
   
   ELSE
   C_ID_JORNADA :=C_ID_JORNADA +1;
    
   END IF;
   END LOOP;
   END LOOP; 
  
   
   
  
  END generar_calendario;
  
  PROCEDURE ver_enfrentamientos(C_CURSOR OUT SYS_REFCURSOR) AS
  BEGIN 
  OPEN C_CURSOR FOR 
  SELECT * FROM PARTIDOS
  ORDER BY ID_JOR,ID_GANADOR;
  
  END ver_enfrentamientos;
  
  
END calendario;
