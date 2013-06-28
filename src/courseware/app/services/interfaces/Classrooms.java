package courseware.app.services.interfaces;

import courseware.app.core.Constants;
import courseware.app.models.Classroom;
import courseware.app.services.UsersService;
import java.util.List;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

import retrofit.http.Query;

public interface Classrooms {
    @GET(UsersService.ENDPOINT)
    void classrooms(@Path("classroom") String classroomId,
        @Query(Constants.ACCESS_TOKEN_PARAM) String accessToken,
        Callback<List<Classroom>> callback);
}
