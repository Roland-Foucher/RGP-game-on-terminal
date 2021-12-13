package com.example.simplon.promo16.perso;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class PersoTest {

    Perso orc;
    Perso elfe;

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

    @Nested
    @DisplayName("Mana and Weapon attack test")
    class testAttack{
        
        @Test
        void testWeaponAttack() {
            orc.weaponAttack(elfe);
            assertEquals(20, elfe.getHealth());
        }

        @Test
        void testManaAttack(){
            orc.manaAttack(elfe);
            assertEquals(40, elfe.getHealth());
            assertEquals(120,orc.getHealth());
        }

        @Test
        void testHowManyManaAfterManaAttack(){
            orc.manaAttack(elfe);
            assertEquals(40, orc.getMana());
        }
    }
    
        @Test // health ne depasse pas maxHealth
        void given_MoreThanMaxHealth_Then_HealthIsMaxHealth(){
            orc.setHealth(20);
            assertEquals(120, orc.getHealth());
        }

        @Test // mana ne depasse pas maxMana
        void given_MoreThanMaxMana_Then_ManaIsMaxMana(){
            orc.setMana(20);
            assertEquals(60, orc.getMana());
        }

        @Test // mana n'est pas negatif
        void given_LessThan0Mana_Then_ManaIs0(){
            orc.setMana(-100);
            assertEquals(0, orc.getMana());
        }
    
        @Test
        void playerIsDead_whenLifeLessThan0(){
            orc.setHealth(-200);
            assertEquals(0, orc.getHealth());
            assertEquals(false, orc.isAlive());
        }

        @Test
        void playerIsDead_WhenLifeEqual0(){
            orc.setHealth(-120);
            assertEquals(0, orc.getHealth());
            assertEquals(false, orc.isAlive());
        }


 
        @Test
        void testDisplayPerso_WhenPersoIsAlive(){
            assertEquals("Orc", orc.getName());
        }

        @Test
        void testDisplayPerso_WhenPersoIsDead(){
            orc.setHealth(-200);
            assertEquals("Orc 💀", orc.getName());
            assertEquals("Orc 💀", orc.getName());
            assertEquals("Orc 💀", orc.getName());
            
        }


}
