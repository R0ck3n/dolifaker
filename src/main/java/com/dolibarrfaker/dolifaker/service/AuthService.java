package com.dolibarrfaker.dolifaker.service;
import org.springframework.stereotype.Service;
import com.dolibarrfaker.dolifaker.api.DolibarrClient;
import com.dolibarrfaker.dolifaker.api.DolibarrSession;

@Service
public class AuthService {
    private final DolibarrSession session;

    public AuthService(DolibarrSession session) {
        this.session = session;
    }

    public boolean login(String url, String apiKey) {
        session.setBaseUrl(url);
        session.setApiKey(apiKey);
        // appel static directement
        return DolibarrClient.testConnection(session);
    }
}
