package com.example.catanfx.Controllers;

import com.example.catanfx.GamePieces.Cards.DevelopmentCard;
import com.example.catanfx.GamePieces.Cards.ResourceCard;
import com.example.catanfx.GamePieces.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class InventoryController implements Initializable {

    @FXML
    private Button X;

    @FXML
    private AnchorPane pane;

    @FXML
    private Label brickCount;

    @FXML
    private Label grainCount;

    @FXML
    private Label lumberCount;

    @FXML
    private Label oreCount;

    @FXML
    private Label woolCount;

    @FXML
    private Label knightCount;

    @FXML
    private Label monopolyCount;

    @FXML
    private Label YoPCount;

    Stage stage;

    private static Player p;

    public void exitInventory(ActionEvent e) throws IOException {
        stage = (Stage)pane.getScene().getWindow();
        stage.close();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        brickCount.setText(Collections.frequency(p.getRC(), new ResourceCard("brick")) + "x");
        grainCount.setText(Collections.frequency(p.getRC(), new ResourceCard("grain")) + "x");
        lumberCount.setText(Collections.frequency(p.getRC(), new ResourceCard("lumber")) + "x");
        oreCount.setText(Collections.frequency(p.getRC(), new ResourceCard("ore")) + "x");
        woolCount.setText(Collections.frequency(p.getRC(), new ResourceCard("wool")) + "x");
        knightCount.setText(Collections.frequency(p.getDC(), new DevelopmentCard("knight")) + "x");
        monopolyCount.setText(Collections.frequency(p.getDC(), new DevelopmentCard("monopoly")) + "x");
        YoPCount.setText(Collections.frequency(p.getDC(), new DevelopmentCard("yearofplenty")) + "x");
    }

    public static void selectPlayer(Player pp){
        p = pp;
    }
}
