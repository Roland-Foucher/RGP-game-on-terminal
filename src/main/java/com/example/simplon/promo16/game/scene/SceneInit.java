package com.example.simplon.promo16.game.scene;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class SceneInit extends JPanel {

    private ImageIcon icoBack;

    private Image imageBack;


    public SceneInit() {
        icoBack = new ImageIcon(getClass().getResource("../../images/backGround.png"));
        this.imageBack = this.icoBack.getImage();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;
        g2.drawImage(this.imageBack, 0, -320, null);
    }

  
 


}
