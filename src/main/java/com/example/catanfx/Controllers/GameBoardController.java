package com.example.catanfx.Controllers;

import com.example.catanfx.GamePieces.Structures.Road;
import com.example.catanfx.GamePieces.Tile;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class GameBoardController implements Initializable {

    private ArrayList<Tile> tilesBook;

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

    private ArrayList<Road> roadsMap;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tilesBook = new ArrayList<>();
        tilesBook.add(new Tile(tile1));tilesBook.add(new Tile(tile2));tilesBook.add(new Tile(tile3));tilesBook.add(new Tile(tile4));tilesBook.add(new Tile(tile5));tilesBook.add(new Tile(tile6));tilesBook.add(new Tile(tile7));tilesBook.add(new Tile(tile8));tilesBook.add(new Tile(tile9));tilesBook.add(new Tile(tile10));tilesBook.add(new Tile(tile11));tilesBook.add(new Tile(tile12));tilesBook.add(new Tile(tile13));tilesBook.add(new Tile(tile14));tilesBook.add(new Tile(tile15));tilesBook.add(new Tile(tile16));tilesBook.add(new Tile(tile17));tilesBook.add(new Tile(tile18));tilesBook.add(new Tile(tile19));
        roadsMap = new ArrayList<>();
        roadsMap.add(new Road("road", "white", road1));
    }

    public void highlightRoad(MouseEvent mouseEvent) {
        ImageView img = (ImageView)mouseEvent.getSource();
        img.setImage(new Image(GameBoardController.class.getResource("/Assets/Road/white.png").toExternalForm()));
    }

    public void stopHighlightRoad(MouseEvent mouseEvent) {
        ImageView img = (ImageView)mouseEvent.getSource();
        img.setImage(new Image(GameBoardController.class.getResource("/Assets/Empty.png").toExternalForm()));
    }
}
