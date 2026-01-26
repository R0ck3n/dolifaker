package com.dolibarrfaker.dolifaker.javafx.pages;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class HomePage extends StackPane {
    
    public HomePage() {
        createUI();
    }
    
    private void createUI() {
        Label label = new Label("Bonjour");
        label.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        
        this.getChildren().add(label);
        this.setAlignment(Pos.CENTER);
    }
}
