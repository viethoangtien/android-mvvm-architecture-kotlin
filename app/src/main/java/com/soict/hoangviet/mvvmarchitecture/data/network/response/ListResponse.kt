package com.soict.hoangviet.baseproject.data.network.response

import com.google.gson.annotations.SerializedName

class ListResponse<T> : BaseResponse() {
    @SerializedName("data")
    var data: ArrayList<T>? = null
}