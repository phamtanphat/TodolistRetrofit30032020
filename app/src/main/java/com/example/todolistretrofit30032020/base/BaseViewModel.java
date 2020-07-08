package com.example.todolistretrofit30032020.base;

import android.view.View;
import android.widget.ProgressBar;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

public abstract class BaseViewModel extends ViewModel implements LifecycleObserver {
    public abstract ProgressBar initProgressBar();
    private ProgressBar mProgressbar;

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){
        mProgressbar = initProgressBar();
    }

    public void showProgress(){
        if (mProgressbar != null){
            mProgressbar.setVisibility(View.VISIBLE);
        }
    }

    public void hideProgress(){
        if (mProgressbar != null){
            mProgressbar.setVisibility(View.GONE);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void clear(){
        mProgressbar = null;
    }

}
