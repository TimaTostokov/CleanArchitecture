package com.example.my.data.data.repository

import com.example.my.cleancodetest.domain.models.SaveUserNameParam
import com.example.my.cleancodetest.domain.models.UserName
import com.example.my.cleancodetest.domain.repository.UserRepository
import com.example.my.data.data.storage.UserStorage
import com.example.my.data.data.storage.models.User

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {

        val user = mapToStorage(saveParam)

        val result = userStorage.save(user)
        return result
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }

}