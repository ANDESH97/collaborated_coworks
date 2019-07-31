package com.brownie.collaborated_cowork.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String TAG = "ApiClient";

    // Local Endpoint //
    //public static final String BASE_URL = "http://192.168.43.88:8080/";
    //public static final String BASE_URL = "http://192.168.1.102:8080/";


    // Aws Endpoint //
    public static final String BASE_URL = "http://ec2-13-127-241-152.ap-south-1.compute.amazonaws.com:8080/";

    public static Retrofit retrofit = null;

    public static Retrofit getApiClient(){

        if(retrofit==null){

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }
}
