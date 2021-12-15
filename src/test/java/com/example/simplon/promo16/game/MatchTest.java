package com.example.simplon.promo16.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;

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

    @BeforeEach
    public void init(){
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
        player2 = null;
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
    void runProgrammePlayer1Loose(){
        
        when(match.personnageInitChoice("player1")).thenReturn(player1);
        when(match.personnageInitChoice("player2")).thenReturn(player2);
        when(player1.playerLoose()).thenReturn(true);
        match.runProgramme();
        assertEquals(1, Match.getPlayer2Win());

    }

    

    @Test
    void PlayerSelectHisPerso_WhenPersoIsDead(){
        when(display.playerChoosePersoToPlay(player1)).thenReturn(1);
        player1.getIndividualPlayerPerso(0).setHealth(-200);
        int persoID = match.playerSelectHisPerso(player1);
        assertEquals(0, persoID);
    }

    @Disabled
    @Test
    void PlayerSelectHisPerso_WhenPersoIsNotDead(){
        
        int persoID = match2.playerSelectHisPerso(player1);
        when(display.playerChoosePersoToPlay(player1)).thenReturn(1);
        assertEquals(1, persoID);
    }




}
