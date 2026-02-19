package com.dolibarrfaker.dolifaker.javafx.components;

import javafx.scene.control.Button;

public class PrimaryButton extends Button {

    public PrimaryButton(String text) {
        super(text);

        // Ajouter la classe CSS
        this.getStyleClass().add("primary-button");

        // Charger le CSS spécifique si besoin
        this.getStylesheets().add(
            getClass().getResource("/javafx/styles/components/button.css").toExternalForm()
        );

        this.setPrefWidth(250);
    }
}
