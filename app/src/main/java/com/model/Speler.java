package com.model;

/**
 * dit het character dat door de gebruiker wordt gebruikt,
 *
 */
public class Speler extends  Charachter  {
    protected Wapen wapen;
    protected Panster panster;
    protected int geld;

    public Speler(int levenspunten, String imageID, Wapen wapen, Panster pantser, int geld) {
        super(levenspunten, imageID);
        this.wapen = wapen;
        this.panster = pantser;
        this.geld = geld;
    }

    public Wapen getWapen() {
        return wapen;
    }

    public void setWapen(Wapen wapen) {
        this.wapen = wapen;
    }

    public Panster getPanster() {
        return panster;
    }

    public void setPanster(Panster panster) {
        this.panster = panster;
    }

    public int getGeld() {
        return geld;
    }

    public void setGeld(int geld) {
        this.geld = geld;
    }
}
