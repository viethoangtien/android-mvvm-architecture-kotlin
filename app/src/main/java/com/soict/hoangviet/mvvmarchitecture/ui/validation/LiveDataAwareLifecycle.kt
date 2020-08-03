package com.soict.hoangviet.mvvmarchitecture.ui.validation

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent

class LiveDataAwareLifecycle<T> : MutableLiveData<T>(), LifecycleObserver {

    fun registerLifeCycle(lifecycle: Lifecycle) {
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        Log.e("myLog", "================================>>>> lifecycle owner STARTED")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        Log.e("myLog", "================================>>>> lifecycle owner STOPED")
    }
}