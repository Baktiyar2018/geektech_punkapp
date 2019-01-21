package com.geektech.punkapp.presentation.beerlist;

public class BeerListPresenter implements BeerListContract.Presenter {
    private BeerListContract.View mView = null;

    @Override
    public void showList() {

        mView.showListSuccess();
        mView.finishView();

    }

    @Override
    public void attachView(BeerListContract.View view) {
        this.mView = view;
        view.attachPresenter(this);
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
