module com.example.alogorithmstforjava {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.alogorithmstforjava to javafx.fxml;
    exports com.example.alogorithmstforjava;
    exports com.example.alogorithmstforjava.BOJ;
    opens com.example.alogorithmstforjava.BOJ to javafx.fxml;
}