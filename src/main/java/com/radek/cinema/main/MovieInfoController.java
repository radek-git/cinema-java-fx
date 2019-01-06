package com.radek.cinema.main;

import com.radek.cinema.hibernate.Movie;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class MovieInfoController implements Initializable {

    private Movie movie;

    @FXML ImageView imageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setMovie(Movie movie) {
        this.movie = movie;

        imageView.setImage(new Image(movie.getPosterUrl(), true));
    }
}
