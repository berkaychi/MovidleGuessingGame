package com.example.movidleguessinggame;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


import java.io.FileNotFoundException;

public class MovidleController {
    private final Game game = new Game();
    public MovidleController() throws FileNotFoundException {}

    @FXML
    private HBox HBoxInfo;

    @FXML
    private Button btnClose;

    @FXML
    private ChoiceBox<String> choiceBoxMovie;

    @FXML
    private Button btnGuess;

    @FXML
    private VBox mainVBox;

    @FXML
    private TextField txtGuess;

    @FXML
    void btnCloseSetOn() {
        Stage stage = (Stage) (btnClose.getScene().getWindow());
        stage.close();
    }

    @FXML
    void txtGuessSetOn() {
        HBoxInfo.setVisible(true);
        game.guess(txtGuess, mainVBox, btnGuess,choiceBoxMovie);}

    @FXML
    void txtChanged() {
        if (txtGuess.getStyle().equals("-fx-background-color:RED;")) {
            txtClear();
        }
    }

    @FXML
    void btnGuessSetOn() {
        HBoxInfo.setVisible(true);
        game.guess(txtGuess, mainVBox, btnGuess,choiceBoxMovie);}

    @FXML
    void btnRestartSetOn() {
        game.restart();
        txtClear();
        txtGuess.setDisable(false);
        btnGuess.setDisable(false);
        Node node = mainVBox.getChildren().get(0);
        Node node1 = mainVBox.getChildren().get(1);
        mainVBox.getChildren().clear();
        mainVBox.getChildren().addAll(node,node1);
        alertGameRules();
        choiceBoxMovie.setDisable(false);

        ListView<String> deneme = new ListView<>();

    }
    @FXML
    private void initialize(){
        choiceBoxMovie.getItems().addAll(game.movieList);
        choiceBoxMovie.setOnAction(actionEvent -> {
            HBoxInfo.setVisible(true);
            txtGuess.setText(choiceBoxMovie.getValue());
            game.guess(txtGuess,mainVBox,btnGuess,choiceBoxMovie);
        });
    }
    void txtClear() {
        txtGuess.clear();
        txtGuess.setStyle("-fx-background-color:#F6DAB1;");
        txtGuess.setAlignment(Pos.CENTER_LEFT);
        txtGuess.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 14));
    }

    @FXML
    void btnGameRulesSetOn() {
        alertGameRules();
    }

    void alertGameRules() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeight(700); alert.setWidth(300);
        alert.setTitle("Game Rules");
        alert.setHeaderText("Welcome to Movidle Guessing Game!");
        alert.setContentText("The objective of the game is to guess the name of a movie from the IMDB Top 250 list based on the given clues.\n\n" +
                "Enter your prediction in the text field and click the Guess button or use Enter key. Also choose a movie in the list box.\n" +
                "You have 5 guesses.\n\n" +
                "If your guess is not in the correct format or not listed, you will receive a warning. You can try again.\n" +
                "If your guess is incorrect, the tiles representing movie properties similar to the target movie will be displayed in green.\n" +
                "Also, in the year box, you can see if the year of the target movie is before or after the movie you entered, or if both are the same.\n" +
                "If your guess is correct, all tiles will turn green. Congratulations, you have won the game!\n"+
                "If you wish, you can start a new game by using the restart button.\n\n" +
                "Enjoy the game and have fun!");
        alert.show();
    }
}
