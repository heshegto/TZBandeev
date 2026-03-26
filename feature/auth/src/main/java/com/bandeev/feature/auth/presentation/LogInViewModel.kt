package com.bandeev.feature.auth.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.bandeev.feature.auth.data.repository.LogInViaEmailImpl
import com.bandeev.feature.auth.domain.usecases.AuthWithOKUseCase
import com.bandeev.feature.auth.domain.usecases.AuthWithVKUseCase
import com.bandeev.feature.auth.domain.usecases.ForgotPasswordUseCase
import com.bandeev.feature.auth.domain.usecases.LogInUseCase
import com.bandeev.feature.auth.domain.usecases.SignUpUseCase
import com.bandeev.feature.auth.domain.models.LogInViaEmailData

class LogInViewModel(application: Application) : AndroidViewModel(application) {
    var logInActivityDataState: LogInActivityViewState? = null
        set(value) {
            field = if (value == null ||
                (value.logInDataState.email.isEmpty() &&
                        value.logInDataState.password.isEmpty() &&
                        !value.btnLogInIsEnabledState)
            ) { null }
            else { value }
        }

    fun clickLogIn(logInData: LogInViaEmailData) {
        LogInUseCase().execute(LogInViaEmailImpl(getApplication()), logInData)
    }

    fun clickSignUp() {
        SignUpUseCase().execute()
    }

    fun clickForgotPassword() {
        ForgotPasswordUseCase().execute()
    }

    fun clickAuthVK() {
        AuthWithVKUseCase().execute(getApplication())
    }

    fun clickAuthOK() {
        AuthWithOKUseCase().execute(getApplication())
    }
}
