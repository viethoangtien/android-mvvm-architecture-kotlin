package com.soict.hoangviet.mvvmarchitecture.data.network.response

import com.google.gson.annotations.SerializedName

data class TestResponse(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("type")
	val type: Any? = null,

	@field:SerializedName("url")
	val url: Any? = null,

	@field:SerializedName("status")
	val status: Int? = null
)