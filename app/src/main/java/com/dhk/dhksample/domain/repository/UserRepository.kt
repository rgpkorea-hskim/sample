package com.dhk.dhksample.domain.repository

import com.dhk.dhksample.data.model.Users
import io.reactivex.Single

interface UserRepository {

    fun getUsers(keyword: String, page: Int): Single<Users>
}