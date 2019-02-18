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
public class Gevecht implements Runnable{
    private Speler speler;
    private Vijand vijand;
    private int beloningCredits;
    private Rekensom momenteleRekensom;
    private boolean somgoed;
    private Activity activity;
    private Rekensomgenerator rekensomgenerator = new Rekensomgenerator();

    public Gevecht(Speler speler, Vijand vijand, int beloningCredits, Activity activity)
    {
        this.speler = speler;
        this.vijand = vijand;
        this.beloningCredits = beloningCredits;
        this.activity = activity;
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
        speler.getPanster().ontvangSchade(hoeveelheid,speler,vijand);
        System.out.println("speler: " + speler.getLevenspunten() + " vijand: " +
                vijand.getLevenspunten());
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

    public boolean controleerSom(int antwoord)
    {
        boolean somcorrect = false;
        if(antwoord == momenteleRekensom.antwoord())
        {
            somcorrect = true;
            somgoed = true;
        }
        return  somcorrect;

    }


    @Override
    public void run() {

        boolean gevechtNogBezig = true;
        while(gevechtNogBezig)
        {
            momenteleRekensom = rekensomgenerator.genereerSom(Rekenvorm.KEER);
            final TextView inputtext = activity.findViewById(R.id.rekensom_iput);
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    inputtext.setText(momenteleRekensom.toString());
                }
            });

            try {
                int wachtmoment = 0;
                while(wachtmoment < 50 && !somgoed) {
                    sleep(100);
                    wachtmoment++;
                }
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(somgoed)
            {
                doeSchade(momenteleRekensom.antwoord());
            }
            else
            {
                krijgSchade(momenteleRekensom.antwoord());
            }
            somgoed = false;
            if(controleerDood())
            {
                gevechtNogBezig = false;

            }

        }
    }
}