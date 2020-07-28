package com.example.androidpl_hw_4.task_2.retrofit;

import android.util.Log;

import com.example.androidpl_hw_4.task_2.JsonUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {

     private static final String TAG = "RetrofitApi";

    public Observable<JsonUser> requestServer(String loginName) {

        Log.d(TAG, "requestServer: " + loginName);

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);

        RetrofitService api = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(gsonConverterFactory)
                .build()
                .create(RetrofitService.class);

        return api.getUserAvatar(loginName).subscribeOn(Schedulers.io());
    }
}
