package com.dolibarrfaker.dolifaker.javafx.pages;

import com.dolibarrfaker.dolifaker.javafx.components.HomeForm;
import com.dolibarrfaker.dolifaker.javafx.components.TitleLabel;
import com.dolibarrfaker.dolifaker.javafx.components.TopBar;
import com.dolibarrfaker.dolifaker.model.dto.User;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class HomePage extends BorderPane {

    private final User user;

    public HomePage(User user) {
        this.user = user;
        createUI();
    }

    private void createUI() {
        String name = (user != null) ? user.getFullName() : "Utilisateur";

        // 🔹 TopBar avec nom utilisateur
        this.setTop(new TopBar(name));

        // 🔹 Titre de la page
        TitleLabel title = new TitleLabel("Génération des objets");

        // 🔹 Formulaire central
        HomeForm homeForm = new HomeForm(value -> {
            System.out.println("On génère " + value + " projets !");
            // 👉 Appel DolibarrClient ici
        });

        // 🔹 Container vertical : titre + formulaire
        VBox centerContainer = new VBox(20, title, homeForm); // 20px spacing
        centerContainer.setPadding(new Insets(40));

        this.setCenter(centerContainer);

        // 🔹 Optionnel : appliquer style global
        this.getStylesheets().addAll(
            getClass().getResource("/javafx/styles/theme.css").toExternalForm(),
            getClass().getResource("/javafx/styles/base.css").toExternalForm()
        );
    }
}
