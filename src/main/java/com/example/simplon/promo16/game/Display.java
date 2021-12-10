package com.example.simplon.promo16.game;

import java.util.HashMap;
import java.util.Map;
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
    private Perso necro= new Necromancer();
    private Perso orc = new Orc();
    
    

    public String[] init(){
        String[] playerNames = new String[2];
        String player1 ="";
        String player2 = "";
        String inputValue = "";
        System.out.println("Bienvenue dans le game !");
        System.out.println("Ce jeux est un RPG, chaque joueur à 4 personnages qui se battent à tour de role");
        System.out.println();
        System.out.println("voici la liste des personnage : ");
        System.out.println();
        System.out.println("Orc : beaucoup de vie et puissant");
        System.out.println("Knight : puissant et à une armure");
        System.out.println("Assassin : peu de vie mais tue en un coup");
        System.out.println("Druide : beaucoup de mana, attack mana puissante");
        System.out.println("Elfe : peu puissant mais regenere sa vie");
        System.out.println("Magician : attack mana puissante et beacoup de mana");
        System.out.println("Necromancien : peu puissant mais peu réssuciter ses alliers");
        System.out.println();
        System.out.println("entrez 'ok' pour continuer");

        do{
        inputValue = scanner.nextLine();
        }while(!inputValue.equals("ok"));
        

        do{
            System.out.println("choissir le nom du player 1");
            player1 = scanner.nextLine();
        }while(player1.isBlank());

        do{
            System.out.println("choissir le nom du player 2");
            player2 = scanner.nextLine();
        }while(player2.isBlank());

        playerNames[0] = player1;
        playerNames[1] = player2;
        return playerNames;
    }

    public void arena(Player player1, Player player2){

        System.out.println();
        displayTextInArena(player1.getPlayerName(), player2.getPlayerName());
        System.out.println();
        

        for (int i = 0; i < 24; i++) {
            if (i == 3){
                displayTextInArena(player1.getIndividualPlayerPerso(0).getName(), player2.getIndividualPlayerPerso(0).getName());
                displayTextInArena("Health : " + ((Integer)player1.getIndividualPlayerPerso(0).getHealth()).toString(), "Health : "+((Integer)player2.getIndividualPlayerPerso(0).getHealth()).toString());
                displayTextInArena("Mana : " + ((Integer)player1.getIndividualPlayerPerso(0).getMana()).toString(), "Mana : "+((Integer)player2.getIndividualPlayerPerso(0).getMana()).toString());
                
            }
            if (i == 9){
                displayTextInArena(player1.getIndividualPlayerPerso(1).getName(), player2.getIndividualPlayerPerso(1).getName());
                displayTextInArena("Health : " + ((Integer)player1.getIndividualPlayerPerso(1).getHealth()).toString(), "Health : "+((Integer)player2.getIndividualPlayerPerso(1).getHealth()).toString());
                displayTextInArena("Mana : " + ((Integer)player1.getIndividualPlayerPerso(1).getMana()).toString(), "Mana : "+((Integer)player2.getIndividualPlayerPerso(1).getMana()).toString());
            }
            if (i == 15){
                displayTextInArena(player1.getIndividualPlayerPerso(2).getName(), player2.getIndividualPlayerPerso(2).getName());
                displayTextInArena("Health : " + ((Integer)player1.getIndividualPlayerPerso(2).getHealth()).toString(), "Health : "+((Integer)player2.getIndividualPlayerPerso(2).getHealth()).toString());
                displayTextInArena("Mana : " + ((Integer)player1.getIndividualPlayerPerso(2).getMana()).toString(), "Mana : "+((Integer)player2.getIndividualPlayerPerso(2).getMana()).toString());
            }
            if (i == 21){
                displayTextInArena(player1.getIndividualPlayerPerso(3).getName(), player2.getIndividualPlayerPerso(3).getName());
                displayTextInArena("Health : " + ((Integer)player1.getIndividualPlayerPerso(3).getHealth()).toString(), "Health : "+((Integer)player2.getIndividualPlayerPerso(3).getHealth()).toString());
                displayTextInArena("Mana : " + ((Integer)player1.getIndividualPlayerPerso(3).getMana()).toString(), "Mana : "+((Integer)player2.getIndividualPlayerPerso(3).getMana()).toString());
            }
            for (int j = 0; j < 72; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
    private void displayTextInArena(String text1, String text2){
        System.out.print(text1);
        for (int i = 0; i < 72-text1.length()-text2.length(); i++) {
            System.out.print(" ");
        }
        System.out.print(text2);
        System.out.println();
    }
   
    

    public int personnageChoice(String timeToChoosePerso, String player, int[] personnageChoice){
        int inputValue;
        HashMap <Integer, String> persos = new HashMap<>(Map.of(1,  "1 - Orc", 2, "2 - Knight", 3, "3 - Assassin", 4, "4 - Druide ", 5, "5 - Elfe", 6, "6 - Magician", 7, "7 - Necromancien"));
        do {
            System.out.println(player + " :");
            System.out.println("choisissez votre " + timeToChoosePerso +" personnage");
            System.out.println();

            // loop on collection and not display perso already choosen
            persos.forEach((num, perso) -> {
                if (num != personnageChoice[0] && num != personnageChoice[1] && num != personnageChoice[2] && num != personnageChoice[3]){
                    System.out.println(perso);
                }
            });

            System.out.println("8 - description des perso");
        
            inputValue = scanner.nextInt();
            // check if perso already choosen
            for (int i : personnageChoice) {
                while (inputValue == i){
                    System.out.println("Le personnage a déjà été choisie");
                    inputValue = scanner.nextInt();
                }
            }

            // if 8 is selected, list the differents caracters
            if(inputValue == 8){
                System.out.println(assasin);
                System.out.println(druid);
                System.out.println(elfe);
                System.out.println(knigth);
                System.out.println(magician);
                System.out.println(necro);
                System.out.println(orc);
                System.out.println("tapez '0' pour continuer");
                scanner.nextInt();
            }
        }while(!(inputValue > 0 && inputValue <8));
        
        return inputValue;
        
    }

    public int playerChoosePerso(Player player){
        int persoSelected = 0;
        do{
            persoSelected = 0;
        System.out.println(player.getPlayerName() +  " choisissez votre personnage");
        System.out.println("1 - " + player.getIndividualPlayerPerso(0).getName());
        System.out.println("2 - " + player.getIndividualPlayerPerso(1).getName());
        System.out.println("3 - " + player.getIndividualPlayerPerso(2).getName());
        System.out.println("4 - " + player.getIndividualPlayerPerso(3).getName());
        persoSelected = scanner.nextInt();
        }while(!(persoSelected>0 && persoSelected<5));
        return  persoSelected ;

    }

    public int playerChooseWhatToDo(Player player){
        int optionSelected = 0;
        if (player.getNumberOfCardPlayer()>0){
            do{
            optionSelected = 0;
            System.out.println("Que voulez vous faire : ");
            System.out.println("1 - Attack");
            System.out.println("2 - PowerCard");
            optionSelected = scanner.nextInt();
            }while(!(optionSelected>0 && optionSelected<3));

        }else{
            do{
                optionSelected = 0;
                System.out.println("Que voulez vous faire : ");
                System.out.println("1 - Attack");
                optionSelected = scanner.nextInt();
                }while(!(optionSelected>0 && optionSelected<2));
        }
        return optionSelected;
    }

    public int playerChooseAttack(Player player, Perso perso){
        int attackSelected = 0;
        do{
            attackSelected = 0;
            System.out.println("Quelle attack choississez vous ? ");
            System.out.println("1 - weapon");
            System.out.println("2 - mana");
            attackSelected = scanner.nextInt();
            while (attackSelected == 2 && perso.getManaCost()>perso.getMana()){
                System.out.println("pas assez de mana pour attacker");
                attackSelected = scanner.nextInt();
            }
        }while(attackSelected!=1 && attackSelected!=2);
        return attackSelected;
    }

    public int playerChooseAdversToAttack(Player player1, Player player2){
        
        int persoEnemySelected = 0;
        do{
            persoEnemySelected = 0;
            System.out.println(player1.getPlayerName() + " choisissez le personnage à attaquer");
            System.out.println("1 - " + player2.getIndividualPlayerPerso(0).getName());
            System.out.println("2 - " + player2.getIndividualPlayerPerso(1).getName());
            System.out.println("3 - " + player2.getIndividualPlayerPerso(2).getName());
            System.out.println("4 - " + player2.getIndividualPlayerPerso(3).getName());
            persoEnemySelected = scanner.nextInt();
        }while(!(persoEnemySelected>0 && persoEnemySelected<5));
        return  persoEnemySelected ;
    }

    public int playerChooseCardOption(){
        int optionCardSelected = 0;
        do{
            optionCardSelected = 0;
            System.out.println("Quelle pouvoir de carte choississez vous ? ");
            System.out.println("1 - add health");
            System.out.println("2 - add mana");
            optionCardSelected = scanner.nextInt();
            
        }while(optionCardSelected!=1 && optionCardSelected!=2);

        return optionCardSelected;
    }

    // TODO : NE PAS POUVOIR SOIGNER OU AJOUTER MANA SI MAX
    // TODO : AFFICHER IS DEAD SI DEAD ET NE PAS POUVOIR SELECTIONNER
    // TODO debug perso 4 crash
    // TODO debug mana necro
    // TODO Input mismatch exception


}

