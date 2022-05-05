package com.example.catanfx.Controllers;

import com.example.catanfx.GamePieces.GameState;
import com.example.catanfx.GamePieces.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class YearOfPlentyController {

    public static Player p;
    private String resource;

    @FXML
    private RadioButton brick;

    @FXML
    private RadioButton grain;

    @FXML
    private RadioButton lumber;

    @FXML
    private RadioButton ore;

    @FXML
    private RadioButton wool;

    @FXML
    private Button use;

    @FXML
    private AnchorPane pane;

    Stage stage;


    @FXML
    void chooseResource(ActionEvent event){
        RadioButton temp = (RadioButton)event.getSource();
        deselect(temp);
        if(temp.equals(brick)){
            resource = "brick";
        }
        else if(temp.equals(grain)){
            resource = "grain";
        }
        else if(temp.equals(lumber)){
            resource = "lumber";
        }
        else if(temp.equals(ore)){
            resource = "ore";
        }
        else if(temp.equals(wool)){
            resource = "wool";
        }
    }

    private void deselect(RadioButton temp){
        if(temp!=brick){brick.setSelected(false);}
        if(temp!=grain){grain.setSelected(false);}
        if(temp!=lumber){lumber.setSelected(false);}
        if(temp!=ore){ore.setSelected(false);}
        if(temp!=wool){wool.setSelected(false);}
    }

    @FXML
    void use(ActionEvent event){
        p = GameState.getAllPlayers().get(GameState.turnNumber);
        GameState.yearOfPlenty(p, resource);
        stage = (Stage)pane.getScene().getWindow();
        stage.close();
    }
}
