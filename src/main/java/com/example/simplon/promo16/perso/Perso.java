package com.example.simplon.promo16.perso;

public class Perso {

    protected String name ;
    protected String weapon;
    protected String manaPower;
    protected int health;
    protected int mana;
    protected int manaAttack;
    protected int weaponAttack;


    public Perso(){}

    public void weaponAttack(Perso perso){
        perso.setHealth(-this.weaponAttack);
    }

    public void manaAttack(Perso perso){
        perso.setHealth(-this.manaAttack);
        this.setMana(-this.getManaAttack());
    }

    // Getter and Setter

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

    public void setHealth(int attack) {
        this.health += attack;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int attack) {
        this.mana += attack;
    }

    public int getManaAttack() {
        return manaAttack;
    }

    public int getWeaponAttack() {
        return weaponAttack;
    }


    
}
