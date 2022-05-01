package com.example.catanfx.GamePieces.Misc;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Token {

    private int number;
    private ImageView image;

    public Token(int num, ImageView img) {
        number = num;
        if(img!=null){
            image = img;
            image.setImage(new Image(Token.class.getResource("/Assets/Tokens/prob_" + number + ".png").toExternalForm()));
        }
    }

    public int getNumber() {
        return number;
    }
}
