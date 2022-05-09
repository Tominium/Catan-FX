package com.example.catanfx.GamePieces.Structures;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;

import java.util.Locale;

public class Port {
    private Polygon poly;
    private ImageView portImg;
    private String type;
    private ImageView pier1;
    private ImageView pier2;

    public Port(String t, Polygon pol, ImageView img, ImageView img1, ImageView img2){
        type = t.toLowerCase();
        poly = pol;
        portImg = img;
        portImg.setImage(new Image(Port.class.getClassLoader().getResource("Assets/Port/"+type+".png").toExternalForm()));
        pier1 = img1;
        pier2 = img2;
    }

    public Polygon getPoly(){return poly;}

    public ImageView getPier1(){return pier1;}
    public ImageView getPier2(){return pier2;}


}
