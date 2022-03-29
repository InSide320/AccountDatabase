module com.example.kursova {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kursova to javafx.fxml;
    exports com.example.kursova;
}