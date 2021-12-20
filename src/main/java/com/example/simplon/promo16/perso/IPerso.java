package com.example.simplon.promo16.perso;

public interface IPerso {

     /**
     * perso weapon attack advers perso. Remove health to the advers perso.
     * 
     * @param advers the perso adverse to remove health points
     */
    void weaponAttack(Perso advers);

    /**
     * perso mana attack an other personnage. Remove health to the advers perso.
     * 
     * @param advers the perso adverse to remove health points
     */
    void manaAttack(Perso advers);

    /**
     * give or substract health to perso, can't have more than default health on
     * init. 
     * if Health = 0 => perso is dead
     * 
     * @param attack the value to add or substract health
     */
    void setHealth(int attack);

    /**
     * give or substract mana to perso, can't have more than default mana on init
     * and less than 0.
     * 
     * @param manaNumber the value to add or substract mana
     */
    void setMana(int manaNumber);
    
    /**
     * Display all power of perso
     */
    @Override
    String toString();

     /**
     * if player is dead display name with a skull
     * 
     * @return name of player
     */
    public String getName();
    
}
