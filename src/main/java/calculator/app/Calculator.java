package calculator.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class Calculator extends Application {

    BorderPane root;
    MenuBar menuBar = new MenuBar();
    Menu File = new Menu("File");
    MenuItem Exit = new MenuItem("Exit");
    CalculatorView calcView = new CalculatorView();
    DisplayView displayView = new DisplayView();
    ArrayList<Float> values = new ArrayList<>();
    ArrayList<String> entered = new ArrayList<>(); // will be used to store numbers entered to create the 'value'
    String arithmetic;
    int latestValIndex;
    int previousValIndex;
    float result;
    String stringNum;



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
            entered.add("-");
            if (entered.indexOf("-") != 0) { //if indexOf "-" is not 0
                entered.add(0, null); //add a null element at index 0
                Collections.swap(entered, entered.indexOf("-"), entered.indexOf(null)); //swap "-" with null element at index 0
                entered.remove(null); //remove null element from entered
            }
            displayView.setDisplayText(formattedString(entered)); //set the displayView displayText to entered
        });

        calcView.buttons.get(1).setOnAction(event -> { //referring to the button, zero
            entered.add("0");
            displayView.setDisplayText(formattedString(entered));
        });

        calcView.buttons.get(2).setOnAction(event -> { //referring to the button, decimal
            entered.add(".");
            displayView.setDisplayText(formattedString(entered));
        });

        calcView.buttons.get(3).setOnAction(event -> { //referring to the button, equals
            try { //start try catch block
                if (displayView.getDisplayText().getText().isEmpty()) { //if displayView text is empty
                    throw new NoValuesPressedException("Error"); //throw this exception
                } else if (displayView.getDisplayText().getText().contains("Error")){ //or if it contains "Error"
                    throw new NoValuesPressedException("Error"); //throw this exception
                } else { //otherwise
                    calculate(arithmetic); //run arithmetic method
                }
            } catch (NoValuesPressedException er){ //catch thrown exception
                displayView.setDisplayText(er.getMessage()); //set displayView text to error message
            }
        });

        calcView.buttons.get(4).setOnAction(event -> { //referring to the button, one
            entered.add("1");
            displayView.setDisplayText(formattedString(entered));
        });

        calcView.buttons.get(5).setOnAction(event -> { //referring to the button, two
            entered.add("2");
            displayView.setDisplayText(formattedString(entered));
        });

        calcView.buttons.get(6).setOnAction(event -> { //referring to the button, three
            entered.add("3");
            displayView.setDisplayText(formattedString(entered));
        });

        calcView.buttons.get(7).setOnAction(event -> { //referring to the button, plus
            ////call the operationException method then call the operationAction method.
            operationException(() -> operationAction("+"));
        });

        calcView.buttons.get(8).setOnAction(event -> { //referring to the button, four
            entered.add("4");
            displayView.setDisplayText(formattedString(entered));
        });

        calcView.buttons.get(9).setOnAction(event -> { //referring to the button, five
            entered.add("5");
            displayView.setDisplayText(formattedString(entered));
        });

        calcView.buttons.get(10).setOnAction(event -> { //referring to the button, six
            entered.add("6");
            displayView.setDisplayText(formattedString(entered));
        });

        calcView.buttons.get(11).setOnAction(event -> { //referring to the button, minus
            //call the operationException method then call the operationAction method.
            operationException(() -> operationAction("-"));
        });

        calcView.buttons.get(12).setOnAction(event -> { //referring to the button, seven
            entered.add("7");
            displayView.setDisplayText(formattedString(entered));
        });

        calcView.buttons.get(13).setOnAction(event -> { //referring to the button, eight
            entered.add("8");
            displayView.setDisplayText(formattedString(entered));
        });

        calcView.buttons.get(14).setOnAction(event -> { //referring to the button, nine
            entered.add("9");
            displayView.setDisplayText(formattedString(entered));
        });

        calcView.buttons.get(15).setOnAction(event -> { //referring to the button, times
            //call the operationException method then call the operationAction method.
            operationException(() -> operationAction("×"));
        });

        //TODO SET FUNCTIONALITY FOR 1/x
        calcView.buttons.get(16).setOnAction(event -> { //referring to the button, oneOverX
            //call the operationException method then call the operationAction method
            operationException(() -> operationAction("1/X"));
        });

        calcView.buttons.get(17).setOnAction(event -> { //referring to the button, xPowerTwo
            //call the operationException method then call the operationAction method
            operationException(() -> operationAction("x²"));
        });

        //TODO SET FUNCTIONALITY FOR √x
        calcView.buttons.get(18).setOnAction(event -> { //referring to the button, squareRoot
            //call the operationException method then call the operationAction method
            operationException(() -> operationAction("√x"));
        });

        calcView.buttons.get(19).setOnAction(event -> { //referring to the button, divide
            //call the operationException method then call the operationAction method
            operationException(() -> operationAction("÷"));
        });

        calcView.buttons.get(20).setOnAction(event -> { //referring to the button, modulo
            //call the operationException method then call the operationAction method
            operationException(() -> operationAction("%"));
        });

        calcView.buttons.get(21).setOnAction(event -> { //referring to the button, clearMostRecent
            entered.clear();
        });

        calcView.buttons.get(22).setOnAction(event -> { //referring to the button, clearAll
            displayView.setPreviousText("");
            displayView.setDisplayText("");
            displayView.setOperationText("");
            values.clear(); //clear the values from values arraylist
        });

        //TODO SET FUNCTIONALITY FOR ⇦
        calcView.buttons.get(23).setOnAction(event -> { //referring to the button, backSpace
            operationException(() -> operationAction("⇦"));
        });
    }

    public String formattedString(ArrayList<String> arrayList){
        return arrayList.toString()
                .replace(",", "")
                .replace("[", "")
                .replace("]", "")
                .replace(" ", "")
                .trim();
    }

    public void calculate(String arithmetic){
        switch (arithmetic) {
            case "+" -> {
                String stringNum = displayView.getDisplayText().getText();
                values.add(Float.parseFloat(stringNum));
                latestValIndex = values.size() - 1;
                previousValIndex = latestValIndex - 1;
                result = values.get(latestValIndex) + values.get(previousValIndex); //latestVal + previousVal
                displayView.setDisplayText(String.valueOf(result)); //set the displayText to string value of result
                values.add(result); //add the result to values
            }
            case "-" -> {
                String stringNum = displayView.getDisplayText().getText();
                values.add(Float.parseFloat(stringNum));
                latestValIndex = values.size() - 1;
                previousValIndex = latestValIndex - 1;
                result = values.get(previousValIndex) - values.get(latestValIndex); //subtract previous val and latest val
                displayView.setDisplayText(String.valueOf(result));//set the displayText to string value of result
                values.add(result); //add the result to values
            }
            case "×" -> {
                String stringNum = displayView.getDisplayText().getText();
                values.add(Float.parseFloat(stringNum));
                latestValIndex = values.size() - 1;
                previousValIndex = latestValIndex - 1;
                result = values.get(previousValIndex) * values.get(latestValIndex); //multiply previous val and latest val
                displayView.setDisplayText(String.valueOf(result));//set the displayText to string value of result
                values.add(result); //add the result to values

            }
            case "÷" -> {
                String stringNum = displayView.getDisplayText().getText();
                values.add(Float.parseFloat(stringNum));
                latestValIndex = values.size() - 1;
                previousValIndex = latestValIndex - 1;
                result = values.get(previousValIndex) / values.get(latestValIndex); //divide previous val and latest val
                displayView.setDisplayText(String.valueOf(result));//set the displayText to string value of result
                values.add(result); //add the result to values

            }
            case "%" ->{
                String stringNum = displayView.getDisplayText().getText();
                values.add(Float.parseFloat(stringNum));
                latestValIndex = values.size() - 1;
                previousValIndex = latestValIndex - 1;
                result = values.get(previousValIndex) % values.get(latestValIndex); //divide previous val and latest val
                displayView.setDisplayText(String.valueOf(result));//set the displayText to string value of result
                values.add(result); //add the result to values
            }
            case "x²" -> {
                String stringNum = displayView.getDisplayText().getText();
                values.add(Float.parseFloat(stringNum));
                latestValIndex = values.size() - 1;
                previousValIndex = latestValIndex - 1;
                result = (float) Math.pow(values.get(latestValIndex), 2); //divide previous val and latest val
                displayView.setDisplayText(String.valueOf(result));//set the displayText to string value of result
                values.add(result); //add the result to values
            }
        }
    }

    public void operationAction(String operation){
        stringNum = displayView.getDisplayText().getText(); //set stringNum equal to the text from displayText
        values.add(Float.parseFloat(stringNum)); // add the stringNum value to values by parsing to float
        displayView.setOperationText(operation); //set the displayText to operation
        arithmetic = operation; //set arithmetic to operation, this will communicate with the = sign.
        displayView.setPreviousText(stringNum); //set te previousText to stringNum
        entered.clear(); //clear the entered arraylist to start a new set of numbers.
    }

    public void operationException(Runnable function) { //THIS WILL SHORTEN AMOUNT OF CODE IN setFunctionality()
        try { //start try catch block
            if (displayView.getDisplayText().getText().isEmpty()) { //if displayView text is empty
                throw new NoValuesPressedException("Error"); //throw this exception
            } else if (displayView.getDisplayText().getText().contains("Error")){ //or if it contains "Error"
                throw new NoValuesPressedException("Error"); //throw this exception
            } else { //otherwise
                function.run(); //run generic method
            }
        } catch (NoValuesPressedException er){ //catch thrown exception
            displayView.setDisplayText(er.getMessage()); //set displayView text to error message
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}