package com.carmudi.test.ui.main;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.carmudi.test.R;
import com.carmudi.test.data.model.ResultsItem;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Asyraf Duyshart on 6/1/17.
 */

public class CarAdapter extends BaseQuickAdapter<ResultsItem, BaseViewHolder> {

    Context mContext;

    public CarAdapter(List<ResultsItem> data){
        super(R.layout.item_car, data);
    }

    public CarAdapter(Context context){
        super(R.layout.item_car);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ResultsItem resultsItem) {
        ImageView imageView = baseViewHolder.getView(R.id.img_car);
        Glide.with(mContext).load(resultsItem.getImages().get(0).getUrl()).centerCrop().into(imageView);
        baseViewHolder.setText(R.id.itemTitle, resultsItem.getData().getBrandModel());
        baseViewHolder.setText(R.id.itemDetail, resultsItem.getData().getBrand());
        baseViewHolder.setText(R.id.carPrice, resultsItem.getData().getPrice());
    }


}
