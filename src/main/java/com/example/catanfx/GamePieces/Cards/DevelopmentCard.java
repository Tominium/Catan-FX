package com.example.catanfx.GamePieces.Cards;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DevelopmentCard {
    private String dc;
    private BufferedImage dcFront;
    private BufferedImage dcBack;
    private int points;

    public DevelopmentCard(String dcName){
        dc = dcName;
        try {
            dcFront = ImageIO.read(DevelopmentCard.class.getResource("Assets/DevCards/"+dc+".png"));
            dcBack = ImageIO.read(DevelopmentCard.class.getResource("Assets/DevCards/back.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public DevelopmentCard(String dcName, int p){
        dc = dcName;
        points = p;
        try {
            dcFront = ImageIO.read(DevelopmentCard.class.getResource("Assets/DevCards/"+dc+".png"));
            dcBack = ImageIO.read(DevelopmentCard.class.getResource("Assets/DevCards/back.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DevelopmentCard() {

    }


    public String getType(){
        return dc;
    }
    public int getPoints(){ return points; }

    public BufferedImage getFront(){ return dcFront; }
    public BufferedImage getBack(){ return dcBack; }

}
