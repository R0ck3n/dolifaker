package com.dolibarrfaker.dolifaker.javafx;

import com.dolibarrfaker.dolifaker.api.DolibarrClient;
import com.dolibarrfaker.dolifaker.api.DolibarrSession;
import com.dolibarrfaker.dolifaker.javafx.pages.HomePage;
import com.dolibarrfaker.dolifaker.javafx.pages.LoginPage;
import com.dolibarrfaker.dolifaker.model.dto.User;
import com.dolibarrfaker.dolifaker.service.UserService;

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
            DolibarrSession session = new DolibarrSession(); // crée une session temporaire
            loginPage.setOnConnexionSuccess(() -> {
                String url = loginPage.getUrlDolibarr();
                String apiKey = loginPage.getApiKey();

                // Mettre à jour la session
                session.setBaseUrl(url);
                session.setApiKey(apiKey);

                // Test de connexion
                boolean ok = DolibarrClient.testConnection(session);
                if (ok) {

                    UserService userService = new UserService(session);
                    User user = userService.getCurrentUser();
                    HomePage homePage = new HomePage(user);
                    homeScene = new Scene(homePage, 400, 300);
                    showHomePage();
                } else {
                    Platform.runLater(() -> {
                        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(
                                javafx.scene.control.Alert.AlertType.ERROR,
                                "Connexion échouée : vérifiez l'URL et la clé API."
                        );
                        alert.showAndWait();
                    });
                }
            });

            loginScene = new Scene(loginPage, 400, 400);



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
