package com.example.androidpl_hw_4.task_2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonUser {

    @Expose
    @SerializedName("login")
    public String login;

    @Expose
    @SerializedName("company")
    public String company;

    @Expose
    @SerializedName("avatar_url")
    public String avatar;
}
