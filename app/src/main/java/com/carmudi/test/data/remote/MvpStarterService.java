package com.carmudi.test.data.remote;


import com.carmudi.test.data.model.CarListResponse;
import com.carmudi.test.data.model.Pokemon;
import com.carmudi.test.data.model.PokemonListResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MvpStarterService {

    @GET("pokemon")
    Single<PokemonListResponse> getPokemonList(@Query("limit") int limit);

    @GET("pokemon/{name}")
    Single<Pokemon> getPokemon(@Path("name") String name);

    @GET("cars/page:{page}/maxitems:{maxitems}")
    Single<CarListResponse> getCarList(@Path("page") int page,@Path("maxitems") int maxitems);

    @GET("cars/page:{page}/maxitems:{maxitems}/{sort}")
    Single<CarListResponse> getCarSortList(@Path("page") int page,@Path("maxitems") int maxitems, @Path("sort") String sort);

}
