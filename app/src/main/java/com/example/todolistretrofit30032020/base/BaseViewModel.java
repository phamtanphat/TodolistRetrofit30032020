package com.example.todolistretrofit30032020.base;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

public abstract class BaseViewModel extends ViewModel implements LifecycleObserver {

    protected abstract MutableLiveData<Boolean> mLoading();

    public void setLoading(Boolean loading){
        mLoading().setValue(loading);
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public LiveData<Boolean> getLoading(){
        return  mLoading();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void clear(){
        mLoading().setValue(null);
    }

}
