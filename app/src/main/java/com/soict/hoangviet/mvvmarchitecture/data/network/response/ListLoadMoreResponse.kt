package com.soict.hoangviet.mvvmarchitecture.data.network.response

import com.soict.hoangviet.baseproject.data.network.response.ListResponse
import com.soict.hoangviet.baseproject.utils.Define

class ListLoadMoreResponse<T> : ListResponse<T> {
    var isRefresh: Boolean = false
    var isLoadingMore: Boolean = false

    constructor(
        type: Int,
        data: ArrayList<T>?,
        error: Throwable?
    ) : super(type, data, error)

    constructor(
        data: ArrayList<T>?,
        isRefresh: Boolean,
        isLoadingMore: Boolean
    ) : super(Define.ResponseStatus.SUCCESS, data, null) {
        this.isRefresh = isRefresh
        this.isLoadingMore = isLoadingMore
    }

    companion object {
        fun <T> loading(): ListLoadMoreResponse<T> =
            ListLoadMoreResponse(Define.ResponseStatus.LOADING, null, null)

        fun <T> success(
            data: ArrayList<T>?,
            isRefresh: Boolean,
            isLoadingMore: Boolean
        ): ListLoadMoreResponse<T> =
            ListLoadMoreResponse(data, isRefresh, isLoadingMore)

        fun <T> error(throwable: Throwable): ListLoadMoreResponse<T> =
            ListLoadMoreResponse(Define.ResponseStatus.ERROR, null, throwable)
    }
}