package com.example.catanfx.GamePieces;

import com.example.catanfx.GamePieces.Cards.DevelopmentCard;
import com.example.catanfx.GamePieces.Cards.ResourceCard;
import com.example.catanfx.GamePieces.Structures.Structure;

import javax.sound.sampled.Port;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class GameState {

    public static ArrayList<Player> players;
    private static ArrayList<Tile> tiles;
    public static int turnNumber;
    //private GameBoardGraphic fullGameBoard;
    //private ResourceDeck rcDeck;
    //private DevelopmentDeck dcDeck;
//    private static Dice dice;
//    private static Thief thief;

    public GameState(int numOfPlayers){
        players = new ArrayList<Player>();
        setColors(numOfPlayers);
        tiles = new ArrayList<Tile>();
//        dice = new Dice();
//        thief = new Thief();
        turnNumber = 0;
    }

    private static void setColors(int num){
        ArrayList<String> colors = new ArrayList<String>();
        colors.add("Blue");colors.add("Red");colors.add("Orange");colors.add("Green");
        Collections.shuffle(colors);
        while(num!=0){
            players.add(new Player(colors.remove(0), num));
            num--;
        }
        Collections.reverse(players);
    }

    public static ArrayList<Player> getAllPlayers(){return players;}

    public static boolean moveThief(Point p){
        return false;
    }

//    public Player checkWin(){
//        for(Player p: )
//    }

    public static Player checkWin() {
        for(int i = 0; i < players.size(); i++)
            if(players.get(i).getPoints()>=10)
                return players.get(i);
        return null;
    }

    public static LinkedList<ResourceCard> getResourceInventory() {
        return players.get(turnNumber).getRC();
    }

    public static LinkedList<DevelopmentCard> getDevelopmentInventory() {
        return players.get(turnNumber).getDC();
    }

    public static int iterateTurn() {
        return turnNumber+1;
    }

    public static void trade(Player p, ArrayList<ResourceCard> send, ArrayList<ResourceCard> receive) {
        for(int i = 0; i < send.size(); i++) {
            p.addRC(send.get(i));
            players.get(turnNumber).removeRCard(send.get(i));
        }
        for(int i = 0; i < receive.size(); i++) {
            players.get(turnNumber).addRC(receive.get(i));
            p.removeRCard(receive.get(i));
        }
    }

    public static boolean canBuild(Structure s) {

        ResourceCard[] road = new ResourceCard[2];
        road[0] = new ResourceCard("brick");
        road[1] = new ResourceCard("lumber");
        ResourceCard[] settlement = new ResourceCard[4];
        road[0] = new ResourceCard("brick");
        road[1] = new ResourceCard("lumber");
        road[2] = new ResourceCard("wheat");
        road[3] = new ResourceCard("wool");
        ResourceCard[] city = new ResourceCard[5];
        road[0] = new ResourceCard("wheat");
        road[1] = new ResourceCard("wheat");
        road[2] = new ResourceCard("ore");
        road[3] = new ResourceCard("ore");
        road[4] = new ResourceCard("ore");


        if(s.getType().equals("road"))
            return hasResources(road);
        else if(s.getType().equals("settlement"))
            return hasResources(settlement);
        else
            return hasResources(city);
    }

    public static boolean hasResources(ResourceCard[] needed) {
        return players.get(turnNumber).getRC().contains(needed);
    }

    public static boolean canPlace(Structure s, Point p) {
        return true;
    }
//
//    public static int getDiceRoll() {
//        return dice.getRolledNum();
//    }

    public static void rollSeven() {


    }

    public static void giveLongestRoad(Player p) {

    }

    public static void giveLargestArmy(Player p) {

    }

    public static Player longestRoad() {
        return players.get(0);
    }

    public static Player largestArmy() {
        return players.get(0);
    }

    public static void steal(Player p) {

    }

    public static void setTile(ArrayList<Tile> t) {

    }

    public static Port isOnPort(Structure s) {
        return null;
    }

    public static HashMap<Player, LinkedList<String>> tokenResource(int num) {
        return null;
    }

    public static void build(Structure s) {

    }

    public static void useDevCard(DevelopmentCard dc) {
        for(int i = 0; i < players.get(turnNumber).getDC().size(); i++)
            if(players.get(turnNumber).getDC().get(i).equals(dc))
                players.get(turnNumber).removeDCard(players.get(turnNumber).getDC().get(i));
    }
}
