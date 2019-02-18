package com.control;

import com.model.Speler;
import com.model.Vijand;

public class Gevecht {
    private Speler speler;
    private Vijand vijand;
    private int beloningCredits;

    public Gevecht(Speler speler, Vijand vijand, int beloningCredits)
    {
        this.speler = speler;
        this.vijand = vijand;
        this.beloningCredits = beloningCredits;
    }

    public void doeSchade(int schade)
    {
            speler.getWapen().voegSchadeToe(schade,speler,vijand);
            System.out.println("speler: " + speler.getLevenspunten() + " vijand: " +
                    vijand.getLevenspunten());
            controleerDood();

    }

    public void krijgSchade(int hoeveelheid)
    {
        speler.setLevenspunten(speler.getLevenspunten() - hoeveelheid);
        System.out.println(speler.getLevenspunten());
        controleerDood();
    }

    public void controleerDood()
    {
       if(vijand.getLevenspunten() <= 0)
       {
           System.out.println("je hebt gewonnen!");
           speler.setGeld(beloningCredits);
       }
       else if(speler.getLevenspunten() <= 0)
       {
           System.out.println("je bent helemaal kaolokapot gemaakt");
       }

    }



}
