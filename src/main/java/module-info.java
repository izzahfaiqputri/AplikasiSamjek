module org.example.proyeksamjek {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.proyeksamjek to javafx.fxml;
    exports org.example.proyeksamjek;
}