package courseware.app.services.interfaces;

import courseware.app.core.Constants;
import courseware.app.models.wrappers.UsersWrapper;
import courseware.app.services.UsersService;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface Users {
    @GET(UsersService.ENDPOINT)
    void users(@Query(Constants.ACCESS_TOKEN_PARAM) String accessToken,
        Callback<UsersWrapper> cb);
}
