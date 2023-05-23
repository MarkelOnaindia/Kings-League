package org.example.Modelo;

import Modelo.ContratoDueno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class tContratoDuenoTest {

    ContratoDueno contratoDueno;
    ContratoDueno Sueldo;
    ContratoDueno contratoDuenoUpdate;

    tContratoDuenoTest() {
        this.contratoDueno = new ContratoDueno(50, "Porcinos", "Ibai", 10000000, "15/06/2023", "15/07/2023");
        this.Sueldo = new ContratoDueno("");
        this.contratoDuenoUpdate = new ContratoDueno("Nombre", "Apellido", "DNI");
    }

    @Test
    void main() {
    }

    @Test
    void testInsertar() throws Exception {
        Assertions.assertEquals(1, TContratoDueno.insertar(this.contratoDueno));
    }

    @Test
    void testSeleccionarSueldo() throws Exception {
        Assertions.assertEquals(this.Sueldo.getClass(), tContratoDueno.setSueldo(this.Sueldo).getSueldo());
    }
}

