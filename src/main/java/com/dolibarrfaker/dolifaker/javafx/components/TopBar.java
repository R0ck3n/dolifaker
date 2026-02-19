package com.dolibarrfaker.dolifaker.javafx.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class TopBar extends HBox {

    public TopBar(String username) {

        Label userLabel = new Label("Connecté : " + username);
        userLabel.getStyleClass().add("user-label");

        this.getChildren().add(userLabel);

        this.setAlignment(Pos.CENTER_RIGHT);
        this.setPadding(new Insets(15));
        this.getStyleClass().add("top-bar");
    }
}

