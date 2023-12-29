package com.example.my.cleancodetest.domain.usecase

import com.example.my.cleancodetest.domain.models.UserName
import com.example.my.cleancodetest.domain.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class GetUserNameUseCase {

    val userRepository = mock<UserRepository>()

    @Test
    fun `should return the same data as in repository`() {

        val testUserName = UserName(firstName = "test first", lastName = "test last")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val useCase = GetUserNameUseCase(userRepository = userRepository)
        val actual = useCase.execute()
        val expected = UserName(firstName = "test first", lastName = "test last")

        Assertions.assertEquals(expected, actual)
    }

}