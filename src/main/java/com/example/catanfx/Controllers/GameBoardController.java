package com.example.catanfx.Controllers;

import com.example.catanfx.GamePieces.Tile;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;

import java.net.URL;
import java.util.ArrayList;
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tilesBook = new ArrayList<>();
        tilesBook.add(new Tile(tile1));tilesBook.add(new Tile(tile2));tilesBook.add(new Tile(tile3));tilesBook.add(new Tile(tile4));tilesBook.add(new Tile(tile5));tilesBook.add(new Tile(tile6));tilesBook.add(new Tile(tile7));tilesBook.add(new Tile(tile8));tilesBook.add(new Tile(tile9));tilesBook.add(new Tile(tile10));tilesBook.add(new Tile(tile11));tilesBook.add(new Tile(tile12));tilesBook.add(new Tile(tile13));tilesBook.add(new Tile(tile14));tilesBook.add(new Tile(tile15));tilesBook.add(new Tile(tile16));tilesBook.add(new Tile(tile17));tilesBook.add(new Tile(tile18));tilesBook.add(new Tile(tile19));
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
