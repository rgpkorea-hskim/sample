package com.dhk.dhksample.domain.model

import com.google.gson.annotations.SerializedName

data class User(@SerializedName("login") val nickName : String,
                @SerializedName("avatar_url") val thumbNailUrl : String)