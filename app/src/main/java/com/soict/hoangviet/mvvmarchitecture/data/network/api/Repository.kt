package com.soict.hoangviet.baseproject.data.network.api

import com.soict.hoangviet.baseproject.data.network.ApiConstant
import com.soict.hoangviet.baseproject.data.network.ApiService
import com.soict.hoangviet.baseproject.data.network.response.ListResponse
import com.soict.hoangviet.mvvmarchitecture.data.network.response.ListLoadMoreResponse
import com.soict.hoangviet.mvvmarchitecture.data.network.response.NotificationResponse
import com.soict.hoangviet.mvvmarchitecture.data.network.response.ObjectLoadMoreResponse
import com.soict.hoangviet.mvvmarchitecture.data.network.response.TestResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class Repository @Inject constructor(val apiService: ApiService) {
    fun getBanner(): Single<ListResponse<TestResponse>> {
        return apiService.getBanner()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getNotification(data: MutableMap<String, Any?>): Single<ObjectLoadMoreResponse<NotificationResponse>> {
        return apiService.getNotification("${ApiConstant.RequestParam.BEARER} eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hcGktc3RhZ2luZy50aW1kYXR4ZS5jb21cL3YxXC9jcmVhdGVfc2Vzc2lvbnMiLCJpYXQiOjE1OTAwNTQwMjMsImV4cCI6MTU5MDA1NzYyMywibmJmIjoxNTkwMDU0MDIzLCJqdGkiOiJRWDNvVFJkSURqTERCQ05XIiwic3ViIjo0LCJwcnYiOiJmNjRkNDhhNmNlYzdiZGZhN2ZiZjg5OTQ1NGI0ODhiM2U0NjI1MjBhIiwicm9sZSI6InVzZXJzIn0.z2q2LiLLtIFW_T2iZKXDYqC0tgm8oQjw98T4Rs-aKsw", data)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}