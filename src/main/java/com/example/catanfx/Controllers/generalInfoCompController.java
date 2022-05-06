package com.example.catanfx.Controllers;

import com.example.catanfx.GamePieces.Cards.DevelopmentDeck;
import com.example.catanfx.GamePieces.GameState;
import com.example.catanfx.GamePieces.HelpMenu;
import com.example.catanfx.GamePieces.Misc.Dice;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class generalInfoCompController {

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
    void openTrade(ActionEvent event) {
        String[] arrayData = {"Domestic Trade", "Maritime Trade"};
        List<String> dialogData = Arrays.asList(arrayData);

        ChoiceDialog dialog = new ChoiceDialog(dialogData.get(0), dialogData);
        dialog.setGraphic(null);
        dialog.setTitle("Trading");
        dialog.setHeaderText("Select Trade Type");

        Optional<String> result = dialog.showAndWait();
        if(result.get().equals("Domestic Trade")){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/catanfx/tradePanel.fxml"));
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

    @FXML
    void rollDice(MouseEvent event) {
        if(GameState.roundZeroBuildRoad || GameState.roundZeroBuildSettlement){}
        else{
            int[] arr = Dice.rollDice();
            dice1.setImage(new Image(generalInfoCompController.class.getResource("/Assets/Dice/" + arr[0] + ".png").toExternalForm()));
            dice2.setImage(new Image(generalInfoCompController.class.getResource("/Assets/Dice/" + arr[1] + ".png").toExternalForm()));
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
//        if (result.get().equals("City")) {
//            if (GameState.canBuild((result.get().toLowerCase()))) {
//                GameBoardController.setCanBuildSettlement();
//            } else {
//                if(GameState.getAllPlayers().get(GameState.turnNumber).getSettlements().size() ==5){
//                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                    alert.setTitle("Error");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Maximum Amount Of " + result.get() + "s Built!");
//                    alert.showAndWait();
//                }
//                else{
//                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                    alert.setTitle("Error");
//                    alert.setHeaderText(null);
//                    alert.setContentText("Not Enough Resources to Build " + result.get() + "!");
//                    alert.showAndWait();
//                }
//            }
//        }
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
        GameState.iterateTurn();
    }

    @FXML
    void next(ActionEvent event) {
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
    @FXML
    void openHelp(MouseEvent event) {
        new HelpMenu();
    }
}
