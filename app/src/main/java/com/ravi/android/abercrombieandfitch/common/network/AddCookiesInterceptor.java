package com.ravi.android.abercrombieandfitch.common.network;


import android.content.SharedPreferences;
import android.util.Log;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AddCookiesInterceptor implements Interceptor {

    private SharedPreferences mSharedPreferences;
    public AddCookiesInterceptor(SharedPreferences sharedPreferences){
        mSharedPreferences = sharedPreferences;
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        HashSet<String> preferences = (HashSet) mSharedPreferences.getStringSet("Cookies", new HashSet<String>());
        for (String cookie : preferences) {
            builder.addHeader("set-cookie", cookie);
            Log.v("Ravi", "Adding Header: " + cookie); // This is done so I know which headers are being added; this interceptor is used after the normal logging of OkHttp
        }

        return chain.proceed(builder.build());
    }
}