package com.islandvibesguelph.islandvibes;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.islandvibesguelph.islandvibes.fragments.AboutFragment;
import com.islandvibesguelph.islandvibes.fragments.InfoFragment;

public class InfoActivity extends FragmentActivity {
    private FragmentManager mFragmentManager;
    private InfoFragment mInfoFragment;
    private static final String INFO_TAG = "info";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        mFragmentManager = getFragmentManager();
        mInfoFragment = new InfoFragment();
        clearStatusBar();
        initializeUI();
    }

    private void initializeUI() {
    }

    private void clearStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(this.getResources().getColor(R.color.black));
        }
        showInfoFragment();
    }

    private void showInfoFragment() {
        mFragmentManager
                .beginTransaction()
                .replace(R.id.layoutInfo, mInfoFragment, INFO_TAG)
                .commit();
    }

    public void goToNextScreen() {

    }
}
