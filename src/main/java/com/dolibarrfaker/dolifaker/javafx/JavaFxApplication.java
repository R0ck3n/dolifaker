package com.dolibarrfaker.dolifaker.javafx;

import com.dolibarrfaker.dolifaker.javafx.pages.HomePage;
import com.dolibarrfaker.dolifaker.javafx.pages.LoginPage;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class JavaFxApplication {

    private static Stage primaryStage;
    private static Scene loginScene;
    private static Scene homeScene;

    public static void launchJavaFx() {
        Platform.runLater(() -> {
            // Créer la page de connexion
            LoginPage loginPage = new LoginPage();
            loginPage.setOnConnexionSuccess(() -> {
                String url = loginPage.getUrlDolibarr();
                String apiKey = loginPage.getApiKey();
            
                // Test de connexion
                boolean ok = DolibarrClient.testConnection(url, apiKey);
                if (ok) {
                    showHomePage();
                } else {
                    javafx.application.Platform.runLater(() -> {
                        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(
                                javafx.scene.control.Alert.AlertType.ERROR,
                                "Connexion échouée : vérifiez l'URL et la clé API."
                        );
                        alert.showAndWait();
                    });
                }
            });
            loginScene = new Scene(loginPage, 400, 400);
            
            // Créer la page d'accueil
            HomePage homePage = new HomePage();
            homeScene = new Scene(homePage, 400, 300);
            
            // Créer et afficher la fenêtre
            primaryStage = new Stage();
            primaryStage.setTitle("Dolifaker");
            primaryStage.setScene(loginScene);
            primaryStage.show();
        });
    }
    
    private static void showHomePage() {
        if (primaryStage != null && homeScene != null) {
            primaryStage.setScene(homeScene);
        }
    }
}
