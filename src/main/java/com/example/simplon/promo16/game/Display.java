package com.example.simplon.promo16.game;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.example.simplon.promo16.perso.Assassin;
import com.example.simplon.promo16.perso.Druid;
import com.example.simplon.promo16.perso.Elfe;
import com.example.simplon.promo16.perso.Knigth;
import com.example.simplon.promo16.perso.Magician;
import com.example.simplon.promo16.perso.Necromancer;
import com.example.simplon.promo16.perso.Orc;
import com.example.simplon.promo16.perso.Perso;
import com.example.simplon.promo16.players.Player;

public class Display {
    private Scanner scanner = new Scanner(System.in);
    private Perso assasin = new Assassin();
    private Perso druid = new Druid();
    private Perso elfe = new Elfe();
    private Perso knigth = new Knigth();
    private Perso magician = new Magician();
    private Perso necro = new Necromancer();
    private Perso orc = new Orc();

    /**
     * First display of perso description. Next players choose names (verify input
     * not blank)
     * 
     * @return array of player's names to init players
     */
    public String[] init() {
        String[] playerNames = new String[2];
        String player1 = "";
        String player2 = "";
        String inputValue = "";
        System.out.println("Bienvenue dans le game !");
        System.out.println("Ce jeux est un RPG, chaque joueur à 4 personnages qui se battent à tour de role");
        System.out.println();
        System.out.println("voici la liste des personnage : ");
        System.out.println();
        System.out.println("Orc : beaucoup de vie et puissant");
        System.out.println("Chevalier : puissant et à une armure");
        System.out.println("Assassin : peu de vie mais tue en un coup");
        System.out.println("Druide : beaucoup de mana, attack mana puissante");
        System.out.println("Elfe : peu puissant mais regenere sa vie");
        System.out.println("Magician : attack mana puissante et beacoup de mana");
        System.out.println("Necromancien : peu puissant mais peu réssuciter ses alliers");
        System.out.println();
        System.out.println("entrez 'ok' pour continuer");

        do {
            inputValue = scanner.nextLine();
        } while (!inputValue.equals("ok"));

        do {
            System.out.println("choissir le nom du player 1");
            player1 = scanner.nextLine();
        } while (player1.isBlank());

        do {
            System.out.println("choissir le nom du player 2");
            player2 = scanner.nextLine();
        } while (player2.isBlank());

        playerNames[0] = player1;
        playerNames[1] = player2;
        return playerNames;
    }

    /**
     * Display the arena with all the perso's of player with health points and mana
     * points.
     * 
     * @param player1 player1 to display perso
     * @param player2 player2 to display perso
     */
    public void arena(Player player1, Player player2) {

        System.out.println();
        displayTextInArena(player1.getPlayerName() + Match.getPlayer1Win(),
                player2.getPlayerName() + Match.getPlayer2Win());
        System.out.println();

        for (int i = 0; i < 24; i++) {
            if (i == 3) {
                displayPersoCharacteristicsInArena(player1, player2, 0);
            }
            if (i == 9) {
                displayPersoCharacteristicsInArena(player1, player2, 1);
            }
            if (i == 15) {
                displayPersoCharacteristicsInArena(player1, player2, 2);
            }
            if (i == 21) {
                displayPersoCharacteristicsInArena(player1, player2, 3);
            }
            for (int j = 0; j < 72; j++) {
                System.out.print("-");
            }
            System.out.println();
            
        }
    }

    /**
     * Methode to display a text line into the arena.
     * 
     * @param text1 param to display of player 1 in left side
     * @param text2 param ot display of player 2 in right side
     */
    public void displayTextInArena(String text1, String text2) {
        System.out.print(text1);
        for (int i = 0; i < 72 - text1.length() - text2.length(); i++) {
            System.out.print(" ");
        }
        System.out.print(text2);
        System.out.println();
    }

    /**
     * Display the characteristiques of the current perso to display into the Arena
     * 
     * @param player1 perso in left side arena
     * @param player2 perso in right side arena
     * @param persoID perso to display characteristiques
     */
    public void displayPersoCharacteristicsInArena(Player player1, Player player2, int persoID) {
        Perso persoPlayer1 = player1.getIndividualPlayerPerso(persoID);
        Perso persoPlayer2 = player2.getIndividualPlayerPerso(persoID);

        displayTextInArena(persoPlayer1.getName(), persoPlayer2.getName());

        displayTextInArena("Health : " + persoPlayer1.getHealth(), "Health : " + persoPlayer2.getHealth());
        displayTextInArena("Mana : " + persoPlayer1.getMana(), "Mana : " + persoPlayer2.getMana());
    }

    /**
     * Display the differents perso to choose and return the id of perso choosen.
     * The player can't choose the same perso two times
     * 
     * @param timeToChoosePerso the turn of choose (1 to 4)
     * @param player player turn to choose perso
     * @param personnageChoice  array of ids selected before
     * @return the id of perso selected
     */
    public int personnageChoice(String timeToChoosePerso, String player, int[] personnageChoice) {
        int inputValue;
        Perso[] persos = { orc, knigth, assasin, druid, elfe, magician, necro };

        do {
            System.out.println(player + " :");
            System.out.println("choisissez votre " + timeToChoosePerso + " personnage");
            System.out.println();

            // loop on collection and not display perso already choosen
            for (int i = 0; i < 7; i++) {
                if (i + 1 != personnageChoice[0] && i + 1 != personnageChoice[1] && i + 1 != personnageChoice[2]
                        && i + 1 != personnageChoice[3]) {
                    System.out.println(String.format("%s - %s\n%s\n%s\n", i + 1, persos[i].getName(),
                            persos[i].getWeapon(), persos[i].getManaPower()));
                }
            }

            System.out.println("8 - description des perso");

            inputValue = this.userInput();

            // check if perso already choosen
            for (int i : personnageChoice) {
                while (inputValue == i) {
                    System.out.println("Le personnage a déjà été choisie");
                    inputValue = this.userInput();
                }
            }

            // if 8 is selected, list the differents caracters
            if (inputValue == 8) {
                for (Perso perso : persos) {
                    System.out.println(perso);
                }
                System.out.println("tapez '0' pour continuer");
                inputValue = this.userInput();
            }
        } while (!(inputValue > 0 && inputValue < 8));

        return inputValue;

    }

