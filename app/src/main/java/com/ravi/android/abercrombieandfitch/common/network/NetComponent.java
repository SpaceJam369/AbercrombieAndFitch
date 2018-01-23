package com.ravi.android.abercrombieandfitch.common.network;

import android.app.Application;
import android.content.Context;

import com.ravi.android.abercrombieandfitch.application.AppComponent;
import com.ravi.android.abercrombieandfitch.common.network.endpoint.EndpointInterface;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

@Singleton
@Component(dependencies = AppComponent.class, modules = NetModule.class)
public interface NetComponent {

    OkHttpClient okHttpClient();
    Retrofit retrofit();
    HttpLoggingInterceptor httpLoggingInterceptor();
    EndpointInterface endpointInterface();

    Context context();
    Application application();

}
