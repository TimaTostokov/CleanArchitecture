package com.example.my.cleancodetest.domain.usecase

import com.example.my.cleancodetest.domain.models.UserName
import com.example.my.cleancodetest.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }

}