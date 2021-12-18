package com.example.simplon.promo16.game;

import com.example.simplon.promo16.perso.Necromancer;
import com.example.simplon.promo16.perso.Perso;
import com.example.simplon.promo16.players.Player;

public class PlayerTurnService {

    Display display;

    public PlayerTurnService(Display diplay) {
        this.display = diplay;
    }

    /**
     * Methode to choose card option or Attack
     * if player choose 1 : weapon
     * if player choose 2 : card
     * 
     * @param playerTurn   player is turn to play
     * @param playerAdvers player to attack
     */
    public Perso playerTurn(Player playerTurn, Player playerAdvers) {

        int persoSelectedID = this.playerSelectHisPerso(playerTurn);
        Perso persoSelected = playerTurn.getIndividualPlayerPerso(persoSelectedID - 1);

        int playerChooseAttackOrCardID = this.playerChooseBetweenAttackOrCard(playerTurn, persoSelected);

        // attack is choose
        if (playerChooseAttackOrCardID == 1) {
            this.attackIsChoosen(playerTurn, playerAdvers, persoSelected, persoSelectedID);

            // card is choose
        } else if (playerChooseAttackOrCardID == 2) {
            int cardOptionID = this.display.playerChooseCardOption();
            playerTurn.chooseCardOption(cardOptionID, persoSelectedID);

            // error
        } else {
            throw new Error("error number when choose attack or card");
        }
        return persoSelected;

    }

    /**
     * player choose perso to attack advers, can't select dead perso
     * 
     * @param playerTurn player is turn to play
     * @return perso selected
     */
    public int playerSelectHisPerso(Player playerTurn) {

        int persoSelectedID = display.playerChoosePersoToPlay(playerTurn);
        Perso persoSelected = playerTurn.getIndividualPlayerPerso(persoSelectedID - 1);

        // check if perso is dead
        while (!persoSelected.isAlive()) {
            System.out.println("Ce perso est mort! Choisir un autre perso.");
            persoSelectedID = display.playerChoosePersoToPlay(playerTurn);
            persoSelected = playerTurn.getIndividualPlayerPerso(persoSelectedID - 1);
        }

        return persoSelectedID;
    }

    /**
     * player choose between attack or take magic card to his perso. Can't select
     * card if value of health and mana are maxa
     * 
     * @param playerTurn    player turn to player
     * @param persoSelected perso selected to attack
     * @return ID 1 = Attack / ID 2 = Card
     */
    public int playerChooseBetweenAttackOrCard(Player playerTurn, Perso persoSelected) {
        int playerChooseAttackOrCardID = display.playerChooseAttackOrCard(playerTurn);

        // don't select card if health and mana are max
        while (playerChooseAttackOrCardID == 2 && persoSelected.getMana() == persoSelected.getMaxMana()
                && persoSelected.getHealth() == persoSelected.getMaxHealth()) {
            System.out.println("Ce perso est déjà au max de ses capacités !");
            playerChooseAttackOrCardID = display.playerChooseAttackOrCard(playerTurn);
        }

        return playerChooseAttackOrCardID;
    }

    /**
     * player choose between mana attack and weapon attack, choose advers perso to
     * attack. can't attack a dead perso advers
     * 
     * @param playerTurn      player turn to play
     * @param playerAdvers    player to attack
     * @param persoSelected   perso choosen to attack
     * @param persoSelectedID id of the perso choosen to attack
     */
    public int attackIsChoosen(Player playerTurn, Player playerAdvers, Perso persoSelected, int persoSelectedID) {

        int playerAttack = display.playerChooseAttack(persoSelected);
        Perso persoToAttack;

        if (persoSelected.getClass() == Necromancer.class && playerAttack == 2) {
            int selfPersoToMakeAlive = display.playerChoosePersoToPlay(playerTurn);
            persoToAttack = playerTurn.getIndividualPlayerPerso(selfPersoToMakeAlive);
            playerTurn.attackOption(persoSelectedID, playerAttack, selfPersoToMakeAlive, playerAdvers);
        } else {
            int playerAdversToAttack = display.playerChooseAdversToAttack(playerTurn, playerAdvers);
            persoToAttack = playerAdvers.getIndividualPlayerPerso(playerAdversToAttack - 1);

            // check if perso Advers is dead
            while (!persoToAttack.isAlive()) {
                System.out.println("Ce perso est mort! Choisir un autre perso.");
                playerAdversToAttack = display.playerChooseAdversToAttack(playerTurn, playerAdvers);
                persoToAttack = playerAdvers.getIndividualPlayerPerso(playerAdversToAttack - 1);
            }
            playerTurn.attackOption(persoSelectedID, playerAttack, playerAdversToAttack, playerAdvers);
        }
        return persoToAttack.getHealth();
    }
}
