package com.example.simplon.promo16.game;

import com.example.simplon.promo16.perso.Necromancer;
import com.example.simplon.promo16.perso.Perso;
import com.example.simplon.promo16.players.Player;

/**
 * services of differents options that user have to select on his turn.
 */
public class PlayerTurnService implements IPlayerturnService {

    Display display;


    /**
     * add the display instanciate in Match class
     * @param diplay display instanciate in match class
     */
    public PlayerTurnService(Display diplay) {
        this.display = diplay;
    }

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

    public int playerChooseBetweenAttackOrCard(Player playerTurn, Perso persoSelected) {
        int playerChooseAttackOrCardID = display.playerChooseAttackOrCard(playerTurn);

        // don't select card if health and mana are max
        while (playerChooseAttackOrCardID == 2 && persoSelected.getMana() == persoSelected.getMaxMana()
                && persoSelected.getHealth() == persoSelected.getMaxHealth()) {
            System.out.println("Ce perso est d??j?? au max de ses capacit??s !");
            playerChooseAttackOrCardID = display.playerChooseAttackOrCard(playerTurn);
        }

        return playerChooseAttackOrCardID;
    }

  
    public int attackIsChoosen(Player playerTurn, Player playerAdvers, Perso persoSelected, int persoSelectedID) {

        int playerAttack = display.playerChooseAttack(persoSelected);
        Perso persoToAttack;

        if (persoSelected.getClass() == Necromancer.class && playerAttack == 2) {
            int selfPersoToMakeAlive = display.playerChoosePersoToPlay(playerTurn);
            while(selfPersoToMakeAlive == playerAttack){
                System.out.println("Vous ne pouvez pas choisir le necromancer!");
                selfPersoToMakeAlive = display.playerChoosePersoToPlay(playerTurn);
            }
            persoToAttack = playerTurn.getIndividualPlayerPerso(selfPersoToMakeAlive - 1);
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
