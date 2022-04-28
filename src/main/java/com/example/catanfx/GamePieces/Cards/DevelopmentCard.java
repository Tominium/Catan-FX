package com.example.catanfx.GamePieces.Cards;

import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DevelopmentCard {
    private String dc;
    private ImageView dcFront;
    private ImageView dcBack;
    private int points;

    public DevelopmentCard(String dcName){
        dc = dcName;
//        try {
//            dcFront = ImageIO.read(DevelopmentCard.class.getResource("Assets/DevCards/"+dc+".png"));
//            dcBack = ImageIO.read(DevelopmentCard.class.getResource("Assets/DevCards/back.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        dcFront = new ImageView(DevelopmentCard.class.getResource("/Assets/DevCards/"+dc+".png").toExternalForm());
        dcBack = new ImageView(DevelopmentCard.class.getResource("/Assets/DevCards/back.png").toExternalForm());
    }
    public DevelopmentCard(String dcName, int p){
        dc = dcName;
        points = p;
        dcFront = new ImageView(DevelopmentCard.class.getResource("/Assets/DevCards/"+dc+".png").toExternalForm());
        dcBack = new ImageView(DevelopmentCard.class.getResource("/Assets/DevCards/back.png").toExternalForm());
    }

    public DevelopmentCard() {

    }


    public String getType(){
        return dc;
    }
    public int getPoints(){ return points; }

    public ImageView getFront(){ return dcFront; }
    public ImageView getBack(){ return dcBack; }

}
