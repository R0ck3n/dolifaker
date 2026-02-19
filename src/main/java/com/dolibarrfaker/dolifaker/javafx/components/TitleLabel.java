package com.dolibarrfaker.dolifaker.javafx.components;

import javafx.scene.control.Label;

/**
 * Composant pour un titre principal sur une page.
 */
public class TitleLabel extends Label {

    public TitleLabel(String text) {
        super(text);

        // Charger CSS
        this.getStylesheets().addAll(
                getClass().getResource("/javafx/styles/theme.css").toExternalForm(),
                getClass().getResource("/javafx/styles/base.css").toExternalForm(),
                getClass().getResource("/javafx/styles/components/form.css").toExternalForm());
        this.getStyleClass().add("page-title");

    }
}
