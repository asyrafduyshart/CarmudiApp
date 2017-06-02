package com.carmudi.test.ui.detail;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.carmudi.test.R;
import com.carmudi.test.data.model.ImagesItem;
import com.carmudi.test.data.model.ResultsItem;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by Asyraf Duyshart on 6/2/17.
 */

public class CarImageAdapterDetail extends BaseQuickAdapter<ImagesItem, BaseViewHolder> {
    Context mContext;

    public CarImageAdapterDetail(Context context){
        super(R.layout.item_car_image);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ImagesItem imagesItem) {
        ImageView carImage = baseViewHolder.getView(R.id.image_car_detail);
        Glide.with(mContext).load(imagesItem.getUrl()).centerCrop().into(carImage);
    }
}
