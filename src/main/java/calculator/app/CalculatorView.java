package calculator.app;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Collections;

public class CalculatorView extends GridPane {
    public CalculatorView(){
        ArrayList<Button> buttons = new ArrayList<>();
        setHgap(1); //set horizontal gap between elements
        setVgap(1); // set vertical gap between elements

        // when adding to CalculatorView, go by column then row
        //row 1
        Button modulo = new Button("%");
        add(modulo, 1, 1);
        Button clearMostRecent = new Button("CE");
        add(clearMostRecent, 2, 1);
        Button clearAll = new Button ("C");
        add(clearAll, 3, 1);
        Button backSpace = new Button("⇦");
        add(backSpace, 4, 1);

        //row 2
        Button oneOverX = new Button("1/x");
        add(oneOverX, 1, 2);
        Button xPowerTwo = new Button("x²");
        add(xPowerTwo, 2, 2);
        Button squareRoot = new Button("√x");
        add(squareRoot, 3, 2);
        Button divide = new Button("÷");
        add(divide, 4, 2);

        //row 3
        Button seven = new Button("7");
        add(seven, 1, 3);
        Button eight = new Button("8");
        add(eight, 2, 3);
        Button nine = new Button("9");
        add(nine, 3, 3);
        Button times = new Button("×");
        add(times, 4, 3);

        //row 4
        Button four = new Button("4");
        add(four, 1, 4);
        Button five = new Button("5");
        add(five, 2, 4);
        Button six = new Button("6");
        add(six, 3, 4);
        Button minus = new Button("-");
        add(minus, 4, 4);

        //row 5
        Button one = new Button("1");
        add(one, 1, 5);
        Button two = new Button("2");
        add(two, 2, 5);
        Button three = new Button("3");
        add(three, 3, 5);
        Button plus = new Button("+");
        add(plus, 4, 5);

        //row 6
        Button plusOrMinus = new Button("±");
        add(plusOrMinus, 1, 6);
        Button zero = new Button("0");
        add(zero, 2, 6);
        Button decimal = new Button(".");
        add(decimal, 3, 6);
        Button equals = new Button("=");
        add(equals, 4, 6);

        //add all the buttons to the buttons arraylist
        Collections.addAll(buttons, plusOrMinus, zero, decimal, equals, //
                one, two, three, plus,
                four, five, six, minus,
                seven, eight, nine, times,
                oneOverX, xPowerTwo, squareRoot, divide,
                modulo, clearMostRecent, clearAll, backSpace);

        for (Button button : buttons) {
            button.setPrefSize(75, 50); //width, height
        }

        setPrefHeight(250);
        setAlignment(Pos.BOTTOM_CENTER);
    }
}
