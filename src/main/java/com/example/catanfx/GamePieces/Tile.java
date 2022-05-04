package com.example.catanfx.GamePieces;

import com.example.catanfx.Controllers.GameBoardController;
import com.example.catanfx.GamePieces.Misc.Token;
import com.example.catanfx.GamePieces.Structures.Structure;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;
import javafx.scene.image.Image;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tile{

    private String type;
    private Token tok;
    private Polygon poly;

    private static ArrayList<String> nameList;
    private static ArrayList<Integer> tokensNums;

    private ArrayList<Structure> vertices;
    private ArrayList<Structure> edges;

    public Tile(Polygon p, ImageView token){
        if(nameList==null){
            nameList = new ArrayList<>();
            nameList.addAll(List.of(new String[]{"lumber", "lumber", "lumber", "lumber", "brick", "brick", "brick", "desert", "grain", "grain", "grain", "grain", "wool", "wool", "wool", "wool", "ore", "ore", "ore"}));
            Collections.shuffle(nameList);
            Collections.shuffle(nameList);
            Collections.shuffle(nameList);
            tokensNums = new ArrayList<>();
            tokensNums.addAll(List.of(new Integer[]{5,2,6,3,8,10,9,12,11,4,8,10,9,4,5,6,3,11}));
        }
        type = nameList.remove(nameList.size()-1);
        poly = p;
        ImagePattern img = new ImagePattern(getImage());
        p.setFill(img);
        if(!type.equals("desert")){
            tok = new Token(tokensNums.remove(0), token);
            System.out.println(type+":"+tok.getNumber());
        }
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void setToken(Token tt){tok = tt;}
    public Token getToken(){return tok;}

    public Image getImage(){
        return new Image(Tile.class.getResource("/Assets/Hexagons/" + type + ".png").toExternalForm());
    }

    public String getType(){
        return type;
    }

    public void addVertex(Structure te){
        vertices.add(te);
    }

    public void addEdges(Structure te){
        edges.add(te);
    }

    public Polygon getPoly(){
        return poly;
    }

    public ArrayList<Structure> getVertices(){
        return vertices;
    }
    public ArrayList<Structure> getEdges(){
        return edges;
    }
}
