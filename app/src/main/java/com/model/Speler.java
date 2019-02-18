package com.model;

public class Speler extends  Charachter  {
    protected Wapen wapen;
    protected String panster;
    protected int geld;

    public Speler(int levenspunten, String imageID, Wapen wapen, String pantser, int geld) {
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

    public String getPanster() {
        return panster;
    }

    public void setPanster(String panster) {
        this.panster = panster;
    }

    public int getGeld() {
        return geld;
    }

    public void setGeld(int geld) {
        this.geld = geld;
    }
}
