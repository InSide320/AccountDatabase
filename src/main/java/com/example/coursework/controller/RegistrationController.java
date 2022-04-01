package com.example.coursework.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class RegistrationController {

    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        RegistrationController.stage = stage;
    }

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
        registrationButton.setOnAction(event -> {
            stage.close();
        });

        dateRegistrationField.textProperty()
                .set(LocalDateTime.now().format(
                        DateTimeFormatter.ofPattern
                                ("yyyy-MM-dd | HH:mm")));

        dateOfEntry.setOnAction(event -> {
            System.out.println(dateOfEntry.getValue());
        });

        releaseDate.setOnAction(event -> {
            System.out.println(releaseDate.getValue());
        });
        groupComoBox.getItems().addAll("ПС4-1", "ПС3-1", "ПС2-1", "ПС1-1");
        groupComoBox.setOnAction(event -> {
            System.out.println(groupComoBox.getValue());
        });
        radioButtonStudentRole.setToggleGroup(toggleGroup);
        radioButtonTeacherRole.setToggleGroup(toggleGroup);
    }

    private static final ToggleGroup toggleGroup = new ToggleGroup();
}
