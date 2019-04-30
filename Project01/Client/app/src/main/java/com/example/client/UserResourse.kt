package com.example.client

import com.google.gson.annotations.SerializedName

data class User(@SerializedName("userName")
                val userName: String, @SerializedName("password") val password: String, @SerializedName("confirmPassword") val confirmPassword: String, @SerializedName("email") val email: String)