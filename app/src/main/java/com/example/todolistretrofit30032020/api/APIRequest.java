package com.example.todolistretrofit30032020.api;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIRequest {

//    @GET("word.php?page={page}&numItems={numItems}")
//    Call<Object> getData(@Path("page") String page);

    @GET("word.php")
    Call<Object> getData(
            @Query("page") Integer page,
            @Query("numItems") Integer numItems);
}
