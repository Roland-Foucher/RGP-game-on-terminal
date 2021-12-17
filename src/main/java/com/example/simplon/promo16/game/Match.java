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
    private static int player1Win = 0;
    private static int player2Win = 0;
    private String[] playerNames;

    private Display display = new Display();


    /**
     * methode to run the game while a player loose
     * first players select personnages
     * next players attack one by one
     * players can replay game
     */
    public void runProgramme() {

        boolean replay = true;

        do {
            // init return names of players
            if (player1 == null || player2 == null)
                playerNames = display.init();

            player1 = this.personnageInitChoice(playerNames[0]);
            player2 = this.personnageInitChoice(playerNames[1]);

            // players fight one by one until one of them loose
            this.playerMatch();
            this.playerLoose();

            int replayGame = display.replayGame();
            replay = replayGame == 1 ? true : false;

        } while (replay);
    }
    /**
     * While nobody loose, player play one by one with call playerTurn methode
     */
    public void playerMatch(){
        while (!player1.playerLoose() && !player2.playerLoose()) {
            display.arena(player1, player2);
            this.playerTurn(player1, player2);
            if (player2.playerLoose()) {
                return;
            }
            display.arena(player1, player2);
            this.playerTurn(player2, player1);
        }
    }
    /**
     * Get +1 to one player if other looseq
     */
    public void playerLoose(){
        if (player1.playerLoose()) {
            System.out.println(player2.getPlayerName() + " win !!");
            Match.player2Win += 1;
        } else {
            System.out.println(player1.getPlayerName() + " win!!");
            Match.player1Win += 1;
        }
    }

    /**
     * Methode to choose card option or Attack
     * if player choose 1 : weapon
     * if player choose 2 : card
     * 
     * @param playerTurn   player is turn to play
     * @param playerAdvers player to attack
     */
    public void playerTurn(Player playerTurn, Player playerAdvers) {

        int persoSelectedID = this.playerSelectHisPerso(playerTurn);
        Perso persoSelected = playerTurn.getIndividualPlayerPerso(persoSelectedID - 1);

        int playerChooseAttackOrCardID = this.playerChooseBetweenAttackOrCard(playerTurn, persoSelected);

        // attack is choose
        if (playerChooseAttackOrCardID == 1) {
            this.attackIsChoosen(playerTurn, playerAdvers, persoSelected, persoSelectedID);

            // card is choose
        } else if (playerChooseAttackOrCardID == 2) {
            int playerChooseCardOptionID = display.playerChooseCardOption();
            playerTurn.chooseCardOption(playerChooseCardOptionID, persoSelectedID);

            // error
        } else {
            throw new Error("error number when choose attack or card");
        }

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
    public void attackIsChoosen(Player playerTurn, Player playerAdvers, Perso persoSelected, int persoSelectedID) {

        int playerAttack = display.playerChooseAttack(persoSelected);

        if (persoSelected.getClass() == Necromancer.class) {
            int selfPersoToMakeAlive = display.playerChoosePersoToPlay(playerTurn);
            playerTurn.attackOption(persoSelectedID, playerAttack, selfPersoToMakeAlive, playerAdvers);
        } else {
            int playerAdversToAttack = display.playerChooseAdversToAttack(playerTurn, playerAdvers);
            Perso persoToAttack = playerAdvers.getIndividualPlayerPerso(playerAdversToAttack - 1);

            // check if perso Advers is dead
            while (!persoToAttack.isAlive()) {
                System.out.println("Ce perso est mort! Choisir un autre perso.");
                playerAdversToAttack = display.playerChooseAdversToAttack(playerTurn, playerAdvers);
                persoToAttack = playerAdvers.getIndividualPlayerPerso(playerAdversToAttack - 1);
            }
            playerTurn.attackOption(persoSelectedID, playerAttack, playerAdversToAttack, playerAdvers);
        }
    }

    /**
     * display the choose of perso and make player
     * 
     * @param playerName name choose by user to the player
     * @return player to make
     */
    public Player personnageInitChoice(String playerName) {
        String timeToChoosePerso[] = { "premier", "second", "troisiéme", "quatrième" };

        int personnageInitChoicePlayer1[] = new int[4];
        for (int i = 0; i < 4; i++) {
            personnageInitChoicePlayer1[i] = display.personnageChoice(timeToChoosePerso[i], playerName,
                    personnageInitChoicePlayer1);
        }

        return this.makePlayer(personnageInitChoicePlayer1[0], personnageInitChoicePlayer1[1],
                personnageInitChoicePlayer1[2], personnageInitChoicePlayer1[3], playerName);
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

    public static String getPlayer1Win() {
        return " win : " + player1Win;
    }

    public static String getPlayer2Win() {
        return " win : " + player2Win;
    }
    public void playertoTest(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }
    public void mockDisplay(Display display){
        this.display = display;
    }
    //TODO exception
    // TODO player computer
}
