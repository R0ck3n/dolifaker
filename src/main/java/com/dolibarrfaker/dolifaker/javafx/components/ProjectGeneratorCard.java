package com.dolibarrfaker.dolifaker.javafx.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.util.function.Consumer;

public class ProjectGeneratorCard extends VBox {

    private final Spinner<Integer> projetsInput;

    public ProjectGeneratorCard(Consumer<Integer> onGenerate) {

        Label title = new Label("Générer des projets");
        title.getStyleClass().add("title");

        Label projetsLabel = new Label("Nombre de projets");

        projetsInput = new Spinner<>();
        projetsInput.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1000, 5)
        );
        projetsInput.setEditable(true);

        Button submitButton = new Button("Générer");
        submitButton.getStyleClass().add("primary-button");

        submitButton.setOnAction(event -> {
            int value = projetsInput.getValue();
            onGenerate.accept(value);
        });

        this.getChildren().addAll(title, projetsLabel, projetsInput, submitButton);

        this.setSpacing(15);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(30));
        this.setMaxWidth(350);
        this.getStyleClass().add("card");
    }
}
