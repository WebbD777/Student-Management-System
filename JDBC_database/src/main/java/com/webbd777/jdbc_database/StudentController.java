package com.webbd777.jdbc_database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class StudentController {//implements Initializable {

    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField amountField;
    @FXML
    private Label successLabel;

    private Statement statement;

    private String id;
    private String name;
    private String address;
    private String amount;

    public void Entered(ActionEvent event) throws Exception {

        id = idField.getText();
        name = nameField.getText();
        address = addressField.getText();
        amount = amountField.getText();

        String personalSql = "INSERT INTO personalInfo VALUES('"+id+"','"+name+"','"+address+"')"; // String sql = "insert into people values ('5', 'Michelle')";
        statement.executeUpdate(personalSql);

        String feeSql = "INSERT INTO fees VALUES('"+id+"','"+amount+"',0)";
        statement.executeUpdate(feeSql);

        idField.clear();
        nameField.clear();
        addressField.clear();
        amountField.clear();

        successLabel.setText("Success!!");
        TimeUnit.SECONDS.sleep(2);
        successLabel.setText("Add another student?");

    }

    public void State(Statement statement)  {

        this.statement = statement;
    }

  //  @Override
  //  public void initialize(URL url, ResourceBundle resourceBundle) {

  //  }
}

