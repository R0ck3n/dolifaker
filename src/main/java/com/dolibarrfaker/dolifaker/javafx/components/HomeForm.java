package com.dolibarrfaker.dolifaker.javafx.components;

import com.dolibarrfaker.dolifaker.model.dto.HomeFormValues;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

/**
 * HomeForm : formulaire pour générer des objets (projets, utilisateurs…)
 * - Contient des FormNumberLine pour chaque type d’objet
 * - Ne centre pas son contenu : layout respecté par le parent
 */
public class HomeForm extends VBox {

    private final FormNumberLine projectsLine;
    private final FormNumberLine tiersLine;
    private final PrimaryButton generateButton;
    private ProjectGenerationCallback callback;

    public HomeForm(ProjectGenerationCallback callback) {
        super(10); // espacement vertical
        this.setPadding(new Insets(10));
        this.callback = callback;

        // 🔹 Ligne pour générer des projets
        projectsLine = new FormNumberLine(
                "Nombre de projets à générer",
                0, 1000, 0);
        this.getChildren().add(projectsLine);

        // 🔹 Ligne pour générer des Tiers
        tiersLine = new FormNumberLine(
                "Nombre de Tiers à générer",
                0, 1000, 0);
        this.getChildren().add(tiersLine);

        // 🔹 Bouton "Générer"
        generateButton = new PrimaryButton("Générer");
        generateButton.setOnAction(e -> {
            if (callback != null) {
                callback.onGenerate(new HomeFormValues(
                    projectsLine.getValue(),
                    tiersLine.getValue()
                ));
            }
        });
        this.getChildren().add(generateButton); // ⚡ Ajouter le bouton au VBox

        // Charger CSS spécifique formulaire
        this.getStylesheets().add(
                getClass().getResource("/javafx/styles/components/form.css").toExternalForm());
        this.getStyleClass().add("home-form");
    }

    // 🔹 Setter callback si besoin
    public void setCallback(ProjectGenerationCallback callback) {
        this.callback = callback;
    }

    // 🔹 Getter pour récupérer la valeur actuelle
    public int getProjectCount() {
        return projectsLine.getValue();
    }

    public FormNumberLine getProjectsLine() {
        return projectsLine;
    }

    public PrimaryButton getGenerateButton() {
        return generateButton;
    }

    // 🔹 Interface callback
    public interface ProjectGenerationCallback {
        void onGenerate(HomeFormValues values);
    }
    
}
