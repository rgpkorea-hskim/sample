package com.dhk.dhksample.data.repository

import com.dhk.dhksample.Constant
import com.dhk.dhksample.data.model.Users
import com.dhk.dhksample.domain.repository.UserRepository
import com.dhk.dhksample.network.ApiManager
import com.dhk.dhksample.network.ApiService
import io.reactivex.Single

class UserRepositoryImpl : UserRepository {
    override fun getUsers(keyword: String, page: Int): Single<Users> {
        return ApiManager.get(Constant.BASE_URL, ApiService::class).getUsers(keyword, page)
    }
}