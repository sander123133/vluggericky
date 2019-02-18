package com.model.vijanden;

import com.model.Vijand;

public class Aap extends Vijand {

    public Aap(int levenspunten, String imageID) {
        super(levenspunten, imageID);
    }

    @Override
    public int leverSchade(int hoeveelheid) {
        return (int) (hoeveelheid * 1.20);
    }

    @Override
    public int ontvangSchade(int hoeveelheid) {
        return (int) (hoeveelheid * 1.20);
    }
}
