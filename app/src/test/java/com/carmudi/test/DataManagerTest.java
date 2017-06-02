package com.carmudi.test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import com.carmudi.test.common.TestDataFactory;
import com.carmudi.test.data.DataManager;
import com.carmudi.test.data.model.NamedResource;
import com.carmudi.test.data.model.Pokemon;
import com.carmudi.test.data.model.PokemonListResponse;
import com.carmudi.test.data.model.ResultsItem;
import com.carmudi.test.data.remote.MvpStarterService;
import com.carmudi.test.util.RxSchedulersOverrideRule;
import io.reactivex.Single;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DataManagerTest {

    @Rule
    public final RxSchedulersOverrideRule mOverrideSchedulersRule = new RxSchedulersOverrideRule();
    @Mock
    MvpStarterService mMockMvpStarterService;
    private DataManager mDataManager;

    @Before
    public void setUp() {
        mDataManager = new DataManager(mMockMvpStarterService);
    }

    @Test
    public void getPokemonListCompletesAndEmitsPokemonList() {
        List<NamedResource> namedResourceList = TestDataFactory.makeNamedResourceList(5);
        PokemonListResponse pokemonListResponse =
                new PokemonListResponse();
        pokemonListResponse.results = namedResourceList;

        when(mMockMvpStarterService.getPokemonList(anyInt()))
                .thenReturn(Single.just(pokemonListResponse));

        mDataManager.getPokemonList(10)
                .test()
                .assertComplete()
                .assertValue(TestDataFactory.makePokemonNameList(namedResourceList));
    }

    @Test
    public void getCarCompletesAndEmitsCar() {
        ResultsItem car = TestDataFactory.makeItem();
//        when(mMockMvpStarterService.getCarList(anyInt(), anyInt()))
//                .thenReturn(Single.just(car.getData().getItemContactEmail()));

        mDataManager.getCarList(1,2)
                .test()
                .assertComplete();
    }
}
