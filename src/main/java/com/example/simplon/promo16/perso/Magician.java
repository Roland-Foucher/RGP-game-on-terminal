package com.example.simplon.promo16.perso;

/**
 * magician have a lot of mana 
 */
public class Magician extends Perso {

    public Magician() {
        this.name = "Magician";
        this.weapon += "Canne";
        this.manaPower += "Eclaire";
        this.health = 80;
        this.mana = 150;
        this.manaAttack = 70;
        this.manaCost = 50;
        this.weaponAttack = 20;
        this.maxHealth = this.health;
        this.maxMana = this.mana;
    }
    
}
