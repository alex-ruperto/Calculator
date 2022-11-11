package calculator.app;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class DisplayView extends HBox {
    public DisplayView(){
        Label displayText = new Label();
        displayText.setText("Test");
        setAlignment(Pos.CENTER);
        setPrefHeight(250);

        getChildren().add(displayText);
    }


}
