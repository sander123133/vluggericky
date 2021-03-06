package com.model;


public class Rekensom {
    private int eersteGetal;
    private int tweedeGetal;
    private Rekenvorm rekenvorm;

    /**
     * dit is de rekensom die uit een rekensomgenerator komt
     * @param eersteGetal het eerste getal in het vraagstuk
     * @param tweedeGetal het tweede getal in het vraagstuk
     * @param rekenvorm of het *, /, -, + is (eventueel uitbreidbaar)
     */
    public Rekensom(int eersteGetal, int tweedeGetal, Rekenvorm rekenvorm) {
        this.eersteGetal = eersteGetal;
        this.tweedeGetal = tweedeGetal;
        this.rekenvorm = rekenvorm;
    }

    public int getEersteGetal() {
        return eersteGetal;
    }

    public void setEersteGetal(int eersteGetal) {
        this.eersteGetal = eersteGetal;
    }

    public int getTweedeGetal() {
        return tweedeGetal;
    }

    public void setTweedeGetal(int tweedeGetal) {
        this.tweedeGetal = tweedeGetal;
    }

    public Rekenvorm getRekenvorm() {
        return rekenvorm;
    }

    public void setRekenvorm(Rekenvorm rekenvorm) {
        this.rekenvorm = rekenvorm;
    }

    public int antwoord() {
        switch (rekenvorm) {
            case PLUS:
                return eersteGetal + tweedeGetal;
            case KEER:
                return eersteGetal * tweedeGetal;
            case DELEN:
                return eersteGetal / tweedeGetal;
            case AFTERKKEN:
                return eersteGetal - tweedeGetal;
        }
        return 0;
    }

    public String toString() {
        switch (rekenvorm) {
            case PLUS:
                return eersteGetal + " + " + tweedeGetal;
            case AFTERKKEN:
                return eersteGetal + " - " + tweedeGetal;
            case KEER:
                return eersteGetal + " * " + tweedeGetal;
            case DELEN:
                return eersteGetal + " / " + tweedeGetal;
        }
        return "";
    }
}