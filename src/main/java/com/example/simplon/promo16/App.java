package com.example.simplon.promo16;


import javax.swing.JFrame;

import com.example.simplon.promo16.game.Display;
import com.example.simplon.promo16.game.Match;
import com.example.simplon.promo16.game.Scene;
import com.example.simplon.promo16.perso.Orc;
import com.example.simplon.promo16.players.Player;

/**
 * Hello world!
 *
 */
public class App 
{
    public static Scene scene;
    public static void main( String[] args )
    {
        // Match match = new Match();
        // match.runProgramme();
        
        JFrame display = new JFrame("game RPG");
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.setSize(1280, 720);
        display.setLocationRelativeTo(null);
        display.setResizable(false);
        display.setAlwaysOnTop(true);

        scene = new Scene();
        display.setContentPane(scene);
        display.setVisible(true);
        
        Match match = new Match();
        match.runProgramme();
        
        // scene.getSelectPlayerKeyX();
        // scene.selectPlayer();
    
    }
}
