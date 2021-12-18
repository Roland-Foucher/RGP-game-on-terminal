package com.example.simplon.promo16.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.simplon.promo16.perso.Perso;
import com.example.simplon.promo16.players.Player;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MatchTest {
    Match match2;
    Display display;

    Player player1Mock, player2Mock;
    PlayerTurnService playerTurnService;
    RouterSelect routerSelect;

    @BeforeEach
    public void init() {
        match2 = new Match();
        display = mock(Display.class);

        player1Mock = mock(Player.class);
        player2Mock = mock(Player.class);
        playerTurnService = new PlayerTurnService(display, routerSelect);

    }

    @AfterEach
    public void restoreStreams() {

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
    void testChoosePersoInvalid() {

        assertThrows(Error.class, () -> {
            match2.choosePerso(8);
        });

    }

    @Test
    void testMakePlayer() {
        Player player = match2.makePlayer(1, 2, 3, 4, "Player1");
        assertEquals("Orc", player.getIndividualPlayerPerso(0).getName());
        assertEquals("Assassin", player.getIndividualPlayerPerso(2).getName());
        assertEquals("Druide", player.getIndividualPlayerPerso(3).getName());
        assertEquals("Player1", player.getPlayerName());
    }

    @Test
    void runProgrammePlayer1Loose() {
        when(player1Mock.playerLoose()).thenReturn(true);
        match2.playertoTest(player1Mock, player2Mock);
        match2.playerMatch(playerTurnService, playerTurnService);
        match2.playerLoose();
        assertEquals(" win : 1", Match.getPlayer2Win());

    }

    @Test
    void runProgrammePlayer2Loose() {
        when(player2Mock.playerLoose()).thenReturn(true);
        match2.playertoTest(player1Mock, player2Mock);
        match2.playerMatch(playerTurnService, playerTurnService);
        match2.playerLoose();
        assertEquals(" win : 1", Match.getPlayer1Win());
    }

}
