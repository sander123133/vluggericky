package com.model.vijanden;

import com.model.Vijand;

public class CultMensen extends Vijand {

    public CultMensen(int levenspunten, String imageID, boolean isEenBaas) {
        super(levenspunten, imageID, isEenBaas);
    }

    @Override
    public int leverSchade(int hoeveelheid) {
        return 0;
    }

    @Override
    public int ontvangSchade(int hoeveelheid) {
        return 0;
    }
}
