package com.example.catanfx.GamePieces;

import com.example.catanfx.GamePieces.Cards.DevelopmentCard;
import com.example.catanfx.GamePieces.Cards.ResourceCard;
import com.example.catanfx.GamePieces.Misc.Dice;
import com.example.catanfx.GamePieces.Structures.Structure;

import javax.sound.sampled.Port;
import java.awt.*;
import java.util.*;
import java.util.spi.AbstractResourceBundleProvider;

public class GameState {

    public static ArrayList<Player> players;
    private static ArrayList<Tile> tiles;
    public static int turnNumber;
    //private GameBoardGraphic fullGameBoard;
    //private ResourceDeck rcDeck;
    //private DevelopmentDeck dcDeck;
//    private static Dice dice;
//    private static Thief thief;
    public static boolean roundZeroRollDice;
    public static boolean roundZeroBuildSettlement;
    public static boolean roundZeroBuildRoad;
    public static TreeMap<Integer, ArrayList<Integer>> zeroMap;

    public GameState(int numOfPlayers){
        players = new ArrayList<Player>();
        setColors(numOfPlayers);
        tiles = new ArrayList<Tile>();
//        dice = new Dice();
//        thief = new Thief();
        turnNumber = 0;
        new Dice();
        roundZeroRollDice = true;
        zeroMap = new TreeMap<>();
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

    private static void setPlayerNums(){
        ArrayList<Player> temp = new ArrayList<>();
        for(int a: zeroMap.keySet()){
            for(int b: zeroMap.get(a)){
                temp.add(players.get(b));
            }
        }
        players = temp;
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

    public static void iterateTurn() {
        if(turnNumber == players.size() - 1){
            turnNumber = 0;
        }else{
            turnNumber++;
        }

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

    public static boolean canBuild(String s) {
        if(s.equals("road"))
            return canBuildRoad();
        else if(s.equals("settlement"))
            return canBuildSettlement();
        else
            return canBuildCity();
    }

    private static boolean canBuildRoad(){
        LinkedList<ResourceCard> rc = players.get(turnNumber).getRC();
        if(Collections.frequency(rc, new ResourceCard("brick")) < 1){return false;}
        if(Collections.frequency(rc, new ResourceCard("lumber")) < 1) {return  false;}
        return true;
    }

    private static boolean canBuildSettlement(){
        LinkedList<ResourceCard> rc = players.get(turnNumber).getRC();
        if(Collections.frequency(rc, new ResourceCard("brick")) < 1){return false;}
        if(Collections.frequency(rc, new ResourceCard("lumber")) < 1) {return  false;}
        if(Collections.frequency(rc, new ResourceCard("grain")) < 1) {return  false;}
        if(Collections.frequency(rc, new ResourceCard("wool")) < 1) {return  false;}
        return true;
    }

    private static boolean canBuildCity(){
        LinkedList<ResourceCard> rc = players.get(turnNumber).getRC();
        if(Collections.frequency(rc, new ResourceCard("grain")) < 2){return false;}
        if(Collections.frequency(rc, new ResourceCard("ore")) < 3) {return  false;}
        return true;
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

    public static void buildRoad(){
        getAllPlayers().get(turnNumber).removeRCard(new ResourceCard("brick"));
        getAllPlayers().get(turnNumber).removeRCard(new ResourceCard("lumber"));
    }

    public static void buildSettlement(){
        if(roundZeroBuildSettlement){
            turnNumber++;
            if(turnNumber == 4){
                turnNumber = 0;
                roundZeroBuildSettlement = false;
            }
        }
        else{
            getAllPlayers().get(turnNumber).removeRCard(new ResourceCard("brick"));
            getAllPlayers().get(turnNumber).removeRCard(new ResourceCard("lumber"));
            getAllPlayers().get(turnNumber).removeRCard(new ResourceCard("grain"));
            getAllPlayers().get(turnNumber).removeRCard(new ResourceCard("wool"));
        }
    }

    public static void buildCity(){
        getAllPlayers().get(turnNumber).removeRCard(new ResourceCard("grain"));
        getAllPlayers().get(turnNumber).removeRCard(new ResourceCard("grain"));
        getAllPlayers().get(turnNumber).removeRCard(new ResourceCard("ore"));
        getAllPlayers().get(turnNumber).removeRCard(new ResourceCard("ore"));
        getAllPlayers().get(turnNumber).removeRCard(new ResourceCard("ore"));
    }

    public static void useDevCard(DevelopmentCard dc) {
        for(int i = 0; i < players.get(turnNumber).getDC().size(); i++)
            if(players.get(turnNumber).getDC().get(i).equals(dc))
                players.get(turnNumber).removeDCard(players.get(turnNumber).getDC().get(i));
    }

    public static void roundZeroRollDiceDice(int r){
        if(turnNumber==0){
            if(zeroMap.get(r)==null){
                zeroMap.put(r, new ArrayList<>());
            }
            zeroMap.get(r).add(0);
            turnNumber++;
        }
        else if(turnNumber==1){
            if(zeroMap.get(r)==null){
                zeroMap.put(r, new ArrayList<>());
            }
            zeroMap.get(r).add(1);
            turnNumber++;
        }
        else if(turnNumber==2){
            if(zeroMap.get(r)==null){
                zeroMap.put(r, new ArrayList<>());
            }
            zeroMap.get(r).add(2);
            turnNumber++;
        }
        else if(players.size()==4&&turnNumber==3){
            if(zeroMap.get(r)==null){
                zeroMap.put(r, new ArrayList<>());
            }
            zeroMap.get(r).add(3);
            turnNumber++;
        }
        System.out.println(zeroMap);
        if(players.size()==3&&turnNumber==3){
            turnNumber = 0;
            setPlayerNums();
            roundZeroRollDice = false;
            roundZeroBuildSettlement = true;
        }
        else if(players.size()==4&& turnNumber==4){
            turnNumber = 0;
            setPlayerNums();
            roundZeroRollDice = false;
            roundZeroBuildSettlement = true;
        }
    }
}
