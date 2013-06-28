package courseware.app;

import android.app.Application;

public class CoursewareApplication extends Application {
    private CoursewareServices services;

    @Override public void onCreate() {
        super.onCreate();

        services = new CoursewareServices();
    }

    public CoursewareServices getServices() {
        return services;
    }
}
