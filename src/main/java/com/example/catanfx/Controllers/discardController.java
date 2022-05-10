package com.example.catanfx.Controllers;

import com.example.catanfx.GamePieces.Cards.ResourceCard;
import com.example.catanfx.GamePieces.Cards.ResourceDeck;
import com.example.catanfx.GamePieces.GameState;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

public class discardController implements Initializable {

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
    private Text textHead;

    private int index;

    private ArrayList<ResourceCard> temp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        temp = new ArrayList<>();
        index = 0;
        for(int i=0; i<GameState.getAllPlayers().size(); i++){
            if(GameState.getAllPlayers().get(i).getRC().size()>7){
                textHead.setText("Player " +(i+1)+": Please Select " + GameState.getAllPlayers().get(i).getRC().size()/2 + " Cards To Discard" );
                showCards(GameState.getAllPlayers().get(i).getRC());
                index = i;
                System.out.println(index);
                return;
            }
        }
    }

    private void showCards(LinkedList<ResourceCard> arr){
        cb1.getItems().clear();cb2.getItems().clear();cb3.getItems().clear();cb4.getItems().clear();cb5.getItems().clear();
        cb1.getItems().add(0);cb2.getItems().add(0);cb3.getItems().add(0);cb4.getItems().add(0);cb5.getItems().add(0);
        if(arr.contains(new ResourceCard("brick"))){
            IntStream.rangeClosed(1, Collections.frequency(arr, new ResourceCard("brick"))).boxed().forEach(cb1.getItems()::add);
        }
        if(arr.contains(new ResourceCard("lumber"))){
            IntStream.rangeClosed(1, Collections.frequency(arr, new ResourceCard("lumber"))).boxed().forEach(cb2.getItems()::add);
        }
        if(arr.contains(new ResourceCard("grain"))){
            IntStream.rangeClosed(1, Collections.frequency(arr, new ResourceCard("grain"))).boxed().forEach(cb3.getItems()::add);
        }
        if(arr.contains(new ResourceCard("wool"))){
            IntStream.rangeClosed(1, Collections.frequency(arr, new ResourceCard("wool"))).boxed().forEach(cb4.getItems()::add);
        }
        if(arr.contains(new ResourceCard("ore"))){
            IntStream.rangeClosed(1, Collections.frequency(arr, new ResourceCard("ore"))).boxed().forEach(cb5.getItems()::add);
        }
        cb1.getSelectionModel().select(0);cb2.getSelectionModel().select(0);cb3.getSelectionModel().select(0);cb4.getSelectionModel().select(0);cb5.getSelectionModel().select(0);
    }

    private Integer getSum(){
        return cb1.getValue() + cb2.getValue() + cb3.getValue() + cb4.getValue() + cb5.getValue();
    }

    @FXML
    void next(ActionEvent event) {
        if(getSum()!=GameState.getAllPlayers().get(index).getRC().size()/2){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please Select The Proper Number Of Cards To Remove");
            alert.showAndWait();
            return;
        }
        else{
            recordDiscard();
            for(ResourceCard rc: temp){
                GameState.getAllPlayers().get(index).removeRCard(rc);
            }
            if (index + 1 == GameState.getAllPlayers().size()) {
                Stage stage = (Stage) cb1.getScene().getWindow();
                // do what you have to do
                stage.close();
            } else {
                for (index = index+1; index < GameState.getAllPlayers().size(); index++) {
                    if(GameState.getAllPlayers().get(index).getRC().size()>7){
                        textHead.setText("Player " +(index+1)+": Please Select " + GameState.getAllPlayers().get(index).getRC().size()/2 + " Cards To Discard" );
                        showCards(GameState.getAllPlayers().get(index).getRC());
                        System.out.println(index);
                        return;
                    }
                }
                Stage stage = (Stage) cb1.getScene().getWindow();
                // do what you have to do
                stage.close();
            }
        }
    }

    private void recordDiscard(){

        temp = new ArrayList<>();
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
    private void makeCards( String text, Integer num, ArrayList<ResourceCard> temp){
        for(int i=0; i<num;i++){
            temp.add(new ResourceCard(text));
        }
    }


}
