package com.model;

public abstract class Charachter {
    protected  int levenspunten;
    protected  String imageID;

    public Charachter(int levenspunten, String imageID) {
        this.levenspunten = levenspunten;
        this.imageID = imageID;
    }

    public int getLevenspunten() {
        return levenspunten;
    }

    public void setLevenspunten(int levenspunten) {
        this.levenspunten = levenspunten;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }
}
