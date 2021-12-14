package com.example.simplon.promo16.game;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.example.simplon.promo16.game.keyboard.KeyboardSelectPlayer2;
import com.example.simplon.promo16.game.keyboard.KeyboardSelectPlayer1;
import com.example.simplon.promo16.players.Player;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Scene extends JPanel {

    private ImageIcon icoBack;
    private ImageIcon icoSelectPlayer;

    private ImageIcon icoOrcP1;
    private ImageIcon icoOrcP2;
    private ImageIcon icoKnigthP1;
    private ImageIcon icoKnigthP2;
    private ImageIcon icoAssassinP1;
    private ImageIcon icoAssassinP2;
    private ImageIcon icoDruidP1;
    private ImageIcon icoDruidP2;
    private ImageIcon icoElfeP1;
    private ImageIcon icoElfeP2;
    private ImageIcon icoMagicianP1;
    private ImageIcon icoMagicianP2;
    private ImageIcon icoNecromancerP1;
    private ImageIcon icoNecromancerP2;


    private Image imageBack;
    private Image imageSelectPlayer;

    private Image imagePerso1Player1;
    private Image imagePerso2Player1;
    private Image imagePerso3Player1;
    private Image imagePerso4Player1;
    private Image imagePerso1Player2;
    private Image imagePerso2Player2;
    private Image imagePerso3Player2;
    private Image imagePerso4Player2;

    int selectPlayerKeyX;
    int selectPlayerKeyY;
    

    public Scene() {
        super();

        this.selectPlayerKeyX = -20;
        this.selectPlayerKeyY = -300;
        
        icoBack = new ImageIcon(getClass().getResource("../images/backGround.png"));
        icoSelectPlayer = new ImageIcon(getClass().getResource("../images/selectPlayer.png"));

        icoOrcP1 = new ImageIcon(getClass().getResource("../images/orcPlayer1.png"));
        icoOrcP2 = new ImageIcon(getClass().getResource("../images/orcPlayer2.png"));
        icoMagicianP1 = new ImageIcon(getClass().getResource("../images/sorcierPlayer1.png"));
        icoMagicianP2 = new ImageIcon(getClass().getResource("../images/sorcierPlayer2.png"));
        
        this.imageBack = this.icoBack.getImage();
        this.imageSelectPlayer = this.icoSelectPlayer.getImage();

        this.imagePerso1Player1 = this.icoOrcP1.getImage();
        this.imagePerso1Player2 = this.icoOrcP2.getImage();
        this.imagePerso2Player1 = this.icoMagicianP1.getImage();
        this.imagePerso2Player2 = this.icoMagicianP2.getImage();


        Thread chronoDisplay = new Thread(new Chrono());
        chronoDisplay.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;
        
        g2.drawImage(this.imageBack, 0, -320, null);
        g2.drawImage(this.imagePerso1Player1, 380, 340, null);
        g2.drawImage(this.imagePerso1Player1, 260, 360, null);
        g2.drawImage(this.imagePerso1Player1, 140, 380, null);
        g2.drawImage(this.imagePerso1Player1, 20, 400, null);

        g2.drawImage(this.imagePerso1Player2, 680, 340, null);
        g2.drawImage(this.imagePerso2Player2, 800, 360, null);
        g2.drawImage(this.imagePerso2Player2, 920, 380, null);
        g2.drawImage(this.imagePerso2Player2, 1040, 400, null);

        g2.drawImage(this.imageSelectPlayer, selectPlayerKeyX, selectPlayerKeyY, null);
    }

    public void selectPlayer1(){

        this.selectPlayerKeyX = 20;
        this.selectPlayerKeyY = 300;

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new KeyboardSelectPlayer1());
    }
    public void selectPlayer2(){

        this.selectPlayerKeyX = 1080;
        this.selectPlayerKeyY = 300;

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new KeyboardSelectPlayer2());
    }

    public int getSelectPlayerKeyX() {
        return selectPlayerKeyX;
    }

    public void setSelectPlayerKey(int selectPlayerKeyX, int selectPlayerKeyY) {
        this.selectPlayerKeyX += selectPlayerKeyX;
        this.selectPlayerKeyY += selectPlayerKeyY;
    }



}
