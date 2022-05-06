package com.example.catanfx.Controllers;
import com.example.catanfx.GamePieces.GameState;
import com.example.catanfx.GamePieces.HelpMenu;
import com.example.catanfx.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import java.net.URL;
import java.util.ResourceBundle;
public class
MainMenuController implements Initializable {

    @FXML
    private ComboBox<Integer> choice;
    @FXML
    private Button helpButton;
    @FXML
    private Button startButton;
//    @FXML
//    public void initialize(){
//        choice.getItems().addAll(3, 4);
//    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choice.getItems().addAll(3, 4);
    }
    @FXML
    void startGame(ActionEvent event) {
        if(choice.getValue()==null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select the proper number of players");
            alert.showAndWait();
        }
        else{
            new GameState(choice.getValue());
            HelloApplication.changeScene("test.fxml");
        }
    }
    @FXML
    public void helpMenu(ActionEvent actionEvent) {
        new HelpMenu();
    }
}
