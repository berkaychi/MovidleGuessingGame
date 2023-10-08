package com.example.movidleguessinggame;

import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static com.example.movidleguessinggame.Util.getImageView;

public class Game {
    private int randomMovie = -1;
    private int movieNo = 0;
    private int guessCount = 0;
    private final ArrayList<Movies> movies;
    private final Set<String> guessMovies = new HashSet<>();
    public final String[] movieList = new String[250];
    Create create = new Create();
    ReadFile file = new ReadFile();


    public Game() throws FileNotFoundException {
        movies = file.createMovies();
        randomMovie();
        choiceMovie();
    }

    void win(Button btnGuess, TextField txtGuess,ChoiceBox<String> choiceBoxMovie) {
        Alert winAlert = new Alert(Alert.AlertType.INFORMATION);
        winAlert.setTitle("Game Rules");
        winAlert.setHeaderText("CONGRATS , YOU WIN!");
        winAlert.setContentText("If you use RESTART button, you can restart the game.");
        btnGuess.setDisable(true);
        txtGuess.setDisable(true);
        choiceBoxMovie.setDisable(true);
        winAlert.show();
    }

    void lose(Button btnGuess, TextField txtGuess,ChoiceBox<String> choiceBoxMovie) {
        Alert loseAlert = new Alert(Alert.AlertType.INFORMATION);
        loseAlert.setTitle("LOSE");
        loseAlert.setHeaderText(" YOU LOSE :(\nCorrect movie is: "+ movies.get(randomMovie-1).getName());
        loseAlert.setContentText("If you use RESTART button, you can restart the game.");

        btnGuess.setDisable(true);
        txtGuess.setDisable(true);
        choiceBoxMovie.setDisable(true);
        loseAlert.show();
    }

    void restart() {
        randomMovie = -1;
        randomMovie();
        movieNo = 0;
        guessCount = 0;
        guessMovies.clear();
    }

    void guess(TextField txtguess, VBox mainVBox, Button btnGuess,ChoiceBox<String> choiceBoxMovie) {
        String gss = txtguess.getText().trim().toLowerCase(Locale.ENGLISH);

        if (!guessMovies.add(gss)) {
            txtguess.setText("You've tried this movie before! Please try again by entering a different movie.");
            txtguess.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 16));
            txtguess.setStyle("-fx-background-color:RED;");
            txtguess.setAlignment(Pos.CENTER);
        }
        else if (searchMovie(gss) != -1) {

            if (movieNo - 1 == randomMovie - 1) {
                mainVBox.getChildren().add(create.hboxCreate(movies,randomMovie,movieNo));
                txtguess.clear();
                guessCount++;
                win(btnGuess,txtguess,choiceBoxMovie);
            }
            else {
                mainVBox.getChildren().add(create.hboxCreate(movies,randomMovie,movieNo));
                txtguess.clear();
                movieNo = 0;
                guessCount++;
                if (guessCount > 4)
                    lose(btnGuess,txtguess,choiceBoxMovie);
            }
        }
        else {
            txtguess.setText("Please enter a film that is on the IMDB Top 250 list!");
            txtguess.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 16));
            txtguess.setStyle("-fx-background-color:RED;");
            txtguess.setAlignment(Pos.CENTER);
        }
    }

    private int searchMovie(String guess) {
        for (Movies movie : movies) {
            if (guess.equalsIgnoreCase(movie.getName())) {
                movieNo++;
                return movieNo;
            }
            movieNo++;
        }
        movieNo = 0;
        return -1;
    }

    private void randomMovie() {
        if (randomMovie == -1)
            randomMovie = (int) (Math.random() * 251);
    }

    private void choiceMovie(){
        for(int i = 0;i<249;i++){
             movieList[i] = movies.get(i).getName();
        }
    }
}