package com.example.simplon.promo16.game;

import com.example.simplon.promo16.perso.Assassin;
import com.example.simplon.promo16.perso.Druid;
import com.example.simplon.promo16.perso.Elfe;
import com.example.simplon.promo16.perso.Knigth;
import com.example.simplon.promo16.perso.Magician;
import com.example.simplon.promo16.perso.Necromancer;
import com.example.simplon.promo16.perso.Orc;
import com.example.simplon.promo16.perso.Perso;
import com.example.simplon.promo16.players.Player;

public class Match {
    private Player player1;
    private Player player2;
    
    Display display = new Display();
    
    /**
     * methode to run the game while a player loose
     * first players select personnages
     * next players attack one by one
     */
    public void runProgramme(){
        String timeToChoosePerso[] = {"premier", "second", "troisiéme", "quatrième"};

        // init return names of players
        String[] playerNames = display.init();
       
        //choose personnages for player 1
        int personnageInitChoicePlayer1[] = new int[4];
        for (int i = 0; i < 4; i++) {
            personnageInitChoicePlayer1[i] = display.personnageChoice(timeToChoosePerso[i], playerNames[0], personnageInitChoicePlayer1);
        } 
        player1 = this.makePlayer(personnageInitChoicePlayer1[0], personnageInitChoicePlayer1[1], personnageInitChoicePlayer1[2], personnageInitChoicePlayer1[3], playerNames[0]);
        
        //choose personnages for player 2
        int personnageInitChoicePlayer2[] = new int[4];
        for (int i = 0; i < 4; i++) {
            personnageInitChoicePlayer2[i] = display.personnageChoice(timeToChoosePerso[i], playerNames[1], personnageInitChoicePlayer2);
        } 
        player2 = this.makePlayer(personnageInitChoicePlayer2[0], personnageInitChoicePlayer2[1], personnageInitChoicePlayer2[2], personnageInitChoicePlayer2[3], playerNames[1]);
        
        //players fight one by one until one of them loose
        while(!player1.playerLoose() && !player2.playerLoose()){
            display.arena(player1, player2);
            this.playerTurn(player1, player2);
            if (player2.playerLoose()){
                return;
            }
            display.arena(player1, player2);
            this.playerTurn(player2, player1);
            
        }
        // end of game
        if (player1.playerLoose()){
            System.out.println(player2.getPlayerName() +  " win !!");
        }else{
            System.out.println(player1.getPlayerName() +  " win!!");
        }
        //TODO faire un rejouer?

    }
   
    /**
     * Methode to choose card option or Attack
     * if player choose 1 : weapon
     * if player choose 2 : card
     * @param playerTurn player is turn to play
     * @param playerAdvers player to attack
     */
    public void playerTurn(Player playerTurn , Player playerAdvers){
    
        int persoSelectedID = display.playerChoosePersoToPlay(playerTurn);
        Perso persoSelected = playerTurn.getIndividualPlayerPerso(persoSelectedID-1);

        // check if perso is dead
        while (!persoSelected.isAlive()){
            System.out.println("Ce perso est mort! Choisir un autre perso.");
            persoSelectedID = display.playerChoosePersoToPlay(playerTurn);
            persoSelected = playerTurn.getIndividualPlayerPerso(persoSelectedID-1);
        }
        
        int playerChooseAttackOrCardID = display.playerChooseAttackOrCard(playerTurn);

        // don't select card if health and mana are max
        while(playerChooseAttackOrCardID == 2 && persoSelected.getMana() == persoSelected.getMaxMana() && persoSelected.getHealth() == persoSelected.getMaxHealth()){
            System.out.println("Ce perso est déjà au max de ses capacités !");
            playerChooseAttackOrCardID = display.playerChooseAttackOrCard(playerTurn);
        }
        

        // attack is choose
        if (playerChooseAttackOrCardID == 1){
            int playerAttack = display.playerChooseAttack(persoSelected);
            if (persoSelected.getClass() == Necromancer.class){
                int selfPersoToMakeAlive = display.playerChoosePersoToPlay(playerTurn);
                playerTurn.attackOption(persoSelectedID, playerAttack, selfPersoToMakeAlive, playerAdvers);
            }else{
                int playerAdversToAttack = display.playerChooseAdversToAttack(playerTurn, playerAdvers);
                Perso persoToAttack = playerAdvers.getIndividualPlayerPerso(playerAdversToAttack-1);

                // check if perso Advers is dead
                while(!persoToAttack.isAlive()){
                    System.out.println("Ce perso est mort! Choisir un autre perso.");
                    playerAdversToAttack = display.playerChooseAdversToAttack(playerTurn, playerAdvers);
                    persoToAttack = playerAdvers.getIndividualPlayerPerso(playerAdversToAttack-1);
                }
                playerTurn.attackOption(persoSelectedID, playerAttack, playerAdversToAttack, playerAdvers);
            }
            
        //card is choose
        }else if (playerChooseAttackOrCardID == 2){
            int playerChooseCardOptionID = display.playerChooseCardOption();
            player1.chooseCardOption(playerChooseCardOptionID, persoSelectedID);
        
        // error
        }else{
            System.out.println("error in the choose attack");
        }
        //TODO test choix perso dead
    }

    /**
     * make a player with the choose of user
     * @param userChoosePerso1 int choose by user for perso one
     * @param userChoosePerso2 int choose by user for perso two
     * @param userChoosePerso3 int choose by user for perso three
     * @param userChoosePerso4 int choose by user for perso four
     * @return player created
     */
    public Player makePlayer(int userChoosePerso1, int userChoosePerso2, int userChoosePerso3, int userChoosePerso4, String name){
        Perso perso1 = this.choosePerso(userChoosePerso1);
        Perso perso2 = this.choosePerso(userChoosePerso2);
        Perso perso3 = this.choosePerso(userChoosePerso3);
        Perso perso4 = this.choosePerso(userChoosePerso4);
        Player player = new Player(perso1, perso2, perso3, perso4, name);

        return player;
    }
   
     /**
     * choose a perso with int ID to add to player
     * @param persoChoosen number choose by user
     * @return perso to add to player
     */
    public Perso choosePerso(int persoChoosenID){
        Perso perso = null;
        switch (persoChoosenID){
            case 1 :
                perso = new Orc();
                break;
            case 2 :
                perso = new Knigth();
                break;
            case 3 :
                perso = new Assassin();
                break;
            case 4 :
                perso = new Druid();
                break;
            case 5 :
                perso = new Elfe();
                break;
            case 6 :
                perso = new Magician();
                break;
            case 7 :
                perso = new Necromancer();
                break;
            default :
                System.out.println("please choose a good value");
                break;
        }
        return perso;
    }

    //TODO faire un test mock
    // TODO Rearanger les test avec nom/ groupes / ...

}

