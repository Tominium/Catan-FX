package com.example.catanfx.GamePieces;

import com.example.catanfx.GamePieces.Misc.Token;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tile{

    private String type;
    private Token tok;
    private Polygon poly;

    private static ArrayList<String> nameList;

    public Tile(Polygon p){
        if(nameList==null){
            nameList = new ArrayList<>();
            nameList.addAll(List.of(new String[]{"lumber", "lumber", "lumber", "lumber", "brick", "brick", "brick", "desert", "grain", "grain", "grain", "grain", "wool", "wool", "wool", "wool", "ore", "ore", "ore"}));
            Collections.shuffle(nameList);
            Collections.shuffle(nameList);
            Collections.shuffle(nameList);
        }
        type = nameList.remove(nameList.size()-1);
        poly = p;
        ImagePattern img = new ImagePattern(getImage());
        p.setFill(img);
        tok = new Token(3);
    }

    public void setToken(Token tt){tok = tt;}
    public Token getToken(){return tok;}

    public Image getImage(){
        return new Image(Tile.class.getResource("/Assets/Hexagons/" + type + ".png").toExternalForm());
    }

    public String getType(){
        return type;
    }
}
