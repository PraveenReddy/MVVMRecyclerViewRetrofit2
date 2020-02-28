package com.example.mvvmandroidretrofit2.network;


import com.example.mvvmandroidretrofit2.models.Hero;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Hero>> getHeroes();
}
