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
    

    public void runProgramme(){
        int personnageChoice;
        Display display = new Display();
        display.init();
    
        personnageInitChoice[0] = display.personnageChoice();
        personnageInitChoice[2] = display.personnageChoice();
        personnageInitChoice[3] = display.personnageChoice();
        personnageInitChoice[4] = display.personnageChoice();

    }
   
    /**
     * make a player with the choose of user
     * @param userChoosePerso1 int choose by user for perso one
     * @param userChoosePerso2 int choose by user for perso two
     * @param userChoosePerso3 int choose by user for perso three
     * @param userChoosePerso4 int choose by user for perso four
     * @return player created
     */
    public Player makePlayer(int userChoosePerso1, int userChoosePerso2, int userChoosePerso3, int userChoosePerso4){
        Perso perso1 = this.choosePerso(userChoosePerso1);
        Perso perso2 = this.choosePerso(userChoosePerso2);
        Perso perso3 = this.choosePerso(userChoosePerso3);
        Perso perso4 = this.choosePerso(userChoosePerso4);
        Player player = new Player(perso1, perso2, perso3, perso4);

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

