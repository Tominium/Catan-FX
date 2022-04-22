package com.example.catanfx.Controllers;

import com.example.catanfx.GamePieces.Cards.ResourceCard;
import com.example.catanfx.GamePieces.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class tradeController implements Initializable {

    public static Player sel;
    @FXML
    private ImageView card1;

    @FXML
    private ImageView card2;

    @FXML
    private ImageView card3;

    @FXML
    private ImageView card4;

    @FXML
    private ImageView card5;

    @FXML
    private ComboBox<?> cb1;

    @FXML
    private ComboBox<?> cb2;

    @FXML
    private ComboBox<?> cb3;

    @FXML
    private ComboBox<?> cb4;

    @FXML
    private ComboBox<?> cb5;

    @FXML
    private Button next;

    @FXML
    private RadioButton p1;

    @FXML
    private RadioButton p2;

    @FXML
    private RadioButton p3;

    @FXML
    private RadioButton p4;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    void choosePlayer(ActionEvent event) {

    }

    public static void selectedPlayer(Player p){
        sel = p;
    }

    public void showCards(ArrayList<ResourceCard> arr){
        if(Collections.frequency(arr, new ResourceCard("brick"))>0){
        }
    }
}
