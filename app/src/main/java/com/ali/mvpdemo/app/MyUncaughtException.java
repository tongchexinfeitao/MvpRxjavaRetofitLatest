package com.ali.mvpdemo.app;

import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.util.Log;

/**
 * Created by mumu on 2018/6/12.
 */

public class MyUncaughtException implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Log.e("tag", "打印出错误信息 + " + e.getMessage());

        android.os.Process.killProcess(android.os.Process.myPid());
        Process.killProcess(Process.myPid());
    }

    private static MyUncaughtException myUncaughtException = new MyUncaughtException();

    public static MyUncaughtException getInstance() {
        return myUncaughtException;
    }

    Context context;
    Handler handler;





    public void initUncaughtException(Context context) {
        this.context = context;
        handler = new Handler() {
        };
        Thread.setDefaultUncaughtExceptionHandler(myUncaughtException);

    }
}
