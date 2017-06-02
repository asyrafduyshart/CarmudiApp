package com.carmudi.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import com.carmudi.test.common.TestDataFactory;
import com.carmudi.test.data.DataManager;
import com.carmudi.test.data.model.ResultsItem;
import com.carmudi.test.ui.main.MainMvpView;
import com.carmudi.test.ui.main.MainPresenter;
import com.carmudi.test.util.RxSchedulersOverrideRule;
import io.reactivex.Single;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ravindra on 24/12/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock
    MainMvpView mMockMainMvpView;
    @Mock
    DataManager mMockDataManager;
    private MainPresenter mMainPresenter;

    @Rule
    public final RxSchedulersOverrideRule mOverrideSchedulersRule = new RxSchedulersOverrideRule();

    @Before
    public void setUp() {
        mMainPresenter = new MainPresenter(mMockDataManager);
        mMainPresenter.attachView(mMockMainMvpView);
    }

    @After
    public void tearDown() {
        mMainPresenter.detachView();
    }

    @Test
    public void getCarReturnsCarDetail() throws Exception {
        List<ResultsItem> resultsItems = TestDataFactory.makeCarNameList(10);
        when(mMockDataManager.getCarList(10,1))
                .thenReturn(Single.just(resultsItems));

        mMainPresenter.getCarList(1,5,"newest");

        verify(mMockMainMvpView, times(2)).showProgress(anyBoolean());
        verify(mMockMainMvpView).showCar(resultsItems);
        verify(mMockMainMvpView, never()).showError(new RuntimeException());

    }

    @Test
    public void getCarReturnsError() throws Exception {
        when(mMockDataManager.getCarList(11,2))
                .thenReturn(Single.error(new RuntimeException()));

        mMainPresenter.getCarList(1,5,"newest");

        verify(mMockMainMvpView, times(2)).showProgress(anyBoolean());
        verify(mMockMainMvpView).showError(any(Throwable.class));
        verify(mMockMainMvpView, never()).showCar(ArgumentMatchers.anyList());
    }

}