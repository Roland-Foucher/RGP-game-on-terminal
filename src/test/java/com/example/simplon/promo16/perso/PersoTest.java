package com.example.simplon.promo16.perso;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersoTest {
    Orc orc;
    Elfe elfe;

    @BeforeEach
    public void init(){
        orc = new Orc();
        elfe = new Elfe();
    }
    @AfterEach
    public void finish(){
        orc = null;
        elfe = null;
    }
    @Test
    void testWeaponAttack() {
        orc.weaponAttack(elfe);
        assertEquals(20, elfe.getHealth());
    }

    @Test
    void testManaAttackOrc(){
        orc.manaAttack(elfe);
        assertEquals(40, elfe.getHealth());
        assertEquals(120,orc.getHealth());
    }

    @Test
    void testHowManyManaBeforeManaAttack(){
        orc.manaAttack(elfe);
        assertEquals(0, orc.getMana());
    }

    @Test
    void testManaAttackElfe(){
        orc.weaponAttack(elfe);
        elfe.manaAttack(orc);
        assertEquals(120, orc.getHealth());
        assertEquals(50, elfe.getHealth());
    }
}