package com.dolibarrfaker.dolifaker.javafx;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFxApplication {

    public static void launchJavaFx() {
        Platform.runLater(() -> {
            Label label = new Label("Bonjour");
            label.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
            
            StackPane root = new StackPane();
            root.getChildren().add(label);
            
            Scene scene = new Scene(root, 400, 300);
            
            Stage stage = new Stage();
            stage.setTitle("Dolifaker");
            stage.setScene(scene);
            stage.show();
        });
    }
}
