package com.example.catanfx.GamePieces.Structures;

import com.example.catanfx.Controllers.GameBoardController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Locale;

public class Road extends Structure {
    public Road(String type, String color, ImageView image) {
        super(type, color, image);
    }

    public void setColor(String c) {
        color = c.toLowerCase();
        image.setImage(new Image(Road.class.getClassLoader().getResource("Assets/Road/" + color + ".png").toExternalForm()));
    }
}
