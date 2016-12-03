package com.islandvibesguelph.islandvibes.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dhall on 2016-12-02.
 */

public class ValidationUtility {

    private static String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

    public static boolean validate(final String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
