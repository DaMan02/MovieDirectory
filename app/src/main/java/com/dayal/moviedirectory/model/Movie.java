package com.dayal.moviedirectory.model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Movie {
    private String movieTitle;
    private String movieYear;
    private String movieType;
    private String moviePoster;
    private String movieID;

    public Movie() {
    }

    public Movie(String movieID, String movieTitle, String movieYear, String movieType, String moviePoster) {
        this.movieTitle = movieTitle;
        this.movieYear = movieYear;
        this.movieType = movieType;
        this.moviePoster = moviePoster;
        this.movieID = movieID;
    }
    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }
    public String getmovieTitle() {
        return movieTitle;
    }

    public void setmovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }
}
