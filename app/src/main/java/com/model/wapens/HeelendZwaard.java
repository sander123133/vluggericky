package com.model.wapens;

import com.model.Speler;
import com.model.Vijand;
import com.model.Wapen;

public class HeelendZwaard extends Wapen {

    public HeelendZwaard() {
    }

    @Override
    public void voegSchadeToe(int schade, Speler speler, Vijand vijand) {
        vijand.setLevenspunten((int) (vijand.getLevenspunten() - schade * 1.25));
        speler.setLevenspunten((int) (speler.getLevenspunten() + schade * 0.25));
    }
}
