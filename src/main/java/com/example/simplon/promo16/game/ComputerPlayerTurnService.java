package com.example.simplon.promo16.game;

import java.util.Random;

import com.example.simplon.promo16.perso.Necromancer;
import com.example.simplon.promo16.perso.Perso;
import com.example.simplon.promo16.players.Player;

public class ComputerPlayerTurnService extends PlayerTurnService {
    private Random random = new Random();

    public ComputerPlayerTurnService(Display diplay, RouterSelect routerSelect) {
        super(diplay, routerSelect);
    }

    /**
     * computer choose between attack or play his card randomly.
     * computer can't choose a dead perso
     * can't select card if max mana and max health
     * 
     */
    @Override
    public Perso playerTurn(Player player2, Player player1) {

        Perso persoSelected = null;
        int persoSelectedID;

        do {
            persoSelectedID = random.nextInt(4) + 1;
            persoSelected = player2.getIndividualPlayerPerso(persoSelectedID - 1);
        } while (!persoSelected.isAlive());

        System.out.println("computer choose : " + persoSelected.getName());
        int playerChooseAttackOrCardID;

        if (persoSelected.getHealth() == persoSelected.getMaxHealth()
                && persoSelected.getMana() == persoSelected.getMaxMana()) {
            playerChooseAttackOrCardID = 1;
        } else if (player2.getNumberOfCardPlayer() == 0) {
            playerChooseAttackOrCardID = 1;
        } else {
            playerChooseAttackOrCardID = random.nextInt(2) + 1;
        }

        // attack is choose
        if (playerChooseAttackOrCardID == 1) {
            System.out.println("computer choose : attack");
            this.attackIsChoosen(player2, player1, persoSelected, persoSelectedID);

            // card is choose
        } else if (playerChooseAttackOrCardID == 2) {
            System.out.println("computer choose : card");
            int cardOptionID = random.nextInt(2) + 1;
            if (persoSelected.getHealth() == persoSelected.getMaxHealth())
                cardOptionID = 2;

            if (persoSelected.getMana() == persoSelected.getMaxMana())
                cardOptionID = 1;

            if (cardOptionID == 1)
                System.out.println("computer choisie carte vie");

            if (cardOptionID == 2)
                System.out.println("computer choose carte mana");

            player2.chooseCardOption(cardOptionID, persoSelectedID);

            // error
        } else {
            throw new Error("error number when choose attack or card");
        }
        return persoSelected;
    }

    /**
     * make a random choice of attack fo computer
     * 
     * cant't attack mana with necro if all team is alive
     * can't attack mana if not enough
     * can't attack a dead perso
     */
    @Override
    public int attackIsChoosen(Player player2, Player player1, Perso persoSelected, int persoSelectedID) {

        int playerAttack = random.nextInt(2) + 1;
        Perso persoToAttack;

        // check perso have mana to attack mana
        while (persoSelected.getMana() < persoSelected.getManaCost() && playerAttack == 2) {
            playerAttack = 1;
        }

        // check if all perso are alive for necromancer
        boolean allAlive = true;
        for (int i = 0; i < 4; i++) {
            allAlive = player2.getIndividualPlayerPerso(i).isAlive();
        }

        // check if necro is selected to do attack weapon if all perso are alive
        if (persoSelected.getClass() == Necromancer.class && allAlive) {
            playerAttack = 1;
        }

        // display what computer choose attack mana or weapon
        if (playerAttack == 1) {
            System.out.println("computer choose weapon attack");
        } else {
            System.out.println("computer choose mana attack");
        }

        // change the perso to apply mana to computer perso
        if (persoSelected.getClass() == Necromancer.class && playerAttack == 2) {
            int selfPersoToMakeAlive = random.nextInt(4) + 1;
            // check not choose necro!
            while (selfPersoToMakeAlive == playerAttack) {
                selfPersoToMakeAlive = random.nextInt(4) + 1;
            }
            persoToAttack = player2.getIndividualPlayerPerso(selfPersoToMakeAlive - 1);

            System.out.println("computer soigne " + persoToAttack.getName());
            player2.attackOption(persoSelectedID, playerAttack, selfPersoToMakeAlive, player1);

        } else {
            int playerAdversToAttack = random.nextInt(4) + 1;
            persoToAttack = player1.getIndividualPlayerPerso(playerAdversToAttack - 1);

            // check if perso Advers is dead
            while (!persoToAttack.isAlive()) {

                playerAdversToAttack = random.nextInt(4) + 1;
                persoToAttack = player1.getIndividualPlayerPerso(playerAdversToAttack - 1);
            }
            System.out.println("computer attaque " + persoToAttack.getName());
            player2.attackOption(persoSelectedID, playerAttack, playerAdversToAttack, player1);
        }
        return persoToAttack.getHealth();
    }

}
