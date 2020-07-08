package com.example.todolistretrofit30032020.repository;

import com.example.todolistretrofit30032020.api.APIRequest;
import com.example.todolistretrofit30032020.api.RetrofitInit;

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


}
