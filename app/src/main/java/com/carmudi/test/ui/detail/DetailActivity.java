package com.carmudi.test.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import javax.inject.Inject;

import butterknife.BindView;

import com.carmudi.test.R;
import com.carmudi.test.data.model.ResultsItem;
import com.carmudi.test.ui.base.BaseActivity;
import com.carmudi.test.ui.common.ErrorView;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class DetailActivity extends BaseActivity implements DetailMvpView, ErrorView.ErrorListener {

    public static final String EXTRA_CAR_OBJECT = "EXTRA_CAR_OBJECT";

    @Inject
    DetailPresenter mDetailPresenter;

    @BindView(R.id.view_error)
    ErrorView mErrorView;
    @BindView(R.id.progress)
    ProgressBar mProgress;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.layout_car)
    View mCarLayout;
    @BindView(R.id.recycler_car)
    RecyclerView mCarImageRecycler;
    @BindView(R.id.recycler_detail)
    RecyclerView mCarDetailRecycler;

    List<CarDetailAdapterObject> detailAdapterObjects;

    CarDetailAdapterObject carDetailAdapterObject;

    private String mCarObjectString;
    CarImageAdapterDetail mCarImageAdapter;
    CarDetailAdapter mCarDetailAdapter;

    public static Intent getStartIntent(Context context, String pokemonName) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_CAR_OBJECT, pokemonName);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        mDetailPresenter.attachView(this);

        mCarObjectString = getIntent().getStringExtra(EXTRA_CAR_OBJECT);
        if (mCarObjectString == null) {
            throw new IllegalArgumentException("Detail Activity requires a car object");
        }

        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);

        mErrorView.setErrorListener(this);

        mCarImageRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mCarDetailRecycler.setLayoutManager(new LinearLayoutManager(this));

        iniImageAdapter();
        iniDetailAdapter();

        mDetailPresenter.getCar(mCarObjectString);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_detail;
    }

    @Override
    public void showCar(ResultsItem car) {
        setTitle(car.getData().getBrand() + " " + car.getData().getBrandModel());
        mCarImageAdapter.addData(car.getImages());

        detailAdapterObjects = new ArrayList<>();

        //Put Detail to Object
        carDetailAdapterObject = new CarDetailAdapterObject();
        carDetailAdapterObject.setData("Brand Model", car.getData().getBrandModel());
        detailAdapterObjects.add(carDetailAdapterObject);

        carDetailAdapterObject = new CarDetailAdapterObject();
        carDetailAdapterObject.setData("Brand Name", car.getData().getBrand());
        detailAdapterObjects.add(carDetailAdapterObject);

        carDetailAdapterObject = new CarDetailAdapterObject();
        carDetailAdapterObject.setData("Price", car.getData().getPrice());
        detailAdapterObjects.add(carDetailAdapterObject);

        carDetailAdapterObject = new CarDetailAdapterObject();
        carDetailAdapterObject.setData("Description", car.getData().getDescription());
        detailAdapterObjects.add(carDetailAdapterObject);

        carDetailAdapterObject = new CarDetailAdapterObject();
        carDetailAdapterObject.setData("Transmisison", car.getData().getTransmission());
        detailAdapterObjects.add(carDetailAdapterObject);

        carDetailAdapterObject = new CarDetailAdapterObject();
        carDetailAdapterObject.setData("Interior", car.getData().getInterior());
        detailAdapterObjects.add(carDetailAdapterObject);

        carDetailAdapterObject = new CarDetailAdapterObject();
        carDetailAdapterObject.setData("Exterior", car.getData().getExterior());
        detailAdapterObjects.add(carDetailAdapterObject);

        carDetailAdapterObject = new CarDetailAdapterObject();
        carDetailAdapterObject.setData("Equipment", car.getData().getEquipment());
        detailAdapterObjects.add(carDetailAdapterObject);

        carDetailAdapterObject = new CarDetailAdapterObject();
        carDetailAdapterObject.setData("Agent", car.getData().getAgencyName());
        detailAdapterObjects.add(carDetailAdapterObject);

        carDetailAdapterObject = new CarDetailAdapterObject();
        carDetailAdapterObject.setData("Agent Email", car.getData().getItemContactEmail());
        detailAdapterObjects.add(carDetailAdapterObject);

        carDetailAdapterObject = new CarDetailAdapterObject();
        carDetailAdapterObject.setData("Agent Phone", car.getData().getItemContactMobile());
        detailAdapterObjects.add(carDetailAdapterObject);



        mCarDetailAdapter.addData(detailAdapterObjects);


        mCarLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void showProgress(boolean show) {
        mErrorView.setVisibility(View.GONE);
        mProgress.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showError(Throwable error) {
        mCarLayout.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
        Timber.e(error, "There was a problem retrieving the pokemon...");
    }

    @Override
    public void onReloadData() {
        mDetailPresenter.getCar(mCarObjectString);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDetailPresenter.detachView();
    }

    private void iniImageAdapter() {
        mCarImageAdapter = new CarImageAdapterDetail(this);
        mCarImageAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        mCarImageRecycler.setAdapter(mCarImageAdapter);
    }

    private void iniDetailAdapter() {
        mCarDetailAdapter = new CarDetailAdapter();
        mCarDetailAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        mCarDetailRecycler.setAdapter(mCarDetailAdapter);
    }
}