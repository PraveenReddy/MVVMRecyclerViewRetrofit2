package com.example.mvvmandroidretrofit2.repositories;

import com.example.mvvmandroidretrofit2.models.Hero;
import com.example.mvvmandroidretrofit2.network.Api;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeroesRepository {

    private static HeroesRepository instance;

    public static HeroesRepository getInstance(){
        if(instance == null){
            instance = new HeroesRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Hero>> getHeroes(){
        MutableLiveData<List<Hero>> data = new MutableLiveData<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<Hero>> call = api.getHeroes();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

            }
        });
        return data;
    }
}
