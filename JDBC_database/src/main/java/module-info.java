module com.webbd777.jdbc_database {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.webbd777.jdbc_database to javafx.fxml;
    exports com.webbd777.jdbc_database;
}