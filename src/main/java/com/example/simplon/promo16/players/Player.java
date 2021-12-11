package com.example.simplon.promo16.players;

import java.util.ArrayList;
import java.util.List;

import com.example.simplon.promo16.perso.Necromancer;
import com.example.simplon.promo16.perso.Perso;
import com.example.simplon.promo16.perso.PowerCard;

public class Player {

    private List <Perso> playerListOfPerso = new ArrayList<>();
    private PowerCard powerCard = new PowerCard();
    private String playerName;

    /**
     * constructor of player to add in the list
     * @param perso1 type of perso selected
     * @param perso2 type of perso selected
     * @param perso3 type of perso selected
     * @param perso4 type of perso selected
     */
    public Player(Perso perso1, Perso perso2, Perso perso3, Perso perso4,String name) {
        playerListOfPerso.add(perso1);
        playerListOfPerso.add(perso2);
        playerListOfPerso.add(perso3);
        playerListOfPerso.add(perso4);
        this.playerName = name;
    }

    /**
     * if all of perso is dead player loose
     * @return true if all perso are dead
     */

    public boolean playerLoose() {
        for (Perso perso : playerListOfPerso) {
            if (perso.isAlive()){
                return false;
            }
        }
        return true;
    }
    
     /**
     * methode to choose the option attack. if perso is a necromancer, 
     * @param persoAttack perso of player turn
     * @param choiceAttach choice between mana, card or weapon 
     * @param persoToAttack perso to attack
     * @param playerTurn player is turn to attack
     * @param playerAgainst player to attack
     */
    public void attackOption(int persoAttack, int choiceAttach, int persoToAttack, Player playerAgainst){
        
        // check value perso are OK
        if (persoAttack<1 || persoAttack >4){
            System.out.println("invalide perso choice");
            return;
        }

        if (persoToAttack<1 || persoToAttack >4){
            System.out.println("invalide perso to attack choice");
            return;
        }

        // convert choice to index list value
        persoAttack-=1;
        persoToAttack-=1;

        // take perso list to a variable and check is alive
        Perso persoPlayerTurn = this.getIndividualPlayerPerso(persoAttack);
        Perso persoPlayerAgainst = playerAgainst.getIndividualPlayerPerso(persoToAttack);
        
       
       
        //switch choices and check option
        switch (choiceAttach){
            case 1 :
            if (!persoPlayerTurn.isAlive()){
                System.out.println("error = this perso is dead !");
                return;
            }
                persoPlayerTurn.weaponAttack(persoPlayerAgainst);
                break;
            case 2 :
                 if (persoPlayerTurn.getClass() == Necromancer.class){  // check if necro is selected
                    persoPlayerAgainst = this.getIndividualPlayerPerso(persoToAttack);
                 }
                persoPlayerTurn.manaAttack(persoPlayerAgainst);
                break;
            default :
                System.out.println("invalid choice of perso");
                break;
        }
    }

    /**
     * methode to apply card to a perso
     * @param option option selected 1 or 2
     * @param perso perso selected 1 2 3 or 4
     * 
     */
    public void chooseCardOption(int option, int perso){

        if (this.getPowerCard().getNumberOfCard() == 0){
            System.out.println("not anougth card to do this");
            return;
        }
        
        // check perso choice is OK 
        if (perso < 1 || perso > 4) {
            System.out.println("invalid choice of perso");
            return;
        }
        // convert choice to index list value
        perso-=1;
        // take perso list to a variable and check is alive
        Perso persoToApplyCard = this.getIndividualPlayerPerso(perso);
        if (!persoToApplyCard.isAlive()){
            System.out.println("error = this perso is dead !");
            return;
        }

        //switch choices and check option is OK
        switch (option){
            case 1 :
                this.getPowerCard().addHealth(persoToApplyCard);
                break;
            case 2 :
                this.getPowerCard().addMana(persoToApplyCard);
                break;
            default :
                System.out.println("this option does not exist");
                break;
        }
    }

    //
    // getter
    //

    private PowerCard getPowerCard() {
        return powerCard;
    }

    public int getNumberOfCardPlayer(){
        return powerCard.getNumberOfCard();
    }

    /**
     * check the number of perso in the array
     * @return normaly 4
     */

    public int getNumberOfPerso(){
        return this.playerListOfPerso.size();
    }

        /**
     * get a perso in the list
     * @param i the index of list
     * @return  the perso we want
     */
    public Perso getIndividualPlayerPerso(int i){
        
        try {
            return playerListOfPerso.get(i);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("invalid choice of perso");
        }
        return null;
    }

    public String getPlayerName() {
        return playerName;
    }
    


}
