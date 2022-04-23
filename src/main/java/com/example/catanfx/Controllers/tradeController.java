package com.example.catanfx.Controllers;

import com.example.catanfx.GamePieces.Cards.ResourceCard;
import com.example.catanfx.GamePieces.GameState;
import com.example.catanfx.GamePieces.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;
import java.util.stream.IntStream;

public class tradeController implements Initializable {

    public static Player sel;

    @FXML
    private ComboBox<Integer> cb1;

    @FXML
    private ComboBox<Integer> cb2;

    @FXML
    private ComboBox<Integer> cb3;

    @FXML
    private ComboBox<Integer> cb4;

    @FXML
    private ComboBox<Integer> cb5;

    @FXML
    private Button next;

    @FXML
    private RadioButton p1;

    @FXML
    private RadioButton p2;

    @FXML
    private RadioButton p3;

    @FXML
    private RadioButton p4;

    @FXML
    private Button trade;

    private static ArrayList<ResourceCard> trade1;
    private static ArrayList<ResourceCard> trade2;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(GameState.getAllPlayers().size()!=4){p4.setVisible(false); p4.setDisable(true);}
        showCards(GameState.getAllPlayers().get(0).getRC());
        trade1 = new ArrayList<>();
        trade2 = new ArrayList<>();
    }
    @FXML
    void choosePlayer(ActionEvent event) {
        RadioButton temp = (RadioButton)event.getSource();
        deselect(temp);
        switch(temp.getText()){
            case "Player 1":
                sel = GameState.getAllPlayers().get(0);
                break;
            case "Player 2":
                sel = GameState.getAllPlayers().get(1);
                break;
            case "Player 3":
                sel = GameState.getAllPlayers().get(2);
                break;
            case "Player 4":
                sel = GameState.getAllPlayers().get(3);
                break;
        }
        if(GameState.getAllPlayers().get(GameState.turnNumber)==sel){
            temp.setSelected(false);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Cannot Trade With Yourself :)");
            alert.showAndWait();
        }

    }

    public static void selectedPlayer(Player p){
        sel = p;
    }

    private void showCards(LinkedList<ResourceCard> arr){
        if(arr.contains(new ResourceCard("brick"))){
            IntStream.rangeClosed(0, Collections.frequency(arr, new ResourceCard("brick"))).boxed().forEach(cb1.getItems()::add);
        }
        if(arr.contains(new ResourceCard("lumber"))){
            IntStream.rangeClosed(0, Collections.frequency(arr, new ResourceCard("lumber"))).boxed().forEach(cb2.getItems()::add);
        }
        if(arr.contains(new ResourceCard("grain"))){
            IntStream.rangeClosed(0, Collections.frequency(arr, new ResourceCard("grain"))).boxed().forEach(cb3.getItems()::add);
        }
        if(arr.contains(new ResourceCard("wool"))){
            IntStream.rangeClosed(0, Collections.frequency(arr, new ResourceCard("wool"))).boxed().forEach(cb4.getItems()::add);
        }
        if(arr.contains(new ResourceCard("ore"))){
            IntStream.rangeClosed(0, Collections.frequency(arr, new ResourceCard("ore"))).boxed().forEach(cb5.getItems()::add);
        }
    }

    private void deselect(RadioButton temp){
        if(temp!=p1){p1.setSelected(false);}
        if(temp!=p2){p2.setSelected(false);}
        if(temp!=p3){p3.setSelected(false);}
        if(temp!=p4){p4.setSelected(false);}
    }

    @FXML
    void next(ActionEvent event) {

        if(!p1.isSelected()&&!p2.isSelected()&&!p3.isSelected()&&!p4.isSelected()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please Choose A Player To Trade With");
            alert.showAndWait();
            return;
        }
        if((cb1.getValue()==null&&cb2.getValue()==null&&cb3.getValue()==null&&cb4.getValue()==null&&cb5.getValue()==null)||(cb1.getValue()==0&&cb2.getValue()==0&&cb3.getValue()==0&&cb4.getValue()==0&&cb5.getValue()==0)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please Select Resources To Trade");
            alert.showAndWait();
            return;
        }
        recordTrade();
        cb1.getItems().clear();cb2.getItems().clear();cb3.getItems().clear();cb4.getItems().clear();cb5.getItems().clear();
        p1.setDisable(true);p2.setDisable(true);p3.setDisable(true);p4.setDisable(true);
        next.setDisable(true); next.setVisible(false); trade.setDisable(false); trade.setVisible(true);
        showCards(sel.getRC());
    }

    @FXML
    void complete(ActionEvent event) {
        if((cb1.getValue()==null&&cb2.getValue()==null&&cb3.getValue()==null&&cb4.getValue()==null&&cb5.getValue()==null)||(cb1.getValue()==0&&cb2.getValue()==0&&cb3.getValue()==0&&cb4.getValue()==0&&cb5.getValue()==0)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please Select Resources To Trade");
            alert.showAndWait();
            return;
        }
        recordTrade();
        Stage stage = (Stage) trade.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    private void recordTrade(){
        ArrayList<ResourceCard> temp = null;
        if(trade1.isEmpty()){
            temp = trade1;
        }
        else{
            temp = trade2;
        }

        if(cb1.getValue()!=null){
            makeCards("brick", cb1.getValue(), temp);
        }
        if(cb2.getValue()!=null){
            makeCards("lumber", cb2.getValue(), temp);
        }
        if(cb3.getValue()!=null){
            makeCards("grain", cb3.getValue(), temp);
        }
        if(cb4.getValue()!=null){
            makeCards("wool", cb4.getValue(), temp);
        }
        if(cb5.getValue()!=null){
            makeCards("ore", cb5.getValue(), temp);
        }
    }

    public static ArrayList<ResourceCard>[] getTrade(){
        return new ArrayList[]{trade1, trade2};
    }

    private void makeCards( String text, Integer num, ArrayList<ResourceCard> temp){
        for(int i=0; i<num;i++){
            temp.add(new ResourceCard(text));
        }
    }

}
