/**
 * Sample Skeleton for 'authorization.fxml' Controller Class
 */

package com.example.coursework.controller;

import com.example.coursework.RegistrationApplication;
import com.example.coursework.user.User;
import com.example.coursework.user.UserController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button authSignInButton;

    private static final Logger logger = Logger.getGlobal();

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
        final String MASSAGE_NOT_AUTHORIZATION = "You have entered incorrect data, please register";
        final String[] massageAuthorization = {MASSAGE_NOT_AUTHORIZATION};
        authSignInButton.setOnAction(event -> {
            if (!emailField.getText().isBlank() && emailField.getText().length() >= 5
                    && !passwordField.getText().isBlank() && passwordField.getText().length() >= 5
            ) {
                for (User user : UserController.getInstance().userList()) {
                    if (emailField.getText().equals(user.getAuthEmail())
                            && passwordField.getText().equals(user.getAuthPassword())
                    ) {
                        massageAuthorization[0] = "Your authorization!";
                        emailField.clear();
                        passwordField.clear();
                    }
                }
            } else
                logger.log(Level.INFO, "This field empty! Pls entry data");
            try {
                logger.log(Level.INFO, massageAuthorization[0]);
            } catch (NullPointerException e) {
                logger.log(Level.INFO, MASSAGE_NOT_AUTHORIZATION);
            }
            massageAuthorization[0] = MASSAGE_NOT_AUTHORIZATION;
        });


    }
}
