package com.example.catanfx.GamePieces.Cards;

import javafx.scene.image.ImageView;

import java.util.Objects;


public class DevelopmentCard {
    private String dc;
    private ImageView dcFront;
    private ImageView dcBack;
    private int points;
    private boolean justBought;

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
        justBought = true;
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
    public boolean justBought(){ return justBought;}
    public void oldCardNow(){ justBought = false; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DevelopmentCard that = (DevelopmentCard) o;
        return that.getType().toLowerCase().equals(getType().toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(dc, dcFront, dcBack);
    }
}
