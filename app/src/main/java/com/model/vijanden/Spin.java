package com.model.vijanden;

import com.model.Vijand;

public class Spin extends Vijand {

    public Spin(int levenspunten, String imageID, boolean isEenBaas) {
        super(levenspunten, imageID, isEenBaas);
    }

    @Override
    public int leverSchade(int hoeveelheid) {
        if(isEenBaas()) {
            return (int) (hoeveelheid * 1.75);
        }
        else {
            return (int) (hoeveelheid * 1.50);
        }
    }

    @Override
    public int ontvangSchade(int hoeveelheid) {
        if(isEenBaas()) {
            return (int) (hoeveelheid * 0.75);
        }
        else {
            return (int) (hoeveelheid * 0.90);
        }
    }
}