    /**
     * On game, player choose his perso to play.
     * take a skull if player dead
     * 
     * @param player player turn
     * @return id of perso selected (-1 to match the array)
     */
    public int playerChoosePersoToPlay(Player player) {
        Perso perso1 = player.getIndividualPlayerPerso(0);
        Perso perso2 = player.getIndividualPlayerPerso(1);
        Perso perso3 = player.getIndividualPlayerPerso(2);
        Perso perso4 = player.getIndividualPlayerPerso(3);
        Perso[] persos = { perso1, perso2, perso3, perso4 };

        int persoSelected;
        do {
            persoSelected = 0;
            System.out.println(player.getPlayerName() + " choisissez votre personnage");

            for (int i = 0; i < persos.length; i++) {
                System.out.println((i + 1) + " - " + persos[i].getName() + "\n" + persos[i].getWeapon() + "\n"
                        + persos[i].getManaPower() + "\n");
            }

            persoSelected = this.userInput();
        } while (!(persoSelected > 0 && persoSelected < 5));
        return (persoSelected);

    }

    /**
     * After choose perso, player choose Attack option or Card option
     * If player don't have any card, don't display et can't select card
     * 
     * @param player player turn
     * @return id of the option selected (1 = attack / 2 = Card)
     */
    public int playerChooseAttackOrCard(Player player) {
        int optionSelected = 0;
        if (player.getNumberOfCardPlayer() > 0) {
            do {
                optionSelected = 0;
                System.out.println("Que voulez vous faire : ");
                System.out.println("1 - Attack");
                System.out.println("2 - PowerCard");
                optionSelected = this.userInput();

            } while (optionSelected != 1 && optionSelected != 2);

        } else {
            do {
                optionSelected = 0;
                System.out.println("Que voulez vous faire : ");
                System.out.println("1 - Attack");
                optionSelected = this.userInput();
            } while (optionSelected != 1);
        }
        return optionSelected;
    }

    /**
     * If player choose Attack : choice to choose between mana or weapon.
     * If perso don't have anougth mana, can't choice mana.
     * 
     * @param perso choosen
     * @return id of the choice selected (1 = weapon / 2 - mana)
     */
    public int playerChooseAttack(Perso perso) {
        int attackSelected = 0;
        do {
            attackSelected = 0;
            System.out.println("Quelle attack choississez vous ? ");
            System.out.println("1 - " + perso.getWeapon());
            System.out.println("2 - " + perso.getManaPower());

            attackSelected = this.userInput();

            while (attackSelected == 2 && perso.getManaCost() > perso.getMana()) {
                System.out.println("pas assez de mana pour attacker");
                attackSelected = this.userInput();
            }
        } while (attackSelected != 1 && attackSelected != 2);
        return attackSelected;
    }

    /**
     * 
     * @param player1
     * @param player2
     * @return
     */
    public int playerChooseAdversToAttack(Player player1, Player player2) {

        int persoEnemySelected = 0;
        do {
            persoEnemySelected = 0;
            System.out.println(player1.getPlayerName() + " choisissez le personnage à attaquer");

            for (int i = 0; i < 4; i++) {
                System.out.println((i + 1) + " - " + player2.getIndividualPlayerPerso(i).getName());
            }

            persoEnemySelected = this.userInput();

        } while (!(persoEnemySelected > 0 && persoEnemySelected < 5));

        return persoEnemySelected;
    }

    /**
     * Select the card option between add health and and  mana
     * @return 1 if add health
     * @return 2 if add mana
     */
    public int playerChooseCardOption() {
        int optionCardSelected;
        do {
            optionCardSelected = 0;
            System.out.println("Quelle pouvoir de carte choississez vous ? ");
            System.out.println("1 - add health");
            System.out.println("2 - add mana");
            optionCardSelected = this.userInput();

        } while (optionCardSelected != 1 && optionCardSelected != 2);

        return optionCardSelected;
    }

    /**
     * players choose if they want to replay the game
     * @return 1 if yes
     * @return 2 if no
     */
    public int replayGame() {
        int optionReplaySelected;
        do {
            optionReplaySelected = 0;
            System.out.println("voulez-vous refaire une partie?");
            System.out.println("1 - oui");
            System.out.println("2 - non");
            optionReplaySelected = this.userInput();
        } while (optionReplaySelected != 1 && optionReplaySelected != 2);
        return optionReplaySelected;
    }

    /**
     * methode to check if the user input is an integer.
     * 
     * @return integer input user OK
     */
    public int userInput() {
        boolean inputOk = false;
        int input = 0;
        while (!inputOk) {
            try {
                input = scanner.nextInt();
                inputOk = true;

            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide !");
                scanner.next();
            }
        }
        return input;
    }

}
