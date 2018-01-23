package com.ravi.android.abercrombieandfitch.common.network;


import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ravi.android.abercrombieandfitch.common.network.endpoint.EndpointInterface;

import java.util.Collections;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.CertificatePinner;
import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {

    private String mBaseUrl;
    private String mHostName;

    public NetModule(String baseUrl, String hostName) {
        mBaseUrl = baseUrl;
        mHostName = hostName;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, SharedPreferences sharedPreferences) {
        ConnectionSpec connectionSpec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                .build();

        CertificatePinner certificatePinner = new CertificatePinner.Builder()
                .add(mHostName, "sha256/SUYiGITAArDzgZ+n0HOrp8gkuhzj4e8SdrbMIey+1YI=")
                .add(mHostName, "sha256/pvsOo/07kXBfe36yjJgm6H46EJRe7gurjSAeunJgFyg=")
                .add(mHostName, "sha256/JbQbUG5JMJUoI6brnx0x3vZF6jilxsapbXGVfjhN8Fg=")
                .build();

        return new OkHttpClient.Builder()
                .connectionSpecs(Collections.singletonList(connectionSpec))
                .certificatePinner(certificatePinner)
                .addNetworkInterceptor(httpLoggingInterceptor)
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    EndpointInterface provideEndPoint(Retrofit retrofit) {
        return retrofit.create(EndpointInterface.class);
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        return httpLoggingInterceptor;
    }
}
