package com.example.my.clean.presentation

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.my.clean.R
import com.example.my.data.data.storage.sharedprefs.SharedPrefUserStorage

class MainActivity : Activity() {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE)
    {
        com.example.my.data.data.repository.UserRepositoryImpl(
            userStorage = SharedPrefUserStorage(
                context = applicationContext
            )
        )
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        com.example.my.cleancodetest.domain.usecase.GetUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        com.example.my.cleancodetest.domain.usecase.SaveUserNameUseCase(
            userRepository = userRepository
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            val params = com.example.my.cleancodetest.domain.models.SaveUserNameParam(name = text)
            val result: Boolean = saveUserNameUseCase.execute(param = params)
            dataTextView.text = "Save result = $result"
        }

        receiveButton.setOnClickListener {
            val userName: com.example.my.cleancodetest.domain.models.UserName =
                getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}}"
        }
    }

}