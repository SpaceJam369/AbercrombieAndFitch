package com.ravi.android.abercrombieandfitch.common.network.endpoint;


import com.ravi.android.abercrombieandfitch.model.ProductCard;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface EndpointInterface {

    @Headers("Accept: application/json")
    @GET("anf/nativeapp/qa/codetest/codeTest_exploreData.json")
    Observable<List<ProductCard>> getProductDataDetails();
}
