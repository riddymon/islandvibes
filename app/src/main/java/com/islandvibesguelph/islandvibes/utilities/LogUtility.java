package com.islandvibesguelph.islandvibes.utilities;

/**
 * Created by djriddy on 2015-12-23.
 */
import android.app.Activity;
import android.util.Log;

import com.islandvibesguelph.islandvibes.Options;

public class LogUtility {

    private static final int MAX_LOG_SIZE = 1000;

    public static void debug(String message) {
        if (Options.IS_LOGGING_ENABLED) {
            logLongMessage(message, false, null);
        }
    }

    public static void error(String message, Throwable throwable) {
        if (Options.IS_LOGGING_ENABLED) {
            logLongMessage(message, true, throwable);
        }
    }

    public static void debugToast(final Activity activity, final String mValue) {
        if (Options.IS_DEBUG_MODE) {
            UiUtility.createToastMessage(activity, mValue);
        }
    }

    private static void logLongMessage(String message, boolean isError, Throwable throwable) {
        for (int i = 0; i <= message.length() / MAX_LOG_SIZE; i++) {
            int start = i * MAX_LOG_SIZE;
            int end = (i + 1) * MAX_LOG_SIZE;
            end = end > message.length() ? message.length() : end;

            if (isError) {
                Log.w(Options.LOG_TAG, message.substring(start, end), throwable);
            } else {
                Log.d(Options.LOG_TAG, message.substring(start, end));
            }
        }
    }

}
