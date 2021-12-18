package com.example.simplon.promo16.game;

import com.example.simplon.promo16.perso.Perso;
import com.example.simplon.promo16.players.Player;

public interface IDiplay {
    int init();

    String choosePlayer1Name();

    public String choosePlayer2Name();

    public void arena(Player player1, Player player2);
   
    public void displayTextInArena(String text1, String text2);
    
    public void displayPersoCharacteristicsInArena(Player player1, Player player2, int persoID);
    
    public int personnageChoice(String timeToChoosePerso, String player, int[] personnageChoice);
       
    public int playerChoosePersoToPlay(Player player);

    public int playerChooseAttackOrCard(Player player);
   
    public int playerChooseAttack(Perso perso);
  
    public int playerChooseAdversToAttack(Player player1, Player player2);
    
    public int playerChooseCardOption();
    
    public int replayGame();

}
