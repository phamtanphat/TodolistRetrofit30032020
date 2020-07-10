package com.example.todolistretrofit30032020.base;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public abstract class BaseViewModel extends ViewModel implements LifecycleObserver {

    private MutableLiveData<Boolean> mLoading = new MutableLiveData<>();


    public void setLoading(Boolean b){
        synchronized (mLoading){
            mLoading.setValue(b);
        }
    }

    public MutableLiveData<Boolean> getLoading() {
        return mLoading;
    }



}
