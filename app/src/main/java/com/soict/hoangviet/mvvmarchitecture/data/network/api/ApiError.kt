package com.soict.hoangviet.baseproject.data.network

import com.google.gson.annotations.SerializedName
import com.soict.hoangviet.baseproject.data.network.api.ApiException

class ApiError @JvmOverloads constructor(
    @SerializedName("msg")
    @JvmField
    var message: String = ApiConstant.HttpMessage.ERROR_TRY_AGAIN,
    @SerializedName("status")
    @JvmField
    var statusCode: Int = ApiConstant.HttpStatusCode.UNKNOWN
) {
    fun getApiException(): ApiException {
        return ApiException(statusCode, message)
    }
}