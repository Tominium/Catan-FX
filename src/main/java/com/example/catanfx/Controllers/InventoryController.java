package com.example.catanfx.Controllers;

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
import java.util.LinkedList;
import java.util.ResourceBundle;

public class InventoryController implements Initializable {

    @FXML
    private Button X;

    @FXML
    private AnchorPane pane;

    @FXML
    private GridPane pics;

    Stage stage;

    public void exitInventory(ActionEvent e) throws IOException {
        stage = (Stage)pane.getScene().getWindow();
        stage.close();
    }

    public static void updateInventory(){
        //LinkedList<ResourceCard> hand = p.getRC();
//        int index = 0;
//        for(int i = 0; i < 5; i++){
//            for(int j = 0; j < 4; j++){
//                if(hand.get(index).getFront() != null) {
//                    IVpics.add(hand.get(index).getFront(), i, j);
//                    index++;
//                }
//                else{
//                    break;
//                }
//            }
//        }
//        System.out.println("bruh");



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image(InventoryController.class.getResource("/Assets/Resource_Cards/brick.png").toExternalForm());
        ImageView iv = new ImageView(image);
        iv.setFitHeight(20);
        iv.setFitWidth(30);
        pics.add(iv, 0, 0);
        Image image2 = new Image(InventoryController.class.getResource("/Assets/Resource_Cards/brick.png").toExternalForm());
        ImageView iv2 = new ImageView(image);
        iv.setFitHeight(20);
        iv.setFitWidth(30);
        pics.add(iv2, 0 ,1);
        System.out.println("So this works huh");

    }
}
