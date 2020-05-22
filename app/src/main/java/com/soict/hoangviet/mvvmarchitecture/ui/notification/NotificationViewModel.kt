package com.soict.hoangviet.mvvmarchitecture.ui.notification

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.soict.hoangviet.baseproject.data.network.api.Repository
import com.soict.hoangviet.baseproject.data.sharepreference.SharePreference
import com.soict.hoangviet.mvvmarchitecture.data.network.response.NotificationResponse
import com.soict.hoangviet.mvvmarchitecture.data.network.response.ObjectLoadMoreResponse
import com.soict.hoangviet.mvvmarchitecture.ui.base.BaseViewModel
import javax.inject.Inject

class NotificationViewModel @Inject constructor(
    repository: Repository,
    sharePreference: SharePreference,
    val context: Context
) : BaseViewModel(repository = repository, sharePreference = sharePreference) {
    private var pageIndex = 1
    private var totalPage = 0
    private val limit = 10
    val notificationLiveData = MutableLiveData<ObjectLoadMoreResponse<NotificationResponse>>()

    fun getNotification(isRefresh: Boolean) {
        var data: MutableMap<String, Any?> = mutableMapOf()
        data["page"] = pageIndex
        data["limit"] = limit
        compositeDisposable.add(
            repository.getNotification(data)
                .doOnSubscribe {
                    if(!isRefresh) notificationLiveData.value = ObjectLoadMoreResponse.loading()
                }
                .subscribe({
                    pageIndex = it.currentPage + 1
                    totalPage = it.totalItems / limit
                    notificationLiveData.value =
                        ObjectLoadMoreResponse.success(
                            it.data,
                            isRefresh,
                            pageIndex <= totalPage
                        )
                }, {
                    notificationLiveData.value = ObjectLoadMoreResponse.error(it)
                })
        )
    }
}