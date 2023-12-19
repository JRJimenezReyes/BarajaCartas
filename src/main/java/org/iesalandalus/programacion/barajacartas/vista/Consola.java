package org.iesalandalus.programacion.barajacartas.vista;

import org.iesalandalus.programacion.barajacartas.modelo.Baraja;
import org.iesalandalus.programacion.barajacartas.modelo.Carta;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    private Consola() {}
    public static int leerVeces() {
        int veces;
        do {
            System.out.print("Dime el número de veces que quieres barajar: ");
            veces = Entrada.entero();
        } while (veces < 0);
        return veces;
    }

    public static void mostrarResultados(Baraja barajaBarajada) {
        Baraja barajaSinBarajar = new Baraja();
        int coincidencias = 0;
        for (int i = 0; i < Baraja.NUM_CARTAS; i++) {
            Carta cartaBarajada = barajaBarajada.getCarta(i);
            Carta cartaSinBarajar = barajaSinBarajar.getCarta(i);
            if (cartaBarajada.equals(cartaSinBarajar)) {
                System.out.printf("La carta: %s, no se ha movido%n", cartaBarajada);
                coincidencias++;
            }
        }
        System.out.printf("No se han movido %d cartas", coincidencias);
    }
}
