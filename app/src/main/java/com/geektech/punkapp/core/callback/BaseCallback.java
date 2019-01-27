package com.geektech.punkapp.core.callback;

public interface BaseCallback<T> {
    void onSuccess(T result);
    void onFail(String massage);

}
