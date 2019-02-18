package com.model.wapens;

import com.model.Speler;
import com.model.Vijand;
import com.model.Wapen;

public class SterkerwordendZwaard extends Wapen {
    double multypliler;
    public SterkerwordendZwaard() {
        multypliler = 1.25;
    }

    @Override
    public void voegSchadeToe(int schade, Speler speler, Vijand vijand) {
        vijand.setLevenspunten((int) (vijand.getLevenspunten() - schade * multypliler));
        multypliler =+ 0.20;
    }
}
