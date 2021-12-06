package com.example.simplon.promo16.perso;

public class Elfe extends Perso {
   
    public Elfe(){
        this.name = " Elfe" ;
        this.weapon = "Arc";
        this.manaPower = "giveHealth";
        this.health = 80;
        this.mana = 60;
        this.manaAttack = 0;
        this.weaponAttack = 40;
    }


    @Override
    public void manaAttack(Perso perso){
        perso.setHealth(-this.manaAttack);
        this.setMana(-this.getManaAttack());
        this.setHealth(30);
    }

    
}
