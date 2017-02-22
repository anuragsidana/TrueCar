package com.example.anurag.truecar;

import android.app.Application;
import android.content.Context;

/**
 * Created by anurag on 2/20/2017.
 */

public class MyApplication extends Application {
    private  static MyApplication sInstance;


    @Override
    public void onCreate() {
        super.onCreate();
        sInstance=this;
    }
    public  static Context getAppContext(){
        return sInstance.getApplicationContext();

    }
}
