package com.dolibarrfaker.dolifaker.javafx.pages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;

public class LoginPage extends StackPane {
    
    private TextField urlField;
    private TextField apiKeyField;
    private Button connexionButton;
    private Runnable onConnexionSuccess;
    
    public LoginPage() {
        createUI();
    }
    
    private void createUI() {
        VBox vbox = new VBox(15);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(40));
        
        Label titleLabel = new Label("Connexion");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        
        Label idLabel = new Label("Entrez l'url Dolibarr :");
        urlField = new TextField();
        urlField.setPromptText("Url Dolibarr");
        urlField.setPrefWidth(250);
        
        Label passwordLabel = new Label("Entrer la clé API:");
        apiKeyField = new TextField();
        apiKeyField.setPromptText("clé API");
        apiKeyField.setPrefWidth(250);
        
        connexionButton = new Button("Connexion");
        connexionButton.setPrefWidth(250);
        connexionButton.setStyle("-fx-font-size: 14px;");
        
        connexionButton.setOnAction(e -> {
            if (onConnexionSuccess != null) {
                onConnexionSuccess.run();
            }
        });
        
        vbox.getChildren().addAll(
            titleLabel,
            idLabel,
            urlField,
            passwordLabel,
            apiKeyField,
            connexionButton
        );
        
        this.getChildren().add(vbox);
    }
    
    public void setOnConnexionSuccess(Runnable callback) {
        this.onConnexionSuccess = callback;
    }
    
    public String getUrlDolibarr() {
        return urlField.getText();
    }
    
    public String getApiKey() {
        return apiKeyField.getText();
    }
    
}
