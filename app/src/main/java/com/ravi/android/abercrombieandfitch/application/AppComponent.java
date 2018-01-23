package com.ravi.android.abercrombieandfitch.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import dagger.Component;

@AppScoped
@Component(modules = AppModule.class)
public interface AppComponent {
    Context providesContext();
    Application provideApplication();
    SharedPreferences provideSharedPreferences();
}
