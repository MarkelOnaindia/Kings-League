-- Procedimiento info equipos
CREATE OR REPLACE PROCEDURE info_equipos(
    informacion_equ OUT SYS_REFCURSOR) AS
BEGIN
  OPEN informacion_equ FOR
  SELECT *
  FROM view_equipos;
END info_equipos;