package com.example.mobiledemo.base;

import android.app.Application;

import com.example.mobiledemo.utils.Utils;


/**
 * Created by sunhuahui on 2017/1/29.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
