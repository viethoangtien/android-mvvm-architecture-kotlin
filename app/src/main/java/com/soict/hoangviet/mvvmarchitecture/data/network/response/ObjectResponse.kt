package com.soict.hoangviet.baseproject.data.network.response

import com.google.gson.annotations.SerializedName

class ObjectResponse<T> : BaseResponse() {
    @SerializedName("data")
    var data: T? = null
}