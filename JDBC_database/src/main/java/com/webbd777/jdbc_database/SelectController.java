package com.webbd777.jdbc_database;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SelectController implements Initializable {

    @FXML
    private TreeView treeView;

    private Statement state;
    private ArrayList<String> arrTable = new ArrayList<String>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        TreeItem<String> rootItem = new TreeItem<>("Tables");

        for (int i = 0; i < arrTable.size(); i ++) {
            TreeItem<String> branch = new TreeItem<>("Tables");

            rootItem.getChildren().add(branch);
        }

        treeView.setRoot(rootItem);
    }

    public void selectTable(){

    }

    public void tableFetch(Statement statement) throws SQLException {

        state = statement;

        ResultSet resultset = statement.executeQuery("SHOW TABLES");

        while (resultset.next()){

            arrTable.add(resultset.getString(1));

        }

        System.out.println("Array made");
    }
}
