package com.example.simplon.promo16.perso;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NecromancerTest {

    Perso orc;
    Perso necro;

    @BeforeEach
    public void init() {
        orc = new Orc();
        necro = new Necromancer();
    }

    @AfterEach
    public void finish() {
        orc = null;
        necro = null;
    }

    @Test
    void testManaAttackonDeathPerso() {
        orc.setHealth(-2000);
        necro.manaAttack(orc);
        assertEquals(60, orc.getHealth());
        assertEquals(50, necro.getMana());
    }

    @Test
    void testManaAttackonAlivePerso() {
        assertThrows(Error.class, () -> {
            necro.manaAttack(orc);
        });

    }

}
