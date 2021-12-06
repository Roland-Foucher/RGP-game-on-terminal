package com.example.simplon.promo16.perso;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersoTest {
    Perso perso1;
    Perso perso2;

    @BeforeEach
    public void init(){
        perso1 = new Orc();
        perso2 = new Elfe();
    }
    @AfterEach
    public void finish(){
        perso1 = null;
        perso2 = null;
    }
    @Test
    void testWeaponAttack() {
        perso1.weaponAttack(perso2);
        assertEquals(60, perso2.getLife());
    }

    @Test
    void testManaAttack(){
        perso1.manaAttack(perso2);
        assertEquals(80, perso2.getLife());
    }
}
