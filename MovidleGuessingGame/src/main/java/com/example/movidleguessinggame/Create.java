package com.example.movidleguessinggame;

import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Create {
    ReadFile file = new ReadFile();

    public Create() throws FileNotFoundException {
        file.imageURL();
    }
    public HBox hboxCreate(ArrayList<Movies> movies, int randomMovie, int movieNo) {
        String[] rndmMovie = movies.get(randomMovie-1).toString().split(";");
        String[] guessMovie = movies.get(movieNo - 1).toString().split(";");
        HBox hbox = new HBox();

        hbox.setAlignment(Pos.TOP_CENTER);
        hbox.setSpacing(5);
        hbox.setPrefWidth(905);
        hbox.setPrefHeight(85);
        hbox.getChildren().add(file.imageCreate(movieNo));

        for (int i = 0; i < 6; i++) {
            Label lbl = labelCreate(guessMovie,i);
            Util.guessControl(lbl, i,guessMovie,rndmMovie);
            hbox.getChildren().add(lbl);
            TranslateTransition transition = createTransition(lbl, -200, 0, hbox.getLayoutX());
            transition.play();
        }
        return hbox;
    }
    private Label labelCreate(String[] guessMovie,int i){
        Label lbl = new Label();
        lbl.setAlignment(Pos.CENTER);
        lbl.setTextAlignment(TextAlignment.CENTER);
        lbl.setTextFill(Paint.valueOf("38230D"));
        lbl.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 14));
        lbl.setWrapText(true);
        lbl.setPrefWidth(120);
        lbl.setPrefHeight(80);
        lbl.setText(guessMovie[i + 1]);
        return lbl;
    }

    private TranslateTransition createTransition(Label label, double fromX, double fromY, double toX) {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), label);
        transition.setFromX(fromX);
        transition.setFromY(fromY);
        transition.setToX(toX);
        return transition;
    }
}
