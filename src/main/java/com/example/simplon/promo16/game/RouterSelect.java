package com.example.simplon.promo16.game;

import com.example.simplon.promo16.App;
import com.example.simplon.promo16.players.Player;

public class RouterSelect {
    private int persoID;

    
    public void playerChoosePersoToPlay(){

        System.out.println("coucou");

        int key = App.scene.getSelectPlayerKeyX();
        

        switch (key){
            case 20 :
                this.persoID = 1;
                break;
            case 140 : 
                this.persoID = 2;
                break;
            case 260 : 
                this.persoID = 3;
                break;
            case 380 : 
                this.persoID = 4;
                break;
            case 1040 :
                this.persoID = 1;
                break;
            case 920 : 
                this.persoID = 2;
                break;
            case 800 : 
                this.persoID = 3;
                break;
            case 680 : 
                this.persoID = 4;
                break;
            default : 
                System.out.println("error select perso");
                
        }     
    }


    public int getPersoID() {
        return persoID;
    }
}
