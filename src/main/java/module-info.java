module com.example.temanr1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens com.example.temanr1 to javafx.fxml;
    exports com.example.temanr1;
}