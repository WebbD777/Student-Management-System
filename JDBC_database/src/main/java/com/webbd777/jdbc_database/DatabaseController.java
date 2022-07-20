package com.webbd777.jdbc_database;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DatabaseController implements Initializable {
    //  private Connection connect;
    @FXML
    private ChoiceBox<String> tableBox;
    @FXML
    private ChoiceBox<String> queryBox;
    // private ArrayList<String> arr = new ArrayList<String>();
    private String[] queryArr = {"Select", "Insert"};
    private Statement state;

    /*public  DatabaseController(Connection connection){
        connect = connection;
        arr = new ArrayList<String>();
    }*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //tableBox.getItems().addAll(arr);
      //  queryBox.getItems().addAll(queryArr);

       // tableBox.setOnAction(this::getTable);
        //  ResultSetMetaData rsMetaData = rs.getMetaData();

      //  rsMetaData.
    }

  //  private void getTable(Event event) {
   //     String table = (String) tableBox.getValue();
   // }

    public void Tables(Connection connect) throws SQLException {
        state = connect.createStatement();
/*
        ResultSet resultset = statement.executeQuery("SHOW TABLES");
        ArrayList<String> arr = new ArrayList<String>();

        while ( resultset.next()){
            arr.add(resultset.getString(1));
        }
        tableBox.getItems().addAll(arr);

        //return arr;
        */
 //*/
    }

    // public void getTable(ActionEvent e){
    //   String table = (String) tableBox.getValue();
    //}

    /*public ArrayList<String> tables() throws SQLException {
        Statement statement = connect.createStatement();

        ResultSet resultset = statement.executeQuery("SHOW TABLES");
        ArrayList<String> arr = new ArrayList<String>();

        while ( resultset.next()){
            arr.add(resultset.getString(1));
        }
        for (int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }

        return arr;

    }*/


}
