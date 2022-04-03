module com.example.kursova {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.zaxxer.hikari;
    requires java.sql;


    opens com.example.coursework to javafx.fxml;
    exports com.example.coursework;
    exports com.example.coursework.controller;
    opens com.example.coursework.controller to javafx.fxml;
    exports com.example.coursework.database;
    opens com.example.coursework.database to javafx.fxml;
    exports com.example.coursework.user;
    opens com.example.coursework.user to javafx.fxml;
}