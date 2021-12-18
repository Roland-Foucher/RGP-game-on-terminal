package com.example.simplon.promo16.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.simplon.promo16.perso.Elfe;
import com.example.simplon.promo16.perso.Knigth;
import com.example.simplon.promo16.perso.Necromancer;
import com.example.simplon.promo16.perso.Orc;
import com.example.simplon.promo16.perso.Perso;
import com.example.simplon.promo16.players.Player;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

public class PlayerTurnServiceTest {

    Match match, match2;
    Display display;

    Player player1, player2;
    Perso orc, elfe, necro, knight, orc2, elfe2, knight2, necro2;

    Player player1Mock, player2Mock;
    PlayerTurnService playerTurnService;

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
        orc2 = new Orc();
        elfe2 = new Elfe();
        knight2 = new Necromancer();
        necro2 = new Necromancer();

        player1Mock = mock(Player.class);
        player2Mock = mock(Player.class);
        playerTurnService = new PlayerTurnService(display);

    }

    @AfterEach
    public void restoreStreams() {
        match = null;
        orc = null;
        elfe = null;
        necro = null;
        knight = null;
        player1 = null;
        player1Mock = null;
        player2Mock = null;
        match2 = null;
        display = null;
    }

    @Nested
    class testIfAttackIsChoosen {

        @Test
        void testAttackIsChoosen_Weapon() {
            when(display.playerChooseAttack(orc)).thenReturn(1);
            when(display.playerChooseAdversToAttack(player1, player2)).thenReturn(1);
            match2.mockDisplay(display);
            assertEquals(60, playerTurnService.attackIsChoosen(player1, player2, orc, 1));
            // assertEquals(0, orc2.getHealth());
        }

        @Test
        void testAttackIsChoosen_Mana() {
            when(display.playerChooseAttack(orc)).thenReturn(2);
            when(display.playerChooseAdversToAttack(player1, player2)).thenReturn(1);
            match2.mockDisplay(display);
            assertEquals(80, playerTurnService.attackIsChoosen(player1, player2, orc, 1));
            // assertEquals(0, orc2.getHealth());
        }

        @Test
        void testAttackIsChoosen_BadChoicePersoAttack() {
            when(display.playerChooseAttack(orc)).thenReturn(3);
            when(display.playerChooseAdversToAttack(player1, player2)).thenReturn(1);
            match2.mockDisplay(display);
            assertThrows(Error.class, () -> playerTurnService.attackIsChoosen(player1, player2, orc, 1));
        }

        @Test
        void testAttackIsChoosen_BadChoiceAdverseAttack() {
            when(display.playerChooseAttack(orc)).thenReturn(1);
            when(display.playerChooseAdversToAttack(player1, player2)).thenReturn(5);
            match2.mockDisplay(display);
            assertThrows(NullPointerException.class, () -> playerTurnService.attackIsChoosen(player1, player2, orc, 1));
        }
    }

    @Test
    void testPlayerSelectHisPerso() {
        when(display.playerChoosePersoToPlay(player1)).thenReturn(1);
        match2.mockDisplay(display);
        assertEquals(1, playerTurnService.playerSelectHisPerso(player1));
    }

}
