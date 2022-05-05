package com.example.catanfx.GamePieces;

import com.example.catanfx.GamePieces.Cards.DevelopmentCard;
import com.example.catanfx.GamePieces.Cards.ResourceCard;
import com.example.catanfx.GamePieces.Cards.ResourceDeck;
import com.example.catanfx.GamePieces.Misc.Dice;
import com.example.catanfx.GamePieces.Structures.Road;
import com.example.catanfx.GamePieces.Structures.Settlement;
import com.example.catanfx.GamePieces.Structures.Structure;
import javafx.scene.image.ImageView;

import javax.sound.sampled.Port;
import java.awt.*;
import java.util.*;

public class GameState {

    public static ArrayList<Player> players;
    private static ArrayList<Tile> tiles;
    public static int turnNumber;
    //private GameBoardGraphic fullGameBoard;
//    private static Dice dice;
//    private static Thief thief;
    public static boolean roundZeroRollDice;
    public static boolean roundZeroBuildSettlement;
    public static boolean roundZeroBuildRoad;
    public static boolean turnDirc;
    public static TreeMap<Integer, ArrayList<Integer>> zeroMap;
    public static HashMap<ImageView, Road> roadMap;
    public static ArrayList<Tile> tilesBook;
    public static ArrayList<Structure> setts;

    public GameState(int numOfPlayers){
        players = new ArrayList<Player>();
        new ResourceDeck();
        setColors(numOfPlayers);
        tiles = new ArrayList<Tile>();
//        thief = new Thief();
        turnNumber = 0;
        new Dice();
        roundZeroRollDice = true;
        zeroMap = new TreeMap<>();
        turnDirc = false;
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

    public static void rollDiceGetResources(int a){
        for(Player p: players){
            for(Structure s: p.getSettlements()){
                for (Tile t : tilesBook) {
                    if (!t.getType().equals("desert") && t.getToken().getNumber() == a) {
                        if (!t.getType().equalsIgnoreCase("desert") && t.getVertices().contains(s)) {
                            p.addRC(ResourceDeck.getCard(t.getType()));
                        }
                    }
                }
            }
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
        if(roundZeroBuildRoad){
            roundZeroBuildRoad = false;
            roundZeroBuildSettlement = true;
            if(turnDirc){
                turnNumber--;
            }
            else {
                turnNumber++;
            }
            if(turnNumber==players.size()){
                    turnNumber--;
                    turnDirc = true;
            }
            if(turnDirc && turnNumber==-1){
                roundZeroBuildRoad = false;
                roundZeroBuildSettlement = false;
                turnNumber = 0;
                roundZeroGiveResources();
            }
        }
        else{
            getAllPlayers().get(turnNumber).removeRCard(new ResourceCard("brick"));
            getAllPlayers().get(turnNumber).removeRCard(new ResourceCard("lumber"));
        }
    }

    public static void buildSettlement(){
        if(roundZeroBuildSettlement){
            roundZeroBuildSettlement = false;
            roundZeroBuildRoad = true;
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
    public static boolean roundZeroRoadLogic(ImageView img){
        ImageView imgf = players.get(turnNumber).getSettlements().get(players.get(turnNumber).getSettlements().size()-1).getImage();
        return imgf.getBoundsInParent().intersects(img.getBoundsInParent());
    }

    public static boolean roundZeroSettlementLogic(Settlement img){
        for(Tile tt: tilesBook){
            if(tt.getVertices().contains(img)){
                for(Structure s: tt.getEdges()){
                    if(!s.getColor().equalsIgnoreCase(players.get(turnNumber).getColor()) && s.getImage().getBoundsInParent().intersects(img.getImage().getBoundsInParent())){
                        if(roundZeroRoadIntersectSettlementLogic(s.getImage(), tt.getVertices())){
                            System.out.println("DOg");
                            return false;
                        }
                    }
                    if(s.isVisible() && !s.getColor().equalsIgnoreCase(players.get(turnNumber).getColor()) && s.getImage().getBoundsInParent().intersects(img.getImage().getBoundsInParent()) ){
                        System.out.println("CAT");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static  void setRoadMap(HashMap<ImageView, Road> roadHashMapMap){
        roadMap = roadHashMapMap;
    }

    public static boolean roundZeroRoadIntersectSettlementLogic(ImageView img, ArrayList<Structure> verts){
        for(Structure s: verts){
            if(s.isVisible() && !s.getColor().equalsIgnoreCase(players.get(turnNumber).getColor()) &&img.getBoundsInParent().intersects(s.getImage().getBoundsInParent())){
                return true;
            }
        }
        return false;
    }

    public static void roundZeroGiveResources(){
        for(Player p: players){
            Structure s = p.getSettlements().get(1);
            for(Tile t: tilesBook){
                if(!t.getType().equalsIgnoreCase("desert") && t.getVertices().contains(s)){
                    p.addRC(ResourceDeck.getCard(t.getType()));
                }
            }
        }
    }

    public static void yearOfPlenty(Player p, String resource){
        ResourceCard r = new ResourceCard(resource);
        p.addRC(r);
        p.addRC(r);
    }

}
