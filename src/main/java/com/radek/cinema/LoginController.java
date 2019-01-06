package com.radek.cinema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML TextField loginTextField;
    @FXML PasswordField passwordField;
    @FXML Button loginButton;

    Database database = Database.getInstance();
    
    @FXML
    private void onLoginButtonClick(ActionEvent event) throws Exception {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initModality(Modality.APPLICATION_MODAL);

        if (database.login(loginTextField.getText(), passwordField.getText())) {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/main_scene.fxml"));
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } else {
            alert.setTitle("Nie mozna sie zalogowac");
            alert.setHeaderText(null);
            alert.setContentText("Zle dane logowania!");
            alert.showAndWait();
        }
    }

    public void initialize(URL url, ResourceBundle rb) {
        loginButton.setDisable(true);

        loginTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(loginTextField.getText().isEmpty() || passwordField.getText().isEmpty());
        });

        passwordField.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(loginTextField.getText().isEmpty() || passwordField.getText().isEmpty());
        });

        // hibernate testing
        database.hibernateCostam();
    }    
}
