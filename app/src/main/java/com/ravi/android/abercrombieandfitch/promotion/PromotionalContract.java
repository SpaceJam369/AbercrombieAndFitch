package com.ravi.android.abercrombieandfitch.promotion;


import com.ravi.android.abercrombieandfitch.model.ProductCard;

import java.util.List;

public interface PromotionalContract {

    interface View{
       void onProductDataReceived(List<ProductCard> productCard);
    }

    interface Presenter{
        void initialize();
    }
}
