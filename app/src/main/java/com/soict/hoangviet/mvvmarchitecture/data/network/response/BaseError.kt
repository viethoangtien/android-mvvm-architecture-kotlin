package com.soict.hoangviet.mvvmarchitecture.data.network.response

class BaseError(message: String, val code: Int) : Throwable(message) {
}