package com.dhk.dhksample.network

import com.dhk.dhksample.data.model.Users
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search/users")
    fun getUsers(@Query("q") keyword: String, @Query("page") page: Int): Single<Users>
}