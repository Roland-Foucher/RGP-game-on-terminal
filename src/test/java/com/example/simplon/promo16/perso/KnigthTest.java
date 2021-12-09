package com.example.simplon.promo16.perso;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KnigthTest {

    Perso orc;
    Perso knight;

    @BeforeEach
    public void init(){
        orc = new Orc();
        knight = new Knigth();
    }
    @AfterEach
    public void finish(){
        orc = null;
        knight = null;
    }


    @Test
    void testSetHealth_After_Attack() {
        orc.weaponAttack(knight);
        knight.manaAttack(orc);
        assertEquals(110, orc.getHealth());
        assertEquals(30, knight.getHealth());
    }
    @Test
    void testManaProtected_After_Attack() {
        knight.manaAttack(orc);
        orc.weaponAttack(knight);
        
        assertEquals(110, orc.getHealth());
        assertEquals(50, knight.getHealth());
    }
    @Test
    void testKnightIsDead(){
        knight.setHealth(-2000);
        assertEquals(false, knight.isAlive);
    }


}
