package courseware.app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.internal.widget.IcsToast;
import courseware.app.CoursewareApplication;
import courseware.app.R;
import courseware.app.models.AuthenticationResponse;
import courseware.app.models.Credentials;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginActivity extends SherlockFragmentActivity {

    private TextView loginButton;
    private EditText emailInput;
    private EditText passwordInput;
    private Intent showWelcome;

    private Credentials credentials;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);

        loginButton = (TextView) findViewById(R.id.login_button);
        emailInput = (EditText) findViewById(R.id.email_field);
        passwordInput = (EditText) findViewById(R.id.password_field);
        showWelcome = new Intent(LoginActivity.this, WelcomeActivity.class);

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                credentials = new Credentials(emailInput.getText().toString(), passwordInput.getText().toString());

                getApp().getServices().getAuthenticationService().login(credentials, new Callback<AuthenticationResponse>() {
                    public void success(AuthenticationResponse auth, Response response) {
                        if (!auth.isError()) {
                            getApp().getServices().setAccessToken(auth.getAccessToken());

                            IcsToast.makeText(getApplicationContext(), R.string.auth_success, IcsToast.LENGTH_SHORT).show();
                            startActivity(showWelcome);
                        } else {
                            IcsToast.makeText(getApplicationContext(), R.string.auth_failure, IcsToast.LENGTH_SHORT).show();
                        }
                    }
                    
                    public void failure(RetrofitError retrofitError) {
                        IcsToast.makeText(getApplicationContext(), R.string.auth_success, IcsToast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public LoginActivity getActivity() {
        return this;
    }

    public CoursewareApplication getApp() {
        return (CoursewareApplication) getApplication();
    }
}