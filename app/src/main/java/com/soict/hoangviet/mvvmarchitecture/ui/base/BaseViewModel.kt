package com.soict.hoangviet.mvvmarchitecture.ui.base

import androidx.lifecycle.ViewModel
import com.soict.hoangviet.baseproject.data.network.api.Repository
import com.soict.hoangviet.baseproject.data.sharepreference.SharePreference
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel(
    protected var repository: Repository? = null,
    protected var compositeDisposable: CompositeDisposable = CompositeDisposable(),
    protected var sharePreference: SharePreference? = null
) : ViewModel() {

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.let {
            it.dispose()
        }
    }
}