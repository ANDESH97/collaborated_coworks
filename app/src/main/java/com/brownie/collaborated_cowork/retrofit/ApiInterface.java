package com.brownie.collaborated_cowork.retrofit;

import com.brownie.collaborated_cowork.models.C2C;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("getAllC2Cs")
    Call<List<C2C>> getAllC2Cs();
}
