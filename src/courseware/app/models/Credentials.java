package courseware.app.models;

import courseware.app.core.Constants;

public class Credentials {
    private String email;
    private String password;
    private String client_id = Constants.CLIENT_ID;

    public Credentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
