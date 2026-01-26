package com.dolibarrfaker.dolifaker;

import com.dolibarrfaker.dolifaker.javafx.JavaFxApplication;
import javafx.application.Platform;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DolifakerApplication {

	public static void main(String[] args) {
		// Vérifier si on est en mode headless (tests, serveur, etc.)
		boolean isHeadless = java.awt.GraphicsEnvironment.isHeadless();
		
		if (!isHeadless) {
			// Initialiser JavaFX - doit être fait avant Spring Boot
			Platform.startup(() -> {
				// JavaFX est maintenant initialisé
			});
		}
		
		// Lancer Spring Boot
		SpringApplication.run(DolifakerApplication.class, args);
	}

	@EventListener
	public void onApplicationReady(ApplicationReadyEvent event) {
		// Ne pas lancer JavaFX si on est en mode headless
		if (java.awt.GraphicsEnvironment.isHeadless()) {
			return;
		}
		
		// Vérifier si on est dans un contexte de test en vérifiant la stack trace
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		boolean isTest = false;
		for (StackTraceElement element : stackTrace) {
			if (element.getClassName().contains("junit") || 
			    element.getClassName().contains("test") ||
			    element.getClassName().contains("surefire")) {
				isTest = true;
				break;
			}
		}
		
		if (isTest) {
			return;
		}
		
		// Lancer la fenêtre JavaFX
		try {
			Platform.runLater(() -> {
				JavaFxApplication.launchJavaFx();
			});
		} catch (IllegalStateException e) {
			// Si le toolkit n'est pas encore initialisé, réessayer dans un thread séparé
			new Thread(() -> {
				try {
					// Attendre que JavaFX soit complètement initialisé
					Thread.sleep(300);
					Platform.runLater(() -> {
						JavaFxApplication.launchJavaFx();
					});
				} catch (InterruptedException ie) {
					Thread.currentThread().interrupt();
				} catch (IllegalStateException ise) {
					// JavaFX n'est pas disponible, ignorer silencieusement
				}
			}).start();
		}
	}
}
