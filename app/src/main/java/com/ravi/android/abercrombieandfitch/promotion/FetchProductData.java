package com.ravi.android.abercrombieandfitch.promotion;


import com.ravi.android.abercrombieandfitch.common.network.endpoint.EndpointInterface;
import com.ravi.android.abercrombieandfitch.model.ProductCard;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FetchProductData {

    private EndpointInterface mEndPoint;

    @Inject
    public FetchProductData(EndpointInterface endPoint){
        mEndPoint = endPoint;
    }

    void fetchProductDetails(Observer<List<ProductCard>> observer){
        mEndPoint.getProductDataDetails()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer);
    }
}
