package com.soict.hoangviet.mvvmarchitecture.data.network.response

import com.google.gson.annotations.SerializedName

data class DataItemNotification(

    @field:SerializedName("driver_id")
    val driverId: Int? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("driver_book_option_id")
    val driverBookOptionId: Any? = null,

    @field:SerializedName("avatar")
    val avatar: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("type")
    val type: Int? = null,

    @field:SerializedName("content")
    val content: Any? = null,

    @field:SerializedName("type_notification")
    val typeNotification: Int? = null,

    @field:SerializedName("user_id")
    val userId: Int? = null,

    @field:SerializedName("driver_post_id")
    val driverPostId: Int? = null,

    @field:SerializedName("user_book_id")
    val userBookId: Int? = null,

    @field:SerializedName("user_post_id")
    val userPostId: Any? = null,

    @field:SerializedName("driver_book_id")
    val driverBookId: Any? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("status")
    val status: Int? = null
)