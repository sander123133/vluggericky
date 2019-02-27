package com.model.vijanden;

import com.model.Vijand;

public class Neushoorn extends Vijand {

    public Neushoorn(int levenspunten, String imageID, boolean isEenBaas) {
        super(levenspunten, imageID, isEenBaas);
    }

    @Override
    public int doeSchade(int hoeveelheid) {
        if(isEenBaas()) {
            return (int) (hoeveelheid * 1.35);
        }
        else {
            return (int) (hoeveelheid * 1.25);
        }
    }


    @Override
    public int ontvangSchade(int hoeveelheid) {
        if(isEenBaas()) {
            return (int) (hoeveelheid * 0.25);
        }
        else {
            return (int) (hoeveelheid * 0.50);
        }
    }
}

