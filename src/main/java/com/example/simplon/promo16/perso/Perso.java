package com.example.simplon.promo16.perso;

public class Perso {

    private String name ;
    private String weapon;
    private String manaPower;
    private int life;
    private int mana;
    private int manaAttack;
    private int weaponAttack;
    
    // public Perso(String name, String weapon, String manaPower, int life, int mana, int manaAttack, int weaponAttack) {
    //     this.name = name;
    //     this.weapon = weapon;
    //     this.manaPower = manaPower;
    //     this.life = life;
    //     this.mana = mana;
    //     this.manaAttack = manaAttack;
    //     this.weaponAttack = weaponAttack;
    // }

    public void weaponAttack(Perso perso){
        perso.setLife(this.weaponAttack);
    }

    public void manaAttack(Perso perso){
        perso.setLife(this.manaAttack);
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
