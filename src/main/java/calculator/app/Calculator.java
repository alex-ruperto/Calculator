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

    BorderPane root; //root borderpane; this will have two 'halves,' top and bottom
    MenuBar menuBar = new MenuBar(); //create new menubar Object
    Menu File = new Menu("File"); //create new menu object that will go inside the menuBar
    MenuItem Exit = new MenuItem("Exit"); //create new MenuItem that will go inside File menu
    CalculatorView calcView = new CalculatorView(); //calcView Object (refer to class)
    DisplayView displayView = new DisplayView(); //displayView Object (refer to class)
    ArrayList<Float> values = new ArrayList<>(); //all the values that were entered in 'entered'
    ArrayList<String> entered = new ArrayList<>(); // new elements get added to this with each button press regarding the number user wants
    String arithmetic; //use for a switch in calculate()
    int latestValIndex; //index of the newest value in values
    int previousValIndex; //index of the value before the newest value in values.
    float result; //result of the calculation. resides in calculate() method.
    String stringNum; //used to hold the value of what is in displayView.displayText. Once user is done entering a value.

    public void start(Stage stage){
        stage.setTitle("Calculator App"); //set the title of stage to this
        genMenuBar(); //call the genMenuBar() method to init borderPane and menuBar
        setFunctionality(); //call the setFunctionality method to set functionality for all the buttons.

        Scene mainScene = new Scene(root, 300, 500); //initialize main scene object with root as the pane, and the size to 300x500
        root.setBottom(calcView); //calcView is the bottom half
        root.setCenter(displayView); //calcview is the top half, but it is set to center since the menuBar is at root.setTop()
        mainScene.getStylesheets().add("style.css"); //set the stylesheet for mainScene to style.css
        stage.setScene(mainScene); //set the scene for stage to main scene
        stage.show(); //necessary to be able to see the application.
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
            entered.add("-"); //add the string "-" to 'entered'.
            if (entered.indexOf("-") != 0) { //if indexOf "-" is not 0
                entered.add(0, null); //add a null element at index 0
                Collections.swap(entered, entered.indexOf("-"), entered.indexOf(null)); //swap "-" with null element at index 0
                entered.remove(null); //remove null element from entered
            }
            displayView.setDisplayText(formattedString(entered)); //in displayView, call setDisplayText method using formattedString method for entered
        });

        calcView.buttons.get(1).setOnAction(event -> { //referring to the button, zero
            entered.add("0"); //add the string "0" to 'entered'.
            displayView.setDisplayText(formattedString(entered)); //in displayView, call setDisplayText method using formattedString method for entered
        });

        calcView.buttons.get(2).setOnAction(event -> { //referring to the button, decimal
            entered.add("."); //add the "." to 'entered'
            displayView.setDisplayText(formattedString(entered)); //in displayView, call setDisplayText method using formattedString method for entered
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
            displayView.setDisplayText(formattedString(entered)); //in displayView, call setDisplayText method using formattedString method for entered
        });

        calcView.buttons.get(5).setOnAction(event -> { //referring to the button, two
            entered.add("2");
            displayView.setDisplayText(formattedString(entered)); //in displayView, call setDisplayText method using formattedString method for entered
        });

        calcView.buttons.get(6).setOnAction(event -> { //referring to the button, three
            entered.add("3");
            displayView.setDisplayText(formattedString(entered)); //in displayView, call setDisplayText method using formattedString method for entered
        });

        calcView.buttons.get(7).setOnAction(event -> { //referring to the button, plus
            ////call the operationException method then call the operationAction method.
            operationException(() -> operationAction("+"));
        });

        calcView.buttons.get(8).setOnAction(event -> { //referring to the button, four
            entered.add("4");
            displayView.setDisplayText(formattedString(entered)); //in displayView, call setDisplayText method using formattedString method for entered
        });

        calcView.buttons.get(9).setOnAction(event -> { //referring to the button, five
            entered.add("5");
            displayView.setDisplayText(formattedString(entered)); //in displayView, call setDisplayText method using formattedString method for entered
        });

        calcView.buttons.get(10).setOnAction(event -> { //referring to the button, six
            entered.add("6");
            displayView.setDisplayText(formattedString(entered)); //in displayView, call setDisplayText method using formattedString method for entered
        });

        calcView.buttons.get(11).setOnAction(event -> { //referring to the button, minus
            //call the operationException method then call the operationAction method.
            operationException(() -> operationAction("-"));
        });

        calcView.buttons.get(12).setOnAction(event -> { //referring to the button, seven
            entered.add("7");
            displayView.setDisplayText(formattedString(entered)); //in displayView, call setDisplayText method using formattedString method for entered
        });

        calcView.buttons.get(13).setOnAction(event -> { //referring to the button, eight
            entered.add("8");
            displayView.setDisplayText(formattedString(entered)); //in displayView, call setDisplayText method using formattedString method for entered
        });

        calcView.buttons.get(14).setOnAction(event -> { //referring to the button, nine
            entered.add("9");
            displayView.setDisplayText(formattedString(entered)); //in displayView, call setDisplayText method using formattedString method for entered
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
            //call the operationException method then call the operationAction method
            operationException(() -> operationAction("⇦"));
        });
    }

    public String formattedString(ArrayList<String> arrayList){ //this will reformat the toString method to fit the syntax for displayView
        //it essentially just returns a custom toString method for an arraylist.
        return arrayList.toString() //call the toString method for arrayList
                .replace(",", "") //replace , with nothing
                .replace("[", "") //replace [ with nothing
                .replace("]", "") //replace ] with nothing
                .replace(" ", "") //replace " " with nothing
                .trim(); //call trim method
    }

    public void calculate(String arithmetic){
        switch (arithmetic) {
            case "+" -> {
                initializeStringNum(); //call the initializeStringNum method.
                result = values.get(latestValIndex) + values.get(previousValIndex); //latestVal + previousVal
                displayView.setDisplayText(String.valueOf(result)); //set the displayText to string value of result
                values.add(result); //add the result to values
            }
            case "-" -> {
                initializeStringNum(); //call the initializeStringNum method.
                result = values.get(previousValIndex) - values.get(latestValIndex); //subtract previous val and latest val
                displayView.setDisplayText(String.valueOf(result));//set the displayText to string value of result
                values.add(result); //add the result to values
            }
            case "×" -> {
                initializeStringNum(); //call the initializeStringNum method.
                result = values.get(previousValIndex) * values.get(latestValIndex); //multiply previous val and latest val
                displayView.setDisplayText(String.valueOf(result));//set the displayText to string value of result
                values.add(result); //add the result to values

            }
            case "÷" -> {
                initializeStringNum(); //call the initializeStringNum method.
                result = values.get(previousValIndex) / values.get(latestValIndex); //divide previous val and latest val
                displayView.setDisplayText(String.valueOf(result));//set the displayText to string value of result
                values.add(result); //add the result to values

            }
            case "%" ->{
                initializeStringNum(); //call the initializeStringNum method.
                result = values.get(previousValIndex) % values.get(latestValIndex); //divide previous val and latest val
                displayView.setDisplayText(String.valueOf(result));//set the displayText to string value of result
                values.add(result); //add the result to values
            }
            case "x²" -> {
                initializeStringNum(); //call the initializeStringNum method.
                result = (float) Math.pow(values.get(latestValIndex), 2); //divide previous val and latest val
                displayView.setDisplayText(String.valueOf(result));//set the displayText to string value of result
                values.add(result); //add the result to values
            }
        }
    }

    public void initializeStringNum(){
        //this method will both initialize stringNum variable, add it to values, and initialize latestValIndex and previousValIndex
        stringNum = displayView.getDisplayText().getText();  //set the value of stringNum to the text in displayText of displayView
        values.add(Float.parseFloat(stringNum)); //add the parsed float value of stringNum to values.
        latestValIndex = values.size() - 1; //set latestValIndex to(size of Values - 1)
        previousValIndex = latestValIndex - 1; //set previousValIndex to (latetValIndex - 1)
    }

    public void operationAction(String operation){
        stringNum = displayView.getDisplayText().getText(); //set stringNum equal to the text from displayText
        values.add(Float.parseFloat(stringNum)); // add the stringNum value to values by parsing to float
        displayView.setOperationText(operation); //set the displayText to operation
        arithmetic = operation; //set arithmetic to operation, this will communicate with the = sign.
        displayView.setPreviousText(stringNum); //set te previousText to stringNum
        entered.clear(); //clear the entered arraylist to start a new set of numbers.
    }

    public void operationException(Runnable function) { //THIS WILL SHORTEN AMOUNT OF CODE IN setFunctionality(). Takes in a method as a parameter.
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