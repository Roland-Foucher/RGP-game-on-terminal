package com.example.simplon.promo16.perso;

public class Elfe extends Perso {
    /**
     * Constructor Elfe
     */
    public Elfe() {
        this.name = "Elfe";
        this.weapon += "Arc";
        this.manaPower += "Soigne";
        this.health = 80;
        this.mana = 60;
        this.manaAttack = 0;
        this.manaCost = 30;
        this.weaponAttack = 40;
        this.maxHealth = this.health;
        this.maxMana = this.mana;
    }

    /**
     * Elfe can add health itself but don't hurt ennemy
     * override Perso methode manaAttack to setHealth
     */
    @Override
    public void manaAttack(Perso perso) {
        perso.setHealth(-this.manaAttack);
        this.setMana(-this.getManaCost());
        this.setHealth(30);
    }

    @Override
    public String getManaPower() {
        String manaPowerDescription = this.manaPower + " - Degat : " + this.manaAttack + " - cout " + this.manaCost
                + " - ajoute 30 health au personnage";
        return manaPowerDescription;
    }

}
