package com.example.my.cleancodetest.domain.repository

import com.example.my.cleancodetest.domain.models.SaveUserNameParam
import com.example.my.cleancodetest.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean
    fun getName(): UserName

}