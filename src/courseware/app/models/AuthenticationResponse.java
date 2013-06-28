package courseware.app.models;

public class AuthenticationResponse {
    public Boolean error = false;
    public String access_token = "";

    public Boolean isError() {
        return error;
    }

    public String getAccessToken() {
        return access_token;
    }
}
