package com.dolibarrfaker.dolifaker.javafx.pages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;

public class LoginPage extends StackPane {
    
    private TextField idField;
    private PasswordField passwordField;
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
        
        Label idLabel = new Label("Identifiant:");
        idField = new TextField();
        idField.setPromptText("Entrez votre identifiant");
        idField.setPrefWidth(250);
        
        Label passwordLabel = new Label("Mot de passe:");
        passwordField = new PasswordField();
        passwordField.setPromptText("Entrez votre mot de passe");
        passwordField.setPrefWidth(250);
        
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
            idField,
            passwordLabel,
            passwordField,
            connexionButton
        );
        
        this.getChildren().add(vbox);
    }
    
    public void setOnConnexionSuccess(Runnable callback) {
        this.onConnexionSuccess = callback;
    }
    
    public String getIdentifiant() {
        return idField.getText();
    }
    
    public String getPassword() {
        return passwordField.getText();
    }
}
