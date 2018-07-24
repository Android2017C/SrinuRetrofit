package com.example.sreenureddy.srinuretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.sreenureddy.srinuretrofit.adapter.CategoryAdapter;
import com.example.sreenureddy.srinuretrofit.modelClasses.CategoryRequest;
import com.example.sreenureddy.srinuretrofit.modelClasses.CategoryResponse;
import com.example.sreenureddy.srinuretrofit.modelClasses.Movie;
import com.example.sreenureddy.srinuretrofit.retrofit.ApiClient;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Movie> movieList;
    RecyclerView recyclerView;
    CategoryAdapter recyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieList = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter = new CategoryAdapter(getApplicationContext(),movieList);
        recyclerView.setAdapter(recyclerAdapter);
        DisplayMyCategory();
    }
    private void DisplayMyCategory() {
        ApiClient.getApiService("cnu").getMovieDetails().enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                movieList = response.body();
                Log.d("TAG","Response = "+movieList);
                recyclerAdapter.setMovieList(movieList);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });
    }
}
