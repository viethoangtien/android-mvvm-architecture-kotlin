package com.soict.hoangviet.mvvmarchitecture.data.network.response

class BaseError(message: String, val code: Int, var isShowToast: Boolean = false) :
    Throwable(message) {
}