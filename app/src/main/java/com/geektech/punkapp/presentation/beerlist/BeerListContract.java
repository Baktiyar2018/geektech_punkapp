package com.geektech.punkapp.presentation.beerlist;

import com.geektech.punkapp.core.MVP.BaseMVPContract;


public interface BeerListContract {
    interface View extends BaseMVPContract.View<Presenter>{
        void showListSuccess();
        void showListFailure(String message);
    }

    interface Presenter extends  BaseMVPContract.Presenter<View>{
        void showList();

    }
}
