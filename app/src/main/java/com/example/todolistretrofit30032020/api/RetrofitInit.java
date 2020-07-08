package com.example.todolistretrofit30032020.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInit {

    private static RetrofitInit retrofitInit = null;
    private Retrofit retrofit;

    private RetrofitInit(){
        retrofit = initRetrofit();
    }
    public static APIRequest getInStance(){
        if (retrofitInit == null){
            retrofitInit = new RetrofitInit();
        }
        return  retrofitInit.retrofit.create(APIRequest.class);
    }

    public Retrofit initRetrofit(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .disableHtmlEscaping()
                .create();

        // OkhttpClient

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .connectTimeout(30,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://servertuvung3003.000webhostapp.com/apituvung/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
        return retrofit;
    }
}
