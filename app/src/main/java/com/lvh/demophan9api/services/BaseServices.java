package com.lvh.demophan9api.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lvh.demophan9api.JsonPlaceHolderApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseServices{

    private static JsonPlaceHolderApi jsonPlaceHolderApi;

    public static JsonPlaceHolderApi getBaseService(){
        if (jsonPlaceHolderApi == null){
            jsonPlaceHolderApi = creatRetrofit();
        }

        return jsonPlaceHolderApi;
    }


    private static JsonPlaceHolderApi creatRetrofit(){
        JsonPlaceHolderApi jsonPlaceHolderApi;
        Gson gson = new GsonBuilder().serializeNulls().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi .class);

        return jsonPlaceHolderApi;
    }


}
