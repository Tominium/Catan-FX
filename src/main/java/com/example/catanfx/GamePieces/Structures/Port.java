package com.example.catanfx.GamePieces.Structures;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;

public class Port {
    private Polygon poly;
    private ImageView portImg;
    private String type;

    public Port(String t, Polygon pol, ImageView img){
        type = t;
        poly = pol;
        portImg = img;
        portImg.setImage(new Image(Port.class.getResource("/Assets/Port/"+type+".png").toExternalForm()));
    }

    public Polygon getPoly(){return poly;}


}
