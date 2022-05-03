package com.example.catanfx.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class GameBoardGraphicController {
    @FXML
    private AnchorPane anchorPane1;
   @FXML
    private AnchorPane anchorPane2;
   @FXML
    private AnchorPane anchorPane3;

    public void initialize() {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("test.fxml"));
//        Parent root = loader.load();
//        TestController controller = loader.<TestController>getController();
//        controller.setData(data);
    }

    public AnchorPane getAP1() {
        return anchorPane1;
    }

    public AnchorPane getAP3() {
        return anchorPane3;
    }




}
