package com.carmudi.test.ui.main;

import java.util.List;

import com.carmudi.test.data.model.ResultsItem;
import com.carmudi.test.ui.base.MvpView;

public interface MainMvpView extends MvpView {

    void showCar(List<ResultsItem> car);

    void showProgress(boolean show);

    void showError(Throwable error);

}