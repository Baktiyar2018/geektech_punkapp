package com.geektech.punkapp.domain.beerlist;


import com.geektech.punkapp.core.callback.BaseCallback;
import com.geektech.punkapp.data.beer.model.Beer;

import java.util.ArrayList;

public interface BeerListUseCases  {

            void getBeerList(ArrayList<Beer> beers,MBeerListCallback callback);

            abstract class MBeerListCallback implements BaseCallback<Boolean> {
                @Override
                public void onSuccess(Boolean result) {

                }

                @Override
                public void onFail(String massage) {

                }
            }
}
