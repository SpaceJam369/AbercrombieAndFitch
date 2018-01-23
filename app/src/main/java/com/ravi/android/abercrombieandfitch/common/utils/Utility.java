package com.ravi.android.abercrombieandfitch.common.utils;


import android.content.Context;

import java.io.InputStream;
import java.util.Scanner;

public class Utility {

    public static String readStringFromJson(Context context, String fileName){
        int jsonResId = context.getResources().getIdentifier(fileName, "raw", context.getPackageName());
        InputStream inputStream = context.getResources().openRawResource(jsonResId);
        Scanner sc = new Scanner(inputStream).useDelimiter("\\A");
        return sc.hasNext()? sc.next() : "";
    }
}
