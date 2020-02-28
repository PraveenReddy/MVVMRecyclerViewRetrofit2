package com.example.mvvmandroidretrofit2.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mvvmandroidretrofit2.R;
import com.example.mvvmandroidretrofit2.adapters.HeroesAdapter;
import com.example.mvvmandroidretrofit2.models.Hero;
import com.example.mvvmandroidretrofit2.viewmodels.HeroesViewModel;

import java.util.List;

public class HeroesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HeroesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        HeroesViewModel model = ViewModelProviders.of(this).get(HeroesViewModel.class);
        model.init();
        model.getHeroes().observe(this, new Observer<List<Hero>>() {
            @Override
            public void onChanged(@Nullable List<Hero> heroList) {
                adapter = new HeroesAdapter(HeroesActivity.this, heroList);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
