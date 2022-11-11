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
    CalculatorView calcView = new CalculatorView();
    DisplayView displayView = new DisplayView();


    @Override
    public void start(Stage stage){

        stage.setTitle("Calculator App");
        genMenuBar();
        setFunctionality();

        Scene mainScene = new Scene(root, 300, 500);
        root.setBottom(calcView);
        root.setCenter(displayView);
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

    private void setFunctionality(){
        calcView.buttons.get(0).setOnAction(event -> { //referring to the button, plusOrMinus
            displayView.setDisplayText("±");
        });

        calcView.buttons.get(1).setOnAction(event -> { //referring to the button, zero
            displayView.setDisplayText("0");
        });

        calcView.buttons.get(2).setOnAction(event -> { //referring to the button, decimal
            displayView.setDisplayText(".");
        });

        calcView.buttons.get(3).setOnAction(event -> { //referring to the button, equals
            displayView.setDisplayText("=");
        });

        calcView.buttons.get(4).setOnAction(event -> { //referring to the button, one
            displayView.setDisplayText("1");
        });

        calcView.buttons.get(5).setOnAction(event -> { //referring to the button, two
            displayView.setDisplayText("2");
        });

        calcView.buttons.get(6).setOnAction(event -> { //referring to the button, three
            displayView.setDisplayText("3");
        });

        calcView.buttons.get(7).setOnAction(event -> { //referring to the button, plus
            displayView.setDisplayText("+");
        });

        calcView.buttons.get(8).setOnAction(event -> { //referring to the button, four
            displayView.setDisplayText("4");
        });

        calcView.buttons.get(9).setOnAction(event -> { //referring to the button, five
            displayView.setDisplayText("5");
        });

        calcView.buttons.get(10).setOnAction(event -> { //referring to the button, six
            displayView.setDisplayText("6");
        });

        calcView.buttons.get(11).setOnAction(event -> { //referring to the button, minus
            displayView.setDisplayText("-");
        });

        calcView.buttons.get(12).setOnAction(event -> { //referring to the button, seven
            displayView.setDisplayText("7");
        });

        calcView.buttons.get(13).setOnAction(event -> { //referring to the button, eight
            displayView.setDisplayText("8");
        });

        calcView.buttons.get(14).setOnAction(event -> { //referring to the button, nine
            displayView.setDisplayText("9");
        });

        calcView.buttons.get(15).setOnAction(event -> { //referring to the button, times
            displayView.setDisplayText("×");
        });

        calcView.buttons.get(16).setOnAction(event -> { //referring to the button, oneOverX
            displayView.setDisplayText("1/x");
        });

        calcView.buttons.get(17).setOnAction(event -> { //referring to the button, xPowerTwo
            displayView.setDisplayText("x²");
        });

        calcView.buttons.get(18).setOnAction(event -> { //referring to the button, squareRoot
            displayView.setDisplayText("√x");
        });

        calcView.buttons.get(19).setOnAction(event -> { //referring to the button, divide
            displayView.setDisplayText("÷");
        });

        calcView.buttons.get(20).setOnAction(event -> { //referring to the button, modulo
            displayView.setDisplayText("%");
        });

        calcView.buttons.get(21).setOnAction(event -> { //referring to the button, clearMostRecent
            displayView.setDisplayText("CE");
        });

        calcView.buttons.get(22).setOnAction(event -> { //referring to the button, clearAll
            displayView.setDisplayText("C");
        });

        calcView.buttons.get(23).setOnAction(event -> { //referring to the button, clearAll
            displayView.setDisplayText("⇦");
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}