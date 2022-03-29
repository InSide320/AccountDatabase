/**
 * Sample Skeleton for 'authorization.fxml' Controller Class
 */

package com.example.coursework.controller;

import com.example.coursework.RegistrationApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AuthorizationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Hyperlink loginSignUpLink;

    @FXML
    private Hyperlink loginForgotPasswordLink;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button authSignInButton;

    @FXML
    void initialize() {

        loginSignUpLink.setOnAction(event -> {
            try {
                Stage stage = new Stage();
                new RegistrationApplication().start(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


    }
}
