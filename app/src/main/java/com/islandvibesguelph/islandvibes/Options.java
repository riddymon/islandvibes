package com.islandvibesguelph.islandvibes;

/**
 * Created by djriddy on 2015-12-23.
 */
import android.content.Context;
import com.islandvibesguelph.islandvibes.utilities.PropertyFileUtility;

public class Options {

    public static boolean IS_DEBUG_MODE = false;
    public static String LOG_TAG = "ISLAND_VIBES";

    public static boolean IS_OFFLINE_MODE = false;
    public static boolean IS_LOGGING_ENABLED = true;

    public static void initializeOptions(Context context) {

        PropertyFileUtility props = PropertyFileUtility.getInstance(context);
        String debug = props.getProperty("debug");
        String offline = props.getProperty("offline");
        String loggingEnabled = props.getProperty("loggingEnabled");

        IS_DEBUG_MODE = debug != null ? Boolean.parseBoolean(debug) : false;
        IS_OFFLINE_MODE = offline != null ? Boolean.parseBoolean(offline) : false;
        IS_LOGGING_ENABLED = loggingEnabled != null ? Boolean.parseBoolean(loggingEnabled) : false;

    }
}
