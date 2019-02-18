package com.model.pantsers;

import com.model.Panster;
import com.model.Speler;
import com.model.Vijand;

public class GoudenPantser extends Panster {

    public GoudenPantser() {
    }

    @Override
    public void ontvangSchade(int hoeveelheid, Speler speler, Vijand vijand) {
        speler.setLevenspunten((int) (speler.getLevenspunten() - hoeveelheid  * 0.50));
        vijand.setLevenspunten((int) (vijand.getLevenspunten() - hoeveelheid * 0.10));
    }
}
