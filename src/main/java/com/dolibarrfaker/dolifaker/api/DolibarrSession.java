package com.dolibarrfaker.dolifaker.api;

import org.springframework.stereotype.Component;

/**
 * Stocke l'URL Dolibarr et la clé API pour la session en cours.
 * Utilisé par DolibarrClient et les services métier.
 */
@Component
public class DolibarrSession {

    private String baseUrl;
    private String apiKey;

    public DolibarrSession() {
        // valeurs par défaut (optionnel)
        this.baseUrl = "";
        this.apiKey = "";
    }

    public DolibarrSession(String baseUrl, String apiKey) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
    }

    // --- Getters et setters ---
    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    // --- Utilitaires ---
    /**
     * Vérifie si la session est configurée
     */
    public boolean isConfigured() {
        return baseUrl != null && !baseUrl.isEmpty()
                && apiKey != null && !apiKey.isEmpty();
    }
}

