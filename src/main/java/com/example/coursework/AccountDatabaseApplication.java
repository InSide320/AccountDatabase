package com.example.coursework;

import com.example.coursework.database.hikaricp.DataSource;
import com.example.coursework.database.hikaricp.HikariCPConfig;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class AccountDatabaseApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AccountDatabaseApplication.class.getResource("authorization.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.setTitle("AccountDatabase");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println(HikariCPConfig.propertiesFile);
        HikariCPConfig hikariCPConfig = new HikariCPConfig();
        try {
            hikariCPConfig.setFileProperties();
            DataSource.getConnection();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        launch();
    }
}