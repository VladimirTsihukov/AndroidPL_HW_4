package com.example.androidpl_hw_4.task_2.retrofit;

import com.example.androidpl_hw_4.task_2.JsonUser;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {

    @GET("/users/{user}")
    Observable<JsonUser> getUserAvatar(@Path("user") String user);
}
