package calculator.app;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class DisplayView extends HBox {
    private final Label displayText = new Label();
    private final Label previousText = new Label();
    private final Label operationText = new Label();

    public DisplayView(){
        Region region1 = new Region();
        Region region2 = new Region();

        HBox.setHgrow(region1, Priority.ALWAYS);
        HBox.setHgrow(region2, Priority.ALWAYS);

        getChildren().addAll(region1, displayText, region2, previousText, operationText);

        setAlignment(Pos.CENTER);
        setPrefHeight(250);

        displayText.getStyleClass().add("displayText-label");
        previousText.getStyleClass().add("previousText-label");
        operationText.getStyleClass().add("operationText-label");

    }

    public void setDisplayText(String newText){
        this.displayText.setText(newText);
    }

    public Label getDisplayText(){
        return this.displayText;
    }

    public void setPreviousText(String newText){
        this.previousText.setText(newText);
    }

    public void setOperationText(String newText){
        this.operationText.setText(newText);
    }


}
