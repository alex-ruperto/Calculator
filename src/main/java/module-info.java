module com.example.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens calculator.app to javafx.fxml;
    exports calculator.app;
}