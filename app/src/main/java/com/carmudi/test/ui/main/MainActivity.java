package com.carmudi.test.ui.main;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import butterknife.BindView;
import com.carmudi.test.R;
import com.carmudi.test.data.model.ResultsItem;
import com.carmudi.test.ui.base.BaseActivity;
import com.carmudi.test.ui.common.ErrorView;
import com.carmudi.test.ui.detail.DetailActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.gson.Gson;


import timber.log.Timber;

public class MainActivity extends BaseActivity implements MainMvpView,
        ErrorView.ErrorListener, BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    private static final int CAR_COUNT = 5;

    private int mCurrentPage = 1;

    CarAdapter mCarAdapter;

    List<ResultsItem> resultsItem;

    @Inject
    MainPresenter mMainPresenter;

    @BindView(R.id.view_error)
    ErrorView mErrorView;
    @BindView(R.id.progress)
    ProgressBar mProgress;
    @BindView(R.id.recycler_car)
    RecyclerView mCarRecycler;
    @BindView(R.id.swipe_to_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    String selectedSort = "newest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        mMainPresenter.attachView(this);

        setSupportActionBar(mToolbar);

        mSwipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.primary);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.white);
        mSwipeRefreshLayout.setOnRefreshListener(this);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mCarRecycler.setLayoutManager(linearLayoutManager);
        initAdapter();
        mMainPresenter.getCarList(mCurrentPage,CAR_COUNT,selectedSort);

        mErrorView.setErrorListener(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.filter, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.detachView();
    }

    @Override
    public void showCar(List<ResultsItem> car) {
        resultsItem = new ArrayList<>();
        resultsItem.addAll(car);
        mCarAdapter.addData(resultsItem);
        mCurrentPage += 1;
        mCarAdapter.loadMoreComplete();

        mCarRecycler.setVisibility(View.VISIBLE);
        mSwipeRefreshLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_filter){
            showFilterDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showProgress(boolean show) {
        if (show) {
            if (mCarRecycler.getVisibility() == View.VISIBLE
                    && mCarAdapter.getItemCount() > 0) {
                mSwipeRefreshLayout.setRefreshing(true);
            } else {
                mProgress.setVisibility(View.VISIBLE);

                mCarRecycler.setVisibility(View.GONE);
                mSwipeRefreshLayout.setVisibility(View.GONE);
            }

            mErrorView.setVisibility(View.GONE);
        } else {
            mSwipeRefreshLayout.setRefreshing(false);
            mProgress.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError(Throwable error) {
        mCarRecycler.setVisibility(View.GONE);
        mSwipeRefreshLayout.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
        Timber.e(error, "There was an error retrieving the car");
    }

//    @Override
//    public void onCarClick(String pokemon) {
//        startActivity(DetailActivity.getStartIntent(this, pokemon));
//    }

    @Override
    public void onReloadData() {
        mMainPresenter.getCarList(mCurrentPage,CAR_COUNT, selectedSort);
    }

    private void initAdapter() {
        mCarAdapter = new CarAdapter(this);
        mCarAdapter.setOnLoadMoreListener(MainActivity.this, mCarRecycler);
        mCarAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        mCarRecycler.setAdapter(mCarAdapter);

        mCarRecycler.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(final BaseQuickAdapter adapter, final View view, final int position) {
                String data = new Gson().toJson(baseQuickAdapter.getData().get(position));
                startActivity(DetailActivity.getStartIntent(MainActivity.this, data));
            }
        });
    }

    @Override
    public void onLoadMoreRequested() {
        mMainPresenter.getCarList(mCurrentPage,CAR_COUNT, selectedSort);
    }

    @Override
    public void onRefresh() {
        mCurrentPage = 1;
        resultsItem.clear();
        mCarAdapter.setNewData(resultsItem);
        mMainPresenter.getCarList(mCurrentPage,CAR_COUNT, selectedSort);
    }

    public void showFilterDialog(){
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_filter);
        dialog.setTitle("Filter Car By :");
        dialog.setCancelable(true);
        // there are a lot of settings, for dialog, check them all out!
        // set up radiobutton
        RadioGroup radio_filter = (RadioGroup) dialog.findViewById(R.id.radio_filter);
        Button okButton = (Button) dialog.findViewById(R.id.button_ok);


        radio_filter.setSelected(true);
        radio_filter.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch(checkedId){
                    case R.id.rd_1:
                        selectedSort = "oldest";
                        break;
                    case R.id.rd_2:
                        selectedSort = "newest";
                        break;
                    case R.id.rd_3:
                        selectedSort = "price-low";
                        break;
                    case R.id.rd_4:
                        selectedSort = "price-high";
                        break;
                    case R.id.rd_5:
                        selectedSort = "mileage-low";
                        break;
                    case R.id.rd_6:
                        selectedSort = "mileage-high";
                        break;
                }
            }
        });


        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRefresh();
                dialog.dismiss();
            }
        });

        // now that the dialog is set up, it's time to show it
        dialog.show();
    }

}