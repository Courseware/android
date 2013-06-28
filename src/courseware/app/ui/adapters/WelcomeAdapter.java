package courseware.app.ui.adapters;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import courseware.app.CoursewareApplication;
import courseware.app.R;
import courseware.app.ui.fragments.ClassroomsFragment;
import courseware.app.ui.fragments.ProfileFragment;
import courseware.app.ui.utils.TabFactory;


public class WelcomeAdapter extends FragmentPagerAdapter
    implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {
    
    private int PAGES_COUNT = 2;
    private TabHost tabs;
    private ViewPager pager;
    private Context context;
    private CoursewareApplication service;
    
    public WelcomeAdapter(FragmentActivity activity, TabHost tabs, ViewPager pager) {
        super(activity.getSupportFragmentManager());
        
        this.context = activity;
        this.tabs = tabs;
        this.pager = pager;
        
        this.tabs.setOnTabChangedListener(this);
        this.pager.setOnPageChangeListener(this);
        
        addTab(context.getResources().getString(R.string.profile_tab));
        addTab(context.getResources().getString(R.string.classrooms_tab));
    }

    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new ProfileFragment();
            case 1:
                return new ClassroomsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGES_COUNT;
    }

    public void onTabChanged(String tabId) {
        int position = tabs.getCurrentTab();
        pager.setCurrentItem(position);
    }
    
    public void onPageSelected(int position) {
        TabWidget widget = tabs.getTabWidget();
        tabs.setCurrentTab(position);
    }
    
    private void addTab(String label) {
        TabSpec spec = tabs.newTabSpec("simple");
        spec.setIndicator(label);
        spec.setContent(new TabFactory(context));
        tabs.addTab(spec);
        notifyDataSetChanged();
    }

    public void onPageScrolled(int i, float f, int i1) {}
    public void onPageScrollStateChanged(int i) {}
}