package com.islandvibesguelph.islandvibes;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.islandvibesguelph.islandvibes.fragments.AboutFragment;
import com.islandvibesguelph.islandvibes.fragments.InfoConfirmFragment;
import com.islandvibesguelph.islandvibes.fragments.InfoFragment;

import java.util.Timer;
import java.util.TimerTask;

public class InfoActivity extends FragmentActivity {
    private FragmentManager mFragmentManager;
    private InfoFragment mInfoFragment;
    private InfoConfirmFragment mInfoConfirmFragment;
    private static final String INFO_TAG = "info";
    private static final String INFO_CONFIRM_TAG = "info confirm";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        mFragmentManager = getFragmentManager();
        mInfoFragment = new InfoFragment();
        mInfoConfirmFragment = new InfoConfirmFragment();
        clearStatusBar();
        initializeUI();
    }

    public void onClickSaveInfo() {
        goToConfirmation();
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

    private void goToConfirmation() {
        mFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.flip_right_in, R.anim.flip_right_out, R.anim.flip_left_in, R.anim.flip_left_out)
                .replace(R.id.layoutInfo, mInfoConfirmFragment, INFO_CONFIRM_TAG)
                .addToBackStack(null)
                .commit();
    }

    public void navToMain() {
        goToMain();
    }

    private void goToMain() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        }, 3*1000);
    }

}
