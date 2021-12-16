package com.example.simplon.promo16.game.scene;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.example.simplon.promo16.game.keyboard.KeyboardSelectPlayer2;
import com.example.simplon.promo16.perso.Perso;
import com.example.simplon.promo16.game.Chrono;
import com.example.simplon.promo16.game.Match;
import com.example.simplon.promo16.game.keyboard.KeyboardSelectPlayer1;
import com.example.simplon.promo16.players.Player;

import java.awt.Image;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class SceneMatch extends JPanel {

    private ImageIcon icoBack;
    private ImageIcon icoSelectPlayer;

    private ImageIcon icoOrcP1;
    private ImageIcon icoOrcP2;
    private ImageIcon icoKnightP1;
    private ImageIcon icoKnightP2;
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
    private Image[] imagesPlayer1 = {imagePerso1Player1, imagePerso2Player1, imagePerso3Player1, imagePerso4Player1};
    private Image[] imagesPlayer2 = {imagePerso1Player2, imagePerso2Player2, imagePerso3Player2, imagePerso4Player2};

    int selectPlayerKeyX;
    int selectPlayerKeyY;

    int displayTextKeyX;
    int displayTextKeyY;
    

    public SceneMatch(int[] persoInitChoicePlayer1, int[]persoInitChoicePlayer2) {
        super();

        this.selectPlayerKeyX = -20;
        this.selectPlayerKeyY = -300;

        this.displayTextKeyX = -20;
        this.displayTextKeyY = -300;
        
        icoBack = new ImageIcon(getClass().getResource("../../images/backGround.png"));
        icoSelectPlayer = new ImageIcon(getClass().getResource("../../images/selectPlayer.png"));

        icoOrcP1 = new ImageIcon(getClass().getResource("../../images/orc-player1.png"));
        icoOrcP2 = new ImageIcon(getClass().getResource("../../images/orc-player2.png"));
        icoMagicianP1 = new ImageIcon(getClass().getResource("../../images/sorcier-player1.png"));
        icoMagicianP2 = new ImageIcon(getClass().getResource("../../images/sorcier-player2.png"));
        icoKnightP1 = new ImageIcon(getClass().getResource("../../images/chevalier-player1.png"));
        icoKnightP2 = new ImageIcon(getClass().getResource("../../images/chevalier-player2.png"));
        icoAssassinP1 = new ImageIcon(getClass().getResource("../../images/assassin-player1.png"));
        icoAssassinP2 = new ImageIcon(getClass().getResource("../../images/assassin-player2.png"));
        icoElfeP1 = new ImageIcon(getClass().getResource("../../images/elfe-player1.png"));
        icoElfeP2 = new ImageIcon(getClass().getResource("../../images/elfe-player2.png"));
        icoNecromancerP1 = new ImageIcon(getClass().getResource("../../images/necro-player1.png"));
        icoNecromancerP2 = new ImageIcon(getClass().getResource("../../images/necro-player2.png"));
        icoDruidP1 = new ImageIcon(getClass().getResource("../../images/druid-player1.png"));
        icoDruidP2 = new ImageIcon(getClass().getResource("../../images/druid-player2.png"));

        
        this.imageBack = this.icoBack.getImage();
        this.imageSelectPlayer = this.icoSelectPlayer.getImage();

        this.displayPersoPlayer1(persoInitChoicePlayer1);
        this.displayPersoPlayer2(persoInitChoicePlayer2);


        Thread chronoDisplay = new Thread(new Chrono());
        chronoDisplay.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;
        
        g2.drawImage(this.imageBack, 0, -320, null);
        g2.drawImage(this.imagesPlayer1[0], 420, 340, null);
        g2.drawImage(this.imagesPlayer1[1], 280, 360, null);
        g2.drawImage(this.imagesPlayer1[2], 140, 380, null);
        g2.drawImage(this.imagesPlayer1[3], 0, 400, null);

        g2.drawImage(this.imagesPlayer2[0], 680, 340, null);
        g2.drawImage(this.imagesPlayer2[1], 820, 360, null);
        g2.drawImage(this.imagesPlayer2[2], 960, 380, null);
        g2.drawImage(this.imagesPlayer2[3], 1100, 400, null);

        g2.drawImage(this.imageSelectPlayer, selectPlayerKeyX, selectPlayerKeyY, null);

        
        g2.setColor(Color.WHITE);
        g2.fillRect(displayTextKeyX, displayTextKeyY, 100, 50);

        g2.setColor(Color.black);
        g2.drawString("Attack", displayTextKeyX , displayTextKeyY+20);
        g2.drawString("Card", displayTextKeyX , displayTextKeyY+40);
        //TODO revoir les plaements de fleches et de persos + mettres les valeurs x et y dans variables pour ne pas avoir a changer partour si deplacement...
        

    }

    public void displayPersoPlayer1(int[] persoInitChoicePlayer1){
        for (int i = 0; i < 4; i++) {
            
            switch (persoInitChoicePlayer1[i]) {
                case 1:
                this.imagesPlayer1[i] = this.icoOrcP1.getImage();
                break;
            case 2:
                this.imagesPlayer1[i] = this.icoKnightP1.getImage();
                break;
            case 3:
                this.imagesPlayer1[i] = this.icoAssassinP1.getImage();
                break;
            case 4:
                this.imagesPlayer1[i] = this.icoDruidP1.getImage();
                break;
            case 5:
                this.imagesPlayer1[i] = this.icoElfeP1.getImage();
                break;
            case 6:
                this.imagesPlayer1[i] = this.icoMagicianP1.getImage();
                break;
            case 7:
                this.imagesPlayer1[i] = this.icoNecromancerP1.getImage();
                break;
            default:
                System.out.println("please choose a good value");
                break;
            }
        }
    }

    public void displayPersoPlayer2(int[] persoInitChoicePlayer2){
        for (int i = 0; i < 4; i++) {
            
            switch (persoInitChoicePlayer2[i]) {
                case 1:
                this.imagesPlayer2[i] = this.icoOrcP2.getImage();
                break;
            case 2:
                this.imagesPlayer2[i] = this.icoKnightP2.getImage();
                break;
            case 3:
                this.imagesPlayer2[i] = this.icoAssassinP2.getImage();
                break;
            case 4:
                this.imagesPlayer2[i] = this.icoDruidP2.getImage();
                break;
            case 5:
                this.imagesPlayer2[i] = this.icoElfeP2.getImage();
                break;
            case 6:
                this.imagesPlayer2[i] = this.icoMagicianP2.getImage();
                break;
            case 7:
                this.imagesPlayer2[i] = this.icoNecromancerP2.getImage();
                break;
            default:
                System.out.println("please choose a good value");
                break;
            }
        }
    }

    public void selectPlayer(Player playerTurn){

        if(playerTurn == Match.getPlayer1()){ 
            this.selectPlayerKeyX = 20;
            this.selectPlayerKeyY = 300;

            this.setFocusable(true);
            this.requestFocusInWindow();
            this.addKeyListener(new KeyboardSelectPlayer1());
        }else{
            this.selectPlayerKeyX = 1080;
            this.selectPlayerKeyY = 300;

            this.setFocusable(true);
            this.requestFocusInWindow();
            this.addKeyListener(new KeyboardSelectPlayer2());
        }
    }

    public void displaySelectAttackOrCard(){
        this.displayTextKeyX = selectPlayerKeyX;
        this.displayTextKeyY = selectPlayerKeyY;
    }

    public int getSelectPlayerKeyX() {
        return selectPlayerKeyX;
    }

    public void setSelectPlayerKey(int selectPlayerKeyX, int selectPlayerKeyY) {
        this.selectPlayerKeyX += selectPlayerKeyX;
        this.selectPlayerKeyY += selectPlayerKeyY;
    }

    public int getDisplayTextKeyY() {
        return displayTextKeyY;
    }

    public void setDisplayTextKeyXY(int displayTextKeyX, int displayTextKeyY) {
        this.displayTextKeyY = displayTextKeyY;
        this.displayTextKeyX = displayTextKeyX;
    }

 


}
