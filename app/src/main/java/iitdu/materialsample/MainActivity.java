package iitdu.materialsample;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends ActionBarActivity implements android.support.v7.app.ActionBar.TabListener {
    ViewPager mPager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new QuickReturnFragment();
                    case 1:
                        return new StickyFragment();
                }
                return null;
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return getString(R.string.quick_return_item);
                    case 1:
                        return getString(R.string.sticky_item);
                }
                return null;
            }
        };

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(adapter);
        mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                getSupportActionBar().setSelectedNavigationItem(position);
            }
        });

        mPager.setPageMargin(getResources().getDimensionPixelSize(R.dimen.page_margin));

        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        for (int position = 0; position < adapter.getCount(); position++) {
            getSupportActionBar().addTab( getSupportActionBar().newTab()
                    .setText(adapter.getPageTitle(position))
                    .setTabListener(this));
        }

        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }


    @Override
    public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {

    }
}
