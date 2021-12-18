package com.example.simplon.promo16.players;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.simplon.promo16.perso.Elfe;
import com.example.simplon.promo16.perso.Knigth;
import com.example.simplon.promo16.perso.Necromancer;
import com.example.simplon.promo16.perso.Orc;
import com.example.simplon.promo16.perso.Perso;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class playerTest {

    Perso orc;
    Perso elfe;
    Perso necro;
    Perso knight;
    Perso orc2;
    Perso elfe2;
    Perso necro2;
    Perso knight2;
    Player player1;
    Player player2;

    @BeforeEach
    public void init() {
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
    }

    @AfterEach
    public void finish() {
        orc = null;
        elfe = null;
        necro = null;
        knight = null;
        player1 = null;
        orc2 = null;
        elfe2 = null;
        necro2 = null;
        player2 = null;
    }

    @Nested
    class playerLoose {

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
    }

    @Nested
    class getPersoTest {

        @Test
        void testGetNumberOfPerso() {
            assertEquals(4, player1.getNumberOfPerso());
        }

        @Test
        void getIndividualPlayerPerso() {

            assertEquals(knight, player1.getIndividualPlayerPerso(3));
        }

        @Test
        void getIndividualPlayerPerso_WithBadNumberInput() {
            assertEquals(null, player1.getIndividualPlayerPerso(10));
        }
    }

    @Nested
    class cardOptionTest {
        @Test
        void chooseCardOption_GetMana() {
            player1.getIndividualPlayerPerso(1).setMana(-100);
            player1.chooseCardOption(2, 2);
            assertEquals(50, player1.getIndividualPlayerPerso(1).getMana());
        }

        @Test
        void chooseCardOption_GetHealth() {
            player1.getIndividualPlayerPerso(1).setHealth(-70);
            player1.chooseCardOption(1, 2);
            assertEquals(50, player1.getIndividualPlayerPerso(1).getHealth());
        }

        @Test
        void chooseCardOption_InvalideNumber() {
            player1.getIndividualPlayerPerso(1).setHealth(-70);
            assertThrows(Error.class, () -> {
                player1.chooseCardOption(3, 2);
            });

            assertEquals(10, player1.getIndividualPlayerPerso(1).getHealth());
        }

        @Test
        void chooseCardOption_GetHealth_WhenPersoIsDead() {
            player1.getIndividualPlayerPerso(1).setHealth(-200);
            assertThrows(Error.class, () -> {
                player1.chooseCardOption(1, 2);
            });

            assertEquals(0, player1.getIndividualPlayerPerso(1).getHealth());
            assertEquals(false, player1.getIndividualPlayerPerso(1).isAlive());
        }

        @Test
        void chooseCardOption_NotAnougthCard() {
            player1.getIndividualPlayerPerso(1).setMana(-100);
            player1.chooseCardOption(2, 2);
            player1.getIndividualPlayerPerso(1).setMana(-100);
            player1.chooseCardOption(2, 2);
            player1.getIndividualPlayerPerso(1).setMana(-100);
            assertThrows(Error.class, () -> {
                player1.chooseCardOption(2, 2);
            });

            assertEquals(0, player1.getIndividualPlayerPerso(1).getMana());
        }
    }

    @Nested
    class chooseOptionAttack {
        @Test
        void attackOption_chooseWeaponAttack() {
            player1.attackOption(1, 1, 1, player2);
            assertEquals(60, player2.getIndividualPlayerPerso(0).getHealth());
        }

        @Test
        void attackOption_chooseManaAttack() {
            player1.attackOption(1, 2, 1, player2);
            assertEquals(80, player2.getIndividualPlayerPerso(0).getHealth());
            assertEquals(40, player1.getIndividualPlayerPerso(0).getMana());
            player1.attackOption(2, 2, 2, player2);
            assertEquals(80, player2.getIndividualPlayerPerso(1).getHealth());
            assertEquals(30, player1.getIndividualPlayerPerso(1).getMana());
        }

        @Test
        void attackOption_invalidAttackNumber() {

            assertThrows(Error.class, () -> {
                player1.attackOption(1, 4, 1, player2);
            });

            assertEquals(120, player2.getIndividualPlayerPerso(0).getHealth());
        }

        @Test
        void attackOption_ChooseManaAttackNecro() {
            player1.getIndividualPlayerPerso(0).setHealth(-200);
            player1.attackOption(3, 2, 1, player2);
            assertEquals(60, player1.getIndividualPlayerPerso(0).getHealth());

        }
    }

}
