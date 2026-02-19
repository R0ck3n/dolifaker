package com.dolibarrfaker.dolifaker.javafx.pages;

import com.dolibarrfaker.dolifaker.javafx.components.ProjectGeneratorCard;
import com.dolibarrfaker.dolifaker.javafx.components.TopBar;
import com.dolibarrfaker.dolifaker.model.dto.User;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class HomePage extends BorderPane {

    private final User user;

    public HomePage(User user) {
        this.user = user;
        createUI();
    }

    private void createUI() {

        String name = (user != null) ? user.getFullName() : "Utilisateur";

        this.setTop(new TopBar(name));

        ProjectGeneratorCard card = new ProjectGeneratorCard(value -> {
            System.out.println("On génère " + value + " projets !");
            // 👉 Appel DolibarrClient ici plus tard
        });

        StackPane centerWrapper = new StackPane(card);
        centerWrapper.setPadding(new Insets(40));

        this.setCenter(centerWrapper);
    }
}
