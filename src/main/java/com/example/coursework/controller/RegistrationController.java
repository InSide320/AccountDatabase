package com.example.coursework.controller;

import com.example.coursework.database.utility.SqlCommandUtility;
import com.example.coursework.user.User;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
    private ComboBox<String> orgUnitPathComboBox;

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
            SqlCommandUtility.executeCommandToInsertValues(
                    FirstNameTranslitField.getText(), LastNameTranslitField.getText(),
                    emailBackupField.getText(), phoneNumberBeckupField.getText(),
                    lastNameField.getText(), firstNameField.getText(), midlNameField.getText(),
                    dateOfEntry.getValue(), releaseDate.getValue(),
                    groupComoBox.getValue(), orgUnitPathComboBox.getValue(),
                    toggleGroup.getSelectedToggle()
            );

            stage.close();
        });
    }

    private static final List<String> groupNumbers = new ArrayList<>();
    private static final List<String> groupNamesUk = new ArrayList<>();
    private static final List<String> groupNamesOrgUnit = new ArrayList<>();


    private void setGroupType() {
        setListNumbersGroup();
        setNameGroup();
        for (String nameGroup : groupNamesUk) {
            groupUkNumberSettingCycle(nameGroup);
        }
        for (String nameGroup : groupNamesOrgUnit) {
            groupOrgUnitNumberSettingCycle(nameGroup);
        }
    }

    private void groupOrgUnitNumberSettingCycle(String nameGroup) {
        for (String numberGroup : groupNumbers) {
            orgUnitPathComboBox.getItems().add(nameGroup + numberGroup);
        }
    }

    private void groupUkNumberSettingCycle(String nameGroup) {
        for (String numberGroup : groupNumbers) {
            groupComoBox.getItems().add(nameGroup + numberGroup);
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

    private void setNameGroup() {
        groupNamesUk.add("ПС");
        groupNamesUk.add("РА");
        groupNamesUk.add("ЗМ");
        groupNamesUk.add("ЕА");

        groupNamesOrgUnit.add("PS");
        groupNamesOrgUnit.add("RA");
        groupNamesOrgUnit.add("ZM");
        groupNamesOrgUnit.add("EA");
    }

    private void setListNumbersGroup() {
        groupNumbers.add("4-1");
        groupNumbers.add("3-1");
        groupNumbers.add("2-1");
        groupNumbers.add("1-1");
    }
}
