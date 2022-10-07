package com.example.calculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Calculator extends Application {

    BorderPane root;
    MenuBar menuBar = new MenuBar();
    Menu File = new Menu("File");

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Calculator App");
        genMenuBar();

        Scene mainScene = new Scene(root, 600, 600);
        stage.setScene(mainScene);
        stage.show();
    }

    private void genMenuBar(){
        root = new BorderPane();
        menuBar.getMenus().addAll(File);
        root.setTop(menuBar);
    }


    public static void main(String[] args) {

        launch(args);
    }
}