package com.example.simplon.promo16.game;

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
    
    
    public void init(){
        String inputValue = "";
        System.out.println("Bienvenue dans le game !");
        System.out.println("Ce jeux est un RPG, chaque joueur à 4 personnages qui se battent à tour de role");
        System.out.println();
        System.out.println("voici la liste des personnage : ");
        System.out.println();
        System.out.println("Orc :beaucoup de vie et puissant");
        System.out.println("Knight : puissant et à une armure");
        System.out.println("Assassin : peu de vie mais tue en un coup");
        System.out.println("Druide : beaucoup de mana, attack mana puissante");
        System.out.println("Elfe : peu puissant mais regenere sa vie");
        System.out.println("Magician : attack mana puissante et beacoup de mana");
        System.out.println("Necromancien : peu puissant mais peu réssuciter ses alliers");
        System.out.println();
        System.out.println("entrez 'ok' pour continuer");

        do{
        inputValue = scanner.next();
        }while(!inputValue.equals("ok"));
       
    }
    public int personnageChoice(String timeToChoosePerso, String player){
        int inputValue;
        do {
        System.out.println(player + " :");
        System.out.println("choisissez votre " + timeToChoosePerso +" personnage");
        System.out.println();
        System.out.println("1 - Orc");
        System.out.println("2 - Knight");
        System.out.println("3 - Assassin");
        System.out.println("4 - Druide ");
        System.out.println("5 - Elfe");
        System.out.println("6 - Magician");
        System.out.println("7 - Necromancien");
        System.out.println("8 - description des perso");
        
            inputValue = scanner.nextInt();
            if(inputValue == 8){
                System.out.println(assasin);
                System.out.println(druid);
                System.out.println(elfe);
                System.out.println(knigth);
                System.out.println(magician);
                System.out.println(necro);
                System.out.println(orc);
                System.out.println("tape '0' to continue");
                scanner.nextInt();
            }
        }while(!(inputValue > 0 && inputValue <8));
        
        return inputValue;
        
    }

    public int playerChoosePerso(Player player){
        int persoSelected = 0;
        do{
            persoSelected = 0;
        System.out.println(player.getPlayerName() +  "choisissez votre personnage");
        System.out.println("1 - " + player.getIndividualPlayerPerso(0).getName());
        System.out.println("2 - " + player.getIndividualPlayerPerso(1).getName());
        System.out.println("3 - " + player.getIndividualPlayerPerso(2).getName());
        System.out.println("4 - " + player.getIndividualPlayerPerso(3).getName());
        persoSelected = scanner.nextInt();
        }while(!(persoSelected>0 && persoSelected<4));
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

    public int playerChooseAdversToAttack(Player player2){
        
        int persoEnemySelected = 0;
        do{
            persoEnemySelected = 0;
            System.out.println("player1 choisissez le personnage à attaquer");
            System.out.println("1 - " + player2.getIndividualPlayerPerso(0).getName());
            System.out.println("2 - " + player2.getIndividualPlayerPerso(1).getName());
            System.out.println("3 - " + player2.getIndividualPlayerPerso(2).getName());
            System.out.println("4 - " + player2.getIndividualPlayerPerso(3).getName());
            persoEnemySelected = scanner.nextInt();
        }while(!(persoEnemySelected>0 && persoEnemySelected<4));
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
    // TODO : NE PAS POUVOIR AVOIR 2 FOIS LE MEME PERSO!
    // TODO : NE PAS POUVOIR SOIGNER OU AJOUTER MANA SI MAX
    // TODO : POUVOIR CHANGER NOM PLAYERS
    // TODO : AFFICHER IS DEAD SI DEAD ET NE PAS POUVOIR SELECTIONNER
    // TODO : AFFICHER VIE ET MANA DES PERSO
    // TODO AFFICHER MANA COST MANA POWER SUR SELECTION ET ATTACK POWER

}

