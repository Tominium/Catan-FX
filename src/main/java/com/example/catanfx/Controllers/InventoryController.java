package com.example.catanfx.Controllers;

import com.example.catanfx.GamePieces.Cards.DevelopmentCard;
import com.example.catanfx.GamePieces.Cards.ResourceCard;
import com.example.catanfx.GamePieces.GameState;
import com.example.catanfx.GamePieces.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class InventoryController implements Initializable {

    @FXML
    private Button X;

    @FXML
    private Button useKnight;

    @FXML
    private Button useMonopoly;

    @FXML
    private Button useYoP;

    @FXML
    private Button useRB;

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

    @FXML
    private Label VPCount;

    @FXML
    private Label roadBuildingCount;

    Stage stage;

    private static Player p;

    public void exitInventory(ActionEvent e) throws IOException {
        stage = (Stage)pane.getScene().getWindow();
        stage.close();
    }

    public void UseKnightDC(){
        if(GameState.turnNumber != GameState.getAllPlayers().indexOf(p)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Unable to use a Development Card during someone else's turn");

            alert.show();
        }
        else if(Collections.frequency(p.getDC(), new DevelopmentCard("knight")) == 0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("You do not have enough!");

            alert.show();
        }
        else if(GameState.newCard(p, "knight")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("You just bought this card!");

            alert.show();
        }
        else{
            stage = (Stage) pane.getScene().getWindow();
            stage.close();
            GameState.Knight();
            p.playedKnight();
            p.removeDCard(new DevelopmentCard("knight"));
        }
    }

    public void UseMonopolyDC(){
        if(GameState.turnNumber != GameState.getAllPlayers().indexOf(p)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Unable to use a Development Card during someone else's turn");

            alert.show();
        }
        else if(Collections.frequency(p.getDC(), new DevelopmentCard("monopoly")) == 0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("You do not have enough!");

            alert.show();
        }
        else if(GameState.newCard(p, "monopoly")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("You just bought this card!");

            alert.show();
        }
        else {
            stage = (Stage) pane.getScene().getWindow();
            stage.close();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(InventoryController.class.getClassLoader().getResource("com/example/catanfx/monopoly.fxml"));
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
    }

    public void UseYoPDC(){
        if(GameState.turnNumber != GameState.getAllPlayers().indexOf(p)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Unable to use a Development Card during someone else's turn");

            alert.show();
        }
        else if(Collections.frequency(p.getDC(), new DevelopmentCard("yearofplenty")) == 0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("You do not have enough!");

            alert.show();
        }
        else if(GameState.newCard(p, "yearofplenty")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("You just bought this card!");

            alert.show();
        }
        else {
            stage = (Stage) pane.getScene().getWindow();
            stage.close();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(InventoryController.class.getClassLoader().getResource("com/example/catanfx/YearOfPlenty.fxml"));
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
    }

    public void useRBDC(){
        if(GameState.turnNumber != GameState.getAllPlayers().indexOf(p)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Unable to use a Development Card during someone else's turn");

            alert.show();
        }
        else if(Collections.frequency(p.getDC(), new DevelopmentCard("roadbuilding")) == 0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("You do not have enough!");

            alert.show();
        }
        else if(GameState.newCard(p, "roadbuilding")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("You just bought this card!");

            alert.show();
        }
        else{
            stage = (Stage) pane.getScene().getWindow();
            stage.close();
            GameState.roadBuilding();
            p.removeDCard(new DevelopmentCard("roadbuilding"));
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        brickCount.setText(Collections.frequency(p.getRC(), new ResourceCard("brick")) + "x");
        grainCount.setText(Collections.frequency(p.getRC(), new ResourceCard("grain")) + "x");
        lumberCount.setText(Collections.frequency(p.getRC(), new ResourceCard("lumber")) + "x");
        oreCount.setText(Collections.frequency(p.getRC(), new ResourceCard("ore")) + "x");
        woolCount.setText(Collections.frequency(p.getRC(), new ResourceCard("wool")) + "x");
        roadBuildingCount.setText(Collections.frequency(p.getDC(), new DevelopmentCard("roadbuilding")) + "x");
        knightCount.setText(Collections.frequency(p.getDC(), new DevelopmentCard("knight")) + "x");
        monopolyCount.setText(Collections.frequency(p.getDC(), new DevelopmentCard("monopoly")) + "x");
        YoPCount.setText(Collections.frequency(p.getDC(), new DevelopmentCard("yearofplenty")) + "x");
        VPCount.setText(Collections.frequency(p.getDC(), new DevelopmentCard("victorypoint")) + "x");
    }

    public static void selectPlayer(Player pp){
        p = pp;
    }

}
