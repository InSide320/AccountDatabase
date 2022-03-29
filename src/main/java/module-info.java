module com.example.kursova {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.coursework to javafx.fxml;
    exports com.example.coursework;
    exports com.example.coursework.controller;
    opens com.example.coursework.controller to javafx.fxml;
}