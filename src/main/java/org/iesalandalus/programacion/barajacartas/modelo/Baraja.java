package org.iesalandalus.programacion.barajacartas.modelo;

import java.util.Random;

public class Baraja {
    static final int CARTAS_PALO = 12;
    public static final int NUM_CARTAS = 4 * CARTAS_PALO;
    private static final Random generador = new Random();

    private final Carta[] mazo = new Carta[NUM_CARTAS];

    public Baraja() {
        for (int i = 0; i < CARTAS_PALO; i++) {
            mazo[i] = new Carta(i + 1, Palo.OROS);
            mazo[CARTAS_PALO + i] = new Carta(i + 1, Palo.COPAS);
            mazo[2 * CARTAS_PALO + i] = new Carta(i + 1, Palo.ESPADAS);
            mazo[3 * CARTAS_PALO + i] = new Carta(i + 1, Palo.BASTOS);
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
            intercambiar(generador.nextInt(NUM_CARTAS), generador.nextInt(NUM_CARTAS));
        }
    }

    private void intercambiar(int posicion1, int posicion2) {
        Carta aux = mazo[posicion1];
        mazo[posicion1] = mazo[posicion2];
        mazo[posicion2] = aux;
    }

}
