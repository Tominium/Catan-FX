package com.example.catanfx.GamePieces.Structures;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Locale;


public class Settlement extends Structure {
    public Settlement(String type, String color, ImageView image) {
        super(type, color, image);
    }

    public void setColor(String c) {
        color = c.toLowerCase();
        System.out.println(color);
        image.setImage(new Image(Settlement.class.getClassLoader().getResource("Assets/Settlement/" + color + ".png").toExternalForm()));
    }
}
