package com.example.simplon.promo16.perso;

public class Necromancer extends Perso {

    public Necromancer() {
        this.name = "Necromancer";
        this.weapon = "Baton";
        this.manaPower = "Resurection";
        this.life = 80;
        this.mana = 100;
        this.manaAttack = 50;
        this.weaponAttack = 20;
    }

    @Override
    public void manaAttack(Perso perso) {
        if (perso.getLife()==0){
            perso.setLife(//TODO add the max health of perso);
        }
    }

    
    
    
}
