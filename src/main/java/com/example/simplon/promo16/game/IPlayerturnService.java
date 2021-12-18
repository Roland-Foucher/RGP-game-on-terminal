package com.example.simplon.promo16.game;

import com.example.simplon.promo16.perso.Perso;
import com.example.simplon.promo16.players.Player;

public interface IPlayerturnService {
    Perso playerTurn(Player playerTurn, Player playerAdvers);

    int playerSelectHisPerso(Player playerTurn);

   
    int playerChooseBetweenAttackOrCard(Player playerTurn, Perso persoSelected);
    
    int attackIsChoosen(Player playerTurn, Player playerAdvers, Perso persoSelected, int persoSelectedID);
}
