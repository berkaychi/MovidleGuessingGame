package com.example.movidleguessinggame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    private final ArrayList<String> movieImagesURL = new ArrayList<>();
    public ArrayList<Movies> createMovies() throws FileNotFoundException {
        ArrayList<Movies> movies = new ArrayList<>();

        File file = new File("top_250.csv");
        Scanner input = new Scanner(file);
        input.nextLine();

        while (input.hasNextLine()) {
            String str = input.nextLine();
            movies.add(new Movies(str.split(";")));
        }

        input.close();
        return movies;
    }

    public void imageURL() throws FileNotFoundException {
        File file = new File("imdb_top_250_images.csv");
        Scanner imagescan = new Scanner(file);
        imagescan.nextLine();
        while(imagescan.hasNextLine()){
            String url = imagescan.nextLine().split(";")[1];
            movieImagesURL.add(url);
        }
    }

    public ImageView imageCreate(int movieNo){
        Image image = new Image(movieImagesURL.get(movieNo-1));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(80);
        imageView.setFitHeight(80);
        return imageView;
    }
}
