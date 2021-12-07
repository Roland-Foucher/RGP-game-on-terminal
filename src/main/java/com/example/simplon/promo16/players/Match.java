package com.example.simplon.promo16.players;

import com.example.simplon.promo16.perso.Perso;

public class Match {
    private Player player1;
    private Player player2;
    int persoSelected = 0;

    public void match(){
        while(!player1.playerLoose() || !player2.playerLoose() ){
           Perso player1Perso = player1.getPlayerPerso(persoSelected);
           Perso player2PersoToAttack = player2.getPlayerPerso(persoSelected);
        }
    }

}
