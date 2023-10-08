package com.example.movidleguessinggame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MovidleApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MovidleController movidleController = new MovidleController();
        FXMLLoader fxmlLoader = new FXMLLoader(MovidleApplication.class.getResource("movidleGuessingGame.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 750);

        stage.setTitle("Movidle Guessing Game");
        stage.setScene(scene);
        stage.show();
        movidleController.alertGameRules();
    }

    public static void main(String[] args) {
        launch();
    }
}