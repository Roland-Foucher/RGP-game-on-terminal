package com.example.simplon.promo16.perso;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NecromancerTest {

    Orc orc;
    Necromancer necro;

    @BeforeEach
    public void init(){
        orc = new Orc();
        necro = new Necromancer();
    }
    @AfterEach
    public void finish(){
        orc = null;
        necro = null;
    }


    @Test
    void testManaAttackondeathPerso() {
        orc.setHealth(-2000);
        necro.manaAttack(orc);
        assertEquals(60, orc.getHealth());
        assertEquals(50, necro.getMana());
    }
}
