package com.soict.hoangviet.mvvmarchitecture.base.ui

import androidx.lifecycle.ViewModel
import com.soict.hoangviet.baseproject.data.network.api.Repository
import com.soict.hoangviet.baseproject.data.sharepreference.SharePreference
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

open class BaseViewModel : ViewModel() {
    @Inject
    protected lateinit var sharePreference: SharePreference
    @Inject
    protected lateinit var repository: Repository
    protected var compositeDisposable: CompositeDisposable = CompositeDisposable()


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.let {
            it.clear()
        }
    }
}