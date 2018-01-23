package com.ravi.android.abercrombieandfitch.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductCard {

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("backgroundImage")
    private String backgroundImage;

    @Expose
    @SerializedName("content")
    private List<Content> content;

    @Expose
    @SerializedName("promoMessage")
    private String promoMessage;

    @Expose
    @SerializedName("topDescription")
    private String topDescription;

    @Expose
    @SerializedName("bottomDescription")
    private String bottomDescription;

    public String getTitle() {
        return title;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public List<Content> getContent() {
        return content;
    }

    public String getPromoMessage() {
        return promoMessage;
    }

    public String getTopDescription() {
        return topDescription;
    }

    public String getBottomDescription() {
        return bottomDescription;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
