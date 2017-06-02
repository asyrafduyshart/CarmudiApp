package com.carmudi.test.ui.main;

import android.util.Log;

import javax.inject.Inject;

import com.carmudi.test.data.DataManager;
import com.carmudi.test.injection.ConfigPersistent;
import com.carmudi.test.ui.base.BasePresenter;
import com.carmudi.test.util.rx.scheduler.SchedulerUtils;

@ConfigPersistent
public class MainPresenter extends BasePresenter<MainMvpView> {

    private final DataManager mDataManager;

    @Inject
    public MainPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(MainMvpView mvpView) {
        super.attachView(mvpView);
    }


    public void getCarList(int limit, int maxitems, String sort){
        checkViewAttached();
        getMvpView().showProgress(true);
        String sortAppend = String.format("sort:%s", sort);
        mDataManager.getCarList(limit ,maxitems, sortAppend)
                .compose(SchedulerUtils.ioToMain())
                .subscribe(car -> {
                    getMvpView().showProgress(false);
                    getMvpView().showCar(car);
                }, throwable -> {
                    getMvpView().showProgress(false);
                    getMvpView().showError(throwable);
                });
    }

}