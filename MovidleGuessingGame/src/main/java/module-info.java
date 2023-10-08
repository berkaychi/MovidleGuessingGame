module com.example.movidleguessinggame {
    requires javafx.controls;
    requires javafx.fxml;
    opens com.example.movidleguessinggame to javafx.fxml;
    exports com.example.movidleguessinggame;
}