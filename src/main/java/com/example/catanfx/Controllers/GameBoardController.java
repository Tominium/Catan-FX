package com.example.catanfx.Controllers;
import com.example.catanfx.GamePieces.GameState;
import com.example.catanfx.GamePieces.Misc.Token;
import com.example.catanfx.GamePieces.Structures.Port;
import com.example.catanfx.GamePieces.Structures.Road;
import com.example.catanfx.GamePieces.Structures.Settlement;
import com.example.catanfx.GamePieces.Structures.Structure;
import com.example.catanfx.GamePieces.Tile;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;

import java.net.URL;
import java.util.*;

public class GameBoardController implements Initializable {

    @FXML
    private Polygon port1;
    @FXML
    private Polygon port2;
    @FXML
    private Polygon port3;
    @FXML
    private Polygon port4;
    @FXML
    private Polygon port5;
    @FXML
    private Polygon port6;
    @FXML
    private Polygon port7;
    @FXML
    private Polygon port8;
    @FXML
    private Polygon port9;
    @FXML
    private ImageView portImg1;
    @FXML
    private ImageView portImg2;
    @FXML
    private ImageView portImg3;
    @FXML
    private ImageView portImg4;
    @FXML
    private ImageView portImg5;
    @FXML
    private ImageView portImg6;
    @FXML
    private ImageView portImg7;
    @FXML
    private ImageView portImg8;
    @FXML
    private ImageView portImg9;

