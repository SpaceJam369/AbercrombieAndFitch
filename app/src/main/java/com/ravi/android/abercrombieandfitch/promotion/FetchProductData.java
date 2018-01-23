package com.ravi.android.abercrombieandfitch.promotion;


import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ravi.android.abercrombieandfitch.common.network.endpoint.EndpointInterface;
import com.ravi.android.abercrombieandfitch.common.utils.Utility;
import com.ravi.android.abercrombieandfitch.model.ProductCard;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FetchProductData {

    private EndpointInterface mEndPoint;
    private Context mContext;
    private Gson mGson;

    @Inject
    public FetchProductData(EndpointInterface endPoint, Context context, Gson gson){
        mEndPoint = endPoint;
        mContext = context;
        mGson = gson;
    }

    void fetchProductDetails(Observer<List<ProductCard>> observer){
                 getObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer);
    }

    public Observable<List<ProductCard>> getObservable(){
        return Observable.fromCallable(new Callable<List<ProductCard>>(){

            @Override
            public List<ProductCard> call() throws Exception {
                String productCard = Utility.readStringFromJson(mContext, "data");
                return mGson.fromJson(productCard, new TypeToken<List<ProductCard>>(){}.getType());
            }
        }).subscribeOn(Schedulers.newThread());
    }
}
