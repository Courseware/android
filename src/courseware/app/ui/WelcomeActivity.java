package courseware.app.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.TabHost;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import courseware.app.R;
import courseware.app.ui.adapters.WelcomeAdapter;

public class WelcomeActivity extends SherlockFragmentActivity {
    TabHost tabs;
    ViewPager pager;
    WelcomeAdapter adapter;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.welcome);
        
        tabs = (TabHost) findViewById(android.R.id.tabhost);
	tabs.setup();
        
        pager = (ViewPager) findViewById(R.id.pager);
        adapter = new WelcomeAdapter(this, tabs, pager);
        pager.setAdapter(adapter);
    }
}