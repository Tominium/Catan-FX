package com.example.catanfx.GamePieces.Structures;

import com.example.catanfx.Controllers.GameBoardController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Road extends Structure {
    public Road(String type, String color, ImageView image) {
        super(type, color, image);
    }

    public void setColor(String c){color = c; image.setImage(new Image(GameBoardController.class.getResource("/Assets/Road/" + color + ".png").toExternalForm()));}
}
