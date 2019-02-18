package com.model.wapens;

import com.model.Speler;
import com.model.Vijand;
import com.model.Wapen;

public class IJzerenZwaard extends Wapen {
    public IJzerenZwaard() {
    }

    @Override
    public void voegSchadeToe(int schade, Speler speler, Vijand vijand) {
        vijand.setLevenspunten((int) (vijand.getLevenspunten() - schade * 1.5));
    }
}
