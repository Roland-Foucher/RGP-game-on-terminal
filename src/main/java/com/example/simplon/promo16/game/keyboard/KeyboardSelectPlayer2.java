package com.example.simplon.promo16.game.keyboard;

import java.awt.event.KeyListener;

import com.example.simplon.promo16.App;

import java.awt.event.KeyEvent;

public class KeyboardSelectPlayer2 implements KeyListener {
    
    @Override
    public void keyPressed(KeyEvent e){

        if(App.scene.getSelectPlayerKeyX()<1080){
            if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                App.scene.setSelectPlayerKey(120,20);
            }
        }
        if(App.scene.getSelectPlayerKeyX()>800){
            if (e.getKeyCode() == KeyEvent.VK_LEFT){
                App.scene.setSelectPlayerKey(-120,-20);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
