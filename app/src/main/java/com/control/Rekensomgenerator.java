package com.control;


import com.model.Moeilijkheidsgraad;
import com.model.Rekensom;
import com.model.Rekenvorm;

/**
 * deze class genereert sommen die opgelost kunnen worden
 */
public class Rekensomgenerator {
    public Rekensomgenerator()
    {

    }

    public Rekensom genereerSom(Rekenvorm rekenvorm, Moeilijkheidsgraad moeilijkheidsgraad)
    {
        Rekensom rekensom = null;
        // als er een deling is, zijn delingen van 10 / 2 erg makkelijk dus alleen bij delingen mag
        // het eerste getal boven de 10 zijn
        if(moeilijkheidsgraad == Moeilijkheidsgraad.MAKKELIJK || moeilijkheidsgraad == Moeilijkheidsgraad.GEMIDDELD ) {
            if (rekenvorm == Rekenvorm.DELEN) {
                boolean mogelijkeDeling = false;

                //deze loop wordt gebruikt voor het geval dat er een deling onstaat met heel veel komma
                //getallen, de delingen zijn alleen hele getallen
                while (!mogelijkeDeling) {
                    int eersteGetal = (int) ((Math.random() * 100) + 10);
                    int tweedeGetal = (int) ((Math.random() * 9) + 2);
                    if (eersteGetal % tweedeGetal == 0) {
                        rekensom = new Rekensom(eersteGetal, tweedeGetal, rekenvorm);
                        System.out.println(eersteGetal + " " + tweedeGetal);
                        mogelijkeDeling = true;
                    }
                }
            } else if(rekenvorm == Rekenvorm.AFTERKKEN || rekenvorm == Rekenvorm.PLUS){
                int eersteGetal = (int) ((Math.random() * 50) + 1);
                int tweedeGetal = (int) ((Math.random() * 50) + 1);
                rekensom = new Rekensom(eersteGetal, tweedeGetal, rekenvorm);
            }
            else{
                int eersteGetal = (int) ((Math.random() * 10) + 1);
                int tweedeGetal = (int) ((Math.random() * 10) + 1);
                rekensom = new Rekensom(eersteGetal, tweedeGetal, rekenvorm);
            }
        }
        else
        {
            if (rekenvorm == Rekenvorm.DELEN) {
                boolean mogelijkeDeling = false;

                //deze loop wordt gebruikt voor het geval dat er een deling onstaat met heel veel komma
                //getallen, de delingen zijn alleen hele getallen
                while (!mogelijkeDeling) {
                    int eersteGetal = (int) ((Math.random() * 1000) + 10);
                    int tweedeGetal = (int) ((Math.random() * 19) + 2);
                    if (eersteGetal % tweedeGetal == 0) {
                        rekensom = new Rekensom(eersteGetal, tweedeGetal, rekenvorm);
                        System.out.println(eersteGetal + " " + tweedeGetal);
                        mogelijkeDeling = true;
                    }
                }
            }
            else if(rekenvorm == Rekenvorm.KEER){
                int eersteGetal = (int) ((Math.random() * 30) + 1);
                int tweedeGetal = (int) ((Math.random() * 30) + 1);
                rekensom = new Rekensom(eersteGetal, tweedeGetal, rekenvorm);
            }
            else {
                int eersteGetal = (int) ((Math.random() * 1000) + 1);
                int tweedeGetal = (int) ((Math.random() * 1000) + 1);
                rekensom = new Rekensom(eersteGetal, tweedeGetal, rekenvorm);
            }
        }
        return rekensom;
    }

}
