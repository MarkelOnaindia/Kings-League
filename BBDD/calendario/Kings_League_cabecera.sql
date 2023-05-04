CREATE OR REPLACE PACKAGE calendario AS
  PROCEDURE generar_temporada(id_temp IN NUMBER, tipo IN VARCHAR2, estado IN VARCHAR2);
  PROCEDURE generar_jornada(id_jor IN NUMBER, id_temp IN NUMBER, numero IN NUMBER);
  PROCEDURE generar_partido(id_jor IN NUMBER, id_partido IN NUMBER,
                            goles_eq1 IN VARCHAR2, goles_eq2 IN VARCHAR2, hora IN DATE);
END calendario;

