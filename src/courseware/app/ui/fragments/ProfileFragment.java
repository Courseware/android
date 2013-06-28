package courseware.app.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockFragment;
import courseware.app.CoursewareApplication;
import courseware.app.CoursewareServices;
import courseware.app.R;
import courseware.app.models.User;
import courseware.app.models.wrappers.UsersWrapper;
import courseware.app.services.UsersService;
import java.util.List;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ProfileFragment extends SherlockFragment {
    CoursewareServices services;
    UsersService users;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        services = ((CoursewareApplication) getActivity().getApplication()).getServices();
        users = services.getUsersService();
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {        
        View v = inflater.inflate(R.layout.profile, container, false);
        final TextView text = (TextView) v.findViewById(R.id.text);
        text.setText("PROFILE");
        
        users.getUsers(new Callback<UsersWrapper>() {
            public void failure(RetrofitError re) {}

            public void success(UsersWrapper userlist, Response rspns) {
                if(!userlist.getUsers().isEmpty()) {
                    text.setText(userlist.getUsers().get(0).email);
                }
            }
        });
        return v;
    }

}