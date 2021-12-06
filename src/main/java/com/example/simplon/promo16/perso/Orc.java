package com.example.simplon.promo16.perso;

public class Orc extends Perso {

       private String name = "Orc";
       private String weapon = "Gourdin";
       private String manaPower = "Morsure";
       private int life = 120;
       private int mana = 40;
       private int manaAttack = 40;
       private int weaponAttack = 60;
        
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
    
    
    

