package calculator.app;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class DisplayView extends HBox {
    Label displayText = new Label();
    Label previousText = new Label();

    public DisplayView(){
        Region region1 = new Region();
        Region region2 = new Region();

        HBox.setHgrow(region1, Priority.ALWAYS);
        HBox.setHgrow(region2, Priority.ALWAYS);

        getChildren().addAll(region1, displayText, region2, previousText);

        setAlignment(Pos.CENTER);
        setPrefHeight(250);

    }

    public void setDisplayText(String newText){
        this.displayText.setText(newText);
    }

    public void setPreviousText(String newText){
        this.previousText.setText(newText);
    }


}
