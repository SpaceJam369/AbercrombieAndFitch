package com.ravi.android.abercrombieandfitch.promotion;


import com.ravi.android.abercrombieandfitch.common.network.NetComponent;
import com.ravi.android.abercrombieandfitch.common.utils.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(dependencies = NetComponent.class, modules = PromotionalModule.class)
public interface PromotionalComponent {
    void inject(PromotionalActivity activity);
}
