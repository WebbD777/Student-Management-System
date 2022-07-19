package com.webbd777.jdbc_database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Statement;
import java.util.concurrent.TimeUnit;

public class DecisionController {

    private Statement statement;

    @FXML
    private AnchorPane scenePane;
    @FXML
    private Parent par;


    private Stage stageExit;
    private Stage stageClose;
    private Stage stageQuery;
    private Scene sceneQuery;

    public void Select(ActionEvent event) throws Exception {

        stageClose = (Stage)scenePane.getScene().getWindow();
        stageClose.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("select.fxml"));
        par = loader.load();

        SelectController stuCintol = loader.getController();
        stuCintol.tableFetch(statement);

        stageQuery = (Stage)((Node)event.getSource()).getScene().getWindow();
        sceneQuery = new Scene(par);
        stageQuery.setScene(sceneQuery);
        stageQuery.show();
    }

    public void Insert(ActionEvent event) throws Exception {

        //Exit programme
        stageClose = (Stage)scenePane.getScene().getWindow();
        stageClose.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("addStudent.fxml"));
        par = loader.load();

        StudentController stuCintol = loader.getController();
        stuCintol.State(statement);

        stageQuery = (Stage)((Node)event.getSource()).getScene().getWindow();
        sceneQuery = new Scene(par);
        stageQuery.setScene(sceneQuery);
        stageQuery.show();
    }

    public void Exit(ActionEvent event) throws Exception {

        stageExit = (Stage)scenePane.getScene().getWindow();
        stageExit.close();

       /* Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Excited");
        alert.close();*/                   // Fix alert messages
        TimeUnit.SECONDS.sleep(1);


    }

    public void getStatement(Statement statement){
        this.statement = statement;
    }
}
