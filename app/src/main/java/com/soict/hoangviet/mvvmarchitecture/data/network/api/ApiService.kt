package com.soict.hoangviet.baseproject.data.network

import com.soict.hoangviet.baseproject.data.network.response.ObjectResponse
import com.soict.hoangviet.baseproject.data.network.response.ListResponse
import com.soict.hoangviet.mvvmarchitecture.data.network.response.TestResponse
import io.reactivex.Single
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("/v1/category")
    fun getCategory(): Call<ObjectResponse<*>>

    @POST("/v1/user_update_profile")
    @Multipart
    fun updateProfile(
        @Part fileImage: MultipartBody.Part
    ): Call<ObjectResponse<*>>

    @HTTP(method = "DELETE", path = "/v1/cart", hasBody = true)
    fun deleteCartdetail(
        @Header(ApiConstant.RequestParam.AUTHORIZATION_HEADER) authToken: String,
        @Body requestBody: RequestBody
    ): Call<ObjectResponse<*>>

    @GET
    @Headers("Content-Type:application/json")
    fun dynamicUrl(@Url url: String): Call<ObjectResponse<*>>

    @GET("/v1/banners")
    @Headers("Content-Type:application/json")
    fun getBanner(): Single<ListResponse<TestResponse>>
}