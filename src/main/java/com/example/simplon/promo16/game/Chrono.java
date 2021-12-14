package com.example.simplon.promo16.game;

import com.example.simplon.promo16.App;

public class Chrono implements Runnable {
    private final int PAUSE = 20;

    @Override
    public void run() {
        
        while(true){

            App.scene.repaint();

            try {
                Thread.sleep(PAUSE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    
}
