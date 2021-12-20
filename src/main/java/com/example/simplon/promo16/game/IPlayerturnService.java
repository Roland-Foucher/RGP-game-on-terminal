package com.example.simplon.promo16.game;

import com.example.simplon.promo16.perso.Perso;
import com.example.simplon.promo16.players.Player;


public interface IPlayerturnService {

    /**
     * Methode to choose between card option and Attack option
     * if player choose 1 : weapon
     * if player choose 2 : card
     * 
     * @param playerTurn  player is turn to play
     * @param playerAdvers player to attack
     */
    Perso playerTurn(Player playerTurn, Player playerAdvers);

     /**
     * player choose perso to attack advers, can't select dead perso
     * 
     * @param playerTurn player is turn to play
     * @return perso selected to make test
     */
    int playerSelectHisPerso(Player playerTurn);

    /**
     * player choose between attack or take magic card to his perso. Can't select
     * card if value of health and mana are max
     * 
     * @param playerTurn    player turn to player
     * @param persoSelected perso selected to attack
     * @return ID 1 = Attack / ID 2 = Card
     */
    int playerChooseBetweenAttackOrCard(Player playerTurn, Perso persoSelected);
    
    /**
     * player choose between mana attack and weapon attack, choose advers perso to
     * attack. can't attack a dead perso advers
     * 
     * @param playerTurn      player turn to play
     * @param playerAdvers    player to attack
     * @param persoSelected   perso choosen to attack
     * @param persoSelectedID id of the perso choosen to attack
     */
    int attackIsChoosen(Player playerTurn, Player playerAdvers, Perso persoSelected, int persoSelectedID);
}
