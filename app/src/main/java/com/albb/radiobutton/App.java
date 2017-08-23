package com.albb.radiobutton;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * Created by Lenovo on 2017/8/23.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
