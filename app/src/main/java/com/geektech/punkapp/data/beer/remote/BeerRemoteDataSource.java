package com.geektech.punkapp.data.beer.remote;

import android.support.annotation.Nullable;

import com.geektech.punkapp.core.retrofit.RetrofitBaseDataSource;
import com.geektech.punkapp.data.beer.BeerDataSource;
import com.geektech.punkapp.data.beer.model.Beer;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
public class BeerRemoteDataSource extends RetrofitBaseDataSource implements BeerDataSource {

    //region Static

    private static BeerDataSource INSTANCE;

    public static BeerDataSource getInstance(){
        if (INSTANCE == null)
            INSTANCE = new BeerRemoteDataSource();

        return INSTANCE;
    }

    //endregion

    //region Contract
    private BeerNetworkClient mClient = getRetrofit(BeerRemoteConfig.BASE_URL)
            .create(BeerNetworkClient.class);

    @Override
    public void getBeerList(BeerListCallback callback) {
        Call<ArrayList<Beer>> beersCall = mClient.getBeerList(1,40);
        beersCall.enqueue(new Callback<ArrayList<Beer>>() {
            @Override
            public void onResponse(Call<ArrayList<Beer>> call, Response<ArrayList<Beer>> response) {
                 if (response.isSuccessful()){
                     if(response.body() != null){
                         callback.onSuccess(response.body());
                     }else {
                         callback.onError(new Exception("ololo-Body is empty"));
                     }
                 } else {
                     callback.onError(new Exception("ololo-Request failed - code :"+ response.code()));
                 }

            }

            @Override
            public void onFailure(Call<ArrayList<Beer>> call, Throwable t) {
                        callback.onError(new Exception(t.getMessage()));
            }
        });


    }

    @Nullable
    @Override
    public Beer getBeer(int id) {
        return null;
    }

    @Override
    public void setBeerList(ArrayList<Beer> beers) {
    }



    //endregion
}
