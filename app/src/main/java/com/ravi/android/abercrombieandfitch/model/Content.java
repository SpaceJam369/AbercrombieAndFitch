package com.ravi.android.abercrombieandfitch.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Content {

    @Expose
    @SerializedName("target")
    private String target;

    @Expose
    @SerializedName("title")
    private String contentTitle;

    public String getTarget() {
        return target;
    }

    public String getContentTitle() {
        return contentTitle;
    }
}
