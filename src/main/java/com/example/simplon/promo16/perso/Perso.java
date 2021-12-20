package com.example.simplon.promo16.perso;

/**
 * Main class of perso
 */
public class Perso implements IPerso{

    protected String name;
    protected String weapon = "🗡️ : ";
    protected String manaPower = "💧 : ";
    protected int health;
    protected int mana;
    protected int manaAttack;
    protected int manaCost;
    protected int weaponAttack;
    protected int maxMana;
    protected int maxHealth;
    protected int armore;
    protected boolean isAlive = true;

   
    public void weaponAttack(Perso advers) {
        advers.setHealth(-this.weaponAttack);
    }

    public void manaAttack(Perso advers) {
        advers.setHealth(-this.manaAttack);
        this.setMana(-this.getManaCost());
    }
    
    public void setHealth(int attack) {

        this.health += attack;

        if (this.health > maxHealth) {
            this.health = maxHealth;
        }
        if (this.health <= 0) {
            this.isAlive = false;
            this.health = 0;
        }
    }
  
    public void setMana(int manaNumber) {
        this.mana += manaNumber;
        if (this.mana > this.maxMana) {
            this.mana = this.maxMana;
        }
        if (this.mana < 0) {
            this.mana = 0;
        }
    }

    @Override
    public String toString() {
        return String.format(
                "name : %s\npoints de vie : %s\npoints de mana: %s\narme: %s / degats arme : %s\n pouvoir magique :%s / degats pouvoir magique :%s / cout du pouvoir : %s\n ",
                this.name, this.health, this.mana, this.weapon, this.weaponAttack, this.manaPower, this.manaAttack,
                this.manaCost);
    }

    // getters

    public String getName() {
        String nameIfDead = this.isAlive ? name : name + " 💀";
        return nameIfDead;
    }

    public String getWeapon() {
        String weaponDecription = this.weapon + " - Degats : " + this.weaponAttack;
        return weaponDecription;
    }

    public String getManaPower() {
        String manaPowerDescription = this.manaPower + " - Degat : " + this.manaAttack + " - cout " + this.manaCost;
        return manaPowerDescription;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public int getManaAttack() {
        return manaAttack;
    }

    public int getWeaponAttack() {
        return weaponAttack;
    }

    public int getMaxMana() {
        return maxMana;

    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getManaCost() {
        return manaCost;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getArmore() {
        return armore;
    }

}
