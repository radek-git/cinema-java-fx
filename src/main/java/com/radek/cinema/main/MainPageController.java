package com.radek.cinema.main;

import com.radek.cinema.Database;
import com.radek.cinema.hibernate.Movie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    Pagination pagination;

    Database database = Database.getInstance();
    List<Movie> movies = database.getAllMovies();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int pageCount = (int) Math.ceil(movies.size() / 8.0);
        pagination.setPageCount(pageCount);

        pagination.setPageFactory(i -> createPage(i));
    }

    private GridPane createPage(int i) {

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        int imageIndex = i * 8;
        for (int k = 0; k < 2; k++) {
            for (int j = 0; j < 4; j++) {
                if (imageIndex < movies.size()) {
                    loadImage(gridPane, j, k, imageIndex);
                    imageIndex++;
                } else {
                    return gridPane;
                }
            }
        }

        return gridPane;
    }

    private void loadImage(GridPane gridPane, int a, int b, int i) {
        Image image = new Image("/loading.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(167);
        imageView.setFitHeight(250);

        imageView.setOnMouseClicked(mouseEvent -> {
            System.out.println(movies.get(i).toString());

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/movie_info_pane.fxml"));
                Parent root = loader.load();

                MovieInfoController controller = loader.getController();

                controller.setMovie(movies.get(i));

                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();


            } catch (IOException e) {
                e.printStackTrace();
            }



        });


        gridPane.add(imageView, a, b, 1, 1);

        image = new Image(movies.get(i).getPosterUrl(), true);
        imageView.setImage(image);
    }


}
