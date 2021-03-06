package com.example.simplon.promo16.perso;

/**
 * Player have 2 card to add health or mana to perso.
 */
public class PowerCard implements IPowerCard{
    private int numberOfCard = 2;

    public void addHealth(Perso perso) {
        if (this.getNumberOfCard() > 0) {
            perso.setHealth(40);
            this.playOneCard();
        } else {
            throw new Error("player don't have any card");
        }
    }

    public void addMana(Perso perso) {
        if (this.getNumberOfCard() > 0) {
            perso.setMana(50);
            this.playOneCard();
        } else {
            throw new Error("player don't have any card");
        }
    }

    public int getNumberOfCard() {
        return numberOfCard;
    }

    private void playOneCard() {
        this.numberOfCard -= 1;
        if (this.numberOfCard <= 0) {
            this.numberOfCard = 0;
        }
    }
}
