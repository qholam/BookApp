package com.example.tommyspc.books;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

/**
 * Created by Calvin on 11/17/16.
 */

public class SaveLogin {
    static final String PREF_USER_NAME= "email";

    static SharedPreferences getSharedPref(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setUserName(Context context, String email)
    {
        Editor editor = getSharedPref(context).edit();
        editor.putString(PREF_USER_NAME, email);
        editor.commit();
    }

    public static String getUserName(Context context)
    {
        return getSharedPref(context).getString(PREF_USER_NAME, "");
    }
}