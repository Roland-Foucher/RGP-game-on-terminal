package com.example.simplon.promo16.perso;

/**
 * Knigth have armor and can make more armore
 */
public class Knigth extends Perso {

    private int armore = 10;

    public Knigth() {
        this.name = "Chevalier";
        this.weapon = "Epee";
        this.manaPower = "protected";
        this.health = 80;
        this.mana = 50;
        this.manaAttack = 10;
        this.manaCost = 50;
        this.weaponAttack = 70;
        this.maxHealth = this.health;
        this.maxMana = this.mana;

    }

    /**
     * make a percentage with armore if attack is<0 (hurt) 
     */
    @Override
    public void setHealth(int attack) {

        if (attack<0){
            this.health+= attack + armore;
        }else{
            this.health += attack;
        }

        if (this.health > maxHealth) {
            this.health = maxHealth;
        }
        if (this.health < 0) {
            this.isAlive = false;
            this.health = 0;
        }
    }

    /**
     * mana power add 10 to armore
     */
    @Override
    public void manaAttack(Perso perso) {
        
        this.armore += 20;
        perso.setHealth(-this.getManaAttack());
        this.setMana(-this.getManaCost());
    }
    

}
