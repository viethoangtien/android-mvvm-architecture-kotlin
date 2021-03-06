package com.soict.hoangviet.mvvmarchitecture.data.network.response

import com.soict.hoangviet.baseproject.data.network.response.ListResponse
import com.soict.hoangviet.baseproject.data.network.response.ObjectResponse
import com.soict.hoangviet.baseproject.utils.Define

class ObjectLoadMoreResponse<T> : ObjectResponse<T> {
    var isRefresh: Boolean = false
    var isLoadingMore: Boolean = false

    constructor(
        type: Int,
        data: T?,
        error: Throwable?
    ) : super(type, data, error)

    constructor(
        data: T?,
        isRefresh: Boolean,
        isLoadingMore: Boolean
    ) : super(Define.ResponseStatus.SUCCESS, data, null) {
        this.isRefresh = isRefresh
        this.isLoadingMore = isLoadingMore
    }

    companion object {
        fun <T> loading(): ObjectLoadMoreResponse<T> =
            ObjectLoadMoreResponse(
                Define.ResponseStatus.LOADING,
                data = null,
                error = null
            )

        fun <T> success(
            data: T?,
            isRefresh: Boolean = false,
            isLoadingMore: Boolean = false
        ): ObjectLoadMoreResponse<T> =
            ObjectLoadMoreResponse(
                data,
                isRefresh,
                isLoadingMore
            )

        fun <T> error(throwable: Throwable): ObjectLoadMoreResponse<T> =
            ObjectLoadMoreResponse(
                Define.ResponseStatus.ERROR,
                null,
                throwable
            )
    }
}