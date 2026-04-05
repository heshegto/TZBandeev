package com.bandeev.feature.auth.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.bandeev.feature.auth.domain.models.LogInViaEmailData
import com.bandeev.feature.auth.domain.usecases.AuthWithOKUseCase
import com.bandeev.feature.auth.domain.usecases.AuthWithVKUseCase
import com.bandeev.feature.auth.domain.usecases.ForgotPasswordUseCase
import com.bandeev.feature.auth.domain.usecases.LogInUseCase
import com.bandeev.feature.auth.domain.usecases.SignUpUseCase

class LogInViewModel(
    application: Application,
    val logUseCase: LogInUseCase,
    val signUpUseCase: SignUpUseCase,
    val forgotPasswordUseCase: ForgotPasswordUseCase,
    val authWithOKUseCase: AuthWithOKUseCase,
    val authWithVKUseCase: AuthWithVKUseCase
) : AndroidViewModel(application) {
    var logInActivityDataState: LogInViaEmailData? = null

    fun clickLogIn() {
        logInActivityDataState?.let {
            logUseCase.execute(it)
        }
    }

    fun clickSignUp() {
        signUpUseCase.execute()
    }

    fun clickForgotPassword() {
        forgotPasswordUseCase.execute()
    }

    fun clickAuthVK() {
        authWithVKUseCase.execute()
    }

    fun clickAuthOK() {
        authWithOKUseCase.execute()
    }
}
