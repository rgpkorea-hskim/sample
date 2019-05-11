package com.dhk.dhksample.data.model

import com.dhk.dhksample.domain.model.User
import com.google.gson.annotations.SerializedName

data class Users(@SerializedName("total_count") val totalCount : Int,
                 val items : List<User>)