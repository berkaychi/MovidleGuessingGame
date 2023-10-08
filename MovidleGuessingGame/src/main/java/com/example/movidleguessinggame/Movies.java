package com.example.movidleguessinggame;

import java.util.ArrayList;

public class Movies {
    private String no;
    private String name;
    private String year;
    private String genre;
    private String origin;
    private String director;
    private String star;
    private String title;

    public Movies(String[] array) {
        no = array[0];
        name = array[1];
        year = array[2];
        genre = array[3];
        origin = array[4];
        director = array[5];
        star = array[6];
        title = array[7];
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return no + ";" + name + ";" + year + ";" + genre + ";" + origin + ";" + director + ";" + star + ";" + title;
    }

}
