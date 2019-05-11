package com.dhk.dhksample.domain.usecase

import com.dhk.dhksample.domain.model.User
import com.dhk.dhksample.domain.repository.UserRepository
import io.reactivex.Single

class UserUseCase(private val userRepository: UserRepository) {

    fun getUsers(keyword: String, page: Int): Single<List<User>> {
        return userRepository.getUsers(keyword, page).map {
            it.items
        }
    }
}