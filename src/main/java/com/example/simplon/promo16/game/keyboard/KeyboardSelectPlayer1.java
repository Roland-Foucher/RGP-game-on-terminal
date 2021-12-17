package com.example.simplon.promo16.game.keyboard;

import java.awt.event.KeyListener;

import com.example.simplon.promo16.App;
import com.example.simplon.promo16.game.RouterSelect;

import java.awt.event.KeyEvent;

public class KeyboardSelectPlayer1 implements KeyListener {

    
    @Override
    public void keyPressed(KeyEvent e){

        if(App.sceneMatch.getSelectPlayerKeyX()<380){
            if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                App.sceneMatch.setSelectPlayerKey(120,-20);
            }
        }
        if(App.sceneMatch.getSelectPlayerKeyX()>20){
            if (e.getKeyCode() == KeyEvent.VK_LEFT){
                App.sceneMatch.setSelectPlayerKey(-120,20);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
             RouterSelect.playerChoosePersoToPlay();
             App.sceneMatch.displaySelectAttackOrCard();
             App.sceneMatch.setSelectPlayerKey(-1000, -3000);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
