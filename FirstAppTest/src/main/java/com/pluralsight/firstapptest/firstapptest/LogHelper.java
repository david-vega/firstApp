package com.pluralsight.firstapptest.firstapptest;


import android.app.Activity;
import android.util.Log;

public class LogHelper {
    public final static String LOG_TAG = "ACTIVITY_EVENT";

    public static void LogCallback(Activity activity, String callbackName){
        String logMag = String.format("Activity:%s | Callback:%s",
                                      activity.getClass().getSimpleName(),
                                      callbackName);
        Log.d(LOG_TAG, logMag);
    }

}
