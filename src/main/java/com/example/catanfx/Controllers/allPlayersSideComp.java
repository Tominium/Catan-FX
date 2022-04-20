package com.example.catanfx.Controllers;
import com.example.catanfx.GamePieces.GameState;
import com.example.catanfx.GamePieces.Player;
import com.example.catanfx.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class allPlayersSideComp implements Initializable {

    @FXML
    private Pane pane3;
    @FXML
    private Rectangle rect0;
    @FXML
    private Rectangle rect1;
    @FXML
    private Rectangle rect2;
    @FXML
    private Rectangle rect3;
    @FXML
    private TextArea textArea0;
    @FXML
    private TextArea textArea1;
    @FXML
    private TextArea textArea2;
    @FXML
    private TextArea textArea3;
    @FXML
    private Button inventory0;
    @FXML
    private Button inventory1;
    @FXML
    private Button inventory2;
    @FXML
    private Button inventory3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       if(GameState.getAllPlayers().size()==3){pane3.setDisable(true);pane3.setVisible(false);}
       updatePane0();
       updatePane1();
       updatePane2();
       if(pane3.isVisible()){updatePane3();}
    }

    public void updatePane0(){
        Player p = GameState.getAllPlayers().get(0);
        switch(p.getColor().toLowerCase()){
            case "blue":
                rect0.setFill(Color.rgb(30, 144, 255));
                break;
            case "green":
                rect0.setFill(Color.rgb(11, 242, 36));
                break;
            case "orange":
                rect0.setFill(Color.rgb(246, 126, 21));
                break;
            case "red":
                rect0.setFill(Color.rgb(225, 0, 0));
                break;
        }
        String text = "Resource Cards: " + p.getRC().size() + "\n" + "Development Cards: " + p.getDC().size() + "\n" + "Points: " + p.getPoints();
        textArea0.setText(text);
    }

    public void updatePane1(){
        Player p = GameState.getAllPlayers().get(1);
        switch(p.getColor().toLowerCase()){
            case "blue":
                rect1.setFill(Color.rgb(30, 144, 255));
                break;
            case "green":
                rect1.setFill(Color.rgb(11, 242, 36));
                break;
            case "orange":
                rect1.setFill(Color.rgb(246, 126, 21));
                break;
            case "red":
                rect1.setFill(Color.rgb(225, 0, 0));
                break;
        }
        String text = "Resource Cards: " + p.getRC().size() + "\n" + "Development Cards: " + p.getDC().size() + "\n" + "Points: " + p.getPoints();
        textArea1.setText(text);
    }

    public void updatePane2(){
        Player p = GameState.getAllPlayers().get(2);
        switch(p.getColor().toLowerCase()){
            case "blue":
                rect2.setFill(Color.rgb(30, 144, 255));
                break;
            case "green":
                rect2.setFill(Color.rgb(11, 242, 36));
                break;
            case "orange":
                rect2.setFill(Color.rgb(246, 126, 21));
                break;
            case "red":
                rect2.setFill(Color.rgb(225, 0, 0));
                break;
        }
        String text = "Resource Cards: " + p.getRC().size() + "\n" + "Development Cards: " + p.getDC().size() + "\n" + "Points: " + p.getPoints();
        textArea2.setText(text);
    }

    public void updatePane3(){
        Player p = GameState.getAllPlayers().get(3);
        switch(p.getColor().toLowerCase()){
            case "blue":
                rect3.setFill(Color.rgb(30, 144, 255));
                break;
            case "green":
                rect3.setFill(Color.rgb(11, 242, 36));
                break;
            case "orange":
                rect3.setFill(Color.rgb(246, 126, 21));
                break;
            case "red":
                rect3.setFill(Color.rgb(225, 0, 0));
                break;
        }
        String text = "Resource Cards: " + p.getRC().size() + "\n" + "Development Cards: " + p.getDC().size() + "\n" + "Points: " + p.getPoints();
        textArea3.setText(text);
    }

    @FXML
    void openInventory(ActionEvent event) {
        Button b = (Button)event.getSource();
        if(b.equals(inventory0)){
            HelloApplication.changeScene("playerInventory.fxml");
        }
        else if(b.equals(inventory1)){
            System.out.println("Inventory 1");
        }
        else if(b.equals(inventory2)){
            System.out.println("Inventory 2");
        }
        else if(b.equals(inventory3)){
            System.out.println("Inventory 3");
        }
    }

}
