package courseware.app.services.interfaces;

import courseware.app.models.AuthenticationResponse;
import courseware.app.models.Credentials;
import courseware.app.services.AuthenticationService;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

public interface Authentication {
    @POST(AuthenticationService.ENDPOINT)
    void authenticate(@Body Credentials credentials,
        Callback<AuthenticationResponse> callback);
}
