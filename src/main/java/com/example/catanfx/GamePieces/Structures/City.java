package com.example.catanfx.GamePieces.Structures;

import com.example.catanfx.Controllers.GameBoardController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class City extends Structure {

    public City(String type, String color, ImageView image) {
        super(type, color, image);
    }

    public void setColor(String c){color = c; image.setImage(new Image(City.class.getResource("/Assets/City/" + color + ".png").toExternalForm()));}

}
