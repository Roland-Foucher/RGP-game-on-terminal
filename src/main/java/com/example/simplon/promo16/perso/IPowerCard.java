package com.example.simplon.promo16.perso;


public interface IPowerCard {
    /**
     * card add 40pt to health. Verify if player have card.
     * Remove one card
     * @param perso perso to apply card
     */
    void addHealth(Perso perso);

    /**
     * card add 50pt to mana. Verify if player have card.
     * Remove one card
     * @param perso perso to apply card
     */
    void addMana(Perso perso);

    /**
     * get the number of card player have.
     * @return the number of card 
     */
    int getNumberOfCard();
}
