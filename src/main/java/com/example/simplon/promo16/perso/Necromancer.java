package com.example.simplon.promo16.perso;

/**
 * necro can make resurection on perso
 */
public class Necromancer extends Perso {

    public Necromancer() {
        this.name = "Necromancer";
        this.weapon += "Baton";
        this.manaPower += "Resurection";
        this.health = 80;
        this.mana = 100;
        this.manaAttack = 0;
        this.manaCost = 50;
        this.weaponAttack = 20;
        this.maxHealth = this.health;
        this.maxMana = this.mana;    
    }

    /**
     * Necro can make perso alive if health of perso == 0.
     * perso have 1/2 init Health
     */
    @Override
    public void manaAttack(Perso perso) {
        if (!perso.isAlive()){
            perso.isAlive = true;
            perso.setHealth(perso.getMaxHealth()/2);
            this.setMana(-this.getManaCost());
        }
        else{
            System.out.println(perso.getName() + "is not dead");
        }
        
    }

    @Override
    public String getManaPower() {
        String manaPowerDescription = this.manaPower + " - Degat : " + this.manaAttack + " - cout " + this.manaCost + " - ressucite un personnage";
        return manaPowerDescription;
    }

    
    
    
}