    @FXML
    private Polygon tile1;
    @FXML
    private Polygon tile2;
    @FXML
    private Polygon tile3;
    @FXML
    private Polygon tile4;
    @FXML
    private Polygon tile5;
    @FXML
    private Polygon tile6;
    @FXML
    private Polygon tile7;
    @FXML
    private Polygon tile8;
    @FXML
    private Polygon tile9;
    @FXML
    private Polygon tile10;
    @FXML
    private Polygon tile11;
    @FXML
    private Polygon tile12;
    @FXML
    private Polygon tile13;
    @FXML
    private Polygon tile14;
    @FXML
    private Polygon tile15;
    @FXML
    private Polygon tile16;
    @FXML
    private Polygon tile17;
    @FXML
    private Polygon tile18;
    @FXML
    private Polygon tile19;
    @FXML
    private ImageView road1;
    @FXML
    private ImageView road10;
    @FXML
    private ImageView road11;
    @FXML
    private ImageView road12;
    @FXML
    private ImageView road13;
    @FXML
    private ImageView road14;
    @FXML
    private ImageView road15;
    @FXML
    private ImageView road16;
    @FXML
    private ImageView road17;
    @FXML
    private ImageView road18;
    @FXML
    private ImageView road19;
    @FXML
    private ImageView road2;
    @FXML
    private ImageView road20;
    @FXML
    private ImageView road21;
    @FXML
    private ImageView road22;
    @FXML
    private ImageView road23;
    @FXML
    private ImageView road24;
    @FXML
    private ImageView road25;
    @FXML
    private ImageView road26;
    @FXML
    private ImageView road27;
    @FXML
    private ImageView road28;
    @FXML
    private ImageView road29;
    @FXML
    private ImageView road3;
    @FXML
    private ImageView road30;
    @FXML
    private ImageView road31;
    @FXML
    private ImageView road32;
    @FXML
    private ImageView road33;
    @FXML
    private ImageView road34;
    @FXML
    private ImageView road35;
    @FXML
    private ImageView road36;
    @FXML
    private ImageView road37;
    @FXML
    private ImageView road38;
    @FXML
    private ImageView road39;
    @FXML
    private ImageView road4;
    @FXML
    private ImageView road40;
    @FXML
    private ImageView road41;
    @FXML
    private ImageView road42;
    @FXML
    private ImageView road43;
    @FXML
    private ImageView road44;
    @FXML
    private ImageView road45;
    @FXML
    private ImageView road46;
    @FXML
    private ImageView road47;
    @FXML
    private ImageView road48;
    @FXML
    private ImageView road49;
    @FXML
    private ImageView road5;
    @FXML
    private ImageView road50;
    @FXML
    private ImageView road51;
    @FXML
    private ImageView road52;
    @FXML
    private ImageView road53;
    @FXML
    private ImageView road54;
    @FXML
    private ImageView road55;
    @FXML
    private ImageView road56;
    @FXML
    private ImageView road57;
    @FXML
    private ImageView road58;
    @FXML
    private ImageView road59;
    @FXML
    private ImageView road6;
    @FXML
    private ImageView road60;
    @FXML
    private ImageView road61;
    @FXML
    private ImageView road62;
    @FXML
    private ImageView road63;
    @FXML
    private ImageView road64;
    @FXML
    private ImageView road65;
    @FXML
    private ImageView road66;
    @FXML
    private ImageView road67;
    @FXML
    private ImageView road68;
    @FXML
    private ImageView road69;
    @FXML
    private ImageView road7;
    @FXML
    private ImageView road70;
    @FXML
    private ImageView road71;
    @FXML
    private ImageView road72;
    @FXML
    private ImageView road8;
    @FXML
    private ImageView road9;
    @FXML
    private ImageView sett1;
    @FXML
    private ImageView sett10;
    @FXML
    private ImageView sett11;
    @FXML
    private ImageView sett12;
    @FXML
    private ImageView sett13;
    @FXML
    private ImageView sett14;
    @FXML
    private ImageView sett15;
    @FXML
    private ImageView sett16;
    @FXML
    private ImageView sett17;
    @FXML
    private ImageView sett18;
    @FXML
    private ImageView sett19;
    @FXML
    private ImageView sett2;
    @FXML
    private ImageView sett20;
    @FXML
    private ImageView sett21;
    @FXML
    private ImageView sett22;
    @FXML
    private ImageView sett23;
    @FXML
    private ImageView sett24;
    @FXML
    private ImageView sett25;
    @FXML
    private ImageView sett26;
    @FXML
    private ImageView sett27;
    @FXML
    private ImageView sett28;
    @FXML
    private ImageView sett29;
    @FXML
    private ImageView sett3;
    @FXML
    private ImageView sett30;
    @FXML
    private ImageView sett31;
    @FXML
    private ImageView sett32;
    @FXML
    private ImageView sett33;
    @FXML
    private ImageView sett34;
    @FXML
    private ImageView sett35;
    @FXML
    private ImageView sett36;
    @FXML
    private ImageView sett37;
    @FXML
    private ImageView sett38;
    @FXML
    private ImageView sett39;
    @FXML
    private ImageView sett4;
    @FXML
    private ImageView sett40;
    @FXML
    private ImageView sett41;
    @FXML
    private ImageView sett42;
    @FXML
    private ImageView sett43;
    @FXML
    private ImageView sett44;
    @FXML
    private ImageView sett45;
    @FXML
    private ImageView sett46;
    @FXML
    private ImageView sett47;
    @FXML
    private ImageView sett48;
    @FXML
    private ImageView sett49;
    @FXML
    private ImageView sett5;
    @FXML
    private ImageView sett50;
    @FXML
    private ImageView sett51;
    @FXML
    private ImageView sett52;
    @FXML
    private ImageView sett53;
    @FXML
    private ImageView sett54;
    @FXML
    private ImageView sett6;
    @FXML
    private ImageView sett7;
    @FXML
    private ImageView sett8;
    @FXML
    private ImageView sett9;
    @FXML
    private ImageView token1;
    @FXML
    private ImageView token10;
    @FXML
    private ImageView token11;
    @FXML
    private ImageView token12;
    @FXML
    private ImageView token13;
    @FXML
    private ImageView token14;
    @FXML
    private ImageView token15;
    @FXML
    private ImageView token16;
    @FXML
    private ImageView token17;
    @FXML
    private ImageView token18;
    @FXML
    private ImageView token19;
    @FXML
    private ImageView token2;
    @FXML
    private ImageView token3;
    @FXML
    private ImageView token4;
    @FXML
    private ImageView token5;
    @FXML
    private ImageView token6;
    @FXML
    private ImageView token7;
    @FXML
    private ImageView token8;
    @FXML
    private ImageView token9;
    private HashMap<Polygon, Tile> tilesBook;
    private HashMap<ImageView, Road> roadsMap;
    private HashMap<ImageView, Settlement> settMap;
    private HashMap<String, Port> portMap;
    private ArrayList<String> portTypes = new ArrayList<>();

    private static boolean canBuildRoad;
    private static boolean canBuildSettlement;

