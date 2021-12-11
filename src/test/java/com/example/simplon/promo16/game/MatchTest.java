package com.example.simplon.promo16.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;


import com.example.simplon.promo16.perso.Perso;
import com.example.simplon.promo16.players.Player;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MatchTest {
    Match match;


    

    @BeforeEach
    public void init(){
        match = new Match();
    }
    @AfterEach
    public void restoreStreams() {
        match = null;
    }

    @Test
    void testChoosePerso() {
        Perso perso1 = match.choosePerso(1);
        assertEquals("Orc", perso1.getName());
        Perso perso2 = match.choosePerso(2);
        assertEquals("Chevalier", perso2.getName());
        Perso perso3 = match.choosePerso(7);
        assertEquals("Necromancer", perso3.getName());
    }

    @Test
    void testMakePlayer() {
        Player player = match.makePlayer(1, 2, 3, 4, "Player1");
        assertEquals("Orc", player.getIndividualPlayerPerso(0).getName());
        assertEquals("Assassin", player.getIndividualPlayerPerso(2).getName());
        assertEquals("Druide", player.getIndividualPlayerPerso(3).getName());
        assertEquals("Player1", player.getPlayerName());
    }

    @Disabled
    @Test
    void testPlayerTurnAttackOption() {
        System.setIn(new ByteArrayInputStream("1\n1\n1\n1\n".getBytes()));
        Player player1 = match.makePlayer(1, 2, 3, 4, "Player1");
        Player player2 = match.makePlayer(1, 2, 3, 4, "Player1");
        match.playerTurn(player1, player2);
        
        
        assertEquals(0, player2.getIndividualPlayerPerso(0).getHealth());
    }

    @Test
    void testRunProgramme() {

    }
}
