package com.ravi.android.abercrombieandfitch.promotion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.ravi.android.abercrombieandfitch.R;
import com.ravi.android.abercrombieandfitch.application.AbercrombieApplication;
import com.ravi.android.abercrombieandfitch.model.ProductCard;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PromotionalActivity extends AppCompatActivity implements PromotionalContract.View {

    @Inject
    PromotionalPresenter mPresenter;

    @BindView(R.id.text_view) TextView mTextView;
    @BindView(R.id.product_Image) ImageView mProductImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotional);
        ButterKnife.bind(this);

        DaggerPromotionalComponent.builder()
                .netComponent(AbercrombieApplication.getNetComponent())
                .promotionalModule(new PromotionalModule(this))
                .build().inject(this);

        mPresenter.initialize();
    }

    @Override
    public void onProductDataReceived(List<ProductCard> productCard) {
        String productca = "";
        for (ProductCard product: productCard){
            productca+= product.toString();
        }
        Picasso.with(this).load(productCard.get(0).getBackgroundImage()).into(mProductImage);
        mTextView.setText(productca);
    }
}
