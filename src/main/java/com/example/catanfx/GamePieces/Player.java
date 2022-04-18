package com.example.catanfx.GamePieces;

import com.example.catanfx.GamePieces.Cards.DevelopmentCard;
import com.example.catanfx.GamePieces.Cards.ResourceCard;
import com.example.catanfx.GamePieces.Structures.City;
import com.example.catanfx.GamePieces.Structures.Structure;

import java.util.LinkedList;

public class Player {
    private String color;
    private LinkedList<ResourceCard> resourceCards;
    private LinkedList<DevelopmentCard> devCards;
    private LinkedList<Structure> structures;
    private int turnNum;

    public Player(String c, int turn){
        color = c;
        turnNum = turn;
        resourceCards = new LinkedList<>();
        devCards = new LinkedList<>();
        structures = new LinkedList<>();
    }

    public void removeRCard(ResourceCard c){
        resourceCards.remove(c);
    }
    public void removeDCard(DevelopmentCard c){
        devCards.remove(c);
    }

    public String getColor(){return color;}
    public LinkedList<ResourceCard> getRC(){return resourceCards;}
    public int getTurnNum(){return turnNum;}
    public LinkedList<DevelopmentCard> getDC(){return devCards;}
    public LinkedList<Structure> getStructures(){return structures;}

    public void setRC(LinkedList<ResourceCard> rc){resourceCards = rc;}
    public void addRC(ResourceCard c){resourceCards.add(c);}
    public void addDC(DevelopmentCard c){devCards.add(c);}
    public void setDC(LinkedList<DevelopmentCard> d){devCards = d;}
    public void addStruct(Structure s){structures.add(s);}
    public void upgradeStruct(Structure s){
        for(int i=0; i<structures.size(); i++){
            if(structures.get(i).equals(s)){
                structures.set(i, new City("City", s.getColor(), s.getPos()));
                return;
            }
        }
    }

    public int getPoints(){
        int cnt = 0;
        for(DevelopmentCard d: devCards){
            cnt+=d.getPoints();
        }
        return cnt;
    }




}
