package calculator.app;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class Calculator extends Application {

    BorderPane root;
    MenuBar menuBar = new MenuBar();
    Menu File = new Menu("File");
    MenuItem Exit = new MenuItem("Exit");


    @Override
    public void start(Stage stage){

        stage.setTitle("Calculator App");

        genMenuBar();
        genButtons();

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
    private void genButtons(){
        ArrayList<Button> buttons = new ArrayList<>();
        GridPane calcView = new GridPane();
        calcView.setHgap(1);
        calcView.setVgap(1);
        calcView.setAlignment(Pos.CENTER);
        // when adding to calcView, go by column to row

        //row 1
        Button modulo = new Button("%");
        calcView.add(modulo, 1, 1);
        Button clearMostRecent = new Button("CE");
        calcView.add(clearMostRecent, 2, 1);
        Button clearAll = new Button ("C");
        calcView.add(clearAll, 3, 1);
        Button backSpace = new Button("⇦");
        calcView.add(backSpace, 4, 1);

        //row 2
        Button oneOverX = new Button("1/x");
        calcView.add(oneOverX, 1, 2);
        Button xPowerTwo = new Button("x²");
        calcView.add(xPowerTwo, 2, 2);
        Button squareRoot = new Button("√x");
        calcView.add(squareRoot, 3, 2);
        Button divide = new Button("÷");
        calcView.add(divide, 4, 2);

        //row 3
        Button seven = new Button("7");
        calcView.add(seven, 1, 3);
        Button eight = new Button("8");
        calcView.add(eight, 2, 3);
        Button nine = new Button("9");
        calcView.add(nine, 3, 3);
        Button times = new Button("×");
        calcView.add(times, 4, 3);

        //row 4
        Button four = new Button("4");
        calcView.add(four, 1, 4);
        Button five = new Button("5");
        calcView.add(five, 2, 4);
        Button six = new Button("6");
        calcView.add(six, 3, 4);
        Button minus = new Button("-");
        calcView.add(minus, 4, 4);

        //row 5
        Button one = new Button("1");
        calcView.add(one, 1, 5);
        Button two = new Button("2");
        calcView.add(two, 2, 5);
        Button three = new Button("3");
        calcView.add(three, 3, 5);
        Button plus = new Button("+");
        calcView.add(plus, 4, 5);

        //row 6
        Button plusOrMinus = new Button("±");
        calcView.add(plusOrMinus, 1, 6);
        Button zero = new Button("0");
        calcView.add(zero, 2, 6);
        Button decimal = new Button(".");
        calcView.add(decimal, 3, 6);
        Button equals = new Button("=");
        calcView.add(equals, 4, 6);



        Collections.addAll(buttons, plusOrMinus, zero, decimal, equals,
                                    one, two, three, plus,
                                    four, five, six, minus,
                                    seven, eight, nine, times,
                                    oneOverX, xPowerTwo, squareRoot, divide,
                                    modulo, clearMostRecent, clearAll, backSpace);

        for (Button button : buttons) {
            button.setPrefSize(75, 50); //width, height
        }
        calcView.setAlignment(Pos.BOTTOM_CENTER);

        root.setCenter(calcView);



    }


    public static void main(String[] args) {

        launch(args);
    }
}