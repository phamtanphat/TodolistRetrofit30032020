package com.example.todolistretrofit30032020.repository;

import com.example.todolistretrofit30032020.api.APIRequest;
import com.example.todolistretrofit30032020.api.RetrofitInit;
import com.example.todolistretrofit30032020.module.ResponseAPI;

import io.reactivex.Flowable;

public class WordRepository {

    private static WordRepository wordRepository = null;
    private APIRequest apiRequest;

    private WordRepository() {
        apiRequest = RetrofitInit.getInStance();
    }

    public static WordRepository getInstance(){
        if (wordRepository == null){
            wordRepository = new WordRepository();
        }
        return wordRepository;
    }

    public Flowable<ResponseAPI> getWordFromPage(Integer page , Integer numItems){
        return apiRequest.getWordFromPage(page,numItems);
    }

}
