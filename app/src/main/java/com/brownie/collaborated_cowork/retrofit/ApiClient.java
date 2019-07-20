package com.brownie.collaborated_cowork.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String TAG = "ApiClient";

    public static final String BASE_URL = "http://192.168.43.88:7777/";

    public static Retrofit retrofit = null;

    public static Retrofit getApiClient(){

        if(retrofit==null){

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }
}
