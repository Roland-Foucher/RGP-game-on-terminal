package com.example.simplon.promo16.players;

import java.util.ArrayList;
import java.util.List;

import com.example.simplon.promo16.perso.Necromancer;
import com.example.simplon.promo16.perso.Perso;
import com.example.simplon.promo16.perso.PowerCard;


public class Player implements IPlayer {

    private List<Perso> playerListOfPerso = new ArrayList<>();
    private PowerCard powerCard = new PowerCard();
    private String playerName;

    /**
     * constructor of player to add in the list
     * 
     * @param perso1 type of perso selected
     * @param perso2 type of perso selected
     * @param perso3 type of perso selected
     * @param perso4 type of perso selected
     */
    public Player(Perso perso1, Perso perso2, Perso perso3, Perso perso4, String name) {
        playerListOfPerso.add(perso1);
        playerListOfPerso.add(perso2);
        playerListOfPerso.add(perso3);
        playerListOfPerso.add(perso4);
        this.playerName = name;
    }

    public boolean playerLoose() {
        for (Perso perso : playerListOfPerso) {
            if (perso.isAlive()) {
                return false;
            }
        }
        return true;
    }

    public void attackOption(int persoAttack, int choiceAttach, int persoToAttack, Player playerAgainst) {

        // check value perso are OK
        if (persoAttack < 1 || persoAttack > 4) {
            throw new Error("invalide perso choice");
        }
        if (persoToAttack < 1 || persoToAttack > 4) {
            throw new Error("invalide perso to attack choice");
        }

        // convert choice to index list value
        persoAttack -= 1;
        persoToAttack -= 1;

        // take perso list to a variable and check is alive
        Perso persoPlayerTurn = this.getIndividualPlayerPerso(persoAttack);
        Perso persoPlayerAgainst = playerAgainst.getIndividualPlayerPerso(persoToAttack);

        // switch choices and check option
        switch (choiceAttach) {
            case 1:
                if (!persoPlayerTurn.isAlive()) {
                    throw new Error("error = perso selected is dead !");
                }
                persoPlayerTurn.weaponAttack(persoPlayerAgainst);
                break;
            case 2:
                if (persoPlayerTurn.getClass() == Necromancer.class) { // check if necro is selected
                    persoPlayerAgainst = this.getIndividualPlayerPerso(persoToAttack);
                }
                persoPlayerTurn.manaAttack(persoPlayerAgainst);
                break;
            default:
                throw new Error("invalid choice of perso");
        }
    }

  
    public void chooseCardOption(int option, int perso) {

        if (this.getPowerCard().getNumberOfCard() == 0) {
            throw new Error("not anougth card to do this");
        }

        // check perso choice is OK
        if (perso < 1 || perso > 4) {
            throw new Error("invalid choice of perso");
        }
        // convert choice to index list value
        perso -= 1;

        // take perso list to a variable and check is alive
        Perso persoToApplyCard = this.getIndividualPlayerPerso(perso);
        if (!persoToApplyCard.isAlive()) {
            throw new Error("error = this perso is dead !");
        }

        // switch choices and check option is OK
        switch (option) {
            case 1:
                this.getPowerCard().addHealth(persoToApplyCard);
                break;
            case 2:
                this.getPowerCard().addMana(persoToApplyCard);
                break;
            default:
                throw new Error("this option does not exist");

        }
    }

    // getters

    public PowerCard getPowerCard() {
        return this.powerCard;
    }

    public int getNumberOfCardPlayer() {
        return this.powerCard.getNumberOfCard();
    }

    public int getNumberOfPerso() {
        return this.playerListOfPerso.size();
    }

    public Perso getIndividualPlayerPerso(int i) {

        try {
            return playerListOfPerso.get(i);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("invalid choice of perso");
        }
        return null;
    }

    public String getPlayerName() {
        return this.playerName;
    }

}
