package com.example.catanfx.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class helpMenuController {
    @FXML
    private Button nButton;

    @FXML
    private Button pButton;

    @FXML

        ImageView myImageView;
        Button myButton;

        Image myImage = new Image(getClass().getResourceAsStream("src/main/resources/Assets/Images/0004.jpg"));

         public void displayImage () {
            myImageView.setImage(myImage);
        }


    @FXML
    void previousPage(ActionEvent event) {

    }

    @FXML
    void initialize() {
    }
}


