package com.geektech.punkapp.data.beer;

import android.support.annotation.Nullable;

import com.geektech.punkapp.data.beer.model.Beer;
import com.geektech.punkapp.data.beer.remote.BeerRemoteDataSource;

import java.util.ArrayList;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
public class BeerRepository implements BeerDataSource {

    @Nullable
    private BeerDataSource mLocal;
    @Nullable
    private BeerDataSource mRemote;

    //region Constructor

    private BeerRepository(
            @Nullable BeerDataSource mLocal,
            @Nullable BeerDataSource mRemote) {
        this.mLocal = mLocal;
        this.mRemote = mRemote;
    }

    //endregion

    //region Static

    private static BeerDataSource INSTANCE;

    public static BeerDataSource getInstance(
            BeerDataSource local,
            BeerDataSource remote) {
        if (INSTANCE == null) {
            INSTANCE = new BeerRepository(local, remote);
        }
        return INSTANCE;
    }

    //endregion

    //region Contract

    @Override
    public void getBeerList(BeerListCallback callback) {
        if(mRemote != null){
            mRemote.getBeerList(new BeerListCallback() {
                @Override
                public void onSuccess(ArrayList<Beer> beers) {
                    callback.onSuccess(beers);
                }

                @Override
                public void onError(Exception e) {
                    callback.onError(e);
                }
            });
        }
        //TODO: Call remote data source, and write response data to local data source
    }


    @Override
    public void getBeer(int id, BeerCallback beerCallback) {
        //TODO: Get beer from in memory cache or from local data source
        if(mRemote != null){
            mRemote.getBeer(id, new BeerCallback() {
                @Override
                public void onSuccess(Beer beer) {
                    beerCallback.onSuccess(beer);
                }

                @Override
                public void onError(Exception e) {
                    beerCallback.onError(e);
                }
            });
        }

    }

    @Override
    public void setBeerList(ArrayList<Beer> beers) {
        //TODO: Send data to local data source
    }

    //endregion
}
