package com.example.coursework;

import com.example.coursework.controller.RegistrationController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.initModality(Modality.APPLICATION_MODAL);

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/com/example/coursework/registration.fxml"));

        stage.setTitle("RegistrationWindow");
        RegistrationController.setStage(stage);

        Parent root = fxmlLoader.load();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}