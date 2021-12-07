package com.example.simplon.promo16.players;

import java.util.ArrayList;
import java.util.List;

import com.example.simplon.promo16.perso.Perso;

public class Player {

    private List <Perso> playerListOfPerso = new ArrayList<>();

    
    public Player(Perso perso1, Perso perso2, Perso perso3, Perso perso4) {
        playerListOfPerso.add(perso1);
        playerListOfPerso.add(perso2);
        playerListOfPerso.add(perso3);
        playerListOfPerso.add(perso4);
    }

    public void persoIsDead(){

        for (int i = 0; i < playerListOfPerso.size(); i++) {
           if (!this.playerListOfPerso.get(i).isAlive()){
               this.playerListOfPerso.remove(i);
           }
        }
    }

    public boolean playerLoose() {
        return this.playerListOfPerso.isEmpty();
    }

    public int getNumberOfPerso(){
        return this.playerListOfPerso.size();
    }

    public Perso getPlayerPerso(int i){
        
            try {
                return playerListOfPerso.get(i);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("personnage innexistant!");
            }
            return null;
    }

   
    
}
