package com.model;

/**
 * uit deze class onstaan alle instanties die te maken hebben met vijanden, het attribuut iseenbaas
 * zorgt ervoor dat er een baas wordt gegenereert
 */
public abstract class Vijand extends Charachter {
    boolean isEenBaas;
    public Vijand(int levenspunten, String imageID, boolean isEenBaas) {
        super(levenspunten, imageID);
        this.isEenBaas = isEenBaas;
    }

    public abstract int doeSchade(int hoeveelheid);

    public abstract int ontvangSchade(int hoeveelheid);

    public boolean isEenBaas() {
        return isEenBaas;
    }

}
