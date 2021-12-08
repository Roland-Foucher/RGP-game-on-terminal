package com.example.simplon.promo16.players;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.simplon.promo16.perso.Elfe;
import com.example.simplon.promo16.perso.Knigth;
import com.example.simplon.promo16.perso.Necromancer;
import com.example.simplon.promo16.perso.Orc;
import com.example.simplon.promo16.perso.Perso;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class playerTest {

    Perso orc;
    Perso elfe;
    Perso necro;
    Perso knight;
    Player player1;

    @BeforeEach
    public void init(){
        orc = new Orc();
        elfe = new Elfe();
        necro = new Necromancer();
        knight = new Knigth();
        player1 = new Player(orc, elfe, necro, knight);
    }
    @AfterEach
    public void finish(){
        orc = null;
        elfe = null;
        necro = null;
        knight = null;
        player1 = null;
    }

    
    @Test
    void testPlayerLoose_WhenAllPersoDead() {
        for (int i = 0; i < 4; i++) {
            player1.getIndividualPlayerPerso(i).setHealth(-2000);
        }
        assertEquals(true, player1.playerLoose());

    }
    @Test
    void testPlayerLooseFalse_When3PersoDead() {
        for (int i = 0; i < 3; i++) {
            player1.getIndividualPlayerPerso(i).setHealth(-2000);
        }
        
        assertEquals(false, player1.playerLoose());
    }

    @Test
    void testGetNumberOfPerso() {
        assertEquals(4, player1.getNumberOfPerso());
    }

    @Test
    void getIndividualPlayerPerso(){
        
        assertEquals(knight, player1.getIndividualPlayerPerso(3));
    }

    @Test
    void getIndividualPlayerPerso_WithBadNumberInput(){
        assertEquals(null, player1.getIndividualPlayerPerso(10));
    }

}
