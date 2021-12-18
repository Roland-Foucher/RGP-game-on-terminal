package com.example.simplon.promo16;


import javax.swing.JFrame;

import com.example.simplon.promo16.game.Display;
import com.example.simplon.promo16.game.Match;
import com.example.simplon.promo16.game.scene.SceneInit;
import com.example.simplon.promo16.game.scene.SceneMatch;
import com.example.simplon.promo16.perso.Orc;
import com.example.simplon.promo16.players.Player;

/**
 * this class run programme
 *
 */
public class App 
{
    public static SceneInit sceneInit;
    public static SceneMatch sceneMatch;
    public static void main( String[] args )
    {
        // Match match = new Match();
        // match.runProgramme();
        Match match = new Match();
        sceneInit = new SceneInit();
        
        JFrame display = new JFrame("game RPG");
        
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.setSize(1280, 720);
        display.setLocationRelativeTo(null);
        display.setResizable(false);
        display.setAlwaysOnTop(true);

        
        display.setContentPane(sceneInit);
        display.setVisible(true);
        
        sceneMatch = new SceneMatch();
        match.playerInit();
        
        
        display.setContentPane(sceneMatch);
        display.setVisible(true);
        match.runProgramme();
       
        
        // scene.getSelectPlayerKeyX();
        // scene.selectPlayer();
        //TODO faier la boucle replay dans le App
    }
}
