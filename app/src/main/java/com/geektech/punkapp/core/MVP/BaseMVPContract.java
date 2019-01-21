package com.geektech.punkapp.core.MVP;

public interface BaseMVPContract {
    interface View<T extends Presenter>{
        void finishView();
        void attachPresenter(T presenter);
    }
    interface Presenter<T extends View>{
        void attachView(T view);
        void detachView();
    }
}
