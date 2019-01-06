package com.geektech.punkapp.data.beer.remote;

import com.geektech.punkapp.data.beer.model.Beer;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
//TODO: Add remaining API calls
public interface BeerNetworkClient {

    @GET(BeerRemoteConfig.BEERS_URL)
    Call<ArrayList<Beer>> getBeerList(
            @Query("page") int page,
            @Query("per_page") int perPage);
    @GET(BeerRemoteConfig.BEERS_BY_ID)
    Call<ArrayList<Beer>>getBeerById(@Path("id") int id);

}
