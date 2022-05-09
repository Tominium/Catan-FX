package com.example.catanfx.GamePieces.Structures;

import com.example.catanfx.Controllers.GameBoardController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Locale;

public class City extends Structure {

    public City(String type, String color, ImageView image) {
        super(type, color, image);
    }

    public void setColor(String c) {
        color = c.toLowerCase();
        image.setImage(new Image(City.class.getClassLoader().getResource("Assets/City/" + color + ".png").toExternalForm()));
    }

}
