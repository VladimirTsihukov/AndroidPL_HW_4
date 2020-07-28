package com.example.androidpl_hw_4.task_2.retrofit;

import android.util.Log;

import com.example.androidpl_hw_4.task_2.JsonUser;
import com.example.androidpl_hw_4.task_2.MainView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


public class RetrofitPresenter {

    private static final String TAG = "RetrofitPresenter";

    private RetrofitApi retrofitApi;
    private MainView mainView;

    public RetrofitPresenter(MainView view) {
        retrofitApi = new RetrofitApi();
        mainView = view;
    }

    public void getString(String loginName) {
        Observable<JsonUser> observable = retrofitApi.requestServer(loginName);

        Disposable disposable = observable.observeOn((AndroidSchedulers.mainThread())).subscribe(jsonUser -> {
                    Log.d(TAG, "onNext login: " + jsonUser.login);
                    Log.d(TAG, "onNext company: " + jsonUser.company);
                    Log.d(TAG, "onNext avatar: " + jsonUser.avatar);
                    mainView.setUser(jsonUser);
                }, throwable -> {
                    Log.e(TAG, "onError: " + throwable);
                }
        );
    }
}
