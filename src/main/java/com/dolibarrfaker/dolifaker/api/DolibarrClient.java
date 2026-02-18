package com.dolibarrfaker.dolifaker.api;

import com.dolibarrfaker.dolifaker.model.dto.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DolibarrClient {

    private static final OkHttpClient client = new OkHttpClient();
    private static final ObjectMapper mapper = new ObjectMapper();

    public static boolean testConnection(DolibarrSession session) {

        String url = session.getBaseUrl();
        String apiKey = session.getApiKey();

        if (!url.endsWith("/")) {
            url += "/";
        }
        url += "api/index.php/explorer/swagger.json?";

        try {
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("DOLAPIKEY", apiKey)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                return response.isSuccessful();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // méthode pour modifier et retourner l'utilisateur 26 via la route /users/{id}
    public static User getCurrentUser(DolibarrSession session) {
        String url = session.getBaseUrl();
        if (!url.endsWith("/")) url += "/";
        url += "api/index.php/users/info"; // la route pour l'utilisateur courant
    
        String apiKey = session.getApiKey();
    
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("DOLAPIKEY", apiKey)
                    .build();
    
            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful() && response.body() != null) {
                    String body = response.body().string();
                    User user = mapper.readValue(body, User.class);
                    System.out.println("User récupéré : " + user.getFullName());                    
                    return user;
                } else {
                    System.out.println("Erreur HTTP : " + response.code());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
}
