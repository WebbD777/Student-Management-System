package com.webbd777.jdbc_database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
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

    // To go back to decition pane
    private Parent root;
    private Stage stage;
    private Scene scene;

    // To exit
    @FXML
    private AnchorPane scenePane;
    private Stage stageClose;

    // To open select Scene
    private Parent par;
    private Stage stageQuery;
    private Scene sceneQuery;

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

    public void Back(ActionEvent action) throws Exception{

        //Exit programme
        stageClose = (Stage)scenePane.getScene().getWindow();
        stageClose.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("decision.fxml"));
        root = loader.load();

        DecisionController deci = loader.getController();
        deci.getStatement(statement);

        stage = (Stage)((Node)action.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void State(Statement statement)  {

        this.statement = statement;
    }


  //  @Override
  //  public void initialize(URL url, ResourceBundle resourceBundle) {

  //  }
}

