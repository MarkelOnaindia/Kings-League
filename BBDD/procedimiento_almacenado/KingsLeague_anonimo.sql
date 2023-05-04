-- Definir variables de cursor para almacenar los resultados
VAR cur_equipos REFCURSOR
VAR cur_jugadores REFCURSOR

-- Llamar al procedimiento info_equipos del paquete relacion_equipo
EXEC relacion_equipo.info_equipos(:cur_equipos);

-- Recuperar y mostrar los resultados del cursor cur_equipos
PRINT cur_equipos

-- Llamar al procedimiento info_jugadores del paquete relacion_equipo
EXEC relacion_equipo.info_jugadores(:cur_jugadores);

-- Recuperar y mostrar los resultados del cursor cur_jugadores
PRINT cur_jugadores
