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
    private int personnageInitChoice[] = new int[4];
    Display display = new Display();
    

    public void runProgramme(){
        
        
        display.init();
        
        //choose personnages
        personnageInitChoice[0] = display.personnageChoice("premier", "player1");
        personnageInitChoice[1] = display.personnageChoice("second", "player1");
        personnageInitChoice[2] = display.personnageChoice("troisieme", "player1");
        personnageInitChoice[3] = display.personnageChoice("quatrieme", "player1");
        player1 = this.makePlayer(personnageInitChoice[0], personnageInitChoice[1], personnageInitChoice[2], personnageInitChoice[3], "Player1");
        
        personnageInitChoice[0] = display.personnageChoice("premier", "player2");
        personnageInitChoice[1] = display.personnageChoice("second", "player2");
        personnageInitChoice[2] = display.personnageChoice("troisieme", "player2");
        personnageInitChoice[3] = display.personnageChoice("quatrieme", "player2");
        player2 = this.makePlayer(personnageInitChoice[0], personnageInitChoice[1], personnageInitChoice[2], personnageInitChoice[3], "Player2");
        
        while(!player1.playerLoose() || !player2.playerLoose()){
            this.playerTurn(player1, player2);
            this.playerTurn(player2, player1);
        }
        if (player1.playerLoose()){
            System.out.println(player2.getPlayerName() +  " win !!");
        }else{
            System.out.println(player1.getPlayerName() +  " win!!");
        }



    }
   
    public void playerTurn(Player playerTurn , Player playerAdvers){

        int persoSelected = display.playerChoosePerso(playerTurn);
        int playerChooseWhatToDo = display.playerChooseWhatToDo(playerTurn);
            if (playerChooseWhatToDo == 1){
                int playerChooseAttack = display.playerChooseAttack(playerTurn, playerTurn.getIndividualPlayerPerso(persoSelected));
                int playerChooseAdversToAttack = display.playerChooseAdversToAttack(playerAdvers);
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

