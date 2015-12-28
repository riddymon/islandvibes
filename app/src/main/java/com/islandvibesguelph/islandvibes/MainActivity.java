package com.islandvibesguelph.islandvibes;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.islandvibesguelph.islandvibes.fragments.AboutFragment;
import com.islandvibesguelph.islandvibes.fragments.EventsFragment;
import com.islandvibesguelph.islandvibes.fragments.HomeFragment;
import com.islandvibesguelph.islandvibes.fragments.MixFragment;

public class MainActivity extends AppCompatActivity {
    private FragmentManager mFragmentManager;
    private AboutFragment mAboutFragment;
    private EventsFragment mEventsFragment;
    private HomeFragment mHomeFragment;
    private MixFragment mMixFragment;
    private static final String HOME_TAG = "home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getFragmentManager();
        mAboutFragment = new AboutFragment();
        mEventsFragment = new EventsFragment();
        mHomeFragment = new HomeFragment();
        mMixFragment = new MixFragment();
        clearStatusBar();
        initializeUI();
    }

    private void initializeUI() {
        showHomeView();
    }

    private void clearStatusBar() {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    private void showHomeView() {

        mFragmentManager
                .beginTransaction()
                .replace(R.id.layoutHome, mHomeFragment, HOME_TAG)
                .commit();
    }


}
