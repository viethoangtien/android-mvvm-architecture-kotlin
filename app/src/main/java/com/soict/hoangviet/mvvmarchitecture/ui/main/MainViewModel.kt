package com.soict.hoangviet.mvvmarchitecture.ui.main

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.soict.hoangviet.baseproject.data.network.api.Repository
import com.soict.hoangviet.baseproject.data.network.response.ListResponse
import com.soict.hoangviet.baseproject.data.sharepreference.SharePreference
import com.soict.hoangviet.mvvmarchitecture.base.ui.BaseViewModel
import com.soict.hoangviet.mvvmarchitecture.data.network.response.TestResponse
import javax.inject.Inject

class MainViewModel @Inject constructor(
    repository: Repository,
    sharePreference: SharePreference,
    val context: Context
) : BaseViewModel(repository = repository, sharePreference = sharePreference) {
    var bannerLiveData = MutableLiveData<ListResponse<TestResponse>>()

    fun fetchBanner() {
        compositeDisposable.add(
            repository.getBanner()
                .doOnSubscribe {
                    bannerLiveData.value = ListResponse.loading()
                }
                .subscribe({
                    bannerLiveData.value = ListResponse.success(it.data!!)
                }, {
                    bannerLiveData.value = ListResponse.error(it)
                })
        )
    }
}