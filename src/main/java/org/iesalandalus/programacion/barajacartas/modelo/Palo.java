package org.iesalandalus.programacion.barajacartas.modelo;

public enum Palo {
    OROS, COPAS, ESPADAS, BASTOS;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
