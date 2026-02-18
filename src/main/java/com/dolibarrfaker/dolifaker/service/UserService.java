package com.dolibarrfaker.dolifaker.service;

import org.springframework.stereotype.Service;
import com.dolibarrfaker.dolifaker.api.DolibarrClient;
import com.dolibarrfaker.dolifaker.api.DolibarrSession;
import com.dolibarrfaker.dolifaker.model.dto.User;

@Service
public class UserService {

    private final DolibarrSession session;

    public UserService(DolibarrSession session) {
        this.session = session;
    }

    public User getCurrentUser() {
        return DolibarrClient.getCurrentUser(session);
    }
}
