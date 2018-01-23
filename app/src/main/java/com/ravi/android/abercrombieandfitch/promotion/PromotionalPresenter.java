package com.ravi.android.abercrombieandfitch.promotion;


import android.util.Log;

import com.ravi.android.abercrombieandfitch.model.ProductCard;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class PromotionalPresenter implements PromotionalContract.Presenter {


    private static final String LOG_TAG = PromotionalPresenter.class.getSimpleName();
    private PromotionalContract.View mView;
    private FetchProductData mFetchProductData;

    @Inject
    public PromotionalPresenter(PromotionalContract.View view, FetchProductData fetchProductData){
        mView = view;
        mFetchProductData = fetchProductData;
    }

    @Override
    public void initialize() {
        mFetchProductData.fetchProductDetails(new PromotionalObserver());
    }

    private void onProductDataReceived(List<ProductCard> productCard) {
        mView.onProductDataReceived(productCard);
    }

    private class PromotionalObserver implements Observer<List<ProductCard>> {
        private List<ProductCard> productCard;

        @Override
        public void onSubscribe(Disposable d) {
            Log.e(LOG_TAG, "On Subscribed");
        }

        @Override
        public void onNext(List<ProductCard> productCardList) {
            this.productCard = productCardList;
        }

        @Override
        public void onError(Throwable e) {
            Log.e(LOG_TAG, Log.getStackTraceString(e));
        }

        @Override
        public void onComplete() {
            Log.e(LOG_TAG, "On Completed");
            onProductDataReceived(productCard);
        }
    }
}

