package com.example.coursework;

import com.example.coursework.database.CreateTableDataBase;
import com.example.coursework.database.file.SerializableObject;
import com.example.coursework.database.hikaricp.HikariCPConfig;
import com.example.coursework.database.utility.SqlCommandUtility;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountDatabaseApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AccountDatabaseApplication.class.getResource("authorization.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.setTitle("AccountDatabase");
        stage.setScene(scene);
        stage.show();
    }

    public static final Logger logger = Logger.getGlobal();

    public static void main(String[] args) {

        HikariCPConfig hikariCPConfig = new HikariCPConfig();
        try {
            hikariCPConfig.setFileProperties();
            CreateTableDataBase.createDataBase();
            SqlCommandUtility.selectTableValueAll();
            SerializableObject.getFileValues();
        } catch (IOException e) {
            logger.log(Level.WARNING, e.getMessage(), e.getStackTrace());
        }
        launch();
    }
}