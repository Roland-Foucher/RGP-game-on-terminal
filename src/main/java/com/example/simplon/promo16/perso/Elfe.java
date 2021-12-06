package com.example.simplon.promo16.perso;

public class Elfe extends Perso {
   
    public Elfe(){
    name = " Elfe" ;
    weapon = "Arc";
    manaPower = "giveHealth";
    life = 80;
    mana = 60;
    manaAttack = 0;
    weaponAttack = 40;
    }


    @Override
    public void manaAttack(Perso perso){
        perso.setLife(-this.manaAttack);
        this.setMana(-this.getManaAttack());
        this.setLife(30);
    }

    
}
