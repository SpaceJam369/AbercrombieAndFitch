package com.ravi.android.abercrombieandfitch.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.preference.PreferenceManager;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Application mApplication;

    public AppModule(Application application){
        mApplication = application;
    }

    @Provides
    @AppScoped
    Application provideApplication(){
        return mApplication;
    }

    @AppScoped
    @Provides
    Context provideContext(){
        return mApplication.getApplicationContext();
    }

    @AppScoped
    @Provides
    SharedPreferences provideSharedPreferences(){
        return PreferenceManager.getDefaultSharedPreferences(mApplication);
    }
}
