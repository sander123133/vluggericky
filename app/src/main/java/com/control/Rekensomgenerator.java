package com.control;


import com.model.Rekensom;

/**
 * deze class genereert sommen die opgelost kunnen worden
 */
public class Rekensomgenerator {
    public Rekensomgenerator()
    {

    }

    public Rekensom genereerSom(Rekenvorm rekenvorm)
    {
        Rekensom rekensom = null;
        // als er een deling is, zijn delingen van 10 / 2 erg makkelijk dus alleen bij delingen mag
        // het eerste getal boven de 10 zijn
        if(rekenvorm == Rekenvorm.DELEN)
        {
            boolean mogelijkeDeling = false;

            //deze loop wordt gebruikt voor het geval dat er een deling onstaat met heel veel komma
            //getallen, de delingen zijn alleen hele getallen
            while(!mogelijkeDeling)
            {
                int eersteGetal = (int) ((Math.random() * 100) + 10);
                int tweedeGetal = (int) ((Math.random() * 9) + 2);
                if(eersteGetal % tweedeGetal == 0) {
                    rekensom = new Rekensom(eersteGetal, tweedeGetal, rekenvorm);
                    System.out.println(eersteGetal + " " + tweedeGetal);
                    mogelijkeDeling = true;
                }
            }
        }
        else
        {
            int eersteGetal = (int) ((Math.random() * 10) + 1);
            int tweedeGetal = (int) ((Math.random() * 10) + 1);
            rekensom = new Rekensom(eersteGetal, tweedeGetal, rekenvorm);
        }
        return rekensom;
    }

}
