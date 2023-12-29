@file:Suppress("UNUSED_EXPRESSION")

package com.example.my.cleancodetest.domain.usecase

import com.example.my.cleancodetest.domain.models.SaveUserNameParam
import com.example.my.cleancodetest.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        val oldUserName = userRepository.getName()
        if (oldUserName.firstName == param.name) {
            return true
        } else false

        val result: Boolean = userRepository.saveName(saveParam = param)
        return result
    }

}