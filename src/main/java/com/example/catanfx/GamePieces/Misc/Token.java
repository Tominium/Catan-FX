package com.example.catanfx.GamePieces.Misc;
import javafx.scene.image.Image;

public class Token {

    private int number;
    private Image image;

    public Token(int num) {
        number = num;
        image = new Image(Token.class.getResource("/Assets/Tokens/prob_"+number+".png").toExternalForm());
    }

    public int getNumber() {
        return number;
    }

    public Image getImage() {
        return image;
    }
}
