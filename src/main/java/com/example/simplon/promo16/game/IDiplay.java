package com.example.simplon.promo16.game;

import com.example.simplon.promo16.perso.Perso;
import com.example.simplon.promo16.players.Player;

public interface IDiplay {

    /**
     * First display of perso description. Next players choose names (verify input
     * not blank)
     * 
     * @return array of player's names to init players
     */
    int init();

    /**
     * player choose his name
     * @param playerID id to display between 1 and 2 (player1 or player2)
     * @return string of player name.
     */
    String choosePlayerName(int playerID);


    /**
     * Display the arena with all the perso of players with health points and mana
     * points.
     * 
     * @param player1 player1 to display perso
     * @param player2 player2 to display perso
     */
    void arena(Player player1, Player player2);
   
    /**
     * Methode to display a text line into the arena.
     * 
     * @param text1 param to display of player 1 in left side
     * @param text2 param ot display of player 2 in right side
     */
    void displayTextInArena(String text1, String text2);
    
    /**
     * Display the characteristiques of the current perso into the Arena
     * 
     * @param player1 perso in left side arena
     * @param player2 perso in right side arena
     * @param persoID perso to display characteristiques
     */
    void displayPersoCharacteristicsInArena(Player player1, Player player2, int persoID);
    
    /**
     * Display the differents perso to choose and return the id of perso choosen.
     * The player can't choose the same perso two times
     * 
     * @param timeToChoosePerso the turn of choose (1 to 4)
     * @param player            player turn to choose perso
     * @param personnageChoice  array of ids selected before
     * @return the id of perso selected
     */
    int personnageChoice(String timeToChoosePerso, String player, int[] personnageChoice);
    
    /**
     * On game, player choose his perso to play.
     * take a skull if player dead
     * 
     * @param player player turn
     * @return id of perso selected (-1 to match the array)
     */
    int playerChoosePersoToPlay(Player player);

    /**
     * After choose perso, player choose Attack option or Card option
     * If player don't have any card, don't display et can't select card
     * 
     * @param player player turn
     * @return id of the option selected (1 = attack / 2 = Card)
     */
    int playerChooseAttackOrCard(Player player);
   
    /**
     * If player choose Attack : choice to choose between mana or weapon.
     * If perso don't have anougth mana, can't choice mana.
     * 
     * @param perso choosen
     * @return id of the choice selected (1 = weapon / 2 - mana)
     */
    int playerChooseAttack(Perso perso);
    
    /**
     * player choose advers to attack, value must be between 1 and 4
     * 
     * @param player1 player turn
     * @param player2 player to attack
     * @return player ID to attack between 1 and 4
     */
    int playerChooseAdversToAttack(Player player1, Player player2);
    
    /**
     * Select the card option between add health and and mana
     * 
     * @return 1 if add health
     * @return 2 if add mana
     */
    int playerChooseCardOption();
    
    /**
     * players choose if they want to replay the game
     * 
     * @return 1 if yes
     * @return 2 if no
     */
    int replayGame();

    /**
     * methode to check if the user input is an integer.
     * 
     * @return integer input user OK
     */
    int userInput();
}
