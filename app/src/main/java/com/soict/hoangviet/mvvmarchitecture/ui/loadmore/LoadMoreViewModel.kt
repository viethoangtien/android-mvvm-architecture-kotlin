package com.soict.hoangviet.mvvmarchitecture.ui.loadmore

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.soict.hoangviet.mvvmarchitecture.base.ui.BaseViewModel
import com.soict.hoangviet.mvvmarchitecture.data.network.response.ConstructionResponse
import com.soict.hoangviet.mvvmarchitecture.data.network.response.ListLoadMoreResponse
import com.soict.hoangviet.mvvmarchitecture.data.network.response.setLoadingMore
import javax.inject.Inject

class LoadMoreViewModel @Inject constructor(val context: Context) : BaseViewModel() {
    val constructionLiveData = MutableLiveData<ListLoadMoreResponse<ConstructionResponse>>()
    private var pageIndexConstruction = 1
    private var totalPageConstruction = 0

    fun getConstruction(isRefresh: Boolean = false) {
        if (isRefresh) {
            pageIndexConstruction = 1
        }
        compositeDisposable.add(
            repository.getConstruction(pageIndexConstruction)
                .subscribe({
                    pageIndexConstruction++
                    it.data?.let {
                        totalPageConstruction = it.totalPage
                        constructionLiveData.value = ListLoadMoreResponse.success(it.data!!)
                            .setLoadingMore(
                                isRefresh,
                                pageIndexConstruction <= totalPageConstruction
                            )
                    }
                }, {
                    constructionLiveData.value = ListLoadMoreResponse.error(it)
                })
        )
    }

}