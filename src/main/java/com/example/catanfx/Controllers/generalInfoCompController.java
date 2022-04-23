package com.example.catanfx.Controllers;

import com.example.catanfx.GamePieces.GameState;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class generalInfoCompController {

    @FXML
    private Button tradeButton;

    @FXML
    void openTrade(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/catanfx/tradePanel.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.showAndWait();
            GameState.trade(tradeController.sel, tradeController.getTrade()[0], tradeController.getTrade()[1]);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
