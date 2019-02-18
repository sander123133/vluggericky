package com.model.vijanden;

import com.model.Vijand;

public class Kip extends Vijand {

    public Kip(int levenspunten, String imageID) {
        super(levenspunten, imageID);
    }

    @Override
    public int leverSchade(int hoeveelheid) {
        return (int) (hoeveelheid * 0.90);
    }

    @Override
    public int ontvangSchade(int hoeveelheid) {
        return  hoeveelheid;
    }
}
