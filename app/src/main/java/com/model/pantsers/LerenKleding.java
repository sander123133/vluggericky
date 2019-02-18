package com.model.pantsers;

import com.model.Panster;
import com.model.Speler;
import com.model.Vijand;

public class LerenKleding extends Panster {

    public LerenKleding() {
    }

    @Override
    public void ontvangSchade(int hoeveelheid, Speler speler, Vijand vijand) {
        speler.setLevenspunten((int) (speler.getLevenspunten() - hoeveelheid * 0.65));
    }
}
