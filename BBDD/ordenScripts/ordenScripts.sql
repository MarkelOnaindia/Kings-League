/*Kings League equipo 2*/
/*Scripts de orden de scripts*/

    /*Creacion de tablas*/
    @\Kings-League\BBDD\creates\createtables_kings_league.sql
    
    /*Inserciones*/
        /*Usuarios*/
        @\Kings-League\BBDD\inserts\usuarioInsert.sql
        /*Staff*/
        @\Kings-League\BBDD\inserts\staffInsert.sql
        /*Propietarios*/
        @\Kings-League\BBDD\inserts\propietarioInsert.sql
        /*Jugadores*/
        @\Kings-League\BBDD\inserts\jugadorInsert.sql
        /*Equipos*/
        @\Kings-League\BBDD\inserts\equipoInsert.sql
        /*Entrenador*/
        @\Kings-League\BBDD\inserts\entrenadorInsert.sql
        /*Temporada*/
        @\Kings-League\BBDD\inserts\temporadaInsert.sql
        /*Jornada*/
        @\Kings-League\BBDD\inserts\jornadaInsert.sql
        /*Partido*/
        @\Kings-League\BBDD\inserts\partidoInsert.sql
        /*Contrato Staff*/
        @\Kings-League\BBDD\inserts\contratoStaffInsert.sql
        /*Contrato Jugador*/
        @\Kings-League\BBDD\inserts\contratoJugadorInsert.sql
        /*Contrato Entrenador*/
        @\Kings-League\BBDD\inserts\contratoEntrenaInsert.sql
        /*Contrato Entrenador*/
        @\Kings-League\BBDD\inserts\contratoDuenoInsert.sql
    
    /*Creacion de triggers*/
        /*Maximo de jugadores*/
        @\Kings-League\BBDD\triggers\maxJugador\maxJugadores.sql
        /*Evitar empates*/
        @\Kings-League\BBDD\triggers\noEmpates\noEmpate.sql
        /*Equipos repetidos jornada*/
        @\Kings-League\BBDD\triggers\equiposRepetidos\equiposRepetidoJornada.sql
        /*Minimo de jugadores*/
        @\Kings-League\BBDD\triggers\minJugador\minJugador.sql
        /*Dos triggers del calendario*/
            /*Jugadores*/
            @\Kings-League\BBDD\triggers\triggerCalendario\triggerCalendarioJugador.sql
            /*Equipos*/
            @\Kings-League\BBDD\triggers\triggerCalendario\triggerCalendarioEquipo.sql
        /*Presupuesto maximo*/
        @\Kings-League\BBDD\triggers\presupuestoMax\presupuestoMax.sql
        
    /*Creacion de views*/
        /*Clasificacion*/
        @\Kings-League\BBDD\views\clasificacion.sql
        @\Kings-League\BBDD\views\infoEquipos.sql
        @\Kings-League\BBDD\views\ultimaJornada.sql

    /*Procedimientos almacenados*/
        /*Informe de equipo*/
        @"\Kings-League\BBDD\procedimientos almacenados\procedimiento infoequipos\procedimiento_infoequipos";
        /*Informe jugador*/
        @"\Kings-League\BBDD\procedimientos almacenados\procedimiento infojugadores\procedimiento_infojugadores";
