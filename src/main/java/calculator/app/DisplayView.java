package calculator.app;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class DisplayView extends HBox {
    Label displayText = new Label();
    public DisplayView(){
        setAlignment(Pos.CENTER);
        setPrefHeight(250);
        getChildren().add(displayText);
    }

    public void setDisplayText(String newText){
        this.displayText.setText(newText);
    }


}
