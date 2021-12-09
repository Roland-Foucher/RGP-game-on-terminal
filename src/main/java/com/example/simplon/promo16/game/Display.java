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
    public int personnageChoice(){
        int inputValue;
        System.out.println("choisissez votre premier personnage");
        System.out.println();
        System.out.println("1 - Orc");
        System.out.println("2 - Knight");
        System.out.println("3 - Assassin");
        System.out.println("4 - Druide ");
        System.out.println("5 - Elfe");
        System.out.println("6 - Magician");
        System.out.println("7 - Necromancien");
        System.out.println("8 - description des perso");
        do {
            inputValue = scanner.nextInt();
            if(inputValue == 8){
                System.out.println(assasin);
                System.out.println(druid);
                System.out.println(elfe);
                System.out.println(knigth);
                System.out.println(magician);
                System.out.println(necro);
                System.out.println(orc);
                System.out.println("tape 'OK' to continue");
                // scanner.nextString();//TODO continue le display pour sortir du help
            }
        }while(!(inputValue >0 && inputValue <9));
        return inputValue;
        
        
    }
}

