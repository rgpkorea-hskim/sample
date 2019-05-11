package com.dhk.dhksample.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.reflect.KClass

object ApiManager {

    private val retrofitInstance by lazy {
        Hashtable<String, Retrofit>()
    }

    fun <T : Any> get(baseUrl: String, kClass: KClass<T>): T {

        fun getNewRetrofit(baseUrl: String): Retrofit {
            val builder = OkHttpClient.Builder()
                .followRedirects(true)
                .followSslRedirects(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)

            return Retrofit.Builder()
                .client(builder.build())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val retrofit = retrofitInstance[baseUrl] ?: getNewRetrofit(baseUrl).apply {
            retrofitInstance[baseUrl] = this
        }
        return retrofit.create(kClass.java)
    }
}