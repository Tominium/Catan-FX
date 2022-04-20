package com.example.catanfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(HelloApplication.class.getResource("/CSS/bootstrap2.css").toExternalForm());
        primaryStage.setTitle("Settlers Of Catan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void changeScene(String fxml){
        Parent pane = null;
        try {
            pane = FXMLLoader.load(
                    HelloApplication.class.getResource(fxml));
        } catch (IOException e) {
            e.printStackTrace();
        }

        primaryStage.getScene().setRoot(pane);
        primaryStage.close();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}