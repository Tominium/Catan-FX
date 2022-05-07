package com.example.catanfx.Controllers;

import com.example.catanfx.GamePieces.GameState;
import com.example.catanfx.GamePieces.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FourforOneTradeController {
    String resourceOffered;
    String resourceRequested;
    String tradePartner;
    public static Player p;
    @FXML
    private RadioButton brick1;

    @FXML
    private RadioButton lumber1;

    @FXML
    private RadioButton grain1;

    @FXML
    private RadioButton wool1;

    @FXML
    private RadioButton ore1;

    @FXML
    private RadioButton brick2;

    @FXML
    private RadioButton lumber2;

    @FXML
    private RadioButton grain2;

    @FXML
    private RadioButton wool2;

    @FXML
    private RadioButton ore2;

    @FXML
    private RadioButton bank;

    @FXML
    private RadioButton port;

    @FXML
    private Button cont;

    @FXML
    private AnchorPane pane;

    Stage stage;

    @FXML
    void chooseResource(ActionEvent event){
        RadioButton temp = (RadioButton)event.getSource();
        deselectOffer(temp);
        if(temp.equals(brick1)){
            resourceOffered = "brick";
        }
        else if(temp.equals(grain1)){
            resourceOffered = "grain";
        }
        else if(temp.equals(lumber1)){
            resourceOffered = "lumber";
        }
        else if(temp.equals(ore1)){
            resourceOffered = "ore";
        }
        else if(temp.equals(wool1)){
            resourceOffered = "wool";
        }
    }

    private void deselectOffer(RadioButton temp){
        if(temp!=brick1){brick1.setSelected(false);}
        if(temp!=grain1){grain1.setSelected(false);}
        if(temp!=lumber1){lumber1.setSelected(false);}
        if(temp!=ore1){ore1.setSelected(false);}
        if(temp!=wool1){wool1.setSelected(false);}
    }

    @FXML
    void chooseResourceRecieved(ActionEvent event){
        RadioButton temp = (RadioButton)event.getSource();
        deselectRecieved(temp);
        if(temp.equals(brick2)){
            resourceRequested = "brick";
        }
        else if(temp.equals(grain2)){
            resourceRequested = "grain";
        }
        else if(temp.equals(lumber2)){
            resourceRequested = "lumber";
        }
        else if(temp.equals(ore2)){
            resourceRequested = "ore";
        }
        else if(temp.equals(wool2)){
            resourceRequested = "wool";
        }
    }

    private void deselectRecieved(RadioButton temp){
        if(temp!=brick2){brick2.setSelected(false);}
        if(temp!=grain2){grain2.setSelected(false);}
        if(temp!=lumber2){lumber2.setSelected(false);}
        if(temp!=ore2){ore2.setSelected(false);}
        if(temp!=wool2){wool2.setSelected(false);}
    }

    @FXML
    void choosePartner(ActionEvent event){
        RadioButton temp = (RadioButton)event.getSource();
        deselectPartner(temp);
        if(temp.equals(bank)){
            tradePartner = "bank";
        }
        else if(temp.equals(port)){
            tradePartner = "port";
        }
    }

    private void deselectPartner(RadioButton temp) {
        if (temp != port) {
            port.setSelected(false);
        }
        if (temp != bank) {
            bank.setSelected(false);
        }
    }

    @FXML
    void next(ActionEvent event){
        p = GameState.getAllPlayers().get(GameState.turnNumber);
        if(resourceRequested == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please request a Resource Card!");

            alert.show();
        }
        else if(resourceOffered == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select Resource Cards to offer!");

            alert.show();
        }
        else if(tradePartner == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please choose who you want to trade with!");

            alert.show();
        }
        else if(tradePartner.equals("bank")){
            if(GameState.checkBankTrade(p, resourceOffered)){
                GameState.BankTrade(p, resourceOffered, resourceRequested);
                stage = (Stage)pane.getScene().getWindow();
                stage.close();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Not enough Resource Cards!");

                alert.show();
            }
        }
    }
}
