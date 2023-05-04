CREATE OR REPLACE PACKAGE BODY calendario AS
  PROCEDURE generar_temporada(id_temp IN NUMBER, tipo IN VARCHAR2, estado IN VARCHAR2) IS
    id_temp NUMBER;
  BEGIN
    -- Insertar la temporada en la tabla de temporadas
    INSERT INTO temporada (id, tipo, estado)
    VALUES (temporadas_seq.nextval, tipo, estado)
    RETURNING id INTO id_temp;

    -- Generar las jornadas y partidos de la temporada
    -- ...

  END generar_temporada;

  PROCEDURE generar_jornada(id_jor IN NUMBER, id_temp IN NUMBER, numero IN NUMBER) IS
    id_jor NUMBER;
  BEGIN
    -- Insertar la jornada en la tabla de jornadas
    INSERT INTO jornadas (id, numero, id_temp)
    VALUES (jornadas_seq.nextval, numero, id_temp)
    RETURNING id INTO id_jor;

    -- Generar los partidos de la jornada
    -- ...

  END generar_jornada;

  PROCEDURE generar_partido(id_jor IN NUMBER, id_partido IN NUMBER,
                            goles_eq1 IN VARCHAR2, goles_eq2 IN VARCHAR2, hora IN DATE) IS
  BEGIN
    -- Insertar el partido en la tabla de partidos
    INSERT INTO partidos (id, goles_eq1, goles_eq2, id_jor, hora)
    VALUES (partidos_seq.nextval, goles_eq1, goles_eq2, id_jor, hora)
    RETURNING id INTO id_partido;


  END generar_partido;
END calendario;
