package com.example.coursework.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistrationController {

    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        RegistrationController.stage = stage;
    }

    Logger logger = Logger.getGlobal();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField emailBackupField;

    @FXML
    private TextField phoneNumberBeckupField;

    @FXML
    private TextField FirstNameTranslitField;

    @FXML
    private TextField LastNameTranslitField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField midlNameField;

    @FXML
    private ComboBox<String> groupComoBox;

    @FXML
    private RadioButton radioButtonStudentRole;

    @FXML
    private RadioButton radioButtonTeacherRole;

    @FXML
    private ComboBox<?> orgUnitPathComboBox;

    @FXML
    private DatePicker dateOfEntry;

    @FXML
    private DatePicker releaseDate;

    @FXML
    private Button registrationButton;

    @FXML
    private TextArea commentField;

    @FXML
    private TextField dateRegistrationField;

    @FXML
    void initialize() {
        setDefaultOptions();


        registrationButton.setOnAction(event -> {
            stage.close();
        });

        dateOfEntry.setOnAction(event -> {
            try {
                logger.log(Level.INFO, String.valueOf(dateOfEntry.getValue()));
            } catch (DateTimeParseException e) {
                logger.log(Level.WARNING, e.getMessage(), e.getStackTrace());
            }
        });

        releaseDate.setOnAction(event -> {
            logger.log(Level.INFO, String.valueOf(releaseDate.getValue()));
        });

        groupComoBox.setOnAction(event -> {
            logger.log(Level.INFO, groupComoBox.getValue());
        });
    }

    private static final String[] groupNumbers = {"4-1", "3-1", "2-1", "1-1"};
    private static final String[] groupNames = {"PS", "RA", "ZM", "EA"};

    private void setGroupType() {
        for (String nameGroup : groupNames) {
            for (String numberGroup : groupNumbers) {
                groupComoBox.getItems().add(nameGroup + numberGroup);
            }
        }
    }

    private void setDefaultOptions() {
        radioButtonStudentRole.setToggleGroup(toggleGroup);
        radioButtonTeacherRole.setToggleGroup(toggleGroup);

        dateRegistrationField.textProperty()
                .set(LocalDateTime.now().format(
                        DateTimeFormatter.ofPattern
                                ("yyyy-MM-dd | HH:mm")));
        setGroupType();
    }

    private static final ToggleGroup toggleGroup = new ToggleGroup();
}
