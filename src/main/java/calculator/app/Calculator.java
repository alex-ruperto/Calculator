package calculator.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Calculator extends Application {

    BorderPane root;
    MenuBar menuBar = new MenuBar();
    Menu File = new Menu("File");
    MenuItem Exit = new MenuItem("Exit");


    @Override
    public void start(Stage stage){

        stage.setTitle("Calculator App");

        genMenuBar();
        genView();

        Scene mainScene = new Scene(root, 300, 500);
        mainScene.getStylesheets().add("style.css");
        stage.setScene(mainScene);
        stage.show();
    }

    private void genMenuBar(){
        root = new BorderPane();  //initialize root borderPane
        File.getItems().add(Exit); //add Exit MenuItem to File Menu

        Exit.setOnAction(event -> System.exit(0)); //set the action for Exit MenuItem to close

        menuBar.getMenus().addAll(File); //add All menus to menuBar. so far only File
        root.setTop(menuBar); //set menuBar to the top of root
    }
    private void genView(){
        CalculatorView calcView = new CalculatorView();
        DisplayView displayView = new DisplayView();

        root.setBottom(calcView);
        root.setCenter(displayView);

    }

    public static void main(String[] args) {

        launch(args);
    }
}