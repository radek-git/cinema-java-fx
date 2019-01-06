package com.radek.cinema.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    MainPageController mainPageController;

    @FXML Button mainPageButton;
    @FXML Button orderHistoryButton;
    @FXML Button settingsButton;
    @FXML Button logoutButton;

    @FXML AnchorPane anchorPane;

    // https://api.themoviedb.org/3/search/movie?api_key=15d2ea6d0dc1d476efbca3eba2b9bbfb&query=killer
    // https://github.com/dlemmermann/PreferencesFX

    public void initialize(URL url, ResourceBundle rb) {
        loadPane("/fxml/main_pane.fxml");
    }

    @FXML
    private void onMainPageButtonClick(ActionEvent event) throws IOException {
        loadPane("/fxml/main_pane.fxml");
    }

    @FXML
    private void onOrderHistoryButtonClick(ActionEvent event) throws IOException {
        loadPane("/fxml/order_history_pane.fxml");
    }

    @FXML
    private void onSettingsButtonClick(ActionEvent event) throws IOException {
        loadPane("/fxml/settings_pane.fxml");
    }

    @FXML
    private void onLogoutButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login_scene.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void loadPane(String path) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource(path));
            anchorPane.getChildren().clear();
            anchorPane.getChildren().add(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
