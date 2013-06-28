package courseware.app.services;

import courseware.app.models.wrappers.UsersWrapper;
import courseware.app.services.interfaces.Users;
import retrofit.Callback;
import retrofit.RestAdapter;

public class UsersService {
    private Users users;
    private String accessToken;
    
    public final static String ENDPOINT = "/v1/users";

    public UsersService(RestAdapter adapter, String token) {
        this.users = adapter.create(Users.class);
        this.accessToken = token;
    }

    public void getUsers(Callback<UsersWrapper> callback) {
        users.users(accessToken, callback);
    }
}
