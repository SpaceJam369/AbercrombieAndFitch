package com.ravi.android.abercrombieandfitch.application;


import android.app.Application;

import com.ravi.android.abercrombieandfitch.common.network.DaggerNetComponent;
import com.ravi.android.abercrombieandfitch.common.network.NetComponent;
import com.ravi.android.abercrombieandfitch.common.network.NetModule;

public class AbercrombieApplication extends Application {

    private static AppComponent mAppComponent;
    private static NetComponent mNetComponent;
    private static final String BASE_URL = "https://www.abercrombie.com";
    private static final  String HOST_NAME = "www.abercrombie.com";

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                        .appModule(new AppModule(this))
                        .build();

        mNetComponent = DaggerNetComponent.builder()
                        .appComponent(mAppComponent)
                        .netModule(new NetModule(BASE_URL, HOST_NAME))
                        .build();
    }

    public static NetComponent getNetComponent(){
        return mNetComponent;
    }

    public static AppComponent getAppComponent(){
        return mAppComponent;
    }
}
