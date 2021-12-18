package com.example.simplon.promo16.perso;

public interface IPerso {


    void weaponAttack(Perso advers);

    void manaAttack(Perso advers);

    void setHealth(int attack);

    void setMana(int manaNumber);
    
    @Override
    String toString();
    
}
