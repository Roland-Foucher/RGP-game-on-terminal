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

/**
 * class to display game on terminal.
 * make interaction with player for the choices.
 */
public class Display {
    private Scanner scanner = new Scanner(System.in);
    private Perso assasin = new Assassin();
    private Perso druid = new Druid();
    private Perso elfe = new Elfe();
    private Perso knigth = new Knigth();
    private Perso magician = new Magician();
    private Perso necro = new Necromancer();
    private Perso orc = new Orc();


    public int init() {

        int inputValue = 0;
        System.out.println("Bienvenue !");
        System.out.println("But du jeu : éliminer tous les personnages advers");
        System.out.println();
        System.out.println("voici la liste des personnages : ");
        System.out.println();
        System.out.println("Orc : puissant, peut augmenter sa force, beaucoup de vie");
        System.out.println("Chevalier : puissant, équipé d'une armure");
        System.out.println("Assassin : peu de vie mais a le pouvoir de tuer en un coup");
        System.out.println("Druide : beaucoup de mana, attack mana puissante");
        System.out.println("Elfe : peu puissant mais regenere sa vie");
        System.out.println("Magician : attack mana puissante et beacoup de mana");
        System.out.println("Necromancien : peu puissant mais peu réssuciter ses alliers");
        System.out.println();
        System.out.println("choisir le mode de jeu");
        System.out.println("1 : Player vs Player");
        System.out.println("2 : Player vs Computer");

        do {
            inputValue = this.userInput();
        } while (inputValue != 1 && inputValue != 2);
        return inputValue;
    }

    public String choosePlayerName(int playerID) {
        String player = "";
        scanner.nextLine();
        do {
            System.out.println("choisir le nom du player " + playerID);
            player = scanner.nextLine();
        } while (player.isBlank());

        return player;
    }
    
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

    public void displayTextInArena(String text1, String text2) {
        System.out.print(text1);
        for (int i = 0; i < 72 - text1.length() - text2.length(); i++) {
            System.out.print(" ");
        }
        System.out.print(text2);
        System.out.println();
    }

    public void displayPersoCharacteristicsInArena(Player player1, Player player2, int persoID) {
        Perso persoPlayer1 = player1.getIndividualPlayerPerso(persoID);
        Perso persoPlayer2 = player2.getIndividualPlayerPerso(persoID);

        displayTextInArena(persoPlayer1.getName(), persoPlayer2.getName());

        displayTextInArena("Health : " + persoPlayer1.getHealth(), "Health : " + persoPlayer2.getHealth());
        displayTextInArena("Mana : " + persoPlayer1.getMana(), "Mana : " + persoPlayer2.getMana());
    }


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
