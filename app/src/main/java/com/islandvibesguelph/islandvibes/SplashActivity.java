package com.islandvibesguelph.islandvibes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.islandvibesguelph.islandvibes.models.UserInfo;
import com.islandvibesguelph.islandvibes.utilities.AppUtility;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends Activity {
    private TextView mLblVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        clearStatusBar();
        showSpinner();
        initializeUI();
        populateData();
    }

    private void goToHome() {
//        scheduleAlarm(System.currentTimeMillis() + Constants.REFRESH_DURATION);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void goToUserInfo() {
//        scheduleAlarm(System.currentTimeMillis() + Constants.REFRESH_DURATION);
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
        finish();
    }

    private void getStartupData() {
        UserInfo redir = new UserInfo();
        redir.setFirstName("dennis");
        redir.setLastName("hall");
        redir.setEmail("test@email.com");
        redir.save();

        if (isFirstRun()) {
            goToUserInfo();
        } else {
            goToHome();
        }
    }

    //Determine if app should display user info screen
    private Boolean isFirstRun() {
        boolean firstRun;
        ArrayList<UserInfo> savedUsers = (ArrayList<UserInfo>)UserInfo.getUser();

        if(savedUsers == null || savedUsers.isEmpty()){
            firstRun = true;
        }
        else {
            firstRun = false;
        }
//        UserInfo lastUser = aaTest.get(aaTest.size()-1);
        return firstRun;
    }

    private void clearStatusBar() {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    private void showSpinner() {
        ImageView imageView = (ImageView) findViewById(R.id.imgSplash);
        imageView.setImageResource(R.drawable.splash_icon);
        Animation pulse = AnimationUtils.loadAnimation(this, R.anim.pulse);
        imageView.startAnimation(pulse);
    }

    private void initializeUI() {
        mLblVersion = (TextView)findViewById(R.id.lblVersion);
    }

    private void populateData() {
        mLblVersion.setText(getString(R.string.lblVersion) + " " + getAppVersion());

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                getStartupData();
            }
        }, 2000);


    }

    private String getAppVersion() {
        return AppUtility.getVersion(this);
    }

}
