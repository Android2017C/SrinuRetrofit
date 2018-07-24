package com.example.sreenureddy.srinuretrofit.retrofit;


import com.example.sreenureddy.srinuretrofit.modelClasses.CategoryRequest;
import com.example.sreenureddy.srinuretrofit.modelClasses.CategoryResponse;
import com.example.sreenureddy.srinuretrofit.modelClasses.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by SreenuReddy on 7/19/2018.
 */

public interface ApiService {

  /*  @POST("category_list")
    Call<CategoryResponse> categoryRequest(@Body CategoryRequest newPlantRequest);*/
 @GET("volley_array.json")
    Call<List<Movie>> getMovieDetails();

    @GET("category_list")
    Call<CategoryResponse> CATEGORY_RESPONSE_CALL();

}