    private static boolean canBuildCity;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tilesBook = new HashMap<>();
        tilesBook.put(tile1, new Tile(tile1, token1));tilesBook.put(tile2, new Tile(tile2, token2));tilesBook.put(tile3, new Tile(tile3, token3));tilesBook.put(tile4, new Tile(tile4, token4));tilesBook.put(tile5, new Tile(tile5, token5));tilesBook.put(tile6, new Tile(tile6, token6));tilesBook.put(tile7, new Tile(tile7, token7));tilesBook.put(tile8, new Tile(tile8, token8));tilesBook.put(tile9, new Tile(tile9, token9));tilesBook.put(tile10, new Tile(tile10, token10));tilesBook.put(tile11, new Tile(tile11, token11));tilesBook.put(tile12, new Tile(tile12, token12));tilesBook.put(tile13, new Tile(tile13, token13));tilesBook.put(tile14, new Tile(tile14, token14));tilesBook.put(tile15, new Tile(tile15, token15));tilesBook.put(tile16, new Tile(tile16, token16));tilesBook.put(tile17, new Tile(tile17, token17));tilesBook.put(tile18, new Tile(tile18, token18));tilesBook.put(tile19, new Tile(tile19, token19));
        settMap = new HashMap<>();
        settMap.put(sett1, new Settlement("settlement", "white", sett1));settMap.put(sett2, new Settlement("settlement", "white", sett2));settMap.put(sett3, new Settlement("settlement", "white", sett3));settMap.put(sett4, new Settlement("settlement", "white", sett4));settMap.put(sett5, new Settlement("settlement", "white", sett5));settMap.put(sett6, new Settlement("settlement", "white", sett6));settMap.put(sett7, new Settlement("settlement", "white", sett7));settMap.put(sett8, new Settlement("settlement", "white", sett8));settMap.put(sett9, new Settlement("settlement", "white", sett9));settMap.put(sett10, new Settlement("settlement", "white", sett10));settMap.put(sett11, new Settlement("settlement", "white", sett11));settMap.put(sett12, new Settlement("settlement", "white", sett12));settMap.put(sett13, new Settlement("settlement", "white", sett13));settMap.put(sett14, new Settlement("settlement", "white", sett14));settMap.put(sett15, new Settlement("settlement", "white", sett15));settMap.put(sett16, new Settlement("settlement", "white", sett16));settMap.put(sett17, new Settlement("settlement", "white", sett17));settMap.put(sett18, new Settlement("settlement", "white", sett18));settMap.put(sett19, new Settlement("settlement", "white", sett19));settMap.put(sett20, new Settlement("settlement", "white", sett20));settMap.put(sett21, new Settlement("settlement", "white", sett21));settMap.put(sett22, new Settlement("settlement", "white", sett22));settMap.put(sett23, new Settlement("settlement", "white", sett23));settMap.put(sett24, new Settlement("settlement", "white", sett24));settMap.put(sett25, new Settlement("settlement", "white", sett25));settMap.put(sett26, new Settlement("settlement", "white", sett26));settMap.put(sett27, new Settlement("settlement", "white", sett27));settMap.put(sett28, new Settlement("settlement", "white", sett28));settMap.put(sett29, new Settlement("settlement", "white", sett29));settMap.put(sett30, new Settlement("settlement", "white", sett30));settMap.put(sett31, new Settlement("settlement", "white", sett31));settMap.put(sett32, new Settlement("settlement", "white", sett32));settMap.put(sett33, new Settlement("settlement", "white", sett33));settMap.put(sett34, new Settlement("settlement", "white", sett34));settMap.put(sett35, new Settlement("settlement", "white", sett35));settMap.put(sett36, new Settlement("settlement", "white", sett36));settMap.put(sett37, new Settlement("settlement", "white", sett37));settMap.put(sett38, new Settlement("settlement", "white", sett38));settMap.put(sett39, new Settlement("settlement", "white", sett39));settMap.put(sett40, new Settlement("settlement", "white", sett40));settMap.put(sett41, new Settlement("settlement", "white", sett41));settMap.put(sett42, new Settlement("settlement", "white", sett42));settMap.put(sett43, new Settlement("settlement", "white", sett43));settMap.put(sett44, new Settlement("settlement", "white", sett44));settMap.put(sett45, new Settlement("settlement", "white", sett45));settMap.put(sett46, new Settlement("settlement", "white", sett46));settMap.put(sett47, new Settlement("settlement", "white", sett47));settMap.put(sett48, new Settlement("settlement", "white", sett48));settMap.put(sett49, new Settlement("settlement", "white", sett49));settMap.put(sett50, new Settlement("settlement", "white", sett50));settMap.put(sett51, new Settlement("settlement", "white", sett51));settMap.put(sett52, new Settlement("settlement", "white", sett52));settMap.put(sett53, new Settlement("settlement", "white", sett53));settMap.put(sett54, new Settlement("settlement", "white", sett54));
        roadsMap = new HashMap<>();
        roadsMap.put(road1, new Road("road", "white", road1));roadsMap.put(road2, new Road("road", "white", road2));roadsMap.put(road3, new Road("road", "white", road3));roadsMap.put(road4, new Road("road", "white", road4));roadsMap.put(road5, new Road("road", "white", road5));roadsMap.put(road6, new Road("road", "white", road6));roadsMap.put(road7, new Road("road", "white", road7));roadsMap.put(road8, new Road("road", "white", road8));roadsMap.put(road9, new Road("road", "white", road9));roadsMap.put(road10, new Road("road", "white", road10));roadsMap.put(road11, new Road("road", "white", road11));roadsMap.put(road12, new Road("road", "white", road12));roadsMap.put(road13, new Road("road", "white", road13));roadsMap.put(road14, new Road("road", "white", road14));roadsMap.put(road15, new Road("road", "white", road15));roadsMap.put(road16, new Road("road", "white", road16));roadsMap.put(road17, new Road("road", "white", road17));roadsMap.put(road18, new Road("road", "white", road18));roadsMap.put(road19, new Road("road", "white", road19));roadsMap.put(road20, new Road("road", "white", road20));roadsMap.put(road21, new Road("road", "white", road21));roadsMap.put(road22, new Road("road", "white", road22));roadsMap.put(road23, new Road("road", "white", road23));roadsMap.put(road24, new Road("road", "white", road24));roadsMap.put(road25, new Road("road", "white", road25));roadsMap.put(road26, new Road("road", "white", road26));roadsMap.put(road27, new Road("road", "white", road27));roadsMap.put(road28, new Road("road", "white", road28));roadsMap.put(road29, new Road("road", "white", road29));roadsMap.put(road30, new Road("road", "white", road30));roadsMap.put(road31, new Road("road", "white", road31));roadsMap.put(road32, new Road("road", "white", road32));roadsMap.put(road33, new Road("road", "white", road33));roadsMap.put(road34, new Road("road", "white", road34));roadsMap.put(road35, new Road("road", "white", road35));roadsMap.put(road36, new Road("road", "white", road36));roadsMap.put(road37, new Road("road", "white", road37));roadsMap.put(road38, new Road("road", "white", road38));roadsMap.put(road39, new Road("road", "white", road39));roadsMap.put(road40, new Road("road", "white", road40));roadsMap.put(road41, new Road("road", "white", road41));roadsMap.put(road42, new Road("road", "white", road42));roadsMap.put(road43, new Road("road", "white", road43));roadsMap.put(road44, new Road("road", "white", road44));roadsMap.put(road45, new Road("road", "white", road45));roadsMap.put(road46, new Road("road", "white", road46));roadsMap.put(road47, new Road("road", "white", road47));roadsMap.put(road48, new Road("road", "white", road48));roadsMap.put(road49, new Road("road", "white", road49));roadsMap.put(road50, new Road("road", "white", road50));roadsMap.put(road52, new Road("road", "white", road52));roadsMap.put(road53, new Road("road", "white", road53));roadsMap.put(road54, new Road("road", "white", road54));roadsMap.put(road55, new Road("road", "white", road55));roadsMap.put(road56, new Road("road", "white", road56));roadsMap.put(road57, new Road("road", "white", road57));roadsMap.put(road58, new Road("road", "white", road58));roadsMap.put(road59, new Road("road", "white", road59));roadsMap.put(road60, new Road("road", "white", road60));roadsMap.put(road61, new Road("road", "white", road61));roadsMap.put(road62, new Road("road", "white", road62));roadsMap.put(road63, new Road("road", "white", road63));roadsMap.put(road64, new Road("road", "white", road64));roadsMap.put(road65, new Road("road", "white", road65));roadsMap.put(road66, new Road("road", "white", road66));roadsMap.put(road67, new Road("road", "white", road67));roadsMap.put(road68, new Road("road", "white", road68));roadsMap.put(road69, new Road("road", "white", road69));roadsMap.put(road70, new Road("road", "white", road70));roadsMap.put(road71, new Road("road", "white", road71));roadsMap.put(road72, new Road("road", "white", road72));roadsMap.put(road51, new Road("road", "white", road51));
        portMap = new HashMap<>();
        portTypes.addAll(List.of(new String[]{"brick", "ore", "grain", "lumber", "wool", "port", "port", "port", "port"}));
        Collections.shuffle(portTypes);
        portMap.put(portTypes.get(0), new Port(portTypes.get(0), port1, portImg1));portMap.put(portTypes.get(1), new Port(portTypes.get(1), port2, portImg2));portMap.put(portTypes.get(2), new Port(portTypes.get(2), port3, portImg3));portMap.put(portTypes.get(3), new Port(portTypes.get(3), port4, portImg4));portMap.put(portTypes.get(4), new Port(portTypes.get(4), port5, portImg5));portMap.put(portTypes.get(5), new Port(portTypes.get(5), port6, portImg6));portMap.put(portTypes.get(6), new Port(portTypes.get(6), port7, portImg7));portMap.put(portTypes.get(7), new Port(portTypes.get(7), port8, portImg8));portMap.put(portTypes.get(8), new Port(portTypes.get(8), port9, portImg9));
        GameState.portsMap = portMap;
        GameState.setRoadMap(roadsMap);
        GameState.tilesBook = new ArrayList<>(tilesBook.values());
        GameState.setts = new ArrayList<>(settMap.values());

