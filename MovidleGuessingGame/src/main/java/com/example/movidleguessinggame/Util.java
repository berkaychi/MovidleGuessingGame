package com.example.movidleguessinggame;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

public class Util {

    static private final Image equalImage = new Image(new File("images/equal.png").toURI().toString());
    static private final Image bottomImage = new Image(new File("images/arrow_down.png").toURI().toString());
    static private final Image topImage = new Image(new File("images/arrow_up.png").toURI().toString());

    static void guessControl(Label lbl, int i, String[] guessMovie, String[] rndmMovie) {
        //String[] guessMovie = movies.get(movieNo - 1).toString().split(";");
        //String[] rndmMovie = movies.get(randomMovie - 1).toString().split(";");
        String labelColor = guessMovie[i + 1].equals(rndmMovie[i + 1]) ? "-fx-background-color:GREEN" : "-fx-background-color:RED;";
        if (i == 1) {
            lbl.setGraphic(movieYearControl(guessMovie[i + 1], rndmMovie[i + 1]));
        }
        lbl.setStyle(labelColor);
    }

    static ImageView movieYearControl(String guessMovieYear, String rndmMovieYear) {
        return getImageView(guessMovieYear, rndmMovieYear);
    }

    static ImageView getImageView(String guessMovieYear, String rndmMovieYear) {
        if (Integer.parseInt(rndmMovieYear) > Integer.parseInt(guessMovieYear)) {
            ImageView topImageView = new ImageView(topImage);
            topImageView.setFitHeight(20);
            topImageView.setPreserveRatio(true);
            return topImageView;
        } else if(Integer.parseInt(rndmMovieYear) < Integer.parseInt(guessMovieYear)){
            ImageView buttomImageView = new ImageView(bottomImage);
            buttomImageView.setFitHeight(20);
            buttomImageView.setPreserveRatio(true);
            return buttomImageView;
        }else{
            ImageView equalImageView = new ImageView(equalImage);
            equalImageView.setFitHeight(20);
            equalImageView.setPreserveRatio(true);
            return equalImageView;
        }
    }
}
