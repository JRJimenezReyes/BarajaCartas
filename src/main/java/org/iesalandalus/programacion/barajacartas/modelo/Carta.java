package org.iesalandalus.programacion.barajacartas.modelo;

import java.util.Objects;

public record Carta(int numero, Palo palo) {

    static final int CARTAS_PALO = 12;
    private static final String[] NOMBRES_NUMEROS = {"As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Sota", "Caballo", "Rey"};

    public Carta {
        validarNumero(numero);
        validarPalo(palo);
    }

    private void validarNumero(int numero) {
        if (numero < 1 || numero > CARTAS_PALO) {
            throw new IllegalArgumentException("El número de la carta no es correcto.");
        }
    }

    private void validarPalo(Palo palo) {
        Objects.requireNonNull(palo, "El palo no puede ser nulo.");
    }

    @Override
    public String toString() {
        return String.format("%s de %s", NOMBRES_NUMEROS[numero - 1], palo);
    }
}
