package com.bandeev.feature.auth.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.bandeev.feature.auth.R
import androidx.activity.viewModels
import com.bandeev.feature.auth.domain.models.LogInViaEmailData


class LogInActivity : AppCompatActivity(R.layout.login_layout) {
    private val viewModel: LogInViewModel by viewModels()
    private val etEmail by lazy { findViewById<EditText>(R.id.edit_email) }
    private val etPassword by lazy { findViewById<EditText>(R.id.edit_password) }
    private val btnLogin by lazy { findViewById<Button>(R.id.button_logIn) }
    lateinit var logInDataState: LogInViaEmailData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val btnVK = findViewById<ImageButton>(R.id.imButton_vk)
        val btnOK = findViewById<ImageButton>(R.id.imButton_ok)
        val btnSignUp = findViewById<TextView>(R.id.tv_signUp)
        val btnForgotPassword = findViewById<TextView>(R.id.tv_forgotPass)
        btnVK.setOnClickListener { viewModel.clickAuthVK() }
        btnOK.setOnClickListener { viewModel.clickAuthOK() }
        btnSignUp.setOnClickListener { viewModel.clickSignUp() }
        btnForgotPassword.setOnClickListener { viewModel.clickForgotPassword() }

        updateUIState()
        etEmail.doAfterTextChanged { updateUIState() }
        etPassword.doAfterTextChanged { updateUIState() }
        btnLogin.setOnClickListener { viewModel.clickLogIn(logInDataState) }
    }

    override fun onResume(){
        super.onResume()
        recoverUIState()
    }
    override fun onPause(){
        super.onPause()
        saveUIState()
    }

    private fun updateUIState() {
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString()
        logInDataState = LogInViaEmailData(email, password)
        btnLogin.isEnabled = logInDataState.isValid()
    }

    private fun recoverUIState() {
        val data = viewModel.logInActivityDataState
        data?.let {
            etEmail.setText(data.logInDataState.email)
            etPassword.setText(data.logInDataState.password)
            btnLogin.isEnabled = data.btnLogInIsEnabledState
        }
    }

    private fun saveUIState(){
        viewModel.logInActivityDataState = LogInActivityViewState(
            logInDataState,
            btnLogin.isEnabled
        )
    }
}