package org.rspeer.network.service;

import com.google.inject.Inject;
import dev.yasper.rump.client.DefaultRestClient;
import lombok.AllArgsConstructor;
import org.rspeer.network.auth.RSPeerUser;
import org.rspeer.network.dto.UserLoginRequest;

import java.io.IOException;

@AllArgsConstructor
public class UserService {

    @Inject
    private final DefaultRestClient restClient;

    public boolean login(String username, String password) {
        try {
            RSPeerUser user = restClient.postForObject("/auth/", new UserLoginRequest(username, password), RSPeerUser.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
