package com.soict.hoangviet.baseproject.data.network.api

import com.soict.hoangviet.baseproject.data.network.ApiConstant
import com.soict.hoangviet.baseproject.data.network.ApiService
import com.soict.hoangviet.baseproject.data.network.response.ListResponse
import com.soict.hoangviet.baseproject.extension.backgroundThreadProcess
import com.soict.hoangviet.mvvmarchitecture.data.network.response.NotificationResponse
import com.soict.hoangviet.mvvmarchitecture.data.network.response.ObjectLoadMoreResponse
import com.soict.hoangviet.mvvmarchitecture.data.network.response.TestResponse
import io.reactivex.Single
import javax.inject.Inject

class Repository @Inject constructor(val apiService: ApiService) {
    fun getBanner(): Single<ListResponse<TestResponse>> {
        return apiService.getBanner().backgroundThreadProcess()
    }

    fun getNotification(data: MutableMap<String, Any?>): Single<ObjectLoadMoreResponse<NotificationResponse>> {
        return apiService.getNotification("${ApiConstant.RequestParam.BEARER}eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hcGktc3RhZ2luZy50aW1kYXR4ZS5jb21cL3YxXC91c2VyX3JlZnJlc2giLCJpYXQiOjE1OTAxMzA2NjAsImV4cCI6MTU5MDYzNzc5NCwibmJmIjoxNTkwNjM0MTk0LCJqdGkiOiJ6TnQzdk1UYkVDaG92T0F6Iiwic3ViIjo0LCJwcnYiOiJmNjRkNDhhNmNlYzdiZGZhN2ZiZjg5OTQ1NGI0ODhiM2U0NjI1MjBhIiwicm9sZSI6InVzZXJzIn0.LxoODTObXqM8-ntpejNAM3X95S7jvkLv4f6FDSyNOqk", data)
            .backgroundThreadProcess()
    }
}