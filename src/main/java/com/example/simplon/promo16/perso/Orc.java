package com.example.simplon.promo16.perso;

/**
 * Orc have standard attack and a lot of life
 */
public class Orc extends Perso {

    public Orc() {
        this.name = "Orc";
        this.weapon += "Gourdin";
        this.manaPower += "Morsure";
        this.health = 120;
        this.mana = 60;
        this.manaAttack = 40;
        this.manaCost = 20;
        this.weaponAttack = 60;
        this.maxHealth = this.health;
        this.maxMana = this.mana;
    }

    /**
     * mana power add 20 to attack
     */
    @Override
    public void manaAttack(Perso perso) {

        this.weaponAttack += 20;
        perso.setHealth(-this.getManaAttack());
        this.setMana(-this.getManaCost());
    }

    @Override
    public String getManaPower() {
        String manaPowerDescription = this.manaPower + " - Degat : " + this.manaAttack + " - cout " + this.manaCost
                + " - ajoute 20 degats au personnage";
        return manaPowerDescription;
    }

}
