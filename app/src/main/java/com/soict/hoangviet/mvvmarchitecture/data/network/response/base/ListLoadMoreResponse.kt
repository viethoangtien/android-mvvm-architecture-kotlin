package com.soict.hoangviet.mvvmarchitecture.data.network.response

import com.soict.hoangviet.baseproject.data.network.response.BaseResponse
import com.soict.hoangviet.baseproject.utils.Define

open class ListLoadMoreResponse<T>(
    val type: Int,
    val data: BaseListResponse<T>?,
    val error: Throwable?,
    var isRefresh: Boolean = false,
    var isLoadingMore: Boolean = false
) : BaseResponse() {
    companion object {
        fun <T> loading(): ListLoadMoreResponse<T> =
            ListLoadMoreResponse(Define.ResponseStatus.LOADING, null, null)

        fun <T> success(data: ArrayList<T>): ListLoadMoreResponse<T> =
            ListLoadMoreResponse(Define.ResponseStatus.SUCCESS, BaseListResponse(data = data), null)

        fun <T> error(throwable: Throwable): ListLoadMoreResponse<T> =
            ListLoadMoreResponse(Define.ResponseStatus.ERROR, null, throwable)
    }
}

fun <T> ListLoadMoreResponse<T>.setLoadingMore(
    isRefresh: Boolean = false,
    isLoadingMore: Boolean = false
): ListLoadMoreResponse<T> {
    this.isRefresh = isRefresh
    this.isLoadingMore = isLoadingMore
    return this
}