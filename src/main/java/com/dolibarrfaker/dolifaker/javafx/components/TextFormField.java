package com.dolibarrfaker.dolifaker.javafx.components;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

/**
 * TextFormField : encapsule un TextField avec Label pour un formulaire
 */
public class TextFormField extends VBox {

    private final TextField textField;

    /**
     * @param labelText texte du label (optionnel)
     * @param promptText texte placeholder dans le TextField
     * @param width largeur du TextField
     */
    public TextFormField(String labelText, String promptText, double width) {
        super(5); // spacing vertical
        this.setAlignment(Pos.CENTER_LEFT);

        // 🔹 Label
        if (labelText != null && !labelText.isEmpty()) {
            Label label = new Label(labelText);
            label.getStyleClass().add("text-form-field-label"); // classe CSS pour le label
            this.getChildren().add(label);
        }

        // 🔹 TextField
        textField = new TextField();
        textField.setPromptText(promptText);
        textField.setPrefWidth(width);
        textField.getStyleClass().add("text-form-field-input"); // classe CSS pour le champ

        this.getChildren().add(textField);

        // 🔹 Classe CSS principale pour le composant
        this.getStyleClass().add("text-form-field");

        // 🔹 Charger CSS spécifique pour ce composant
        this.getStylesheets().add(getClass()
                .getResource("/javafx/styles/components/form.css")
                .toExternalForm());
    }

    // 🔹 Getter pour le TextField
    public TextField getTextField() {
        return textField;
    }

    public String getText() {
        return textField.getText();
    }

    public void setText(String value) {
        textField.setText(value);
    }
}
