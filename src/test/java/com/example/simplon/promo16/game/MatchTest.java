package com.example.simplon.promo16.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import com.example.simplon.promo16.perso.Elfe;
import com.example.simplon.promo16.perso.Knigth;
import com.example.simplon.promo16.perso.Necromancer;
import com.example.simplon.promo16.perso.Orc;
import com.example.simplon.promo16.perso.Perso;
import com.example.simplon.promo16.players.Player;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class MatchTest {
    Match match;
    Match match2;
    Display display;
    Player player1;
    Player player2;
    Perso orc;
    Perso elfe;
    Perso necro;
    Perso knight;
    Perso orc2;
    Perso elfe2;
    Perso necro2;
    Perso knight2;
    Player player1Mock;
    Player player2Mock;

    @BeforeEach
    public void init() {
        match = mock(Match.class);
        match2 = new Match();
        display = mock(Display.class);
        orc = new Orc();
        elfe = new Elfe();
        necro = new Necromancer();
        knight = new Knigth();
        orc2 = new Orc();
        elfe2 = new Elfe();
        necro2 = new Necromancer();
        knight2 = new Knigth();
        player1 = new Player(orc, elfe, necro, knight, "test");
        player2 = new Player(orc2, elfe2, necro2, knight2, "test");
        player1Mock = mock(Player.class);
        player2Mock = mock(Player.class);

    }

    @AfterEach
    public void restoreStreams() {
        match = null;
        orc = null;
        elfe = null;
        necro = null;
        knight = null;
        player1 = null;
        orc2 = null;
        elfe2 = null;
        necro2 = null;
        knight2 = null;
        player2 = null;
        player1Mock = null;
        player2Mock = null;
        match2 = null;
        display = null;
    }

    @Test
    void testChoosePerso() {
        Perso perso1 = match2.choosePerso(1);
        assertEquals("Orc", perso1.getName());
        Perso perso2 = match2.choosePerso(2);
        assertEquals("Chevalier armure : 10", perso2.getName());
        Perso perso3 = match2.choosePerso(7);
        assertEquals("Necromancer", perso3.getName());
    }

    @Test
    void testMakePlayer() {
        Player player = match2.makePlayer(1, 2, 3, 4, "Player1");
        assertEquals("Orc", player.getIndividualPlayerPerso(0).getName());
        assertEquals("Assassin", player.getIndividualPlayerPerso(2).getName());
        assertEquals("Druide", player.getIndividualPlayerPerso(3).getName());
        assertEquals("Player1", player.getPlayerName());
    }

    

    @Disabled
    @Test
    void personnageInitChoice(){
        int[] perso = {1,2,3,4};
        when(display.personnageChoice("", "player1", perso)).thenReturn(1);
        match2.personnageInitChoice("player1");
        
        
    }

    
    @Test
    void runProgrammePlayer1Loose() {
        when(player1Mock.playerLoose()).thenReturn(true);
        match2.playertoTest(player1Mock, player2Mock);
        match2.playerMatch();
        match2.playerLoose();
        assertEquals(" win : 1", Match.getPlayer2Win());

    }
    @Test
    void runProgrammePlayer2Loose() {
        when(player2Mock.playerLoose()).thenReturn(true);
        match2.playertoTest(player1Mock, player2Mock);
        match2.playerMatch();
        match2.playerLoose();
        assertEquals(" win : 1", Match.getPlayer1Win());

    }
    
    @Test
    void PlayerSelectHisPerso() {
        when(display.playerChoosePersoToPlay(player1)).thenReturn(1);
        
        
        match2.mockDisplay(display);
        assertEquals(1, match2.playerSelectHisPerso(player1)); 
    }


}
