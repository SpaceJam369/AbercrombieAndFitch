package com.ravi.android.abercrombieandfitch.promotion;


import com.ravi.android.abercrombieandfitch.common.utils.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class PromotionalModule {

    private PromotionalContract.View mView;

    public PromotionalModule(PromotionalContract.View view){
        mView = view;
    }

    @Provides
    @ActivityScope
    PromotionalContract.View provideView(){
        return mView;
    }

}
