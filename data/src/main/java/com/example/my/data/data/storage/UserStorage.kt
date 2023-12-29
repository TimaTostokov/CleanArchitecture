package com.example.my.data.data.storage

import com.example.my.data.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User

}