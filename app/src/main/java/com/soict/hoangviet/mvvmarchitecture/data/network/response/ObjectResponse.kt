package com.soict.hoangviet.baseproject.data.network.response

import com.soict.hoangviet.baseproject.utils.Define

class ObjectResponse<T>(
    val type: Int,
    val data: T?,
    val error: Throwable?
) : BaseResponse() {
    companion object {
        fun <T> loading(): ListResponse<T> =
            ListResponse(Define.ResponseStatus.LOADING, null, null)

        fun <T> success(data: ArrayList<T>): ListResponse<T> =
            ListResponse(Define.ResponseStatus.SUCCESS, data, null)

        fun <T> error(throwable: Throwable): ListResponse<T> =
            ListResponse(Define.ResponseStatus.ERROR, null, throwable)

    }
}