/*Kings League equipo 2*/
/*Scripts de orden de scripts*/

    /*Creacion de tablas*/
    @$HOME\Desktop\Kings-League\BBDD\createtables_kings_league.sql
    
    /*Inserciones*/
        /*Usuarios*/
        @home/desktop/Kings-League/inserts/usuarioInsert.sql
        /*Staff*/
        @home/desktop/Kings-League/inserts/staffInsert.sql
        /*Propietarios*/
        @home/desktop/Kings-League/inserts/propietarioInsert.sql
        /*Jugadores*/
        @home/desktop/Kings-League/inserts/jugadorInsert.sql
        /*Equipos*/
        @home/desktop/Kings-League/inserts/equipoInsert.sql
        /*Entrenador*/
        @home/desktop/Kings-League/inserts/entrenadorInsert.sql
        /*Temporada*/
        @home/desktop/Kings-League/inserts/temporadaInsert.sql
        /*Jornada*/
        @home/desktop/Kings-League/inserts/jornadaInsert.sql
        /*Partido*/
        @home/desktop/Kings-League/inserts/partidoInsert.sql
        /*Contrato Staff*/
        @home/desktop/Kings-League/inserts/contratoStaffInsert.sql
        /*Contrato Jugador*/
        @home/desktop/Kings-League/inserts/contratoJugadorInsert.sql
        /*Contrato Entrenador*/
        @home/desktop/Kings-League/inserts/contratoEntrenadorInsert.sql
        /*Contrato Entrenador*/
        @home/desktop/Kings-League/inserts/contratoDuenoInsert.sql
    
    /*Creacion de triggers*/
        /*Maximo de jugadores*/
        @"$HOME/Desktop/Kings-League/triggers/maxJugador/maxJugadores.sql"
        /*Evitar empates*/
        @home/desktop/Kings-League/triggers/noEmpates/noEmpate.sql
        /*Equipos repetidos jornada*/
        @home/desktop/Kings-League/triggers/equiposRepetidos/equiposRepetidoJornada.sql
        /*Minimo de jugadores*/
        @home/desktop/Kings-League/triggers/minJugador/minJugador.sql
        /*Dos triggers del calendario*/
            /*Jugadores*/
            @home/desktop/Kings-League/triggers/triggerCalendario/triggerCalendarioJugador.sql
            /*Equipos*/
            @home/desktop/Kings-League/triggers/triggerCalendario/triggerCalendarioEquipo.sql
        /*Presupuesto maximo*/
        @home/desktop/Kings-League/triggers/presupuestoMax/presupuestoMax.sql
        
