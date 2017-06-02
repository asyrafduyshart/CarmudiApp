package com.carmudi.test.data;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.carmudi.test.data.model.CarListResponse;
import com.carmudi.test.data.model.Data;
import com.carmudi.test.data.model.Pokemon;
import com.carmudi.test.data.model.ResultsItem;
import com.carmudi.test.data.remote.MvpStarterService;
import io.reactivex.Single;

@Singleton
public class DataManager {

    private final MvpStarterService mMvpStarterService;

    @Inject
    public DataManager(MvpStarterService mvpStarterService) {
        mMvpStarterService = mvpStarterService;
    }

    public Single<List<ResultsItem>> getCarList(int limit, int maxitems, String sort){
        return mMvpStarterService.getCarSortList(limit,maxitems,sort)
                .toObservable()
                .flatMapIterable(data -> data.getMetadata().getResults())
                .toList();
    }

    public Single<List<ResultsItem>> getCarList(int limit, int maxitems){
        return mMvpStarterService.getCarList(limit,maxitems)
                .toObservable()
                .flatMapIterable(data -> data.getMetadata().getResults())
                .toList();
    }

    public Single<List<String>> getPokemonList(int limit) {
        return mMvpStarterService.getPokemonList(limit)
                .toObservable()
                .flatMapIterable(namedResources -> namedResources.results)
                .map(namedResource -> namedResource.name)
                .toList();
    }

    public Single<CarListResponse> getPokemon(int page, int maxitems) {
        return mMvpStarterService.getCarList(page,maxitems);
    }

}