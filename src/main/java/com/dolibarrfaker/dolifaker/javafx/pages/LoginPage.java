package com.dolibarrfaker.dolifaker.javafx.pages;

import com.dolibarrfaker.dolifaker.javafx.components.LoginForm;
import com.dolibarrfaker.dolifaker.javafx.components.TitleLabel;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class LoginPage extends StackPane {

    private final LoginForm loginForm;

    public LoginPage() {
        loginForm = new LoginForm();

        // 🔹 Titre
        TitleLabel title = new TitleLabel("Connexion à Dolibarr");
        // Centre uniquement le titre horizontalement
        VBox.setMargin(title, new javafx.geometry.Insets(50, 0, 10, 0)); // optionnel : espace en dessous
        title.setMaxWidth(Double.MAX_VALUE); // occupe toute la largeur
        title.setAlignment(Pos.CENTER); // centre le texte

        // 🔹 Container vertical pour titre + formulaire
        VBox container = new VBox(20, title, loginForm); // 20px d'espacement
        this.getChildren().add(container);
        this.setPadding(new javafx.geometry.Insets(20));

        this.getStylesheets().addAll(
            getClass().getResource("/javafx/styles/theme.css").toExternalForm(),
            getClass().getResource("/javafx/styles/base.css").toExternalForm()
        );
    }

    // 🔹 Callback pour le bouton connexion
    public void setOnConnexionSuccess(Runnable callback) {
        loginForm.setOnConnexionSuccess(callback);
    }

    // 🔹 Accès aux champs
    public String getUrlDolibarr() {
        return loginForm.getUrl();
    }

    public String getApiKey() {
        return loginForm.getApiKey();
    }
}
