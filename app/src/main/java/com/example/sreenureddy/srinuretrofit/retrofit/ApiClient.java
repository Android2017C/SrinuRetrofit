package com.example.sreenureddy.srinuretrofit.retrofit;


import com.example.sreenureddy.srinuretrofit.baseUrl.ConstantURL;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SreenuReddy on 7/19/2018.
 */

public class ApiClient {

    private static ApiService apiService = null;
    private static void initialize() {
        Gson gson = new GsonBuilder()
                .setLenient()
               // .registerTypeAdapterFactory(new TypedArray())
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(1, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantURL.Base_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();


        apiService = retrofit.create(ApiService.class);
    }
    public static ApiService getApiService(String name) {
        initialize();
        return apiService;
    }
}
