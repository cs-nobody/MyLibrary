package com.myutils.commonlibrary;

import android.app.Application;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;

public abstract class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.d("app", " onViewInitFinished is " + arg0);
                if (arg0) {
                    System.out.println("x5内核加载成功==============");
                } else {
                    System.out.println("x5内核加载失败==============");
                }
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(this.getApplicationContext(), cb);
        init();
    }

    protected abstract void init();
}
