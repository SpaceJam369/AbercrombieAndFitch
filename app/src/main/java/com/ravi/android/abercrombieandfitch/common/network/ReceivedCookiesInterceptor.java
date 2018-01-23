package com.ravi.android.abercrombieandfitch.common.network;


import android.content.SharedPreferences;
import android.util.Log;

import java.io.IOException;
import java.util.HashSet;
import java.util.prefs.Preferences;

import okhttp3.Interceptor;
import okhttp3.Response;

public class ReceivedCookiesInterceptor implements Interceptor {

    private SharedPreferences mSharedPreferences;
    public ReceivedCookiesInterceptor(SharedPreferences sharedPreferences){
        mSharedPreferences =sharedPreferences;
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("set-cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();

            for (String header : originalResponse.headers("set-cookie")) {
                Log.e("received", header);
                cookies.add(header);
            }

            mSharedPreferences.edit()
                    .putStringSet("Cookies", cookies)
                    .apply();
        }

        return originalResponse;
    }
}