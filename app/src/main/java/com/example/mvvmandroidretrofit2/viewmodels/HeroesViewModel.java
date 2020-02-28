package com.example.mvvmandroidretrofit2.viewmodels;

import com.example.mvvmandroidretrofit2.models.Hero;
import com.example.mvvmandroidretrofit2.repositories.HeroesRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class HeroesViewModel extends ViewModel {

    private MutableLiveData<List<Hero>> heroList;
    private HeroesRepository mRepo;

    public void init(){
        if(heroList != null){
            return;
        }
        mRepo = HeroesRepository.getInstance();
        heroList = mRepo.getHeroes();
    }

    public LiveData<List<Hero>> getHeroes() {
        return heroList;
    }
}
