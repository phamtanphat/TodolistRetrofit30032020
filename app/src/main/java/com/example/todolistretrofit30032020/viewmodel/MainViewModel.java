package com.example.todolistretrofit30032020.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.todolistretrofit30032020.base.BaseViewModel;
import com.example.todolistretrofit30032020.module.ResponseAPI;
import com.example.todolistretrofit30032020.module.Word;
import com.example.todolistretrofit30032020.repository.WordRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends BaseViewModel {

    private MutableLiveData<List<Word>> mWords = new MutableLiveData<>();

    public LiveData<List<Word>> getWordFromPageSucces(){
        return mWords;
    }

    public void callApiWordFromPage(Integer page , Integer numItems){
        setLoading(true);
        WordRepository.getInstance()
                .getWordFromPage(page,numItems)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseAPI>() {
                    @Override
                    public void accept(ResponseAPI responseAPI) throws Exception {
                        mWords.setValue(responseAPI.getData());
                        setLoading(false);
                    }
                });
    }
}
