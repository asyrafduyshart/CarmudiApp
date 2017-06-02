package com.carmudi.test.ui.detail;

import javax.inject.Inject;

import com.carmudi.test.data.DataManager;
import com.carmudi.test.data.model.ResultsItem;
import com.carmudi.test.data.model.Statistic;
import com.carmudi.test.injection.ConfigPersistent;
import com.carmudi.test.ui.base.BasePresenter;
import com.carmudi.test.util.rx.scheduler.SchedulerUtils;
import com.google.gson.Gson;

@ConfigPersistent
public class DetailPresenter extends BasePresenter<DetailMvpView> {

    private final DataManager mDataManager;

    @Inject
    public DetailPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(DetailMvpView mvpView) {
        super.attachView(mvpView);
    }

    public void getCar(String carObject) {
        checkViewAttached();
        getMvpView().showProgress(true);
        if (carObject == null){
            getMvpView().showError(new IllegalArgumentException("Detail Activity requires a car object"));
        }

        try {
            ResultsItem resultsItem = new Gson().fromJson(carObject, ResultsItem.class);
            getMvpView().showProgress(false);
            getMvpView().showCar(resultsItem);
        } catch (Exception e) {
            e.printStackTrace();
            getMvpView().showError(e);
        }
    }
}
