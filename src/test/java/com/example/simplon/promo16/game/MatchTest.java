package com.example.simplon.promo16.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;


import com.example.simplon.promo16.perso.Perso;
import com.example.simplon.promo16.players.Player;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MatchTest {
    Match match;
    Display display;
    Player player1;
    Player player2;
    


    @BeforeEach
    public void init(){
        match = new Match();
        display = mock(Display.class);
        player1 = mock(Player.class);
        player2 = mock (Player.class);
        
        
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
        assertEquals("Chevalier armure : 10", perso2.getName());
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
    @Test
    void runProgrammePlayer1Loose(){
        String[] playerNames = {"player1", "player2"};
        when(display.init()).thenReturn(playerNames);
        when(player1.playerLoose()).thenReturn(true);
        match.runProgramme();
        verify(player1, times(1)).setWin();


    }




}
