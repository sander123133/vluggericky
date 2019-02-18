package com.model.wapens;

import com.model.Charachter;
import com.model.Speler;
import com.model.Vijand;
import com.model.Wapen;

import java.security.SecurityPermission;

public class Houtenzwaard extends Wapen {

    public Houtenzwaard() {
    }

    @Override
    public void voegSchadeToe(int schade, Speler speler, Vijand vijand) {
        vijand.setLevenspunten((int) (vijand.getLevenspunten() - schade * 1.25));
    }
}
