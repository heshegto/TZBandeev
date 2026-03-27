package com.bandeev.feature.auth.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.bandeev.feature.auth.data.repository.AuthNavigatorImpl
import com.bandeev.feature.auth.data.repository.LogInViaEmailImpl
import com.bandeev.feature.auth.domain.models.LogInViaEmailData
import com.bandeev.feature.auth.domain.usecases.AuthWithOKUseCase
import com.bandeev.feature.auth.domain.usecases.AuthWithVKUseCase
import com.bandeev.feature.auth.domain.usecases.ForgotPasswordUseCase
import com.bandeev.feature.auth.domain.usecases.LogInUseCase
import com.bandeev.feature.auth.domain.usecases.SignUpUseCase

class LogInViewModel(application: Application) : AndroidViewModel(application) {
    var logInActivityDataState: LogInViaEmailData? = null

    fun clickLogIn() {
        logInActivityDataState?.let {
                LogInUseCase()
                    .execute(LogInViaEmailImpl(getApplication()), it)
        }
    }

    fun clickSignUp() {
        SignUpUseCase().execute()
    }

    fun clickForgotPassword() {
        ForgotPasswordUseCase().execute()
    }

    fun clickAuthVK() {
        AuthWithVKUseCase().execute(AuthNavigatorImpl(getApplication()))
    }

    fun clickAuthOK() {
        AuthWithOKUseCase().execute(AuthNavigatorImpl(getApplication()))
    }
}
