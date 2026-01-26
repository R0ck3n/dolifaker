package com.dolibarrfaker.dolifaker.javafx;

import com.dolibarrfaker.dolifaker.javafx.pages.HomePage;
import com.dolibarrfaker.dolifaker.javafx.pages.LoginPage;
import javafx.application.Platform;
import javafx.scene.Scene;
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
                // Quand on clique sur connexion, aller à la page d'accueil
                showHomePage();
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
