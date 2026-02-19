package com.dolibarrfaker.dolifaker.javafx.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FormNumberLine : une ligne Label + Spinner
 * - Label complet sur la largeur souhaitée
 * - Spinner pour choisir un nombre
 */
public class FormNumberLine extends HBox {

    private final Label label;
    private final Spinner<Integer> spinner;

    public FormNumberLine(String labelText, int min, int max, int initialValue) {
        super(10); // spacing horizontal
        this.setAlignment(Pos.CENTER_LEFT);
        this.setPadding(new Insets(5, 0, 5, 0)); // marge verticale

        // 🔹 Label
        label = new Label(labelText + " :");
        label.setMinWidth(200);       // largeur minimum pour éviter que le texte soit coupé
        label.setMaxWidth(Double.MAX_VALUE);
        label.setWrapText(false);

        // 🔹 Spinner
        spinner = new Spinner<>();
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(min, max, initialValue));
        spinner.setEditable(true);

        // 🔹 Ajouter au HBox
        this.getChildren().addAll(label, spinner);

        // 🔹 Style
        this.getStyleClass().add("form-number-line");
    }

    // 🔹 Accès aux valeurs
    public int getValue() {
        return spinner.getValue();
    }

    public Spinner<Integer> getSpinner() {
        return spinner;
    }

    public Label getLabel() {
        return label;
    }
}
