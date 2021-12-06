package com.example.simplon.promo16.perso;

public class Elfe extends Perso {

    private String name = " Elfe" ;
    private String weapon = "Arc";
    private String manaPower = "giveHealth";
    private int life = 80;
    private int mana = 60;
    private int manaAttack = 0;
    private int weaponAttack = 40;

    public void weaponAttack(Perso perso){
        perso.setLife(this.weaponAttack);
    }

    public void manaAttack(Perso perso){
        perso.setLife(this.manaAttack);
        this.setMana(-this.getManaAttack());
        this.setLife(10);
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

    public int getLife() {
        return life;
    }

    public void setLife(int attack) {
        this.life -= attack;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int attack) {
        this.mana -= attack;
    }

    public int getManaAttack() {
        return manaAttack;
    }

    public int getWeaponAttack() {
        return weaponAttack;
    }
    
}
