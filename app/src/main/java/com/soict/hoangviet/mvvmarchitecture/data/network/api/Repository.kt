package com.soict.hoangviet.baseproject.data.network.api

import com.soict.hoangviet.baseproject.data.network.ApiConstant
import com.soict.hoangviet.baseproject.data.network.ApiService
import com.soict.hoangviet.baseproject.data.network.response.ListResponse
import com.soict.hoangviet.baseproject.extension.backgroundThreadProcess
import com.soict.hoangviet.mvvmarchitecture.data.network.response.TestResponse
import io.reactivex.Single
import javax.inject.Inject

class Repository @Inject constructor(val apiService: ApiService) {
    fun getBanner(): Single<ListResponse<TestResponse>> {
        return apiService.getBanner().backgroundThreadProcess()
    }

    fun getNotification(data: MutableMap<String, Any?>) = apiService.getNotification("${ApiConstant.RequestParam.BEARER}eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hcGktc3RhZ2luZy50aW1kYXR4ZS5jb21cL3YxXC9jcmVhdGVfc2Vzc2lvbnMiLCJpYXQiOjE1OTA3NDM4MDUsImV4cCI6MTU5MDc0NzQwNSwibmJmIjoxNTkwNzQzODA1LCJqdGkiOiJxdWpoMXhMWm91SVFWRFpkIiwic3ViIjo0LCJwcnYiOiJmNjRkNDhhNmNlYzdiZGZhN2ZiZjg5OTQ1NGI0ODhiM2U0NjI1MjBhIiwicm9sZSI6InVzZXJzIn0.94ZUAl33x7ZEpy47vb6qQmyQMYekFiFG0-pywb4O0tg", data)
        .backgroundThreadProcess()
}