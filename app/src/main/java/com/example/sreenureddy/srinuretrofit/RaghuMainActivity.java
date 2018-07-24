package com.example.sreenureddy.srinuretrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.sreenureddy.srinuretrofit.modelClasses.Category;
import com.example.sreenureddy.srinuretrofit.modelClasses.CategoryResponse;
import com.example.sreenureddy.srinuretrofit.retrofit.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RaghuMainActivity extends AppCompatActivity{
    List<Category> categoryList;
    RecyclerView recyclerView;
    RaghuAdapter recyclerAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        categoryList = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter = new RaghuAdapter(getApplicationContext(),categoryList);
        recyclerView.setAdapter(recyclerAdapter);
        DisplayMyCategory();
    }

    private void DisplayMyCategory() {

        ApiClient.getApiService("cnu").CATEGORY_RESPONSE_CALL().enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                CategoryResponse categoryResponse=response.body();

                     categoryList.addAll(categoryResponse.category);
                    Log.d("TAG","Response = "+categoryList);
                    recyclerAdapter.setCategoryList(categoryList);

            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {

            }
        });

    }
}
