package com.islandvibesguelph.islandvibes.utilities;

/**
 * Created by djriddy on 2015-12-23.
 */
import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileUtility {

    private static PropertyFileUtility mInstance;
    private Properties mProperties;

    private PropertyFileUtility() {
    }

    public static PropertyFileUtility getInstance(Context context) {

        if (mInstance == null) {
            mInstance = new PropertyFileUtility();
            mInstance.loadProperties(context);
        }

        return mInstance;
    }

    private void loadProperties(Context context){

        String envUrl = "app.properties";
        AssetManager assetManager = context.getAssets();
        mProperties = new Properties();

        try{
            InputStream mInputStream = assetManager.open(envUrl);
            mProperties.load(mInputStream);
        }catch(IOException e){
            LogUtility.error("",e);
        }
    }

    public String getProperty(String key){
        return mProperties.getProperty(key);
    }

}