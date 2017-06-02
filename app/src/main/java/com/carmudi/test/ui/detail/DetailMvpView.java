package com.carmudi.test.ui.detail;

import com.carmudi.test.data.model.Pokemon;
import com.carmudi.test.data.model.ResultsItem;
import com.carmudi.test.data.model.Statistic;
import com.carmudi.test.ui.base.MvpView;

public interface DetailMvpView extends MvpView {

    void showCar(ResultsItem car);

    void showProgress(boolean show);

    void showError(Throwable error);

}