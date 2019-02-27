package com.model.vijanden;

import com.model.Vijand;

public class CultMensen extends Vijand {
    public CultMensen(int levenspunten, String imageID, boolean isEenBaas) {
        super(levenspunten, imageID, isEenBaas);
    }

    @Override
    public int doeSchade(int hoeveelheid) {
        if(isEenBaas()) {
            return (int) (hoeveelheid * 1.70);
        }
        else {
            return (int) (hoeveelheid * 1.50);
        }
    }

    @Override
    public int ontvangSchade(int hoeveelheid) {
        if(isEenBaas()) {
            return (int) (hoeveelheid * 0.50);
        }
        else {
            return (int) (hoeveelheid * 0.50);
        }

    }
}
