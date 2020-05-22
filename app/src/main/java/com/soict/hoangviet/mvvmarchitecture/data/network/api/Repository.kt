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
        return apiService.getNotification("${ApiConstant.RequestParam.BEARER} eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hcGktc3RhZ2luZy50aW1kYXR4ZS5jb21cL3YxXC91c2VyX3JlZnJlc2giLCJpYXQiOjE1OTAwNTQwMjMsImV4cCI6MTU5MDExNDU3NywibmJmIjoxNTkwMTEwOTc3LCJqdGkiOiJrM0pEUW1kUWpNQ1JIbmhWIiwic3ViIjo0LCJwcnYiOiJmNjRkNDhhNmNlYzdiZGZhN2ZiZjg5OTQ1NGI0ODhiM2U0NjI1MjBhIiwicm9sZSI6InVzZXJzIn0.T62AnujW_vepNWo88iW9qsEaLv1UdQWABs2tDDVldVw", data)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}