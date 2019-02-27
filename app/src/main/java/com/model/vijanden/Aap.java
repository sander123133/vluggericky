package com.model.vijanden;

import com.model.Vijand;

public class Aap extends Vijand {

    public Aap(int levenspunten, String imageID, boolean isEenBaas) {
        super(levenspunten, imageID, isEenBaas);
    }

    @Override
    public int doeSchade(int hoeveelheid) {
        if(isEenBaas()) {
            return (int) (hoeveelheid * 1.40);
        }
        else {
            return (int) (hoeveelheid * 1.20);
        }
    }

    @Override
    public int ontvangSchade(int hoeveelheid) {
        if(isEenBaas()) {
            return (int) (hoeveelheid * 0.75);
        }
        else {
            return (int) (hoeveelheid * 0.80);
        }
    }
}
