package courseware.app.services;

import courseware.app.models.Classroom;
import courseware.app.services.interfaces.Classrooms;
import retrofit.RestAdapter;

import java.util.List;
import retrofit.Callback;

public class ClassroomsService {
    private Classrooms classrooms;
    private String accessToken;
    public final static String ENDPOINT = "/v1/classrooms/{classroom}";

    public ClassroomsService(RestAdapter adapter, String token) {
        this.classrooms = adapter.create(Classrooms.class);
        this.accessToken = token;
    }

    public void getClassrooms(String classroomId, Callback<List<Classroom>> cb) {
        classrooms.classrooms(classroomId, accessToken, cb);
    }
}
