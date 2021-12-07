package com.example.simplon.promo16.players;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void testPersoIsDead() {
        orc.setHealth(-200);
        player1.persoIsDead();
        assertEquals(3, player1.getNumberOfPerso());
    }

    @Test
    void testPlayerLoose() {
        orc.setHealth(-200);
        elfe.setHealth(-200);
        necro.setHealth(-200);
        knight.setHealth(-200);
        
        assertEquals(false, player1.playerLoose());
    }

    @Test
    void testGetNumberOfPerso() {
        assertEquals(4, player1.getNumberOfPerso());
    }

    @Test
    void getPlayerPerso(){
        
        assertEquals(knight, player1.getPlayerPerso(3));
    }

    @Test
    void getPlayerPerso_WithBadNumberInput(){
        assertEquals(null, player1.getPlayerPerso(10));
    }

}
