package com.example.simplon.promo16.game;
import com.example.simplon.promo16.perso.Perso;
import com.example.simplon.promo16.players.Player;

public interface IMatch {
    public void runProgramme();

    public void playerMatch(PlayerTurnService playerTurnType1, PlayerTurnService playerTurnType2);
    
    public void playerLoose();
    
    public Player personnageInitChoice(String playerName);

    public Perso choosePerso(int persoChoosenID);

    public Player makePlayer(int userChoosePerso1, int userChoosePerso2, int userChoosePerso3, int userChoosePerso4,
            String name);

    
    public Player makePlayerComputer();

}
