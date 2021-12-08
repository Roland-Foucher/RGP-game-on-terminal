package com.example.simplon.promo16.perso;

/**
 * Assassin kill with mana
 */
public class Assassin extends Perso{

    public Assassin() {
        this.name = "Assassin";
        this.weapon = "couteau";
        this.manaPower = "egorge";
        this.health = 50;
        this.mana = 50;
        this.manaAttack = 2000;
        this.manaCost = 50;
        this.weaponAttack = 20;
        this.maxHealth = this.health;
        this.maxMana = this.mana;
    }
    
}
