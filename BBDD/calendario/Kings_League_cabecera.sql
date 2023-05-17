CREATE OR REPLACE PACKAGE calendario AS
PROCEDURE generar_calendario;
PROCEDURE ver_enfrentamientos(C_CURSOR OUT sys_refcursor);
END calendario;

