package com.webbd777.jdbc_database;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SelectController implements Initializable {

    @FXML
    private TreeView treeView;
    @FXML
    private TextArea textArea;

    private Connection connect;

    private Statement state;
    private ArrayList<String> arrTable = new ArrayList<String>();
    private  ResultSet resultset;
    TreeItem<String> rootItem = new TreeItem<>("Tables");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textArea.setEditable(false);
        // TreeItem<String> rootItem = new TreeItem<>("Tables");



/*
        for (int i = 0; i < arrTable.size(); i ++) {

            TreeItem<String> branch = new TreeItem<>(arrTable.get(i));

            rootItem.getChildren().set(i, branch);
        }
*/
        treeView.setRoot(rootItem);

    }

    public void selectTable() throws SQLException {

        Statement state3 = connect.createStatement();
       // TreeItem<String> item2 = treeView.getSelectionModel().getSelectedItem();
        TreeItem<String> item2 = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();

        ArrayList<String> arr = new ArrayList<>();
        textArea.clear();
        if (item2 !=null /*&& item2.getChildren() == null*/ && item2.isLeaf() == true) {
            String child = item2.getValue();
            String parent = item2.getParent().getValue();
            System.out.println("SELECT "+child+" FROM "+parent+";");
            ResultSet rs3 = state3.executeQuery("SELECT "+child+" FROM "+parent+";");
            textArea.setText(item2.getParent().getValue()+"\n"+"-----------"+"\n");
            while (rs3.next()){
                textArea.appendText(rs3.getString(1)+"\n");
            }
        }
    }

    public void tableFetch(Connection connection) throws SQLException {

        connect = connection;
        state = connection.createStatement();

        resultset = state.executeQuery("SHOW TABLES");

        while (resultset.next()){
            String value = resultset.getString(1);
            TreeItem<String> branch = new TreeItem<>(value);

            Statement state2 = connection.createStatement();
            ResultSet resultsetTable = state2.executeQuery("SHOW COLUMNS FROM "+value);

            while (resultsetTable.next()){
                String child = resultsetTable.getString(1);
                TreeItem<String> childBranch = new TreeItem<>(child);
               // System.out.println(child);
                branch.getChildren().add(childBranch);
            }

            rootItem.getChildren().add(branch);

           // arrTable.add(resultset.getString(1));
           // System.out.println(resultset.getString(1));
        }

      //  System.out.println("Array made");
    }
}
