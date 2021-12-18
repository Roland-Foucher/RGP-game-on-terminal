package com.example.simplon.promo16.players;

import com.example.simplon.promo16.perso.Perso;
import com.example.simplon.promo16.perso.PowerCard;

public interface IPlayer {

    
    boolean playerLoose();
    void attackOption(int persoAttack, int choiceAttach, int persoToAttack, Player playerAgainst);
    void chooseCardOption(int option, int perso);
    int getNumberOfCardPlayer();
    int getNumberOfPerso();
    Perso getIndividualPlayerPerso(int i);
    String getPlayerName();
    PowerCard getPowerCard();
}
