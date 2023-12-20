package org.iesalandalus.programacion.barajacartas.modelo;

import java.util.Random;

public class Baraja {
    public static final int NUM_CARTAS = 4 * Carta.CARTAS_PALO;
    private static final Random GENERADOR = new Random();

    private final Carta[] mazo = new Carta[NUM_CARTAS];

    public Baraja() {
        for (int i = 0; i < Carta.CARTAS_PALO; i++) {
            mazo[i] = new Carta(i + 1, Palo.OROS);
            mazo[Carta.CARTAS_PALO + i] = new Carta(i + 1, Palo.COPAS);
            mazo[2 * Carta.CARTAS_PALO + i] = new Carta(i + 1, Palo.ESPADAS);
            mazo[3 * Carta.CARTAS_PALO + i] = new Carta(i + 1, Palo.BASTOS);
        }
    }

    public Carta getCarta(int posicion) {
        comprobarPosicion(posicion);
        return mazo[posicion];
    }

    private void comprobarPosicion(int posicion) {
        if (posicion < 0 || posicion >= NUM_CARTAS) {
            throw new IllegalArgumentException("La posición no está dentro del mazo.");
        }
    }

    public void barajar(int veces) {
        if (veces <= 0) {
            throw new IllegalArgumentException("Al menos hay que barajar una vez.");
        }
        for (int i = 0; i < veces; i++) {
            intercambiar(GENERADOR.nextInt(NUM_CARTAS), GENERADOR.nextInt(NUM_CARTAS));
        }
    }

    private void intercambiar(int posicion1, int posicion2) {
        Carta aux = mazo[posicion1];
        mazo[posicion1] = mazo[posicion2];
        mazo[posicion2] = aux;
    }

}