        for(Tile t: tilesBook.values()){
            Polygon p = t.getPoly();
            for(Structure s: roadsMap.values()){
                if(p.getBoundsInParent().intersects(s.getImage().getBoundsInParent())){
                    t.addEdges(s);
                }
            }
            for(Structure s: settMap.values()){
                if(s.getImage().getBoundsInParent().intersects(p.getBoundsInParent())){
                    t.addVertex(s);
                }
            }
        }
        canBuildRoad = false; canBuildSettlement = false; canBuildCity = false;
        for(Tile t: tilesBook.values()){
            if(t.getVertices().size()!=6){
                System.out.println(t.getVertices().size());
            }
        }
    }

    @FXML
    public void highlightRoad(MouseEvent mouseEvent) {
        ImageView img = (ImageView)mouseEvent.getSource();
        if((!roadsMap.get(img).isVisible() && canBuildRoad && GameState.canPlaceRoad(roadsMap.get(img))) ||
                (!roadsMap.get(img).isVisible() && (GameState.usedRB1  || GameState.usedRB2) && GameState.canPlaceRoad(roadsMap.get(img)))){
            img.setImage(new Image(GameBoardController.class.getResource("/Assets/Road/white.png").toExternalForm()));
        }
        else if(!roadsMap.get(img).isVisible() && GameState.roundZeroBuildRoad && GameState.roundZeroRoadLogic(img)){
            img.setImage(new Image(GameBoardController.class.getResource("/Assets/Road/white.png").toExternalForm()));
        }
    }

    @FXML
    public void stopHighlightRoad(MouseEvent mouseEvent) {
        ImageView img = (ImageView)mouseEvent.getSource();
        if(!roadsMap.get(img).isVisible()){
            img.setImage(new Image(GameBoardController.class.getResource("/Assets/Empty.png").toExternalForm()));
        }
    }

    @FXML
    void buildRoad(MouseEvent event) {
        ImageView img = (ImageView)event.getSource();
        if((!roadsMap.get(img).isVisible() && canBuildRoad && GameState.canPlaceRoad(roadsMap.get(img))) ||
                (!roadsMap.get(img).isVisible() && (GameState.usedRB1 || GameState.usedRB2) && GameState.canPlaceRoad(roadsMap.get(img)))){
            GameState.buildRoad();
            roadsMap.get(img).setColor(GameState.getAllPlayers().get(GameState.turnNumber).getColor());
            roadsMap.get(img).setVisible(true);
            GameState.getAllPlayers().get(GameState.turnNumber).addRoad(roadsMap.get(img));
            canBuildRoad = false;
            GameState.usedRB1 = false;
            GameState.rbControl += 1;
            if(GameState.rbControl == 2){
                GameState.usedRB2 = false;
                GameState.rbControl = 0;
            }
        }
        if(!roadsMap.get(img).isVisible() && GameState.roundZeroBuildRoad && GameState.roundZeroRoadLogic(img)){
            roadsMap.get(img).setVisible(true);
            roadsMap.get(img).setColor(GameState.getAllPlayers().get(GameState.turnNumber).getColor());
            GameState.getAllPlayers().get(GameState.turnNumber).addRoad(roadsMap.get(img));
            GameState.buildRoad();
        }
    }

    @FXML
    void noShowSettlement(MouseEvent event) {
        ImageView img = (ImageView)event.getSource();
        if(!settMap.get(img).isVisible()){
            img.setImage(new Image(GameBoardController.class.getResource("/Assets/Empty.png").toExternalForm()));
        }
        else if(settMap.get(img).isVisible() && (canBuildCity) && GameState.getAllPlayers().get(GameState.turnNumber).getSettlements().contains(settMap.get(img)))
            img.setImage(new Image(GameBoardController.class.getResource("/Assets/Settlement/"+GameState.getAllPlayers().get(GameState.turnNumber).getColor().toLowerCase()+".png").toExternalForm()));
    }

    @FXML
    void showSettlement(MouseEvent event) {
        ImageView img = (ImageView)event.getSource();
        if(!settMap.get(img).isVisible() && ((canBuildSettlement && GameState.canBuildSettlementLocation(img))||(GameState.roundZeroBuildSettlement&&GameState.roundZeroSettlementLogic(settMap.get(img))))){
            img.setImage(new Image(GameBoardController.class.getResource("/Assets/Settlement/white.png").toExternalForm()));
        }
        else if(settMap.get(img).isVisible() && (canBuildCity) && GameState.getAllPlayers().get(GameState.turnNumber).getSettlements().contains(settMap.get(img)))
            img.setImage(new Image(GameBoardController.class.getResource("/Assets/City/"+GameState.getAllPlayers().get(GameState.turnNumber).getColor().toLowerCase()+".png").toExternalForm()));
    }

    @FXML
    void buildSettlement(MouseEvent event) {
        ImageView img = (ImageView)event.getSource();
        if(((canBuildSettlement&&GameState.canBuildSettlementLocation(img)) || (GameState.roundZeroBuildSettlement&&GameState.roundZeroSettlementLogic(settMap.get(img)))) && !settMap.get(img).isVisible()){
            settMap.get(img).setVisible(true);
            settMap.get(img).setColor(GameState.getAllPlayers().get(GameState.turnNumber).getColor());
            GameState.getAllPlayers().get(GameState.turnNumber).addSett(settMap.get(img));
            GameState.buildSettlement();
            canBuildSettlement = false;
            if(!GameState.roundZero){
                GameState.getAllPlayers().get(GameState.turnNumber).setPoints(1);
            }
        }

        else if(settMap.get(img).isVisible() && (canBuildCity) && GameState.getAllPlayers().get(GameState.turnNumber).getSettlements().contains(settMap.get(img))) {
            GameState.getAllPlayers().get(GameState.turnNumber).upgradeStruct(settMap.get(img));
            canBuildCity = false;
            GameState.buildCity();
        }

    }

    @FXML
    void highlightThief(MouseEvent event) {
        if(GameState.rollSeven || GameState.usedKnight){
            ImageView img = (ImageView) event.getSource();
            Token.tokensMap.get(img).setThief(true);
        }
    }

    public void unHighlightThief(MouseEvent mouseEvent) {
        if(GameState.rollSeven || GameState.usedKnight){
            ImageView img = (ImageView) mouseEvent.getSource();
            if(Token.tokensMap.get(img).getNumber()!=-1){
                Token.tokensMap.get(img).setThief(false);
            }
        }
    }

    public void moveThief(MouseEvent mouseEvent) {
        if(GameState.rollSeven || GameState.usedKnight){
            for (Token t : Token.tokensMap.values()) {
                if (t.isThief()) {
                    t.setThief(false);
                }
            }
            ImageView img = (ImageView) mouseEvent.getSource();
            if(Token.tokensMap.get(img).getNumber()!=-1){
                Token.tokensMap.get(img).setThief(true);
                GameState.rollSeven = false;
                GameState.usedKnight = false;
                GameState.rollSeven();
                GameState.checkLargestArmy(GameState.getAllPlayers().get(GameState.turnNumber));
            }
        }
    }


    public static void setCanBuildRoad(){
        canBuildRoad = true;
    }
    public static void setCanBuildSettlement(){
        canBuildSettlement = true;
    }

    public static void setCanBuildCity() {
        canBuildCity = true;
    }

}