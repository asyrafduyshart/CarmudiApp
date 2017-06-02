package com.carmudi.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.carmudi.test.common.TestDataFactory;
import com.carmudi.test.data.DataManager;
import com.carmudi.test.data.model.ResultsItem;
import com.carmudi.test.ui.detail.DetailMvpView;
import com.carmudi.test.ui.detail.DetailPresenter;
import com.carmudi.test.util.RxSchedulersOverrideRule;
import io.reactivex.Single;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ravindra on 24/12/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class DetailPresenterTest {

    @Mock
    DetailMvpView mMockDetailMvpView;
    @Mock
    DataManager mMockDataManager;
    private DetailPresenter mDetailPresenter;

    @Rule
    public final RxSchedulersOverrideRule mOverrideSchedulersRule = new RxSchedulersOverrideRule();

    @Before
    public void setUp() {
        mDetailPresenter = new DetailPresenter(mMockDataManager);
        mDetailPresenter.attachView(mMockDetailMvpView);
    }

    @After
    public void tearDown() {
        mDetailPresenter.detachView();
    }

    @Test
    public void getcarDetailReturnscar() throws Exception {
        ResultsItem resultsItem = TestDataFactory.makeItem();
//        when(mMockDataManager.getCarList()
//                .thenReturn(Single.just(resultsItem));

        mDetailPresenter.getCar(anyString());

        verify(mMockDetailMvpView, times(2)).showProgress(anyBoolean());
        verify(mMockDetailMvpView).showCar(resultsItem);
        verify(mMockDetailMvpView, never()).showError(new RuntimeException());
    }

    @Test
    public void getCarDetailReturnsError() throws Exception {
        when(mMockDataManager.getCarList(1,2))
                .thenReturn(Single.error(new RuntimeException()));

        mDetailPresenter.getCar("id");

        verify(mMockDetailMvpView, times(2)).showProgress(anyBoolean());
        verify(mMockDetailMvpView).showError(any(Throwable.class));
        verify(mMockDetailMvpView, never()).showCar(any(ResultsItem.class));
    }

}