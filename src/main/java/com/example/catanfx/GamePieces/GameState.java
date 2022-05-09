package com.example.catanfx.GamePieces;

import com.example.catanfx.Controllers.generalInfoCompController;
import com.example.catanfx.GamePieces.Cards.DevelopmentCard;
import com.example.catanfx.GamePieces.Cards.DevelopmentDeck;
import com.example.catanfx.GamePieces.Cards.ResourceCard;
import com.example.catanfx.GamePieces.Cards.ResourceDeck;
import com.example.catanfx.GamePieces.Misc.Dice;
import com.example.catanfx.GamePieces.Structures.Port;
import com.example.catanfx.GamePieces.Structures.Road;
import com.example.catanfx.GamePieces.Structures.Settlement;
import com.example.catanfx.GamePieces.Structures.Structure;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class GameState {

    public static ArrayList<Player> players;
    private static ArrayList<Tile> tiles;
    public static int turnNumber;
    //private GameBoardGraphic fullGameBoard;
//    private static Dice dice;
//    private static Thief thief;
    public static boolean roundZero;
    public static boolean roundZeroRollDice;
    public static boolean roundZeroBuildSettlement;
    public static boolean roundZeroBuildRoad;
    public static boolean turnDirc;
    public static TreeMap<Integer, ArrayList<Integer>> zeroMap;
    public static HashMap<ImageView, Road> roadMap;
    public static ArrayList<Tile> tilesBook;
    public static ArrayList<Structure> setts;
    public static HashMap<String, Port> portsMap;
    public static boolean rollSeven;
    public static boolean usedKnight;
    public static boolean usedRB1;
    public static boolean usedRB2;
    public static int rbControl;
    public static int maxKnights;
    public static boolean firstLA;

    public GameState(int numOfPlayers){
        roundZero = true;
        players = new ArrayList<Player>();
        new ResourceDeck();
        new DevelopmentDeck();
        setColors(numOfPlayers);
        tiles = new ArrayList<Tile>();
//        thief = new Thief();
        turnNumber = 0;
        new Dice();
        roundZeroRollDice = true;
        zeroMap = new TreeMap<>();
        turnDirc = false;
        rbControl = 0;
        maxKnights = 3;
        firstLA = false;
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

    public static int checkWin() {
        for(int i = 0; i < players.size(); i++) {
            if (players.get(i).getPoints() >= 10) {
                return i;
            }
        }
        return -1;
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
        if(a!=7){
            for (Player p : players) {
                for (Structure s : p.getStructures()) {
                    for (Tile t : tilesBook) {
                        if (!t.getType().equals("desert") && t.getToken().getNumber() == a) {
                            if (!t.getType().equalsIgnoreCase("desert") && t.getVertices().contains(s)) {
                                p.addRC(ResourceDeck.getCard(t.getType()));
                                if(s.getType().equalsIgnoreCase("City")){
                                    p.addRC(ResourceDeck.getCard(t.getType()));
                                }
                                System.out.println(p.getColor()+": " + t.getType());
                            }
                        }
                    }
                }
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Rolled Seven");
            alert.setHeaderText(null);
            alert.setContentText("You Rolled A Seven! Please Move the Thief!");
            alert.showAndWait();
            rollSeven = true;
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
        if(players.get(turnNumber).getRoads().size() == 15){return false;}
        LinkedList<ResourceCard> rc = players.get(turnNumber).getRC();
        if(Collections.frequency(rc, new ResourceCard("brick")) < 1){return false;}
        if(Collections.frequency(rc, new ResourceCard("lumber")) < 1) {return  false;}
        return true;
    }

    public static boolean canPlaceRoad(Road r){
        for(Structure s: players.get(turnNumber).getStructures()){
            if(s.getImage().getBoundsInParent().intersects(r.getImage().getBoundsInParent())){
                return true;
            }
        }
        for(Structure s: players.get(turnNumber).getRoads()){
            if(s.getImage().getBoundsInParent().intersects(r.getImage().getBoundsInParent())){
                return true;
            }
        }
        return false;
    }



    private static boolean canBuildSettlement(){
        if(players.get(turnNumber).getSettlements().size() == 5){return false;}
        LinkedList<ResourceCard> rc = players.get(turnNumber).getRC();
        if(Collections.frequency(rc, new ResourceCard("brick")) < 1){return false;}
        if(Collections.frequency(rc, new ResourceCard("lumber")) < 1) {return  false;}
        if(Collections.frequency(rc, new ResourceCard("grain")) < 1) {return  false;}
        if(Collections.frequency(rc, new ResourceCard("wool")) < 1) {return  false;}
        return true;
    }

    public static boolean canBuildSettlementLocation(ImageView img){
        for(Structure s: players.get(turnNumber).getRoads()){
            if(s.getImage().getBoundsInParent().intersects(img.getBoundsInParent())){return true;}
        }
        return false;
    }

    public static boolean normalRoundSettlementLogic(Settlement img){
        for(Tile tt: tilesBook){
            if(tt.getVertices().contains(img)){
                for(Structure s: tt.getEdges()){
                    if(s.isVisible() && players.get(turnNumber).getRoads().contains(s)&&s.getImage().getBoundsInParent().intersects(img.getImage().getBoundsInParent())){
                        if(roundZeroRoadIntersectSettlementLogic(s.getImage(), tt.getVertices())){
                            System.out.println("DOg");
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static boolean canBuildCity(){
        if(players.get(turnNumber).getCities().size() == 4){return false;}
        LinkedList<ResourceCard> rc = players.get(turnNumber).getRC();
        if(Collections.frequency(rc, new ResourceCard("grain")) < 2){return false;}
        if(Collections.frequency(rc, new ResourceCard("ore")) < 3) {return  false;}
        return true;
    }

//
//    public static int getDiceRoll() {
//        return dice.getRolledNum();
//    }

    public static void rollSeven() {
        Set<String> colors = new TreeSet<>();
        for(Tile ta: tilesBook){
            if(!ta.getType().equalsIgnoreCase("desert") && ta.getToken().isThief()){
                for(Structure s: ta.getVertices()){
                    if(!s.getColor().equalsIgnoreCase("white") && !s.getColor().equalsIgnoreCase(players.get(turnNumber).getColor())){
                        colors.add(s.getColor());
                    }
                }
                break;
            }
        }
        if(!colors.isEmpty()){
            String[] arrayData = colors.toArray(new String[0]);
            List<String> dialogData = Arrays.asList(arrayData);

            ChoiceDialog dialog = new ChoiceDialog(dialogData.get(0), dialogData);
            dialog.setGraphic(null);
            dialog.setTitle("Stealing");
            dialog.setHeaderText("Select Player To Steal From");

            Optional<String> result = dialog.showAndWait();
            for(Player p: players){
                if(p.getColor().equalsIgnoreCase(result.get())){
                    if(!p.getRC().isEmpty()){
                        players.get(turnNumber).addRC(p.getRandomCard());
                    }
                    else{
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Empty Deck");
                        alert.setHeaderText(null);
                        alert.setContentText("Trying To Steal From A Poor Player! L BOZO! Try Again");
                        alert.showAndWait();
                        if(colors.size()>1){
                            rollSeven();
                        }
                    }
                }
            }
        }
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(generalInfoCompController.class.getClassLoader().getResource("com/example/catanfx/discardPanel.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            ResourceDeck.addCard("brick");
            ResourceDeck.addCard("lumber");
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
            ResourceDeck.addCard("brick");
            ResourceDeck.addCard("lumber");
            ResourceDeck.addCard("grain");
            ResourceDeck.addCard("wool");
        }
    }

    public static void buildCity(){
        getAllPlayers().get(turnNumber).removeRCard(new ResourceCard("grain"));
        getAllPlayers().get(turnNumber).removeRCard(new ResourceCard("grain"));
        getAllPlayers().get(turnNumber).removeRCard(new ResourceCard("ore"));
        getAllPlayers().get(turnNumber).removeRCard(new ResourceCard("ore"));
        getAllPlayers().get(turnNumber).removeRCard(new ResourceCard("ore"));
        ResourceDeck.addCard("grain");
        ResourceDeck.addCard("grain");
        ResourceDeck.addCard("ore");
        ResourceDeck.addCard("ore");
        ResourceDeck.addCard("ore");
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
        ImageView imgf = players.get(turnNumber).getStructures().get(players.get(turnNumber).getStructures().size()-1).getImage();
        return imgf.getBoundsInParent().intersects(img.getBoundsInParent());
    }

    public static boolean roundZeroSettlementLogic(Settlement img){
        for(Tile tt: tilesBook){
            if(tt.getVertices().contains(img)){
                for(Structure s: tt.getEdges()){
                    if(s.getImage().getBoundsInParent().intersects(img.getImage().getBoundsInParent())){
                        if(roundZeroRoadIntersectSettlementLogic(s.getImage(), tt.getVertices())){
                            System.out.println("DOg");
                            return false;
                        }
                    }
                    if(s.isVisible() && s.getImage().getBoundsInParent().intersects(img.getImage().getBoundsInParent()) ){
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
            if(s.isVisible() && img.getBoundsInParent().intersects(s.getImage().getBoundsInParent())){
                return true;
            }
        }
        return false;
    }

    public static void roundZeroGiveResources(){
        for(Player p: players){
            Structure s = p.getStructures().get(1);
            for(Tile t: tilesBook){
                if(!t.getType().equalsIgnoreCase("desert") && t.getVertices().contains(s)){
                    p.addRC(ResourceDeck.getCard(t.getType()));
                }
            }
        }
        roundZero = false;

    }

    public static void yearOfPlenty(Player p, String resource){
        ResourceCard r = new ResourceCard(resource);
        p.addRC(r);
        p.addRC(r);
        p.removeDCard(new DevelopmentCard("yearofplenty"));
    }

    public static void monopoly(Player p, String resource){
        int resourceTotal = 0;
        for(int i = 0; i < players.size(); i++){
            if(players.indexOf(p) != i){
                int count = Collections.frequency(players.get(i).getRC(), new ResourceCard(resource));
                for(int j = 0; j < count; j++){
                    players.get(i).removeRCard(new ResourceCard(resource));
                    resourceTotal++;
                }
            }
        }
        for(int i = 0; i < resourceTotal; i++){
            p.addRC(new ResourceCard(resource));
        }
        p.removeDCard(new DevelopmentCard("monopoly"));

    }

    public static void buyDC(Player p){
        DevelopmentCard d = DevelopmentDeck.getCard();
        p.addDC(d);
        p.removeRCard(new ResourceCard("grain"));
        p.removeRCard(new ResourceCard("ore"));
        p.removeRCard(new ResourceCard("wool"));
    }

    public static boolean check(Player p){
        if(Collections.frequency(p.getRC(), new ResourceCard("grain")) >= 1
        && Collections.frequency(p.getRC(), new ResourceCard("ore")) >= 1
        && Collections.frequency(p.getRC(), new ResourceCard("wool")) >= 1){
            return true;
        }
        return false;
    }

    public static boolean newCard(Player p, String developmentCard){
        DevelopmentCard d = new DevelopmentCard();
        for(int i = 0; i < p.getDC().size(); i++){
            if(p.getDC().get(i).getType().equals(developmentCard)){
                d = p.getDC().get(i);
            }
        }
        if(d.justBought()){
            return true;
        }
        return false;
    }

    public static void oldCard(Player p){
        for(int i = 0; i < p.getDC().size(); i++){
            p.getDC().get(i).oldCardNow();
        }
    }

    public static void BankTrade(Player p, String resourceOffered, String resourceRequested){
        p.removeRCard(new ResourceCard(resourceOffered));
        p.removeRCard(new ResourceCard(resourceOffered));
        p.removeRCard(new ResourceCard(resourceOffered));
        p.removeRCard(new ResourceCard(resourceOffered));
        ResourceDeck.addCard(resourceOffered);
        ResourceDeck.addCard(resourceOffered);
        ResourceDeck.addCard(resourceOffered);
        ResourceDeck.addCard(resourceOffered);
        p.addRC(ResourceDeck.getCard(resourceRequested));
    }

    public static boolean checkBankTrade(Player p, String resourceOffered){
        if(Collections.frequency(p.getRC(), new ResourceCard(resourceOffered)) >= 4){
            return true;
        }
        return false;
    }

    public static void Knight(){
        usedKnight = true;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Used Knight");
        alert.setHeaderText(null);
        alert.setContentText("Please move the Thief");
        alert.showAndWait();
    }

    public static void roadBuilding(){
        usedRB1 = true;
        usedRB2 = true;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Used Road Building");
        alert.setHeaderText(null);
        alert.setContentText("Please place 2 roads");
        alert.showAndWait();
    }

    public static void checkLargestArmy(Player p){
        if(!firstLA) {
            if (p.getKnightsPlayed() >= maxKnights) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Obtained Largest Army");
                alert.setHeaderText(null);
                alert.setContentText("You have the Largest Army!");
                alert.showAndWait();

                maxKnights = p.getKnightsPlayed();
                p.setPoints(2);
                firstLA = true;
                p.obtainedLargestArmy();
            }
        }
        else{
            if (p.getKnightsPlayed() > maxKnights) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Obtained Largest Army");
                alert.setHeaderText(null);
                alert.setContentText("You have the Largest Army!");
                alert.showAndWait();

                maxKnights = p.getKnightsPlayed();
                p.setPoints(2);
                for(int i = 0; i < players.size(); i++){
                    if(players.get(i).hasLargestArmy()){
                        if(players.indexOf(p) == i){
                            break;
                        }
                        else{
                            players.get(i).resetLargestArmy();
                        }
                    }
                }
                p.obtainedLargestArmy();
            }
        }
    }

}
