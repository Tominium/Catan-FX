package com.example.catanfx.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InventoryController {
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void goToInventory(ActionEvent e) throws IOException {
        root = FXMLLoader.load(InventoryController.class.getResource("playerInventory.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void exitInventory(ActionEvent e) throws IOException {
        root = FXMLLoader.load(InventoryController.class.getResource("gameBoard.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
