package com.example.simplon.promo16.perso;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PowerCardTest {
    Perso orc;
    PowerCard powercard;

    @BeforeEach 
    public void init(){
        orc = new Orc();
        powercard = new PowerCard();
    }
    @AfterEach
    public void finish(){
        orc = null;
        powercard = null;
    }
    @Test
    void testAddHealth() {
        orc.setHealth(-40);
        powercard.addHealth(orc);
        assertEquals(120, orc.getHealth());
    }

    @Test
    void testAddMana() {
        orc.setMana(-40);
        powercard.addMana(orc);
        assertEquals(60, orc.getMana());
    }

    @Test
    void testCardNegative(){
        powercard.addHealth(orc);
        powercard.addHealth(orc);
        powercard.addHealth(orc);
        assertEquals(0, powercard.getNumberOfCard());
    }
}
