package com.example.catanfx.GamePieces.Misc;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.HashMap;

public class Token {

    private int number;
    private ImageView image;

    private boolean isThief;
    public static HashMap<ImageView, Token> tokensMap;

    public Token(int num, ImageView img) {
        if(tokensMap==null){
            tokensMap = new HashMap<>();
        }
        number = num;
        isThief = false;
        if(num!=-1){
            image = img;
            image.setImage(new Image(Token.class.getResource("/Assets/Tokens/prob_" + number + ".png").toExternalForm()));
            tokensMap.put(image, this);
        }
        else{
            image = img;
            image.setImage(new Image(Token.class.getResource("/Assets/robber.png").toExternalForm()));
            isThief = true;
            tokensMap.put(image, this);
        }
    }

    public int getNumber() {
        return number;
    }

    public void setThief(Boolean b){
        isThief = b;
        if(isThief){
            image.setImage(new Image(Token.class.getResource("/Assets/robber.png").toExternalForm()));
        }
        else if(number != -1){
            image.setImage(new Image(Token.class.getResource("/Assets/Tokens/prob_" + number + ".png").toExternalForm()));
        }
        else{
            image.setImage(new Image(Token.class.getResource("/Assets/Empty.png").toExternalForm()));
        }
    }

    public boolean isThief(){return isThief;}
}
