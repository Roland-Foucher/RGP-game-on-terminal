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
        
        
        String[] playerNames = display.init();
        int personnageInitChoicePlayer1[] = new int[4];
        
        //choose personnages
        personnageInitChoicePlayer1[0] = display.personnageChoice("premier", playerNames[0], personnageInitChoicePlayer1);
        personnageInitChoicePlayer1[1] = display.personnageChoice("second", playerNames[0], personnageInitChoicePlayer1);
        personnageInitChoicePlayer1[2] = display.personnageChoice("troisieme", playerNames[0], personnageInitChoicePlayer1);
        personnageInitChoicePlayer1[3] = display.personnageChoice("quatrieme", playerNames[0], personnageInitChoicePlayer1);
        player1 = this.makePlayer(personnageInitChoicePlayer1[0], personnageInitChoicePlayer1[1], personnageInitChoicePlayer1[2], personnageInitChoicePlayer1[3], playerNames[0]);
        
        int personnageInitChoicePlayer2[] = new int[4];
        personnageInitChoicePlayer2[0] = display.personnageChoice("premier", playerNames[1], personnageInitChoicePlayer2);
        personnageInitChoicePlayer2[1] = display.personnageChoice("second", playerNames[1], personnageInitChoicePlayer2);
        personnageInitChoicePlayer2[2] = display.personnageChoice("troisieme", playerNames[1], personnageInitChoicePlayer2);
        personnageInitChoicePlayer2[3] = display.personnageChoice("quatrieme", playerNames[1], personnageInitChoicePlayer2);
        player2 = this.makePlayer(personnageInitChoicePlayer2[0], personnageInitChoicePlayer2[1], personnageInitChoicePlayer2[2], personnageInitChoicePlayer2[3], playerNames[1]);
        
        while(!player1.playerLoose() || !player2.playerLoose()){
            display.arena(player1, player2);
            this.playerTurn(player1, player2);
            display.arena(player1, player2);
            this.playerTurn(player2, player1);
        }
        if (player1.playerLoose()){
            System.out.println(player2.getPlayerName() +  " win !!");
        }else{
            System.out.println(player1.getPlayerName() +  " win!!");
        }

    }
   
    /**
     * Methode to choose card option or Attack
     * if player choose 1 : weapon
     * if player choose 2 : card
     * @param playerTurn player is turn to play
     * @param playerAdvers player to attack
     */
    public void playerTurn(Player playerTurn , Player playerAdvers){

        int persoSelected = display.playerChoosePerso(playerTurn);
        int playerChooseWhatToDo = display.playerChooseWhatToDo(playerTurn);

        if (playerChooseWhatToDo == 1){
            int playerChooseAttack = display.playerChooseAttack(playerTurn, playerTurn.getIndividualPlayerPerso(persoSelected));
            int playerChooseAdversToAttack = display.playerChooseAdversToAttack(playerTurn, playerAdvers);
            player1.attackOption(persoSelected, playerChooseAttack, playerChooseAdversToAttack, playerAdvers);

        }else if (playerChooseWhatToDo == 2){
            int playerChooseCardOption = display.playerChooseCardOption();
            player1.chooseCardOption(playerChooseCardOption, persoSelected);

        }else{
            System.out.println("error in the choose attack");
        }
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
     * choose a perso with int to add to player
     * @param persoChoosen number choose by user
     * @return perso to add to player
     */
    public Perso choosePerso(int persoChoosen){
        Perso perso = null;
        switch (persoChoosen){
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

}

