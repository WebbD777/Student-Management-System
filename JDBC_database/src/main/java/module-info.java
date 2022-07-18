module com.webbd777.jdbc_database {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.webbd777.jdbc_database to javafx.fxml;
    exports com.webbd777.jdbc_database;
}