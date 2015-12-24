package com.islandvibesguelph.islandvibes.utilities;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by djriddy on 2015-12-23.
 */
public class AppUtility {

    /**
     * Used to get the version of the application
     *
     * @param context : provide context of the app
     * @return : String with version name
     */
    public static String getVersion(Context context) {

        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            LogUtility.error("",e);
        }

        return "";
    }
}
