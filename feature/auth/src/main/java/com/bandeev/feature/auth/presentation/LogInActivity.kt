package com.bandeev.feature.auth.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.bandeev.feature.auth.R
import com.bandeev.feature.auth.domain.models.LogInViaEmailData
import org.koin.androidx.viewmodel.ext.android.viewModel

class LogInActivity : AppCompatActivity(R.layout.login_layout) {
    private val viewModel: LogInViewModel by viewModel()
    private val btnLogin by lazy { findViewById<Button>(R.id.button_logIn) }
    private val etEmail by lazy { findViewById<EditText>(R.id.edit_email) }
    private val etPassword by lazy { findViewById<EditText>(R.id.edit_password) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val btnVK = findViewById<ImageButton>(R.id.imButton_vk)
        val btnOK = findViewById<ImageButton>(R.id.imButton_ok)
        val btnSignUp = findViewById<TextView>(R.id.tv_signUp)
        val btnForgotPassword = findViewById<TextView>(R.id.tv_forgotPass)

        btnLogin.setOnClickListener { viewModel.clickLogIn() }
        btnVK.setOnClickListener { viewModel.clickAuthVK() }
        btnOK.setOnClickListener { viewModel.clickAuthOK() }
        btnSignUp.setOnClickListener { viewModel.clickSignUp() }
        btnForgotPassword.setOnClickListener { viewModel.clickForgotPassword() }

        recoverUIState()
        updateUIState()
        etEmail.doAfterTextChanged { updateUIState() }
        etPassword.doAfterTextChanged { updateUIState() }
    }

    private fun recoverUIState(){
        viewModel.logInActivityDataState?.let {
            etEmail.setText(it.email)
            etPassword.setText(it.password)
        }
    }

    private fun updateUIState() {
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString()
        viewModel.logInActivityDataState = LogInViaEmailData(email, password)
        btnLogin.isEnabled = viewModel.logInActivityDataState!!.isValid()
    }
}