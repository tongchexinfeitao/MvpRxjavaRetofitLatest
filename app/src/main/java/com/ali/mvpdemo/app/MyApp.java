package com.ali.mvpdemo.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by mumu on 2018/6/12.
 */

public class MyApp extends Application {
    private static MyApp mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        MyUncaughtException.getInstance().initUncaughtException(this);
    }

    public static Context getAppContext() {
        return mApp;
    }
}
