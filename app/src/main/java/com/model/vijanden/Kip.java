package com.model.vijanden;

import com.model.Vijand;

public class Kip extends Vijand {

    public Kip(int levenspunten, String imageID, boolean isEenBaas) {
        super(levenspunten, imageID, isEenBaas);
    }

    @Override
    public int leverSchade(int hoeveelheid) {
                if(isEenBaas()) {
            return (int) (hoeveelheid * 1.10);
        }
        else {
            return (int) (hoeveelheid * 0.90);
        }
    }


    @Override
    public int ontvangSchade(int hoeveelheid) {
        if(isEenBaas()) {
            return (int) (hoeveelheid * 0.90);
        }
        else {
            return hoeveelheid;
        }
    }
}

