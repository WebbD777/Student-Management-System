package com.webbd777.jdbc_database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionController {

    @FXML
    TextField urlField;
    @FXML
    TextField userField;
    @FXML
    PasswordField passwordField;
    @FXML
    TextField portField;
    @FXML
    TextField dataField;
    @FXML
    private AnchorPane scenePane;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Connection connection;

    // Stage stage;

    //public void switchScene(ActionEvent event){

    //}
    /*To open query-inject.fmlx and populate arrayList in DatabaseController*/
    private Stage sta;
    private Scene sce;
    private Parent par;

    public void Login(ActionEvent event) throws Exception {

        String url = "jdbc:mysql://" + urlField.getText() + ":" + portField.getText() + "/" + dataField.getText();
        String user = userField.getText();
        String password = passwordField.getText();

        try {

            connection = DriverManager.getConnection(url, user, password);
            //Close stage
            //stage = (Stage)scenePane.getScene().getWindow();
            //stage.close();
        } catch (SQLException e) {
            // try to load a fail, try again scene
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Credential Mismatch");
            alert.setContentText("Retry");
        }
        connection = DriverManager.getConnection(url, user, password);

        //Closes stage
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();

        // DatabaseController database = new DatabaseController(connection);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("query-inject.fxml"));
        par = loader.load();
        
        DatabaseController databaseController = loader.getController();
        databaseController.Tables(connection);

        //par = loader.load();
        sta = (Stage)((Node)event.getSource()).getScene().getWindow();
        sce = new Scene(par);
        sta.setScene(sce);
        sta.show();



       /* QueryInject inject = new QueryInject();
        Stage i = new Stage();
        inject.start(i);
        */

        // database.initialize();

    }

}