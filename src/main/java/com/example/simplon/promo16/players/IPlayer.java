package com.example.simplon.promo16.players;

import com.example.simplon.promo16.perso.Perso;
import com.example.simplon.promo16.perso.PowerCard;

public interface IPlayer {

    /**
     * if all player's perso are dead player loose.
     * 
     * @return boolean true if all perso are dead
     */
    boolean playerLoose();

     /**
     * methode to choose the option attack between weapon and mana.
     * Player choose a perso to play and a perso advers to attack
     * Check if persoID is between 1 and 4.
     * If perso is a necromancer, select a perso of player turn to make alive.
     * 
     * @param persoAttack   perso of player turn
     * @param choiceAttach  choice between mana, card or weapon
     * @param persoToAttack perso to attack
     * @param playerTurn    player is turn to attack
     * @param playerAgainst player to attack
     */
    void attackOption(int persoAttack, int choiceAttach, int persoToAttack, Player playerAgainst);

    /**
     * methode to apply card to a perso. player choose between add mana or health
     * check if player have card.
     * Check if persoID is between 1 and 4.
     * check if perso is alive.
     * 
     * @param option option selected 1 or 2 -> 1 : health / 2 : mana
     * @param perso  perso selected 1 2 3 or 4
     * 
     */
    void chooseCardOption(int option, int perso);

    /**
     * get the number of cards player have
     * @return the number of card between 0 and 2
     */
    int getNumberOfCardPlayer();

    /**
     * check the number of perso in the array
     * 
     * @return normaly 4
     */
    int getNumberOfPerso();

    /**
     * get a perso in the list of player's persos.
     * 
     * @param i the index of list between 1 and 4
     * @return the perso we want in the list
     */
    Perso getIndividualPlayerPerso(int i);


    String getPlayerName();
    PowerCard getPowerCard();
}
