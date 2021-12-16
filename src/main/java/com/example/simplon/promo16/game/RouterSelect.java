package com.example.simplon.promo16.game;

import com.example.simplon.promo16.App;
import com.example.simplon.promo16.players.Player;

public class RouterSelect {
    private static int persoID;
    private static int attackOrCard;

    
    public static void playerChoosePersoToPlay(){


        int key = App.scene.getSelectPlayerKeyX();
        

        switch (key){
            case 20 :
                RouterSelect.persoID = 1;
                break;
            case 140 : 
                RouterSelect.persoID = 2;
                break;
            case 260 : 
                RouterSelect.persoID = 3;
                break;
            case 380 : 
                RouterSelect.persoID = 4;
                break;
            case 1040 :
                RouterSelect.persoID = 1;
                break;
            case 920 : 
                RouterSelect.persoID = 2;
                break;
            case 800 : 
                RouterSelect.persoID = 3;
                break;
            case 680 : 
                RouterSelect.persoID = 4;
                break;
            default : 
                System.out.println("error select perso");
                
        }     
    }

    public static void playerChooseAttachOrCard(){
        
    }


    public int getPersoID() {
        return persoID;
    }
}
