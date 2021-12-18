package com.example.simplon.promo16.game;

import com.example.simplon.promo16.App;
import java.util.Random;

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
    private static Player player1;
    private static Player player2;
    private static int player1Win = 0;
    private static int player2Win = 0;
    private String[] playerNames;
    private RouterSelect routerSelect = new RouterSelect();
    private static int[] personnageInitChoicePlayer1 = new int[4];
    private static int[] personnageInitChoicePlayer2 = new int[4];

    private Display display = new Display();


    private Random random = new Random();
    private int gameMode;
    private PlayerTurnService humanPlayerTurn;
    private PlayerTurnService computerPlayerTurn;



    /**
     * methode to run the game while a player loose
     * first players select personnages
     * next players attack one by one
     * players can replay game
     */
    public void runProgramme() {
        
            // players fight one by one until one of them loose
            if (gameMode == 1)
                this.playerMatch(humanPlayerTurn, humanPlayerTurn);
            if (gameMode == 2)
                this.playerMatch(humanPlayerTurn, computerPlayerTurn);

            this.playerLoose();

            // end of game
            if (player1.playerLoose()) {
                System.out.println(player2.getPlayerName() + " win !!");
                Match.player2Win += 1;
            } else {
                System.out.println(player1.getPlayerName() + " win!!");
                Match.player1Win += 1;
            }
        //     int replayGame = display.replayGame();
        //     replay = replayGame == 1 ? true : false;

        // } while (replay);
    }

    public void playerInit(){

        gameMode = display.init();
        humanPlayerTurn = new PlayerTurnService(display);

        if (gameMode == 1) {

            if (player1 == null || player2 == null) {
                playerNames[0] = display.choosePlayer1Name();
                playerNames[1] = display.choosePlayer2Name();
            }

            player1 = this.personnageInitChoicePlayer1(playerNames[0]);
            player2 = this.personnageInitChoicePlayer2(playerNames[1]);
        }

        if (gameMode == 2) {

            computerPlayerTurn = new ComputerPlayerTurnService(display);
            if (player1 == null || player2 == null) {
                playerNames[0] = display.choosePlayer1Name();
            }

            player1 = this.personnageInitChoicePlayer1(playerNames[0]);
            player2 = this.makePlayerComputer();
        }
            
    }

    /**
     * While nobody loose, player play one by one with call playerTurn methode
     */
    public void playerMatch(PlayerTurnService playerTurnType1, PlayerTurnService playerTurnType2) {

        while (!player1.playerLoose() && !player2.playerLoose()) {
            display.arena(player1, player2);
            playerTurnType1.playerTurn(player1, player2);
            if (player2.playerLoose()) {
                break;
            }
            display.arena(player1, player2);
            playerTurnType2.playerTurn(player2, player1);
        }
    }

    /**
     * Get +1 to one player if other loose
     */
    public void playerLoose() {
        if (player1.playerLoose()) {
            System.out.println(player2.getPlayerName() + " win !!");
            Match.player2Win += 1;
        } else {
            System.out.println(player1.getPlayerName() + " win!!");
            Match.player1Win += 1;
        }
    }

    /**
     * display the choose of perso and make player
     * 
     * @param playerName name choose by user to the player
     * @return player to make
     */
    public Player personnageInitChoicePlayer1(String playerName) {
        String timeToChoosePerso[] = { "premier", "second", "troisiéme", "quatrième" };

        for (int i = 0; i < 4; i++) {
            personnageInitChoicePlayer1[i] = display.personnageChoice(timeToChoosePerso[i], playerName,
                    personnageInitChoicePlayer1);
        }

        return this.makePlayer(personnageInitChoicePlayer1[0], personnageInitChoicePlayer1[1],
                personnageInitChoicePlayer1[2], personnageInitChoicePlayer1[3], playerName);
    }

    public Player personnageInitChoicePlayer2(String playerName) {
        String timeToChoosePerso[] = { "premier", "second", "troisiéme", "quatrième" };

        for (int i = 0; i < 4; i++) {
            personnageInitChoicePlayer2[i] = display.personnageChoice(timeToChoosePerso[i], playerName,
                    personnageInitChoicePlayer2);
        }

        return this.makePlayer(personnageInitChoicePlayer2[0], personnageInitChoicePlayer2[1],
                personnageInitChoicePlayer2[2], personnageInitChoicePlayer2[3], playerName);
    }

    /**
     * choose a perso with int ID to add to player
     * 
     * @param persoChoosen number choose by user
     * @return perso to add to player
     */
    public Perso choosePerso(int persoChoosenID) {
        Perso perso = null;
        switch (persoChoosenID) {
            case 1:
                perso = new Orc();
                break;
            case 2:
                perso = new Knigth();
                break;
            case 3:
                perso = new Assassin();
                break;
            case 4:
                perso = new Druid();
                break;
            case 5:
                perso = new Elfe();
                break;
            case 6:
                perso = new Magician();
                break;
            case 7:
                perso = new Necromancer();
                break;
            default:
                throw new Error("Invalide value init of perso");
        }
        return perso;
    }

    /**
     * make a player with the choose of user
     * 
     * @param userChoosePerso1 int choose by user for perso one
     * @param userChoosePerso2 int choose by user for perso two
     * @param userChoosePerso3 int choose by user for perso three
     * @param userChoosePerso4 int choose by user for perso four
     * @return player created
     */
    public Player makePlayer(int userChoosePerso1, int userChoosePerso2, int userChoosePerso3, int userChoosePerso4,
            String name) {
        Perso perso1 = this.choosePerso(userChoosePerso1);
        Perso perso2 = this.choosePerso(userChoosePerso2);
        Perso perso3 = this.choosePerso(userChoosePerso3);
        Perso perso4 = this.choosePerso(userChoosePerso4);
        return new Player(perso1, perso2, perso3, perso4, name);
    }

    /**
     * make a player with random number, can't have two same perso. 
     * @return Player for computer
     */
    public Player makePlayerComputer() {
        int num1 = random.nextInt(7) + 1;
        int num2;
        int num3;
        int num4;
        do {
            num2 = random.nextInt(7) + 1;
        } while (num2 == num1);
        do {
            num3 = random.nextInt(7) + 1;
        } while (num3 == num1 || num3 == num2);
        do {
            num4 = random.nextInt(7) + 1;
        } while (num4 == num1 || num4 == num2 || num4 == num3);

        Perso perso1 = this.choosePerso(num1);
        Perso perso2 = this.choosePerso(num2);
        Perso perso3 = this.choosePerso(num3);
        Perso perso4 = this.choosePerso(num4);
        return new Player(perso1, perso2, perso3, perso4, "computer");
    }

    public static String getPlayer1Win() {
        return " win : " + player1Win;
    }

    public static String getPlayer2Win() {
        return " win : " + player2Win;
    }

    public void playertoTest(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void mockDisplay(Display display) {
        this.display = display;
    }

    public static Player getPlayer1() {
        return player1;
    }

    public static Player getPlayer2() {
        return player2;
    }

    public static int[] getPersonnageInitChoicePlayer1() {
        return personnageInitChoicePlayer1;
    }


    public static int[] getPersonnageInitChoicePlayer2() {
        return personnageInitChoicePlayer2;
    }


}
