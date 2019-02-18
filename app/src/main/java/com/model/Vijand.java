package com.model;

public abstract class Vijand extends Charachter {

    public Vijand(int levenspunten, String imageID) {
        super(levenspunten, imageID);
    }

    public abstract int leverSchade(int hoeveelheid);

    public abstract int ontvangSchade(int hoeveelheid);
}
