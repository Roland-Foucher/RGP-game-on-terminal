package com.example.simplon.promo16.perso;

/**
 * Class principal des personnages avec methodes globales
 */
public class Perso {

    protected String name;
    protected String weapon;
    protected String manaPower;
    protected int health;
    protected int mana;
    protected int manaAttack;
    protected int manaCost;
    protected int weaponAttack;
    protected int maxMana;
    protected int maxHealth;
    protected boolean isAlive = true;

    /**
     * perso weapon attack an other personnage 
     * @param advers lost health = weaponAttack
     */
    public void weaponAttack(Perso advers) {
        advers.setHealth(-this.weaponAttack);
    }
    
    /**
     * perso mana atatck an other personnage
     * @param advers lost health = manaAttack
     */
    public void manaAttack(Perso advers) {
        advers.setHealth(-this.manaAttack);
        this.setMana(-this.getManaCost());
    }

        /**
     * give or substract health to perso, can't have more than default health on init. Health = 0 => perso is dead
     * @param attack the num for change health
     */
    public void setHealth(int attack) {

        this.health += attack;

        if (this.health > maxHealth) {
            this.health = maxHealth;
        }
        if (this.health < 0) {
            this.isAlive = false;
            this.health = 0;
        }
    }
    /**
     * give or substract mana to perso, can't have more than default mana on init and less than 0.
     * @param manaNumber
     */
    public void setMana(int manaNumber) {
        this.mana += manaNumber;
        if (this.mana > this.maxMana) {
            this.mana = this.maxMana;
        }
        if (this.mana <0){
            this.mana = 0;
        }
    }

    //getter
    public String getName() {
        return name;
    }

    public String getWeapon() {
        return weapon;
    }

    public String getManaPower() {
        return manaPower;
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

    @Override
    public String toString() {
        return this.getName();
    }




}
