package com.capstone.petang.data.remote.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @field:SerializedName("loginResult")
    val data: Data? = null,

    @field:SerializedName("error")
    val error: Boolean? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("token")
    val token: String? = null
)

data class Data(

    @field:SerializedName("Name")
    val Name: String? = null,

    @field:SerializedName("phone_number")
    val phone_number: Int = 0,


    )
