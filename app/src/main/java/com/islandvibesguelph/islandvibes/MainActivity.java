package com.islandvibesguelph.islandvibes;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.islandvibesguelph.islandvibes.fragments.AboutFragment;
import com.islandvibesguelph.islandvibes.fragments.EventsFragment;
import com.islandvibesguelph.islandvibes.fragments.HomeFragment;
import com.islandvibesguelph.islandvibes.fragments.MixFragment;

public class MainActivity extends Activity {
    private FragmentManager mFragmentManager;
    private AboutFragment mAboutFragment;
    private EventsFragment mEventsFragment;
    private HomeFragment mHomeFragment;
    private MixFragment mMixFragment;
    private static final String HOME_TAG = "home";
    private static final String EVENTS_TAG = "events";

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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(this.getResources().getColor(R.color.black));
        }
    }

    public void onClickEvents() {
        Log.v("Events Button Clicked"," - Event Clicked");
        showEventsView();
    }

    public void onClickHome() {
        Log.v("Home Button Clicked", " - Home Clicked");
        showHomeView();
    }

//    @Override
//    public void onBackPressed() {
//        if (getFragmentManager().getBackStackEntryCount() == 0) {
//            this.finish();
//        } else {
//            getFragmentManager().popBackStack();
//        }
//    }

    @Override
    public void onBackPressed() {
    }

    private void showHomeView() {
        mFragmentManager
                .beginTransaction()
                .replace(R.id.layoutHome, mHomeFragment, HOME_TAG)
                .commit();

    }

    private void showEventsView() {
        mFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.flip_right_in, R.anim.flip_right_out, R.anim.flip_left_in, R.anim.flip_left_out)
                .replace(R.id.layoutHome, mEventsFragment, EVENTS_TAG)
                .addToBackStack(null)
                .commit();
    }

}
