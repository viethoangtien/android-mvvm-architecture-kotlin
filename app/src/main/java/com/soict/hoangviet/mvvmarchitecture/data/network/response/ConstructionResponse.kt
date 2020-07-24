package com.soict.hoangviet.mvvmarchitecture.data.network.response

import com.google.gson.annotations.SerializedName

data class ConstructionResponse(
    @field:SerializedName("fab_id")
    val fabId: Int? = null,

    @field:SerializedName("end_date")
    val endDate: String? = null,

    @field:SerializedName("flag")
    val flag: Int? = null,

    @field:SerializedName("color")
    val color: String? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("header_mark")
    val headerMark: String? = null,

    @field:SerializedName("status")
    val status: Int? = null,

    @field:SerializedName("start_date")
    val startDate: String? = null
)
