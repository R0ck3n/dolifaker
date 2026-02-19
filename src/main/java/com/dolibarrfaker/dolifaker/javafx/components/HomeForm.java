package com.dolibarrfaker.dolifaker.javafx.components;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

/**
 * HomeForm : formulaire complet pour générer des objets
 * - Contient un ou plusieurs FormNumberLine
 * - Bouton Générer
 */
public class HomeForm extends VBox {

    private final PrimaryButton generateButton;
    private final FormNumberLine projectsLine;

    private ProjectGenerationCallback callback;

    public HomeForm(ProjectGenerationCallback callback) {
        super(10);
        this.setPadding(new Insets(10));
        this.callback = callback;

        // 🔹 Ligne projets
        projectsLine = new FormNumberLine("Nombre de projets à générer", 0, 1000, 0);

        // 🔹 Bouton générer
        generateButton = new PrimaryButton("Générer");
        generateButton.setOnAction(e -> {
            if (callback != null) {
                callback.onGenerate(projectsLine.getValue());
            }
        });
        VBox.setMargin(generateButton, new Insets(10,0,0,0)); // marge au-dessus du bouton

        // 🔹 Ajouter tous les enfants
        this.getChildren().addAll(projectsLine, generateButton);

        // 🔹 Style
        this.getStylesheets().add(getClass().getResource("/javafx/styles/components/form.css").toExternalForm());
        this.getStyleClass().add("home-form");
    }

    public void setCallback(ProjectGenerationCallback callback) {
        this.callback = callback;
    }

    public FormNumberLine getProjectsLine() {
        return projectsLine;
    }

    public PrimaryButton getGenerateButton() {
        return generateButton;
    }

    // 🔹 Interface callback
    public interface ProjectGenerationCallback {
        void onGenerate(int count);
    }
}
