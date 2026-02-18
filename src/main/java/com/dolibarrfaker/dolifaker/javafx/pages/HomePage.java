package com.dolibarrfaker.dolifaker.javafx.pages;

import com.dolibarrfaker.dolifaker.model.dto.User;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class HomePage extends StackPane {

    private final User user;

    public HomePage(User user) {
        this.user = user;
        createUI();
    }

    private void createUI() {
        String name = (user != null) ? user.getFullName() : "Utilisateur";
        Label label = new Label("Bonjour " + name);
        label.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        this.getChildren().add(label);
        this.setAlignment(Pos.CENTER);
    }
}
