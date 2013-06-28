package courseware.app.ui.utils;

import android.content.Context;
import android.view.View;
import android.widget.TabHost;

public class TabFactory implements TabHost.TabContentFactory {
    private final Context mContext;

    public TabFactory(Context context) {
        mContext = context;
    }

    @Override
    public View createTabContent(String tag) {
        View v = new View(mContext);
        v.setMinimumWidth(0);
        v.setMinimumHeight(0);
        return v;
    }
}