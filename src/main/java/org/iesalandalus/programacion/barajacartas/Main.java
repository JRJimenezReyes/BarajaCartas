package org.iesalandalus.programacion.barajacartas;

import org.iesalandalus.programacion.barajacartas.modelo.Baraja;
import org.iesalandalus.programacion.barajacartas.vista.Consola;

public class Main {
    public static void main(String[] args) {
        Baraja barajaBarajada = new Baraja();
        barajaBarajada.barajar(Consola.leerVeces());
        Consola.mostrarResultados(barajaBarajada);
    }
}
