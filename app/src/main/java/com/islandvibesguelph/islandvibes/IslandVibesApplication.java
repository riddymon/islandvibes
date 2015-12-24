package com.islandvibesguelph.islandvibes;

/**
 * Created by djriddy on 2015-12-23.
 */
import android.content.Context;
import android.support.multidex.MultiDex;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.app.Application;

import java.util.HashMap;

public class IslandVibesApplication extends Application {

    private HashMap<String, Object> mAppData;

    //Static reference to application context
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();
        Options.initializeOptions(mContext);

        mAppData = new HashMap<String, Object>();
        ActiveAndroid.initialize(this);

    }

    @Override
    protected void attachBaseContext(Context base) {

        super.attachBaseContext(base);
        MultiDex.install(this);
    }


    public static Context getAppContext() {
        return mContext;
    }

    public Object getData(String key) {
        return mAppData.get(key);
    }

    public void setData(String key, Object value) {
        mAppData.put(key, value);
    }

}

