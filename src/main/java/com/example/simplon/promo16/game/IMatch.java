package com.example.simplon.promo16.game;
import com.example.simplon.promo16.perso.Perso;
import com.example.simplon.promo16.players.Player;

public interface IMatch {
    void runProgramme();

    void playerMatch(PlayerTurnService playerTurnType1, PlayerTurnService playerTurnType2);
    
    void playerLoose();
    
    Player personnageInitChoicePlayer(String playerName);

    Perso choosePerso(int persoChoosenID);

    Player makePlayer(int userChoosePerso1, int userChoosePerso2, int userChoosePerso3, int userChoosePerso4,
            String name);

    
    Player makePlayerComputer();

}
