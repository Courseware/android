package courseware.app;

import courseware.app.core.Constants;
import courseware.app.services.AuthenticationService;
import courseware.app.services.ClassroomsService;
import courseware.app.services.UsersService;
import retrofit.RestAdapter;

public class CoursewareServices {
    private RestAdapter adapter;
    private AuthenticationService authenticationService;
    private UsersService usersService;
    private ClassroomsService classroomsService;
    private String accessToken = "";

    public CoursewareServices() {
        adapter = new RestAdapter.Builder().setServer(Constants.API_URL).setDebug(true).build();

        this.authenticationService = new AuthenticationService(adapter);
    }

    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    public UsersService getUsersService() {
        return usersService;
    }

    public ClassroomsService getClassroomsService() {
        return classroomsService;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        // Every time we change access_token, services should be updated
        setupProtectedServices();
    }

    public String getAccessToken() {
        return accessToken;
    }
    
    private void setupProtectedServices() {
        this.usersService = new UsersService(adapter, accessToken);
        this.classroomsService = new ClassroomsService(adapter, accessToken);
    }
}
