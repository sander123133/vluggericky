package com.model;


public abstract class Wapen {


    public Wapen() {
    }

    /**
     * deze methode moeten overgenomen worden door wapens zodat er schade kan worden gedaan op basis
     * op het wapen dat je vasthoudt
     * @param schade
     * @param speler
     * @param vijand
     */
    public abstract void voegSchadeToe(int schade, Speler speler, Vijand vijand);

}
