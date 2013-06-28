package courseware.app.services;

import courseware.app.models.AuthenticationResponse;
import courseware.app.models.Credentials;
import courseware.app.services.interfaces.Authentication;
import retrofit.Callback;
import retrofit.RestAdapter;

public class AuthenticationService {
    private Authentication authentication;
    public final static String ENDPOINT = "/oauth/authenticate";

    public AuthenticationService(RestAdapter adapter) {
        this.authentication = adapter.create(Authentication.class);
    }

    public void login(Credentials credentials, Callback<AuthenticationResponse> callback) {
        authentication.authenticate(credentials, callback);
    }

}
