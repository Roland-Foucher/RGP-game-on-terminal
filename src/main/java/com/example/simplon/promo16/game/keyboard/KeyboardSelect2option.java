package com.example.simplon.promo16.game.keyboard;

import java.awt.event.KeyListener;

import com.example.simplon.promo16.App;
import com.example.simplon.promo16.game.RouterSelect;

import java.awt.event.KeyEvent;

public class KeyboardSelect2option implements KeyListener {
    
    @Override
    public void keyPressed(KeyEvent e){

        if(App.sceneMatch.getSelectPlayerKeyX()<1080){
            if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                App.sceneMatch.setSelectPlayerKey(120,20);
            }
        }
        if(App.sceneMatch.getSelectPlayerKeyX()>800){
            if (e.getKeyCode() == KeyEvent.VK_LEFT){
                App.sceneMatch.setSelectPlayerKey(-120,-20);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            RouterSelect.playerChoosePersoToPlay();
            App.sceneMatch.setSelectPlayerKey(-300, -300);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
