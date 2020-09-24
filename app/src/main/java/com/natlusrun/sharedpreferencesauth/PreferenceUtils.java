package com.natlusrun.sharedpreferencesauth;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferenceUtils {

    private static SharedPreferences mPreference;
    private static final String APP_PREF_NAME = "kg.geektech.lesson1";
    private static final String USER_NAME = "kg.geektech.lesson1.username";
    private static final String USER_PASS = "kg.geektech.lesson1.userpassword";

    public static void init(Context context) {
        mPreference = context.getSharedPreferences("", Context.MODE_PRIVATE);
    }

   public static void saveUserName(String userName) {
        mPreference.edit().putString(USER_NAME, userName).apply();
    }

    public static void saveUserPass(String userPass){
        mPreference.edit().putString(USER_PASS, userPass).apply();
    }

    public static  String getUserName() {
        return mPreference.getString(USER_NAME, "");
    }

    public static String getUserPass(){
        return mPreference.getString(USER_PASS, "");
    }

    public static void clearUserInfo(){
        SharedPreferences.Editor editor = mPreference.edit();
        editor.clear();
        editor.apply();
    }
}
