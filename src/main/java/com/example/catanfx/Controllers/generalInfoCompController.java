package com.example.catanfx.Controllers;

import com.example.catanfx.GamePieces.Cards.DevelopmentDeck;
import com.example.catanfx.GamePieces.Cards.ResourceDeck;
import com.example.catanfx.GamePieces.GameState;
import com.example.catanfx.GamePieces.HelpMenu;
import com.example.catanfx.GamePieces.Misc.Dice;
import com.example.catanfx.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class generalInfoCompController implements Initializable {

    @FXML
    private Button buildButton;
    @FXML
    private Button buyButton;
    @FXML
    private Group dice;
    @FXML
    private ImageView dice1;
    @FXML
    private ImageView dice2;
    @FXML
    private ImageView help;
    @FXML
    private Button nextButton;
    @FXML
    private Button passDiceButton;
    @FXML
    private Button tradeButton;
    @FXML
    private ImageView brick;
    @FXML
    private ImageView grain;
    @FXML
    private ImageView lumber;
    @FXML
    private ImageView wool;
    @FXML
    private ImageView ore;
    @FXML
    private ImageView devCard;
    @FXML
    private AnchorPane pane;

    @FXML
    private Text text1;
    @FXML
    private Text text2;
    @FXML
    private Text text3;
    @FXML
    private Text text4;
    @FXML
    private Text text5;






    @FXML
    void openTrade(ActionEvent event) {

        if(GameState.rollSeven){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Move The Thief First!");
            alert.showAndWait();
        }

        else{
            String[] arrayData = {"Domestic Trade", "Maritime Trade"};
            List<String> dialogData = Arrays.asList(arrayData);

            ChoiceDialog dialog = new ChoiceDialog(dialogData.get(0), dialogData);
            dialog.setGraphic(null);
            dialog.setTitle("Trading");
            dialog.setHeaderText("Select Trade Type");

            Optional<String> result = dialog.showAndWait();
            if (!result.isEmpty()) {
                if (result.get().equals("Domestic Trade")) {
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(generalInfoCompController.class.getClassLoader().getResource("com/example/catanfx/tradePanel.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root1));
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setResizable(false);
                        stage.showAndWait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (result.get().equals("Maritime Trade")) {
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(generalInfoCompController.class.getClassLoader().getResource("com/example/catanfx/MaritimeTrade.fxml"));
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
        }
    }

    @FXML
    void rollDice(MouseEvent event) {
        if(GameState.roundZeroBuildRoad || GameState.roundZeroBuildSettlement){}
        else{
            int[] arr = Dice.rollDice();
            dice1.setImage(new Image(generalInfoCompController.class.getClassLoader().getResource("Assets/Dice/" + arr[0] + ".png").toExternalForm()));
            dice2.setImage(new Image(generalInfoCompController.class.getClassLoader().getResource("Assets/Dice/" + arr[1] + ".png").toExternalForm()));
            if (!GameState.roundZeroRollDice) {
                dice.setDisable(true);
                tradeButton.setVisible(true);
                tradeButton.setDisable(false);
                nextButton.setDisable(false);
                nextButton.setVisible(true);
            } else {
                GameState.roundZeroRollDiceDice(Dice.getRolledNum());
            }
        }
        check();
    }

    @FXML
    void build(ActionEvent event) {
        String[] arrayData = {"Road", "Settlement", "City"};
        List<String> dialogData = Arrays.asList(arrayData);

        ChoiceDialog dialog = new ChoiceDialog(dialogData.get(0), dialogData);
        dialog.setGraphic(null);
        dialog.setTitle("Building");
        dialog.setHeaderText("Select Structure To Build");

        Optional<String> result = dialog.showAndWait();

        if (result.get().equals("Road")) {
            if (GameState.canBuild((result.get().toLowerCase()))) {
                GameBoardController.setCanBuildRoad();
            } else {
                if(GameState.getAllPlayers().get(GameState.turnNumber).getRoads().size() ==15){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Maximum Amount Of " + result.get() + "s Built!");
                    alert.showAndWait();
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Not Enough Resources to Build " + result.get() + "!");
                    alert.showAndWait();
                }
            }
        }
        if (result.get().equals("Settlement")) {
            if (GameState.canBuild((result.get().toLowerCase()))) {
                GameBoardController.setCanBuildSettlement();
            } else {
                if(GameState.getAllPlayers().get(GameState.turnNumber).getSettlements().size() ==5){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Maximum Amount Of " + result.get() + "s Built!");
                    alert.showAndWait();
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Not Enough Resources to Build " + result.get() + "!");
                    alert.showAndWait();
                }
            }
        }
        if (result.get().equals("City")) {
            if (GameState.canBuild((result.get().toLowerCase()))) {
                GameBoardController.setCanBuildCity();
            } else {
                if(GameState.getAllPlayers().get(GameState.turnNumber).getCities().size() ==4){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Maximum Amount Of " + result.get() + "s Built!");
                    alert.showAndWait();
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Not Enough Resources to Build " + result.get() + "!");
                    alert.showAndWait();
                }
            }
        }
    }

    @FXML
    void buyCard(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setContentText("Please Confirm Your Purchase of A Development Card");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            if(GameState.check(GameState.getAllPlayers().get(GameState.turnNumber))) {
                if(DevelopmentDeck.deck.size() != 0) {
                    GameState.buyDC(GameState.getAllPlayers().get(GameState.turnNumber));
                    if(GameState.checkWin()!=-1){
                        Alert alert4 = new Alert(Alert.AlertType.INFORMATION);
                        alert4.setTitle("Game Over");
                        alert4.setHeaderText(null);
                        alert4.setContentText("Game Over! Player " + (GameState.checkWin()+1) + " won!");
                        alert4.showAndWait();
                        HelloApplication.primaryStage.close();
                    }
                }
                else{
                    Alert alert3 = new Alert(Alert.AlertType.INFORMATION);
                    alert3.setTitle("Error");
                    alert3.setHeaderText(null);
                    alert3.setContentText("There are no more Development Cards Left in the Deck!");
                    alert3.showAndWait();
                }
            }
            else{
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Error");
                alert2.setHeaderText(null);
                alert2.setContentText("Not Enough Resources to Buy a Development Card");
                alert2.showAndWait();
            }
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }

    @FXML
    void passDice(ActionEvent event) {
        buildButton.setVisible(false);
        buildButton.setDisable(true);
        buyButton.setVisible(false);
        buyButton.setDisable(true);
        passDiceButton.setVisible(false);
        passDiceButton.setDisable(true);
        dice.setDisable(false);
        GameState.oldCard(GameState.getAllPlayers().get(GameState.turnNumber));
        GameState.iterateTurn();
        if(GameState.checkWin()!=-1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Over");
            alert.setHeaderText(null);
            alert.setContentText("Game Over! Player " + (GameState.checkWin()+1) + " won!");
            alert.showAndWait();
            HelloApplication.primaryStage.close();
        }
    }

    @FXML
    void next(ActionEvent event) {

        if(GameState.rollSeven){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Move The Thief First!");
            alert.showAndWait();
        }

        else{
            tradeButton.setVisible(false);
            tradeButton.setDisable(true);
            nextButton.setVisible(false);
            nextButton.setDisable(true);
            buildButton.setVisible(true);
            buildButton.setDisable(false);
            buyButton.setVisible(true);
            buyButton.setDisable(false);
            passDiceButton.setVisible(true);
            passDiceButton.setDisable(false);
        }
    }
    @FXML
    void openHelp(MouseEvent event) {
        new HelpMenu();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        text1.setText(ResourceDeck.getSize("brick") + "/19");
        text2.setText(ResourceDeck.getSize("grain") + "/19");
        text3.setText(ResourceDeck.getSize("lumber") + "/19");
        text4.setText(ResourceDeck.getSize("ore") + "/19");
        text5.setText(ResourceDeck.getSize("wool") + "/19");
    }

    public void check(){
        if(ResourceDeck.isEmpty("brick")){
            brick.setVisible(false);
            text1.setVisible(false);
        }
        else{
            brick.setVisible(true);
            text1.setText(ResourceDeck.getSize("brick") + "/19");
        }
        if(ResourceDeck.isEmpty("grain")){
            grain.setVisible(false);
            text2.setVisible(false);
        }
        else{
            grain.setVisible(true);
            text2.setText(ResourceDeck.getSize("grain") + "/19");
        }
        if(ResourceDeck.isEmpty("wool")){
            wool.setVisible(false);
            text5.setVisible(false);
        }
        else{
            wool.setVisible(true);
            text5.setText(ResourceDeck.getSize("wool") + "/19");
        }
        if(ResourceDeck.isEmpty("ore")){
            ore.setVisible(false);
            text4.setVisible(false);
        }
        else{
            ore.setVisible(true);
            text4.setText(ResourceDeck.getSize("ore") + "/19");
        }
        if(ResourceDeck.isEmpty("lumber")){
            lumber.setVisible(false);
            text3.setVisible(false);
        }
        else{
            lumber.setVisible(true);
            text3.setText(ResourceDeck.getSize("lumber") + "/19");
        }
        if(DevelopmentDeck.isEmpty()){
            devCard.setVisible(false);
        }
    }
}
