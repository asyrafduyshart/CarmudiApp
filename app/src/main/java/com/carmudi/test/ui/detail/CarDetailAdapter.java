package com.carmudi.test.ui.detail;

import com.carmudi.test.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by Asyraf Duyshart on 6/2/17.
 */

public class CarDetailAdapter extends BaseQuickAdapter<CarDetailAdapterObject, BaseViewHolder> {

    public CarDetailAdapter(){
        super(R.layout.item_detail_car);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, CarDetailAdapterObject carDetailAdapterObject) {
        baseViewHolder.setText(R.id.itemTitle, carDetailAdapterObject.title);
        baseViewHolder.setText(R.id.itemDetail, carDetailAdapterObject.detail);
    }
}
