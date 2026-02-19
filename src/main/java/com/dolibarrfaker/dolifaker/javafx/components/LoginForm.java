package com.dolibarrfaker.dolifaker.javafx.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 * LoginForm encapsule les champs URL + API Key + bouton de connexion
 * Utilise TextFormField pour chaque champ et PrimaryButton pour le bouton
 */
public class LoginForm extends VBox {

    private final TextFormField urlFieldComponent;
    private final TextFormField apiKeyFieldComponent;
    private final PrimaryButton connexionButton;

    private Runnable onConnexionSuccess;

    public LoginForm() {
        super(15); // spacing entre les éléments
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(40));

        // 🔹 Champs
        urlFieldComponent = new TextFormField("URL Dolibarr", "Url Dolibarr", 250);
        apiKeyFieldComponent = new TextFormField("Clé API", "clé API", 250);

        // 🔹 Bouton
        connexionButton = new PrimaryButton("Connexion");
        connexionButton.setOnAction(e -> {
            if (onConnexionSuccess != null) {
                onConnexionSuccess.run();
            }
        });

        // Ajouter tous les enfants
        this.getChildren().addAll(
                urlFieldComponent,
                apiKeyFieldComponent,
                connexionButton
        );

        // Charger CSS
        this.getStylesheets().addAll(
            getClass().getResource("/javafx/styles/theme.css").toExternalForm(),
            getClass().getResource("/javafx/styles/base.css").toExternalForm(),
            getClass().getResource("/javafx/styles/components/form.css").toExternalForm()
        );
        this.getStyleClass().add("login-form");
    }

    // 🔹 Callback
    public void setOnConnexionSuccess(Runnable callback) {
        this.onConnexionSuccess = callback;
    }

    // 🔹 Getters pour les valeurs
    public String getUrl() {
        return urlFieldComponent.getText();
    }

    public String getApiKey() {
        return apiKeyFieldComponent.getText();
    }

    // 🔹 Getters pour accéder aux composants si besoin
    public TextFormField getUrlFieldComponent() {
        return urlFieldComponent;
    }

    public TextFormField getApiKeyFieldComponent() {
        return apiKeyFieldComponent;
    }

    public PrimaryButton getConnexionButton() {
        return connexionButton;
    }
}
