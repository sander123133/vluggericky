package com.control;

import android.app.Activity;
import android.widget.TextView;

import com.example.vluggericky.R;
import com.model.Rekensom;
import com.model.Speler;
import com.model.Vijand;

import static java.lang.Thread.sleep;

/**
 * deze class zorgt voor logica binnen een gevecht:
 * wanneer de speler schade krijgt
 * wanneer de speler schade levert
 * controleren of iemand het gevecht heeft gewonnen
 */
public class Gevecht{
    private Speler speler;
    private Vijand vijand;
    private int beloningCredits;

    public Gevecht(Speler speler, Vijand vijand, int beloningCredits, Activity activity)
    {
        this.speler = speler;
        this.vijand = vijand;
        this.beloningCredits = beloningCredits;

    }

    /**
     * deze methode wordt aangeroepen als de speler een som juist heeft beantwoord
     * @param schade
     */
    public void doeSchade(int schade)
    {
        speler.getWapen().voegSchadeToe(schade,speler,vijand);
        System.out.println("speler: " + speler.getLevenspunten() + " vijand: " +
                vijand.getLevenspunten());
        controleerDood();

    }

    /**
     * deze methode wordt aangeroepen als de speler een som fout beantwoord heeft
     * @param hoeveelheid
     */
    public void krijgSchade(int hoeveelheid)
    {
        speler.setLevenspunten(speler.getLevenspunten() - hoeveelheid);
        System.out.println(speler.getLevenspunten());
        controleerDood();
    }

    /**
     * deze methode wordt aangeroepen nadat een aanval is gedaan, als of de speler of de vijand
     * minder dan 0 levenspunten heeft dan wordt het gevecht geindigt.
     */
    public boolean controleerDood()
    {
        boolean iseriemandood = false;
        if(vijand.getLevenspunten() <= 0)
        {
            System.out.println("je hebt gewonnen!");
            speler.setGeld(beloningCredits);
            iseriemandood = true;
        }
        else if(speler.getLevenspunten() <= 0)
        {
            System.out.println("je bent helemaal kaolokapot gemaakt");
            iseriemandood = true;
        }
        return  iseriemandood;
    }

    public boolean controleerSom(int antwoord, Rekensom rekensom)
    {
        boolean somcorrect = false;
        if(antwoord == rekensom.antwoord())
        {
            somcorrect = true;

        }
        return  somcorrect;

    }




}